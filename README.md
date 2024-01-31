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
### Задание

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


```js
    function create() {
        var login = document.getElementById("login").value;
        var password = document.getElementById("password").value;
    
        $.post("create", {title: title, author: author}, function () {
            redirect("users");
    });
}
```

### Передача данных из сервлета в JSP
Есть несколько способов передачи данных из сервлета в jsp, которые заключаются в использовании определенного контекста или scope. Есть несколько контекстов для передачи данных:

* **request** (контекст запроса): данные сохраняются в HttpServletRequest
* **session** (контекст сессии): данные сохраняются в HttpSession
* **application** (контекст приложения): данные сохраняются в ServletContext

Данные из контекста запроса доступны только в пределах текущего запроса. Данные из контекста сессии доступны только в пределах текущего сеанса. А данные из контекста приложения доступны постоянно, пока работает приложение.

Но вне зависимости от выбранного способа передача данных осуществляется с помощью метода setAttribute(name, value), где name - строковое название данных, а value - сами данные, которые могут представлять различные данные.


```html
    ${attribute}
    ${object.property}
```

resp.sendRedirect(req.getContextPath() + "/users");

req.getServletContext()
.getRequestDispatcher("/pages/users.jsp")
.forward(req, resp);

HttpSession session = request.getSession();

session.invalidate();


Класс Java Bean должен соответствовать ряду ограничений:

* иметь конструктор, который не принимает никаких параметров
* определять для всех свойств, которые используются в jsp, методы геттеры и сеттеры
* названия геттеров и сеттеров должны соответствовать условностям: перед именем переменной добавляется get (для геттера) и set (для сеттера), а название переменной включается с большой буквы. Например, если переменная называется firstName, то функции геттера и сеттера должны называться соответственно getFirstName и setFirstName.
* Однако для переменных типа boolean для функции геттера используется вместо get приставка is. Например, переменная enabled и геттер isEnabled.
* реализовать интерфейс Serializable или Externalizable

## Техническое задание

1. [ ] Навигационная панель, которая будет отличаться для различных ролей
2. [ ] Форма авторизации
3. [ ] Форма создания пользователя на одной странице со списком пользователей
4. [ ] Сделать выход из аккаунта
5. [ ] Сделать страницу со списком дел
6. [ ] Сделать кнопку для отметки дела выполненным
7. [ ] Сделать отдельную страницу для просмотра дела

```html
<c:choose>
    <c:when test="${user.getRole().equals(RoleType.ADMIN.getRole())}">
        <a href="users" class="menu-item">Пользователи</a>
        <a href="createUser" class="menu-item">Создать пользователя</a>
    </c:when>
    <c:when test="${user.getRole().equals(RoleType.MODERATOR.getRole())}">
        <a href="users" class="menu-item">Пользователи</a>
        <a href="recommendations" class="menu-item">Рекомендации</a>
        <a href="rates" class="menu-item">Оценки</a>
    </c:when>
</c:choose>
```
