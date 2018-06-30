package com.duyun.huihsou.housekepper.portal.gloabal;

import com.duyun.huishou.housekeeper.po.UserEntity;

/**
 * Created by fq_qiguo on 2017/5/18.
 */
public class GlobalHolder {

    private static ThreadLocal<UserEntity> currentLoginUser = new ThreadLocal<UserEntity>();

    public static UserEntity getCurrentLoginUser() {
        return currentLoginUser.get();
    }

    public static void setCurrentLoginUser(UserEntity user) {
        currentLoginUser.set(user);
    }

    public static void removeCurrentLoginUser() {
        currentLoginUser.remove();
    }

}
