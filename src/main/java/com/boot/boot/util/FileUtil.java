package com.boot.boot.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 */
public class FileUtil {

    //文件上传工具类服务方法

    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {

        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

    public static void main(String[] args) {

     //   System.err.println( xx());

        Map<String,Object> m = new TreeMap<>();
        m.put("a",333);
        m.put("h",100);
        m.put("b",22);

        Set<Map.Entry<String, Object>> en = m.entrySet();

        for (Map.Entry<String, Object> stringObjectEntry : en) {
            System.out.println(stringObjectEntry.getKey());
        }


    }


    private static   int xx() {

        new Thread(new Runnable() {

            @Override
            public void run() {

                for (int i = 0; i < 5; i++) {

                    System.out.println(i);
                }
            }
        }).start();

      return 10;
    }


}
