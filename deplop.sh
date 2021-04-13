#!/bin/bash

# 获取当前脚本所在路径，也就是项目根目录
WORK_PATH=$(dirname $(readlink -f $0));

cd ${WORK_PATH}

git pull --rebase origin main

mvn clean package -Dmaven.test.skip

# 停止并删除容器
docker stop docker-practice
docker rm docker-practice

# 删除镜像文件
docker rmi spring-boot/docker-practice

# 打包镜像文件
mvn docker:build

# 启动
docker run -d -p 9006:9006 --name=docker-practice spring-boot/docker-practice