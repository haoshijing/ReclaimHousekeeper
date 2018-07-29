package com.duyun.huihsou.housekepper.admin.service.sysuser;

import com.duyun.huihsou.housekepper.admin.exception.ApplicationException;
import com.duyun.huihsou.housekepper.admin.request.AdminUserParams;
import com.duyun.huihsou.housekepper.admin.service.AbstractBaseService;
import com.duyun.huihsou.housekepper.admin.vo.SysUserVO;
import com.duyun.huishou.housekeeper.mapper.IBaseDao;
import com.duyun.huishou.housekeeper.mapper.SysUserEntityMapper;
import com.duyun.huishou.housekeeper.po.SysUserEntity;
import com.duyun.huishou.housekeeper.util.EncryptionUtils;
import com.duyun.huishou.housekeeper.util.JWTSignerUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl extends AbstractBaseService<SysUserEntity> implements SysUserService {

    @Autowired
    private SysUserEntityMapper sysUserEntityMapper;
    @Override
    public IBaseDao getMapper() {
        return sysUserEntityMapper;
    }

    @Override
    public SysUserVO checkLogin(AdminUserParams params) {
        SysUserEntity entity = sysUserEntityMapper.selectByName(params.getName());
        if (entity == null) {
            throw new ApplicationException("用户不存在!");
        }
        String salt = entity.getSalt();
        String pwd = EncryptionUtils.encryptPasswordBySalt(params.getPassWord(), salt);
        if (!pwd.equals(entity.getPassWord())) {
            throw new ApplicationException("密码错误！");
        }

        return generateToken(entity);
    }

    @Override
    public void register(String name, String passWord, String mobile) {

        if (StringUtils.isNotEmpty(name) && StringUtils.isNotEmpty(passWord)) {
            if (sysUserEntityMapper.selectByName(name) != null) {
                throw new ApplicationException("该用户已存在！");
            }
            SysUserEntity sysUserEntity = new SysUserEntity();
            String salt = EncryptionUtils.generateSalt();
            String password = EncryptionUtils.encryptPasswordBySalt(passWord, salt);
            sysUserEntity.setName(name);
            sysUserEntity.setMobile(mobile);
            sysUserEntity.setSalt(salt);
            sysUserEntity.setPassWord(password);
            sysUserEntity.setInsertTime(System.currentTimeMillis());
            sysUserEntity.setLastUpdateTime(System.currentTimeMillis());
            sysUserEntityMapper.insert(sysUserEntity);
        }

    }

    private SysUserVO generateToken(SysUserEntity entity) {
        SysUserVO sysUserVO = new SysUserVO();
        try {
            String token = JWTSignerUtil.shouldSignStringOrURICollection(
                    "/admin/login", entity.getId() + "");

            BeanUtils.copyProperties(entity,sysUserVO);
            sysUserVO.setToken(token);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sysUserVO;
    }
}
