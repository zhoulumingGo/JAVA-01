学习笔记

1、使用GCLogAnalysis.java自己演练一遍串行/并行/CMS/G1的案例
吞吐量分析：其它参数相同情况下，不同垃圾收集器的系统吞吐量也有区别，而不同的垃圾收集器在不同的堆大小下性能也不一致，没有哪一个垃圾收集器能够做到全场景适用。单论吞吐量而言，在只有几百兆内存的情况下，串行GC和CMSGC的表现更好；在1G到4G之间，G1的表现更好；在6G-8G以上，并行GC的吞吐量最好。

GC分析：在堆内存较小时，young gc与full gc发生次数较多。随着内存的增大，young gc与full gc发生的频率降低，但是并非内存越大，效率就越高。因为内存越大，每次gc所需要清理的内存就越大，gc时间相应增大。在业务吞吐要求较高、响应时间要求不高的情况下可以使用并行gc，在业务响应时间要求较高的情况下，选择cms gc或者g1 gc,尤其是当内存较大时，使用G1效果较明显。

2、使用压测工具（wrk或sb），演练gateway-server-0.0.1-SNAPSHOT.jar示例

# SerialGC

java  -jar  -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseSerialGC  -XX:+PrintGCDetails -XX:+PrintGCDateStamps gateway-server-0.0.1-SNAPSHOT.jar

# ParallelGC

java  -jar -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseParallelGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps gateway-server-0.0.1-SNAPSHOT.jar

# ConcMarkSweepGC

java  -jar  -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseConcMarkSweepGC -XX:+PrintGCDetails -XX:+PrintGCDateStamps gateway-server-0.0.1-SNAPSHOT.jar

# G1GC

java  -jar -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps gateway-server-0.0.1-SNAPSHOT.jar

压测命令：sb -u http://localhost:8088/api/hello -c 10 -N 30

结论：在相同的配置和压测条件下，不同GC收集器的对象分配速率也有区别，而且在一定范围内，对象的分配速率越高，系统的吞吐量也越高，但是如果新生代分配的太小，导致系统频繁的进行YGC，也会降低系统的吞吐量，因此对于新生代的大小，也要设置合理的值，设置太大，一次GC停顿时间太长，业务可能无法接受，设置太小，频繁进行YGC，会降低系统吞吐量。
