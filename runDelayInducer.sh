#!/bin/sh
mvn clean package
echo "-----------------------------"
echo "Running ConcMark version"
echo "-----------------------------"
echo
java -Xmx8G -verbose:gc -XX:+UseConcMarkSweepGC -cp target/DelayInducer-1.0-SNAPSHOT.jar com.allennet.delayinducer.DelayInducer
echo "-----------------------------"
echo "Running G1GC version"
echo "-----------------------------"
echo
java -Xmx8G -verbose:gc -XX:+UseG1GC -cp target/DelayInducer-1.0-SNAPSHOT.jar com.allennet.delayinducer.DelayInducer