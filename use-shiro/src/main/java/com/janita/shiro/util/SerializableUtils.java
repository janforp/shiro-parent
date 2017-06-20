package com.janita.shiro.util;

import org.apache.shiro.codec.Base64;
import org.apache.shiro.session.Session;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Created by Janita on 2017/6/20 0020-下午 4:07
 * 该类是：
 */
public class SerializableUtils {

    /**
     * 序列化 session
     * @param session
     * @return
     */
    public static String serialize(Session session) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(session);
            return Base64.encodeToString(byteArrayOutputStream.toByteArray());
        }catch (Exception e){
            throw new RuntimeException("serialize session error", e);
        }
    }

    /**
     * 反序列化
     * @param sessionStr
     * @return
     */
    public static Session deserialize(String sessionStr) {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(Base64.decode(sessionStr));
            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            return (Session) objectInputStream.readObject();
        }catch (Exception e) {
            throw new RuntimeException("deserialize session error", e);

        }
    }
}
