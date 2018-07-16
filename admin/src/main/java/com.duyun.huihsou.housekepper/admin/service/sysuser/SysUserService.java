package com.duyun.huihsou.housekepper.admin.service.sysuser;

import com.duyun.huihsou.housekepper.admin.request.AdminUserParams;
import com.duyun.huihsou.housekepper.admin.service.IBaseService;
import com.duyun.huihsou.housekepper.admin.vo.SysUserVO;
import com.duyun.huishou.housekeeper.po.SysUserEntity;

public interface SysUserService extends IBaseService<SysUserEntity> {

    SysUserVO checkLogin(AdminUserParams name);

    void register(String name, String passWord, String mobile);
}
