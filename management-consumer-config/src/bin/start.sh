#!/bin/sh
echo "-------------------------------------------"
echo "start server"
echo "-------------------------------------------"
# 设置项目代码路径
export CODE_HOME="/data/weball/babyskymng"
# 设置依赖路径
export CLASSPATH=${CODE_HOME}"/WEB-INF/classes:"${CODE_HOME}"/WEB-INF/lib/*"
# JVM启动参数
export JAVA_OPTS="-server -Xms128m -Xmx256m -Xss256k -XX:MaxDirectMemorySize=128m"
# 启动类
export MAIN_CLASS=com.shiro.management.Bootstrap
java ${JAVA_OPTS} -classpath ${CLASSPATH} ${MAIN_CLASS}
tail -f ../logs/info.log