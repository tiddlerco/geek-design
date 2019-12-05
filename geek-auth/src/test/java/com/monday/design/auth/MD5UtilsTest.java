package com.monday.design.auth;

import com.monday.design.auth.util.MD5Utils;
import org.junit.Test;

public class MD5UtilsTest {

    @Test
    public void test1() {
        String str = "123";
        System.out.println(MD5Utils.md5(str));
        System.out.println(MD5Utils.md5(str));
        System.out.println(MD5Utils.md5(str));
    }

}
