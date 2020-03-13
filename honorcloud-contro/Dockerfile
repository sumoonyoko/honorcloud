FROM openjdk:8-jdk-alpine
MAINTAINER sumoon "718685292@qq.com "
VOLUME /tmp
COPY target/*.jar honorcloud.jar
ENTRYPOINT ["java","-jar","/honorcloud.jar"]

#ÉèÖÃÊ±Çø
#RUN /bin/cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && echo 'Asia/Shanghai' >/etc/timezone