# 如何运行
1.确保已安装 JDK 17 、 Maven 和 Git。

2.克隆仓库：
git clone https://github.com/hanzunhao/competition-web-back-end.git

3.移动到项目文件夹 
cd competition-web-back-end

4.安装依赖：
mvn clean install

5.运行项目：
mvn spring-boot:run

# 构建生产环境
mvn clean package
构建后的 JAR 文件将生成在 target 目录中。

# 预览生产环境
java -jar target/your-project-name.jar
后端服务将运行在 http://localhost:8080。
