# Полезные ссылки
____
## Верстка
+ https://www.youtube.com/watch?v=MEOR2b69Pl4&t=3s - Гриды
+ https://www.youtube.com/watch?v=eVZEwEQg4pg - Флексы
+ https://www.youtube.com/watch?v=WWtEPKaSpIw - HTML/CSS/Bootstrap
## JSTL и EL
+ https://metanit.com/java/javaee/ - вся база по Java EE(наша глава 4), топ за свои деньги
+ https://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm - шпаргалка по JSTL
+ https://www.tutorialspoint.com/jsp/jsp_expression_language.htm - шпаргалка по EL

----

## JSTL(кукбук)

----
### Подключение зависимости в Maven и основные элементы на JSP странице
```xml
<dependency>
    <groupId>jstl</groupId>
    <artifactId>jstl</artifactId>
    <version>1.2</version>
</dependency>
```

```html
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <style><%@include file="../styles/style.css"%></style>
    </head>
    <body>
        <%@include file="header.jsp" %>
        <div>
            
        </div>
    </body>
</html>
```

----

### Передача данных из сервлета в JSP

Есть несколько способов передачи данных из сервлета в jsp, которые заключаются в использовании определенного контекста или scope. Есть несколько контекстов для передачи данных:

* **request** (контекст запроса): данные сохраняются в HttpServletRequest
* **session** (контекст сессии): данные сохраняются в HttpSession
* **application** (контекст приложения): данные сохраняются в ServletContext

Данные из контекста запроса доступны только в пределах текущего запроса. Данные из контекста сессии доступны только в пределах текущего сеанса. А данные из контекста приложения доступны постоянно, пока работает приложение.

Но вне зависимости от выбранного способа передача данных осуществляется с помощью метода setAttribute(name, value), где name - строковое название данных, а value - сами данные, которые могут представлять различные данные.

### Получение данных на JSP странице
Это Expression Language, атрибуты достаются из контекстов, подробнее здесь - https://metanit.com/java/javaee/3.9.php

```html
${attribute}
${object.property}
```

----

### Пример по передачи и получению данных

**HelloServlet.java**
```java
@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("msg", "someMessage");
        req.getServletContext().getRequestDispatcher("/pages/hello.jsp").forward(req, resp);
    }
}
```

**hello.jsp**
```html
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Тут выводится сообщение - ${msg}
</body>
</html>
```

----

### Переход из сервлета

```java
resp.sendRedirect(req.getContextPath() + "/users");

req.getServletContext()
.getRequestDispatcher("/pages/users.jsp")
.forward(req, resp);
```


Получить и закрыть сессию(при выходе из аккаунта)
```java
HttpSession session = request.getSession(false);
session.invalidate();
```

### Основные JSTL операторы(остальное в шпоре)

```html
<c:if test="${какое-то условие}">
    показали контент, если выполнилось
</c:if>
```

```html
<c:choose>
    <c:when test="${Role.ADMIN.equals(user.getRole())}">
        Тут контент для админа
    </c:when>
    <c:when test="${Role.USER.equals(user.getRole())}">
        Тут для обычного пользователя
    </c:when>
    <c:otherwise>
        Если ничего выше не сработало
    </c:otherwise>
</c:choose>
```

```html
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.id}</td>
        <td>${user.login}</td>
        <td>${user.password}</td>
    </tr>
</c:forEach>
```


## Техническое задание

1. [ ] Навигационная панель, которая будет отличаться для различных ролей
2. [ ] Форма авторизации
3. [ ] Форма создания пользователя на одной странице со списком пользователей
4. [ ] Сделать выход из аккаунта
5. [ ] Сделать страницу со списком дел
6. [ ] Сделать кнопку для отметки дела выполненным
7. [ ] Сделать отдельную страницу для просмотра дела

