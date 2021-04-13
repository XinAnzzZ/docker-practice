### docker-practice

#### 1、新建一个 Spring Boot 项目

略

#### 2、增加 maven-docker 插件

在 pom 文件的 `plugins` 标签中增加以下内容，并且修改对应的参数。

```xml

<plugin>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-maven-plugin</artifactId>
</plugin>

        <!-- Docker maven plugin -->
<plugin>
<groupId>com.spotify</groupId>
<artifactId>docker-maven-plugin</artifactId>
<version>1.0.0</version>
<configuration>
    <imageName>${docker.image.prefix}/${project.artifactId}</imageName>
    <dockerDirectory>src/main/docker</dockerDirectory>
    <resources>
        <resource>
            <targetPath>/</targetPath>
            <directory>${project.build.directory}</directory>
            <include>${project.build.finalName}.jar</include>
        </resource>
    </resources>
</configuration>
</plugin>
```

#### 3、定义部署脚本

详见根目录下 `deploy.sh` 文件。

#### 4、初始化 git 仓库并提交代码

略。

#### 5、服务器克隆代码

略。

#### 6、部署项目

运行根目录下的部署脚本，本地测试是否可以访问。

#### 7、配置 Nginx 反向代理

登录服务器，进入 `/root/dokcer/nginx` 目录，编辑 `nginx.conf` 文件，新增 `server` 模块，内容如下：

```
server {
      listen 80;
      server_name docker-practice.yuhangma.com;
      location / {
          proxy_pass http://172.17.0.10:9001;
      }
 }
```

进入 `~/docker/nginx` 目录下（即 `docker-compost.yml` 所在目录）执行 `docker-compose restart` 来重启 `Nginx` 容器（也可以使用别名 `dcp restart`）。