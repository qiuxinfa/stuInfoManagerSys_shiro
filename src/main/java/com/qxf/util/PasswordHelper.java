package com.qxf.util;

/**
 * @Auther: qiuxinfa
 * @Date: 2019/10/9
 * @Description: com.qxf.util
 */
import com.qxf.pojo.User;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {
    private String algorithmName = "md5";
    private int hashIterations = 2;

    public void encryptPassword(User user) {
        String newPassword = new SimpleHash(algorithmName, user.getPassword(),  ByteSource.Util.bytes(user.getUsername()), hashIterations).toHex();
        user.setPassword(newPassword);

    }
    public static void main(String[] args) {
        PasswordHelper passwordHelper = new PasswordHelper();
        User user = new User();
        user.setUsername("qiuxinfa");
        user.setPassword("qiuxinfa");
        passwordHelper.encryptPassword(user);
        System.out.println(user);
    }
}