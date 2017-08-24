package repository.util.dataflow;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by C0907 on 2017/8/17.
 */
public class ZipUtil {
    private final static Charset CHARSET = Charset.forName("UTF-8");

    /**
     * 压缩多个ByteArrayOutputStream; 输出InputStream
     * @param map： key为被压缩流的文件名字， value为ByteArrayOutputStream, 已经被写入数据
     * @return InputStream， 压缩之后的数据，转换成的输入流
     * @throws IOException
     *
     * TODO  测试能压缩多大的流？ 效率如何？ 压缩比如何？
     * TODO 限制使用内存的大小 （使用多线程实现pipe）
     */
    public static InputStream zipOutputStreams(Map<String, ByteArrayOutputStream> map) throws IOException {
        ByteArrayOutputStream zipBuffer = new ByteArrayOutputStream();
        ZipOutputStream zipOutputStream = new ZipOutputStream(zipBuffer, CHARSET);
        byte[] buff = new byte[1024];
        try {
            for(String key : map.keySet()) {
                zipOutputStream.putNextEntry(new ZipEntry(key));
                ByteArrayInputStream byteArrayInputStream = null;
                try{
                    byteArrayInputStream = new ByteArrayInputStream(map.get(key).toByteArray());
                    int size;
                    while ((size = byteArrayInputStream.read(buff, 0, buff.length)) != -1) {
                        zipOutputStream.write(buff, 0, size);
                    }
                }finally {
                    if(byteArrayInputStream != null) {
                        byteArrayInputStream.close();
                    }
                }
            }
        }finally {
            // zipOutputStream必须先于zipBuffer.toByteArray()，否则zip文件不完整
            zipOutputStream.closeEntry();
            zipOutputStream.close();
            zipBuffer.close();
        }
        return new ByteArrayInputStream(zipBuffer.toByteArray());
    }
}
