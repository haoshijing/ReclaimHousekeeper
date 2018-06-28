package com.duyun.huishou.housekeeper.aop;

import java.lang.annotation.*;

/**
 * USER: cainaitao
 * Date: 2017/5/20
 * Time: 21:59
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NameSpace {
    String value();
}
