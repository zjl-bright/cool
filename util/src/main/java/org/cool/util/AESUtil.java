package org.cool.util;

import com.google.common.base.Strings;
import com.google.common.base.Throwables;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Random;

/**
 * 可逆加密
 */
@Slf4j
public class AESUtil {

    /**
     * AES加密字符串
     *
     * @param content
     *            需要被加密的字符串
     * @param password
     *            加密需要的密码
     * @return 密文
     */
    public static byte[] encrypt(String content, String password) {
        try {
            // 创建AES的Key生产者
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            // 利用用户密码作为随机数初始化出
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            // 128位的key生产者
            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
            kgen.init(128, random);

            // 根据用户密码，生成一个密钥
            SecretKey secretKey = kgen.generateKey();

            // 返回基本编码格式的密钥，如果此密钥不支持编码，则返回null
            byte[] enCodeFormat = secretKey.getEncoded();

            // 转换为AES专用密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");

            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");

            byte[] byteContent = content.getBytes("utf-8");

            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, key);

            // 加密
            byte[] result = cipher.doFinal(byteContent);

            return result;
        }catch (Exception e) {
            log.error("AESUtil.encrypt.fail,cause: {}", Throwables.getStackTraceAsString(e));
        }
        return null;
    }


    /**
     * 解密AES加密过的字符串
     *
     * @param content
     *            AES加密过过的内容
     * @param password
     *            加密时的密码
     * @return 明文
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            // 创建AES的Key生产者
            KeyGenerator kgen = KeyGenerator.getInstance("AES");

            // 利用用户密码作为随机数初始化出
            SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
            random.setSeed(password.getBytes());
            // 128位的key生产者
            //加密没关系，SecureRandom是生成安全随机数序列，password.getBytes()是种子，只要种子相同，序列就一样，所以解密只要有password就行
            kgen.init(128, random);

            // 根据用户密码，生成一个密钥
            SecretKey secretKey = kgen.generateKey();
            // 返回基本编码格式的密钥
            byte[] enCodeFormat = secretKey.getEncoded();
            // 转换为AES专用密钥
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            // 初始化为解密模式的密码器
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(content);
            // 明文
            return result;
        } catch (Exception e) {
            log.error("AESUtil.encrypt.fail, cause:{}", Throwables.getStackTraceAsString(e));
        }
        return null;
    }

    /**
     * 根据密文获取明文
     * @param ciphertext
     * @param key
     * @return
     */
    public static String getPlaintext(String ciphertext, String key){
        byte[] twoStrResult = BinaryConversionUtil.parseHexStr2Byte(ciphertext);
        byte[] decrypt = decrypt(twoStrResult, key);
        return new String(decrypt);
    }

    /**
     * 根据明文获取密文
     * @param plaintext
     * @param key
     * @return
     */
    public static String getCiphertext(String plaintext, String key) {
        byte[] encrypt = encrypt(plaintext, key);
        return BinaryConversionUtil.parseByte2HexStr(encrypt);
    }

    /**
     * 解析永久用户数
     * @param foreverCiphertext
     * @param aesKey
     * @return
     */
    public static Integer analysisForeverNum(String foreverCiphertext, String aesKey){
        Integer foreverNum = 0;
        try {
            if (!Strings.isNullOrEmpty(foreverCiphertext) && foreverCiphertext.length() >= 2){
                String temporaryPlaintext = getPlaintext(foreverCiphertext, aesKey);
                String temporaryStartStr = temporaryPlaintext.substring(0, 1);
                if (StringUtils.pathEquals(temporaryStartStr, "F")){
                    foreverNum = Integer.valueOf(temporaryPlaintext.substring(1, temporaryPlaintext.length()));
                }
            }
        }catch (Exception e){
            foreverNum = 0;
        }
        return foreverNum;
    }

    /**
     * 解析临时用户
     * @param TemporaryCiphertext
     * @param aesKey
     * @return
     */
    public static Integer analysisTemporaryNum(String TemporaryCiphertext, String aesKey){
        Integer temporaryNum = 0;
        try {
            if (!Strings.isNullOrEmpty(TemporaryCiphertext) && TemporaryCiphertext.length() >= 2){
                String temporaryPlaintext = getPlaintext(TemporaryCiphertext, aesKey);
                String temporaryStartStr = temporaryPlaintext.substring(0, 1);
                if (StringUtils.pathEquals(temporaryStartStr, "T")){
                    temporaryNum = Integer.valueOf(temporaryPlaintext.substring(1, temporaryPlaintext.length()));
                }
            }
        }catch (Exception e){
            temporaryNum = 0;
        }
        return temporaryNum;
    }

//    /**
//     * 解析截止日期
//     * @param deadlineCiphertext
//     * @param aesKey
//     * @return
//     */
//    public static Date analysisDeadline(String deadlineCiphertext, String aesKey){
//        Date deadline;
//        if (Strings.isNullOrEmpty(deadlineCiphertext)){
//            deadline = DateUtils.parseDate("2099-12-31", "yyyy-MM-dd");
//        }else {
//            try {
//                String deadlinePlaintext = getPlaintext(deadlineCiphertext, aesKey);
//                deadline = DateUtils.parseDate(deadlinePlaintext, "yyyy-MM-dd");
//            }catch (Exception e){
//                deadline = DateUtils.addDay(new Date(), -1);
//            }
//        }
//
//        return deadline;
//    }

    public static void main(String[] args) throws Exception{
        //密钥 加密内容(对象序列化后的内容-json格式字符串)
        String key="123456";
        String code = "815148382@qq.com";
        System.out.println(String.format("明文是：%s, 秘钥是: %s",code, key));

        String encryptRes=getEncryptionCode(code,key);
        System.out.println(String.format("加密结果：%s ",encryptRes));

        String decryptRes=getDecryptionCode(encryptRes,key);
        System.out.println(String.format("解密结果：%s ",decryptRes));
    }

    public static String makeRandomPassword(){
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int x = 0; x < 8; ++x) {
            sb.append(charr[random.nextInt(charr.length)]);
        }
        String randomPassword = sb.toString();
        if (randomPassword.matches(".*[a-z]{1,}.*") && randomPassword.matches(".*[A-Z]{1,}.*") && randomPassword.matches(".*\\d{1,}.*") ) {
            return randomPassword;
        }else{
            randomPassword = makeRandomPassword();
        }
        return randomPassword;
    }

    public static String getEncryptionCode(String realCode,String aesKey){
        StringBuilder supplementLink =new StringBuilder(AESUtil.makeRandomPassword());
        supplementLink.append(getCiphertext(realCode,aesKey));
        return supplementLink.toString();
    }

    public static String getDecryptionCode(String encryptionCode, String aesKey){
        return getPlaintext(encryptionCode.substring(8), aesKey);
    }
}
