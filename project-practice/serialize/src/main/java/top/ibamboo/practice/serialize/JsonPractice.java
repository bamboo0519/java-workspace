package top.ibamboo.practice.serialize;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import java.io.*;

/**
 * Created by bamboo on 2017/9/7.
 */
public class JsonPractice {


    public String toJson(Object obj) {
        Gson gson = new Gson();
        return gson.toJson(obj);
    }

    public DBObject toSerialize(Object obj) throws IOException {
        DBObject dbo = new BasicDBObject();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(outputStream);
        try {
            out.writeObject(obj);
            // 转成2进制存储
            dbo.put(obj.getClass().toString(), outputStream.toByteArray());
        } finally {
            out.close();
            outputStream.close();
        }

        return dbo;
    }

    public Object toDeserialize(DBObject dbo, Class clazz) throws IOException, ClassNotFoundException {

        byte[] javaObjectByte = (byte[]) dbo.get(clazz.toString());
        InputStream inputStream = new ByteArrayInputStream(javaObjectByte);
        ObjectInputStream in = new ObjectInputStream(inputStream);
        try {
            Object object =  in.readObject();
            return object;
        }finally {
            in.close();
            inputStream.close();
        }
    }

}
