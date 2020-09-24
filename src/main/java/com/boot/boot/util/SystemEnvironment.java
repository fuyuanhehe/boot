package com.boot.boot.util;

import java.io.IOException;
import java.lang.management.ManagementFactory;
import java.util.Random;
import java.util.Scanner;

public class SystemEnvironment {
    /**
     * 处理器的核心数
     * */
    public static final int PROCESSOR = Runtime.getRuntime().availableProcessors();

    /**
     * 机器码
     * */
    public static final String MAC_CODE;

    /**
     * 说明，当前JVM的进程号
     * */
    public static final String PID = ManagementFactory.getRuntimeMXBean().getName().split("@")[0];

    static {
        MAC_CODE = getMac();
    }

    /**
     * 获得机器码
     * */
    private static String getMac() {
        Process process = null;
        String serial = null;
        try {
            process = Runtime.getRuntime().exec(new String[] { "wmic", "cpu", "get", "ProcessorId" });
            process.getOutputStream().close();
            Scanner sc = new Scanner(process.getInputStream());
            String property = sc.next();
            serial = sc.next();
        } catch (IOException e) {
            serial = CCtticStringUtils.getRandomString(8);
        }
        return serial;
    }
}
