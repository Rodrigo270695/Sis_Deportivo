package com.deportivo.properties;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class Encriptado {

    public String encriptar(String clave, String contrasena) {

        String encriptado = "";

        try {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte llavePassword[] = md5.digest(clave.getBytes("utf-8"));
            byte bytesKey[] = Arrays.copyOf(llavePassword, 24);
            SecretKey key = new SecretKeySpec(bytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE, key);
            byte cadenaBytes[] = contrasena.getBytes("utf-8");
            byte buf[] = cifrado.doFinal(cadenaBytes);
            byte base64Bytes[] = Base64.encodeBase64(buf);
            encriptado = new String(base64Bytes);
            
            
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace(System.err);
        }

        return encriptado;
    }
    
    public String desencriptar(String clave, String contrasena) {

        String desencriptado = "";

        try {

            byte message[] = Base64.decodeBase64(contrasena.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte desContra[] = md5.digest(clave.getBytes("utf-8"));
            byte keyBytes[] = Arrays.copyOf(desContra, 24);
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.DECRYPT_MODE, key);
            byte texto[] = cifrado.doFinal(message);
            desencriptado = new String(texto,"utf-8");
            
            
        } catch (UnsupportedEncodingException | InvalidKeyException | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException | NoSuchPaddingException e) {
            e.printStackTrace(System.err);
        }

        return desencriptado;
    }

}
