package com.duyun.huihsou.housekepper.admin.gloabal;

import com.duyun.huishou.housekeeper.po.SysUserEntity;

/**
 * Created by fq_qiguo on 2017/5/18.
 */
public class GlobalHolder {

    private static ThreadLocal<SysUserEntity> currentLoginUser = new ThreadLocal<SysUserEntity>();

    public static SysUserEntity getCurrentLoginUser() {
        return currentLoginUser.get();
    }

    public static void setCurrentLoginUser(SysUserEntity user) {
        currentLoginUser.set(user);
    }

    public static void removeCurrentLoginUser() {
        currentLoginUser.remove();
    }

}
