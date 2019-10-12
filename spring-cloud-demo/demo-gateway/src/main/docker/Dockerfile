FROM tomcat:8.5.35-jre8-alpine
MAINTAINER hope <hopecyb@163.com>

# 设置tomcat的环境变量
ENV CATALINA_HOME /usr/local/tomcat

RUN echo "http://mirrors.aliyun.com/alpine/v3.8/main" > /etc/apk/repositories \
    && echo "http://mirrors.aliyun.com/alpine/v3.8/community" >> /etc/apk/repositories \
    && apk update upgrade \
    && apk add --no-cache procps unzip curl bash tzdata \
    && ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime \
    && echo "Asia/Shanghai" > /etc/timezone

# 复制启动脚本至镜像，并赋予脚本可执行权限
ADD run.sh /run.sh
RUN chmod +x /*.sh
RUN chmod +x /usr/local/tomcat/bin/*.sh

RUN rm -rf $CATALINA_HOME/webapps/*
ADD *.war $CATALINA_HOME/webapps/
ADD context.xml $CATALINA_HOME/conf/

# 暴露端口
EXPOSE 8080

# 设置自启动命令
CMD ["/run.sh"]