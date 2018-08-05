package com.duyun.huihsou.housekepper.portal.service.user;


import com.duyun.huihsou.housekepper.portal.request.UserParams;
import com.duyun.huihsou.housekepper.portal.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.portal.vo.ResData;
import com.duyun.huishou.housekeeper.exception.ApplicationException;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.UserEntityMapper;
import com.duyun.huishou.housekeeper.po.UserEntity;
import com.duyun.huishou.housekeeper.util.EncryptionUtils;
import com.duyun.huishou.housekeeper.util.JWTSignerUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author albert
 * @package com.xianduankeji.ktv.portal.service.user
 * @email cn.lu.duke@gmail.com
 * @date January 10, 2018
 */

@Service
@Slf4j
public class UserServiceImpl extends AbstractBaseService<UserEntity> implements UserService {

    @Autowired(required = false)
    private UserEntityMapper userMapper;

    @Override
    public IBaseDao getMapper() {
        return (IBaseDao)userMapper;
    }

    @Override
    public void processSessionData(ResData data) {
        String openId = data.getOpenId();
        if(StringUtils.isNotEmpty(openId)){
            UserEntity userEntity = userMapper.selectByOpenId(openId);
            if(userEntity == null){
                UserEntity insertPo = new UserEntity();
                insertPo.setOpenId(data.getOpenId());
                insertPo.setLastUpdateTime(System.currentTimeMillis());
                insertPo.setInsertTime(System.currentTimeMillis());
                insertPo.setBalance(0);
                insertPo.setUnionId(data.getUnionId());
                userMapper.insert(insertPo);
            }
        }
    }

    @Override
    public UserEntity queryByOpenId(String openId) {
        return userMapper.selectByOpenId(openId);
    }

    @Override
    public String login(UserParams params) {
        UserEntity entity = userMapper.selectByMobile(params.getMobile());
        if (entity == null) {
            throw new ApplicationException("用户不存在，请先注册！");
        }
        String salt = entity.getSalt();
        String pwd = EncryptionUtils.encryptPasswordBySalt(params.getPassword(), salt);
        if (!pwd.equals(entity.getPassword())) {
            throw new ApplicationException("密码错误！");
        }

        return generateToken(entity);
    }

    @Override
    public void register(UserParams params) {
        //todo 验证码校验
        if (userMapper.selectByMobile(params.getMobile()) != null) {
            throw new ApplicationException("该手机号已存在！");
        };
        if (!params.getNewPwd1().equals(params.getNewPwd2())) {
            throw new ApplicationException("两次输入密码不一致，请重新输入！");
        }
        UserEntity userEntity = new UserEntity();
        String salt = EncryptionUtils.generateSalt();
        String password = EncryptionUtils.encryptPasswordBySalt(params.getNewPwd2(), salt);
        userEntity.setMobile(params.getMobile());
        userEntity.setSalt(salt);
        userEntity.setPassword(password);
        userEntity.setOpenId(params.getOpenId());
        userEntity.setInsertTime(System.currentTimeMillis());
        userEntity.setLastUpdateTime(System.currentTimeMillis());
        userMapper.insert(userEntity);
    }

    @Override
    public Boolean repwd(UserParams params, UserEntity userEntity) {
        if ( !params.getMobile().equals(userEntity.getMobile())) {
            throw new ApplicationException("该手机号与当前登录手机号不一致，请重新输入！");
        }
        if (!params.getNewPwd1().equals(params.getNewPwd2())) {
            throw new ApplicationException("两次输入密码不一致，请重新输入！");
        }
        String salt = userEntity.getSalt();
        String password = EncryptionUtils.encryptPasswordBySalt(params.getNewPwd2(), salt);
        userEntity.setPassword(password);
        userEntity.setLastUpdateTime(System.currentTimeMillis());
        int result = userMapper.updateByPrimaryKeySelective(userEntity);
        if (result == 0) {
            return false;
        }
        return true;
    }

    @Override
    public Boolean getVerifyCode() {
        //TODO 生成验证码，短信推送

        return true;
    }

    private String generateToken(UserEntity userEntity) {
        String token = null;
        try {
            token = JWTSignerUtil.shouldSignStringOrURICollection(
                    "/user/login", userEntity.getId() + "");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }


}
