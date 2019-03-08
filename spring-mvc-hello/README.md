# spring-mvc-hello


spring-mvc 的最精简的配置demo.


# 依赖引用

pom.xml

```xml
<dependencies>
    <!-- servlet-api -->
    <dependency>
        <groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
        <!-- 编译，测试阶段使用，运行阶段不需要，容器中有-->
        <scope>provided</scope>
    </dependency>
    <!-- spring-webmvc -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.1.1.RELEASE</version>
    </dependency>
</dependencies>
```

# Spring MVC最简配置

1. 在`web.xml`中配置Servlet.
2. 创建`Spring MVC`的xml配置文件。
3. 创建Controller和View.

## 1.在`web.xml`中配置Servlet

在工程的`src/main`下的创建`webapp/WEB-INF/web.xml`文件。

web.xml

```xml
<?xml version="1.0"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee
        http://xmlns.jcp.org/xml/ns/javaee/web-app_3_1.xsd"
         version="3.1">

    <!-- spring mvc 配置开始-->
    <servlet>
        <servlet-name>spring-mvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>spring-mvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
    <!-- spring mvc 配置结束-->

    <!-- 欢迎页-->
    <welcome-file-list>
        <welcome-file>index</welcome-file>
    </welcome-file-list>

</web-app>
```

说明：

1. 这里配置了一个叫 `spring-mvc`的Servlet,并指定了servlet类文件DispatcherServlet,这是Spring MVC的入口，并设置了自动启动。
2. 然后映射所有请求（"/"）到这个Servlet中去处理。
3. Spring MVC的本质是一个Servlet。
4. 在配置DispatcherServlet的时候，可以通过`contextConfigLocation`参数来指定Spring MVC文件的位置，如果不指定，默认使用`WEB-INF/[ServletName]-servlet.xml`文件来访问。这里就使用默认方式配置Spring MVC文件：`WEB-INF/spring-mvc-servlet.xml`。

## 2.创建`Spring MVC`的xml配置文件

使用默认的位置和命名规则来创建`Spring MVC`的xml配置文件。

创建`WEB-INF/spring-mvc-servlet.xml`文件。

```xml
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        http://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
        http://www.springframework.org/schema/mvc/spring-mvc.xsd">

    <!-- 启动注解驱动的spring MVC功能,注册请求url和注解POJO类方法的映射 -->
    <mvc:annotation-driven/>
    <!-- 设置包扫描路径 -->
    <context:component-scan base-package="com.jeiker.controller"/>

</beans>
```

说明：

1. `<mvc:annotation-driven/>`是Spring MVC提供的一键式配置方法，配置此标签后，Spring MVC会自动帮我们注册一些组件。
2. `<context:component-scan base-package="com.jeiker"/>`标签来扫描通过注解配置的类。可以设置只扫描`@Controller`就可以了，其它的交给`spring`容器去管理。

## 3.创建Controller和View

### 创建 Controller

在`src/main/java`中创建`com.jeiker.controller`包，然后增加`HelloController`类。

```java
@Controller
public class HelloController {

    private final Log log = LogFactory.getLog(HelloController.class);

    @RequestMapping(value = "/", method = RequestMethod.HEAD)
    public String head() {
        log.info("in head()");
        return "hello.jsp";
    }

    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String index(Model model) {
        log.info("in index()");
        model.addAttribute("msg", "Hello World");
        return "hello.jsp";
    }
}

```

### 创建 View

在`src/main/webapp`下创建 `hello.jsp`

```html
<%@ page contentType="text/html; UTF-8" language="java" %>
<html>
<head>
    <title>hello</title>
</head>
<body>
${msg}
</body>
</html>
```

#启动测试

```
mvn jetty:run 
```

访问  GET: http://localhost:8080/

可以看到 Hello World  
