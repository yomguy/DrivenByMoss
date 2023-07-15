if [ -d "/home/mos/java/jdk-17.0.5+8" ]; then
    export JAVA_HOME=/home/mos/java/jdk-17.0.5+8
else
    export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64
fi

mvn clean install package -Dbitwig.extension.directory=target
