package com.boot.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @Author fuyuan
 * @Description
 **/
@SpringBootApplication
@MapperScan("com.boot.boot.mapper")
//@ImportResource(locations = {"classpath:quartz-triggers.xml"})
@EnableCaching   //开启缓存
@EnableTransactionManagement

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
-Xmn256m （新生代大小）
-Xss256k （棧最大深度大小）
-XX:SurvivorRatio=8 （新生代分区比例 8:2）
-XX:+UseConcMarkSweepGC （指定使用的垃圾收集器，这里使用CMS收集器）
-XX:+PrintGCDetails （打印详细的GC日志）*/



        /* -XX:+UseConcMarkSweepGC -XX:+UseParNewGC */
        /*


2. 并行／吞吐优先收集器Parallel/Throughput Collector

这是JVM默认的收集器，跟它名字显示的一样，它最大的优点是使用多个线程来扫描和压缩堆。缺点是在minor和full GC的时候都会暂停应用的运行。并行收集器最适合用在可以容忍程序停滞的环境使用，它占用较低的CPU因而能提高应用的吞吐（throughput）。

使用方法：-XX:+UseParallelGC

3. CMS收集器CMS Collector

接下来是CMS收集器，CMS是Concurrent-Mark-Sweep的缩写，并发的标记与清除。这个算法使用多个线程并发地（concurrent）扫描堆，标记不使用的对象，然后清除它们回收内存。在两种情况下会使应用暂停（Stop the World, STW）：1. 当初次开始标记根对象时initial mark。2. 当在并行收集时应用又改变了堆的状态时，需要它从头再确认一次标记了正确的对象final remark。

这个收集器最大的问题是在年轻代与老年代收集时会出现的一种竞争情况（race condition），称为提升失败promotion failure。对象从年轻代复制到老年代称为提升promotion，但有时侯老年代需要清理出足够空间来放这些对象，这需要一定的时间，它收集的速度可能赶不上不断产生的要提升的年轻代对象的速度，这时就需要做STW的收集。STW正是CMS想避免的问题。为了避免这个问题，需要增加老年代的空间大小或者增加更多的线程来做老年代的收集以赶上从年轻代复制对象的速度。

除了上文所说的内容之外，CMS最大的问题就是内存空间碎片化的问题。CMS只有在触发FullGC的情况下才会对堆空间进行compact。如果线上应用长时间运行，碎片化会非常严重，会很容易造成promotion failed。为了解决这个问题线上很多应用通过定期重启或者手工触发FullGC来触发碎片整理。

对比并行收集器它的一个坏处是需要占用比较多的CPU。对于大多数长期运行的服务器应用来说，这通常是值得的，因为它不会导致应用长时间的停滞。但是它不是JVM的默认的收集器。

使用CMS需要仔细分析自己的应用对象生命周期，尤其是在应用要求高性能，高吞吐。需要仔细分析自己应用所需要的heap大小，老年代，新生代的分配比例，以及survival区的大小。设置不合理会很容易造成性能问题。后续会有专门的文章来介绍。

使用方法：-XX：+UseConcMarkSweepGC，此时可同时使用-XX:+UseParNewGC将并行收集作用于年轻代，新的JVM自动打开这一配置

4. G1收集器Garbage First Collector

如果你的堆内存大于4G的话，那么G1会是要考虑使用的收集器。它是为了更好支持大于4G堆内存在JDK 7 u4引入的。G1收集器把堆分成多个区域，大小从1MB到32MB，并使用多个后台线程来扫描这些区域，优先会扫描最多垃圾的区域，这就是它名称的由来，垃圾优先Garbage First。

如果在后台线程完成扫描之前堆空间耗光的话，才会进行STW收集。它另外一个优点是它在处理的同时会整理压缩堆空间，相比CMS只会在完全STW收集的时候才会这么做。

使用过大的堆内存在过去几年是存在争议的，很多开发者从单个JVM分解成使用多个JVM的微服务（micro-service）和基于组件的架构。其他一些因素像分离程序组件、简化部署和避免重新加载类到内存的考虑也促进了这样的分离。

除了这些因素，最大的因素当然是避免在STW收集时JVM用户线程停滞时间过长，如果你使用了很大的堆内存的话就可能出现这种情况。另外，像Docker那样的容器技术让你可以在一台物理机器上轻松部署多个应用也加速了这种趋势。

使用方法：－XX:+UseG1GC

Java 8和G1收集器

G1收集器在Java 8 u20上最漂亮的优化是String去重（String Deduplication）。String对象和它内部使用的char[]数组会占用比较多的内存，因此优化过的G1收集器会把重复的String对象指向同一个char[]数组，避免多个副本存在在堆里。可以使用-XX:+UseStringDeduplication参数来打开这一功能。

Java 8和永久代PermGen

Java 8最大的改变之一是去掉了永久代。永久代需要开发者仔细调节它的大小，过去多年这是产生OutOfMemory异常的重要原因。现在JVM可以自己管理这块区域了。

      1. 串行收集器Seiral Collector

串行收集器是最简单的，它设计为在单核的环境下工作（32位或者windows），你几乎不会使用到它。它在工作的时候会暂停整个应用的运行，因此在所有服务器环境下都不可能被使用。

使用方法：-XX:+UseSerialGC
       */

    }


}
