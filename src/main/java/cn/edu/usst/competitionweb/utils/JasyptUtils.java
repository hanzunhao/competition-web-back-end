package cn.edu.usst.competitionweb.utils;

import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;

public class JasyptUtils {
    public static String stringEncryptor(String secretKey, String message, boolean isEncrypt) {
        PooledPBEStringEncryptor pooledPBEStringEncryptor = new PooledPBEStringEncryptor();
        pooledPBEStringEncryptor.setConfig(getSimpleStringPBEConfig(secretKey));
        return isEncrypt ? pooledPBEStringEncryptor.encrypt(message) : pooledPBEStringEncryptor.decrypt(message);
    }

    private static SimpleStringPBEConfig getSimpleStringPBEConfig(String secretKey) {
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword(secretKey);
        config.setPoolSize("1");
        config.setAlgorithm("PBEWithMD5AndDES");
        config.setKeyObtentionIterations("1000");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.RandomIvGenerator");
        config.setStringOutputType("base64");
        return config;
    }

    public static void main(String[] args) {
        String message = "d6084df1b2d743a8aa2e99e339a461cb";
        String password = "wangmaox";

        String jasyptEncrypt = stringEncryptor(password, message, true);
        System.out.println("密文:"+jasyptEncrypt);

        String jasyptEncrypt1 = stringEncryptor(password, "n2WQziIxyBibmuydZcImOd0no7NGr76oKrIBkaq+b8BkPVRj7pBrkjcXs0/6jxxmfhPyYJQLJxQ=", false);
        System.out.println("明文:"+jasyptEncrypt1);
    }
}
