package project.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.security.MessageDigest;

/**
 * Created with IntelliJ IDEA.
 * User: Sadiq
 * Date: 1/13/17
 * Time: 12:33 AM
 * To change this template use File | Settings | File Templates.
 */
public class Security {

    public static String generateMd5 (String password)throws Exception {

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());

        byte byteData[] = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }
}
