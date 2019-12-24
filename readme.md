## netty-tcp
Echo TCP服务器和客户端

## netty-udp
Echo UDP服务器和客户端

## maven-executable-demo
使用maven-shade-plugin打包
```
# 注意选择合适的setttings.xml配置文件
clean package -Dmaven.test.skip=true -f pom.xml -t xxx.setttings.xml
```