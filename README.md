DelayInducer
============

Show some weird oddities between ConcMark and G1 for java.

============
USAGE: /bin/sh runDelayInducer.sh

It will run the UseConcMarkSweepGC then the UseG1GC version.

This was run on Windows Server 2008R2 in a cygwin terminal, but very similar results are from native windows .BAT files.

CPU: AMD FX-4170 quad core 4.2GHz
OS: Windows Server 2008 R2 Standard SP1
MS Security Essentials installed/enabled: Yes/Yes : client version 4.6.305.0
System Memory: 16G

NOTE: This program tends to cause my memory controller to overheat when using G1GC. This typically occurs when there is a LOT of memory movement or high frequency random access of very far apart memory.



=============
Results (Was built using netbeans instead of maven, I don't have maven on cygwin at the moment)

$ /bin/sh runDelayInducer.sh
runDelayInducer.sh: line 2: mvn: command not found
-----------------------------
Running ConcMark version
-----------------------------

[GC (Allocation Failure)  4197K->501K(253440K), 0.0011741 secs]
[Full GC (Allocation Failure)  501K->477K(253440K), 0.0021999 secs]
[GC (Allocation Failure)  332637K->358161K(515652K), 0.8163480 secs]
[GC (CMS Initial Mark)  359562K(515652K), 0.0033224 secs]
[GC (Allocation Failure)  428177K->463106K(533700K), 0.3528348 secs]
[GC (Allocation Failure)  533122K->568129K(638532K), 0.4034945 secs]
[GC (Allocation Failure)  638145K->673151K(743556K), 0.4061996 secs]
[GC (Allocation Failure)  743167K->778174K(848580K), 0.4537421 secs]
[GC (Allocation Failure)  848190K->883196K(953604K), 0.3998292 secs]
[GC (Allocation Failure)  953212K->988219K(1058628K), 0.4000181 secs]
[GC (Allocation Failure)  1058235K->1093242K(1163652K), 0.4137504 secs]
[GC (Allocation Failure)  1163258K->1234229K(1304964K), 0.4329545 secs]
[GC (Allocation Failure)  1304245K->1343724K(1414596K), 0.4348737 secs]
[GC (Allocation Failure)  1413740K->1448945K(1519812K), 0.4235748 secs]
[GC (Allocation Failure)  1518961K->1558258K(1629060K), 0.4697530 secs]
[GC (Allocation Failure)  1628274K->1663281K(1734084K), 0.4236903 secs]
[GC (Allocation Failure)  1733297K->1768351K(1839300K), 0.4177170 secs]
[GC (Allocation Failure)  1838367K->1873423K(1944324K), 0.4225162 secs]
[GC (Allocation Failure)  1876224K->1884302K(1957188K), 0.0844524 secs]
[Full GC (Allocation Failure)  1884302K->1835654K(1957188K), 5.5478895 secs]
[GC (CMS Initial Mark)  2237049K(3366112K), 0.0004374 secs]
67108864|8262
[GC (Allocation Failure)  2501510K->2605006K(3366112K), 1.1562283 secs]
[GC (Allocation Failure)  2877646K->3100149K(3373216K), 1.5179355 secs]
[GC (Allocation Failure)  3214657K->3269438K(3542368K), 0.7898779 secs]
33554432|3856
[GC (Allocation Failure)  3542078K->3582163K(3855592K), 1.0010329 secs]
[GC (Allocation Failure)  3838444K->3924795K(4197736K), 1.2824674 secs]
16777216|1722
[GC (Allocation Failure)  4191172K->4170552K(4443496K), 0.9653011 secs]
8388608|817
4194304|366
2097152|145
1048576|50
524288|27
262144|11
131072|3
65536|2
32768|1
16384|0
8192|1
4096|0
2048|0
1024|0
512|0
256|0
128|0
64|0
32|0
16|0
8|0
4|0
2|0
-----------------------------
Running G1GC version
-----------------------------

[GC pause (G1 Humongous Allocation) (young) (initial-mark) 1229K->568K(256M), 0.0014794 secs]
[GC concurrent-root-region-scan-start]
[GC concurrent-root-region-scan-end, 0.0008663 secs]
[GC concurrent-mark-start]
[GC concurrent-mark-end, 0.0003964 secs]
[GC remark, 0.0008682 secs]
[GC cleanup 257M->257M(512M), 0.0006035 secs]
[GC pause (G1 Evacuation Pause) (young) 270M->269M(512M), 0.0321783 secs]
[GC pause (G1 Evacuation Pause) (young) 291M->294M(512M), 0.0853470 secs]
[GC pause (G1 Evacuation Pause) (young) (initial-mark) 314M->323M(1024M), 0.1012923 secs]
[GC concurrent-root-region-scan-start]
[GC concurrent-root-region-scan-end, 0.0127585 secs]
[GC concurrent-mark-start]
[GC pause (G1 Evacuation Pause) (young) 369M->372M(2048M), 0.1115802 secs]
[GC pause (G1 Evacuation Pause) (young) 466M->471M(3278M), 0.2056055 secs]
[GC concurrent-mark-end, 1.0609735 secs]
[GC remark, 0.0034597 secs]
[GC cleanup 473M->473M(3278M), 0.0014378 secs]
[GC pause (G1 Evacuation Pause) (young) 619M->624M(4262M), 0.3173215 secs]
[GC pause (G1 Evacuation Pause) (young) 814M->820M(5048M), 0.4274091 secs]
[GC pause (G1 Evacuation Pause) (young) 1044M->1048M(5678M), 0.4767812 secs]
[GC pause (G1 Evacuation Pause) (young) 1298M->1302M(6182M), 0.5400616 secs]
67108864|210838
[GC pause (G1 Evacuation Pause) (young) 2086M->2091M(6584M), 1.0463570 secs]
33554432|72261
[GC pause (G1 Evacuation Pause) (young) 2635M->2639M(6584M), 1.9410981 secs]
16777216|22074
[GC pause (G1 Evacuation Pause) (young) 3053M->3056M(6584M), 1.5731733 secs]
[GC pause (G1 Humongous Allocation) (young) (initial-mark) 3124M->3129M(6584M),0.4049486 secs]
[GC concurrent-root-region-scan-start]
[GC concurrent-root-region-scan-end, 0.1883570 secs]
[GC concurrent-mark-start]
[GC concurrent-mark-end, 1.1174309 secs]
[GC remark, 0.0018856 secs]
[GC cleanup 3178M->240M(6584M), 0.0384332 secs]
[GC concurrent-cleanup-start]
[GC concurrent-cleanup-end, 0.0243909 secs]
8388608|7012
4194304|510
2097152|206
1048576|86
524288|35
262144|16
131072|4
65536|2
32768|2
16384|1
8192|0
4096|0
2048|0
1024|0
512|0
256|0
128|0
64|0
32|0
16|0
8|0
4|0
2|0