package repository.security.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.*;

/**
 * 安全工具基础类
 * @author JinKe chenw@dtdream.com
 *         2017/8/9 13:48
 */
public class SecurityBaseUtils {
    private static final String KEY_SHA = "SHA";
    private static final String KEY_MD5 = "MD5";

    /**
     * MAC算法可选以下多种算法
     *
     * <pre>
     * HmacMD5
     * HmacSHA1
     * HmacSHA256
     * HmacSHA384
     * HmacSHA512
     * </pre>
     */
    public static final String KEY_MAC = "HmacMD5";

    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * MD5加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance(KEY_MD5);
        md5.update(data);
        return md5.digest();

    }

    /**
     * SHA加密
     *
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptSHA(byte[] data) throws Exception {
        MessageDigest sha = MessageDigest.getInstance(KEY_SHA);
        sha.update(data);
        return sha.digest();

    }

    /**
     * 初始化HMAC密钥
     *
     * @return
     * @throws Exception
     */
    public static String initMacKey() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_MAC);
        SecretKey secretKey = keyGenerator.generateKey();
        return encryptBASE64(secretKey.getEncoded());
    }

    /**
     * HMAC加密
     *
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] encryptHMAC(byte[] data, String key) throws Exception {

        SecretKey secretKey = new SecretKeySpec(decryptBASE64(key), KEY_MAC);
        Mac mac = Mac.getInstance(secretKey.getAlgorithm());
        mac.init(secretKey);

        return mac.doFinal(data);
    }

    /**
     * 参数过滤: 除去空值和签名参数
     *
     * @param params 参数信息
     * @return 处理后参数信息
     */
    public static Map<String, String> paramFilter(Map<String, String> params) {
        Map<String, String> result = new HashMap<>();
        params.forEach((k, v) -> {
            if ((v == null) || (v.equals("")) || (k.equalsIgnoreCase("sign")) ||
                    (k.equalsIgnoreCase("sign_type"))) {
            }else {
                result.put(k, v);
            }
        });
        return result;
    }

    /**
     * 构造参数拼接字符串
     * 把所有参数排序, 并按照“参数=参数值”的模式用“&”字符拼接成字符串
     *
     * @param params 参数信息
     * @return 拼接后参数字符串
     */
    public static String buildLinkedParamStr(Map<String, String> params) {

        List<String> keys = new ArrayList<>(params.keySet());
        Collections.sort(keys);

        StringBuilder paramStr = new StringBuilder();

        for (int i = 0; i < keys.size(); i++) {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) { //拼接时，不包括最后一个&字符
                paramStr.append(key).append("=").append(value);
            } else {
                paramStr.append(key).append("=").append(value).append("&");
            }
        }

        return paramStr.toString();
    }
}
