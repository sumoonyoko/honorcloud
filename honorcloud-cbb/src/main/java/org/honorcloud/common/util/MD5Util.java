package org.honorcloud.common.util;
import java.security.MessageDigest;
import org.apache.xmlbeans.impl.util.Base64;

import lombok.extern.slf4j.Slf4j;

/**
 * @Description: 加密工具类
 * @version: v1.0.0
 * @author: sumoonyoko
 * @date: 2019年11月06日 
 */
@Slf4j
public class MD5Util {
    
    /**
     * Base64加签算法.
     * @param plainText String
     * @return String
     */
    public static String enCodeSign(final String plainText) {
        return new String(Base64.encode(getMD5(plainText)));
    }
    
    /**
     * Base64解密算法.
     * @param plainText String
     * @return String
     */
    public static String deCodeSign(final String plainText) {
    	return new String(Base64.decode(getMD5(plainText)));
    }

    /**
     * Md5加签算法.
     * @param plainText String
     * @return byte[]
     */
    public static byte[] getMD5(final String plainText) {
        if (plainText != null) {
            try {
                MessageDigest md5 = MessageDigest.getInstance("MD5");
                md5.update(plainText.getBytes("UTF-8"));
                return md5.digest();
            } catch (final Exception e) {
              log.error("Md5加签出错:{}", e.getMessage());
            }
        }
        return null;
    }

}
