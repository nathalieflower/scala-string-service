FROM openjdk:8-jdk-alpine

ENV SBT_VERSION 0.13.15

RUN apk add --no-cache bash curl openrc git && \
    curl -sL "http://dl.bintray.com/sbt/native-packages/sbt/$SBT_VERSION/sbt-$SBT_VERSION.tgz" | gunzip | tar -x -C /usr/local && \
    ln -s /usr/local/sbt/bin/sbt /usr/local/bin/sbt && \
    chmod 0755 /usr/local/bin/sbt && \
    apk add --no-cache --repository http://dl-cdn.alpinelinux.org/alpine/edge/main --repository  http://dl-cdn.alpinelinux.org/alpine/edge/community docker

WORKDIR /scala-string-service
ADD . /scala-string-service
EXPOSE 9000
CMD sbt run
