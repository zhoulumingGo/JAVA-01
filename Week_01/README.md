学习笔记
1、了解了Java源代码编译成class文件的过程，大致了解了常用的Java字节码。
2、学习了Java类的加载过程并通过作业实践了一个Java类的加载，了解了三种基本的Java类加载器。
3、学习了JVM内存结构，并通过画图加深了理解。
4、使用G1 GC启动了网关程序
java -Xmx1g -Xms1g -XX:-UseAdaptiveSizePolicy -XX:+UseSerialGC -jar gateway-server- 0.0.1-SNAPSHOT.jar
并仿照课上案例分析一下JVM运行情况。