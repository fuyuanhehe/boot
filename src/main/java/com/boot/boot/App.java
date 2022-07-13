package com.boot.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author fuyuan
 * @Description
 **/
@SpringBootApplication
@MapperScan(value = {"com.boot.boot.mapper","com.boot.boot.sharding"})
//@ImportResource(locations = {"classpath:quartz-triggers.xml"})
@EnableCaching   //开启缓存

@EnableScheduling  // boot 定时任务
@EnableRabbit // 启用@RabbitListener
@EnableFeignClients
public class App {


    public static void main(String[] args) {
        SpringApplication.run(App.class, args);


        /*-XX:MetaspaceSize=128m （元空间默认大小）
-XX:MaxMetaspaceSize=128m （元空间最大大小）
-Xms1024m （堆最大大小）
-Xmx1024m （堆默认大小）
-Xmn256m （新生代大小）   老年代 = -Xmx1024m - -Xmn256m
-Xss256k （棧最大深度大小）
-XX:SurvivorRatio=8 （新生代分区比例 8:2）
-XX:+PrintGCDetails （打印详细的GC日志）
内存溢出
-XX:+HeapDumpOnOutOfMemoryError
-XX:HeapDumpPath=/usr/local/dump
gc 日志
-XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:/data/log/gclog/gc.log



        堆设置
                -Xms:初始堆大小
                -Xmx:最大堆大小
                -Xmn:新生代大小
                -XX:NewRatio:设置新生代和老年代的比值。如：为3，表示年轻代与老年代比值为1：3
                -XX:SurvivorRatio:新生代中Eden区与两个Survivor区的比值。注意Survivor区有两个。如：为3，表示Eden：Survivor=3：2，一个Survivor区占整个新生代的1/5
                -XX:MaxTenuringThreshold:设置转入老年代的存活次数。如果是0，则直接跳过新生代进入老年代
                -XX:PermSize、-XX:MaxPermSize:分别设置永久代最小大小与最大大小（Java8以前）
        -XX:MetaspaceSize、-XX:MaxMetaspaceSize:分别设置元空间最小大小与最大大小（Java8以后）
        收集器设置
                -XX:+UseSerialGC:设置串行收集器
                -XX:+UseParallelGC:设置并行收集器
                -XX:+UseParalledlOldGC:设置并行老年代收集器
                -XX:+UseConcMarkSweepGC:设置并发收集器
                垃圾回收统计信息
        -XX:+PrintGC
                -XX:+PrintGCDetails
                -XX:+PrintGCTimeStamps
                -Xloggc:filename
                并行收集器设置
        -XX:ParallelGCThreads=n:设置并行收集器收集时使用的CPU数。并行收集线程数。
        -XX:MaxGCPauseMillis=n:设置并行收集最大暂停时间
                -XX:GCTimeRatio=n:设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)
        并发收集器设置
                -XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况。
        -XX:ParallelGCThreads=n:设置并发收集器新生代收集方式为并行收集时，使用的CPU数。并行收集线程数。



cms
-XX:+UseConcMarkSweepGC -XX:+UseParNewGC
-XX:+UseConcMarkSweepGC （指定使用的垃圾收集器，这里使用CMS收集器） 标记-清除
-XX:CMSInitiatingOccupancyFraction=75 -XX:+UseCMSInitiatingOccupancyOnly  gc阈值

触发内存整理 第一个参数是开启这个能力，第二个参数表示在压缩（compaction）内存之前需要发生多少次不压缩内存的FGC
-XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=0


  g1 标记-整理
  开发人员仅仅需要声明以下参数即可：
        -XX:+UseG1GC -Xmx32g -XX:MaxGCPauseMillis=200

        其中-XX:+UseG1GC为开启G1垃圾收集器，-Xmx32g 设计堆内存的最大内存为32G，
        -XX:MaxGCPauseMillis=200设置GC的最大暂停时间为200ms。如果我们需要调优，
        在内存大小一定的情况下，我们只需要修改最大暂停时间即可。
          */


    }


}
