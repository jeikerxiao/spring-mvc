# spring-mvc-servlet

实现Servlet的三种方式

1. 编写一个类去实现 `Servlet` 接口(必须重写`Servlet`接口里面所有的抽象方法)
2. 编写一个类去继承 `GenericServlet` 抽象类(重写生命周期的`service`方法（抽象方法）)`GenericServle`抽象类它实现了`Servlet`接口，还实现了ServletConfig接口(这个接口中提供了一个`getServletContext`方法)可以在编写一个类中直接调用`getServletContext`方法就可以获得`ServletContext`对象。（开发中不常用）
3. 编写一个类去继承 `HttpServlet` 抽象类(没有抽象方法！根据页面的提交方式决定重写doGet或者doPost方法)

通过三个Demo演示了Servlet的进化。

1. Demo1直接使用`Servlet`接口
2. Demo2继承`GenericServlet`类
3. Demo3继承`HttpServlet`类

## 1.Servlet

```java
public class ServletDemo1 implements Servlet {

    private final Logger logger = Logger.getLogger("ServletDemo1");

    public void init(ServletConfig servletConfig) throws ServletException {
        logger.info("ServletDemo1 - init()");
    }

    public ServletConfig getServletConfig() {
        logger.info("ServletDemo1 - getServletConfig()");
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("ServletDemo1 - service()");
        servletResponse.getWriter().write("ServletDemo1 - Hello World");
    }

    public String getServletInfo() {
        logger.info("ServletDemo1 - getServletInfo()");
        return null;
    }

    public void destroy() {
        logger.info("ServletDemo1 - destroy()");

    }
}
```

## 2.GenericServlet

```java
public class ServletDemo2 extends GenericServlet {

    private final Logger logger = Logger.getLogger("ServletDemo3");

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        logger.info("ServletDemo2 - service()");
        servletResponse.getWriter().write("ServletDemo2 - Hello World");
    }
}

```

## 3.HttpServlet

```java
public class ServletDemo3 extends HttpServlet {

    private final Logger logger = Logger.getLogger("ServletDemo3");

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        logger.info("ServletDemo3 - doGet()");
        response.getWriter().write("ServletDemo3 - Hello World");
    }

}

```

## 4.web配置

web.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
         http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">

    <display-name>ServletDemo</display-name>

    <servlet>
        <servlet-name>servletDemo1</servlet-name>
        <servlet-class>com.jeiker.ServletDemo1</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>servletDemo1</servlet-name>
        <url-pattern>/demo1</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>servletDemo2</servlet-name>
        <servlet-class>com.jeiker.ServletDemo2</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>servletDemo2</servlet-name>
        <url-pattern>/demo2</url-pattern>
    </servlet-mapping>

    <servlet>
        <servlet-name>servletDemo3</servlet-name>
        <servlet-class>com.jeiker.ServletDemo3</servlet-class>
    </servlet>
    <servlet-mapping>
        <servlet-name>servletDemo3</servlet-name>
        <url-pattern>/demo3</url-pattern>
    </servlet-mapping>

    <welcome-file-list>
        <welcome-file>index.html</welcome-file>
    </welcome-file-list>
</web-app>
```

## 访问测试

1. GET http://localhost:8080/demo1
1. GET http://localhost:8080/demo2
1. GET http://localhost:8080/demo3