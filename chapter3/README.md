启动命令
mvn tomcat7:run -f pom.xml
端口设置
```xml
<plugin>
                   <groupId>org.apache.tomcat.maven</groupId>
                   <artifactId>tomcat7-maven-plugin</artifactId>
                   <version>2.2</version>
                   <configuration>
                       <port>8080</port>
                       <path>/${project.artifactId}</path>
                   </configuration>
               </plugin>
 ```
 访问路径
 http://localhost:8080/chapter3/testView