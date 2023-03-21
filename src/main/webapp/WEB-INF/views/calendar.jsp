<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/in' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>
<!DOCTYPE html>
<head>
    <title>Hello</title>
</head>


<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Hello</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/calendar.css'/>">


</head>

<body>
<nav class="nav">
    <ul class="list">
        <li><a href="<c:url value='/calendar/list'/>">가계부</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
        <li><a href="<c:url value='/register/addUser'/>">회원가입</a></li>
    </ul>
</nav>

<div style="text-align:center">
    <div class="board-container">
        <div class="search-container">
            <p>총자산 : ${userDto}원</p>
        </div>


<%--        boardList 참고--%>
        <table>
            <c:forEach var="calendar" items="${calendarDto}">
                <td><a style="color: black" href="<c:url value="/calendar/detail"/>"><c:out value="${calendar.week}"/></a></td>
            </c:forEach>
        </table>


        </div>
    </div>
</div>
</body>
</html>
