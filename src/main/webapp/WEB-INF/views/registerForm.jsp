<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/in' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel = "icon" href =
            "space_man.png" rel="shortcut icon" type="image/x-icon">
    <title>Hello</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
    <link rel="stylesheet" href="<c:url value='/css/registerFormStyle.css'/>">

    <script src="https://kit.fontawesome.com/437ac62fbf.js" crossorigin="anonymous"></script>
    <script src="../p5.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>

<body>
<nav class="nav">


    <ul class="list">
        <li><a href="<c:url value='/calendar/list'/>">가계부</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
<%--        <c:if test="${loginId eq null}">--%>
            <li><a href="<c:url value='/register/addUser'/>">회원가입</a></li>
<%--        </c:if>--%>
    </ul>

</nav>

<section>
<div style="text-align:center;">
    <form:form modelAttribute="userDto">

    <div class="title">회원가입</div>
        <div id="msg" class="msg"><form:errors path="id"/></div>
    <label for="">아이디</label>
    <input class="input-field" type="text" name="id" placeholder="8~12자리">
    <label for="">비밀번호</label>
    <input class="input-field" type="text" name="pwd" placeholder="8~12자리">
    <label for="">총자산</label>
    <input class="input-field" type="text" name="total" placeholder="금액">

    <button>회원 가입</button>
    </form:form>
</div>
</section>
</body>

<script>
    function formCheck(frm) {
        let msg ='';
        if(frm.id.value.length<3) {
            setMessage('id의 길이는 3이상이어야 합니다.', frm.id);
            return false;
        }
        return true;
    }
    function setMessage(msg, element){
        document.getElementById("msg").innerHTML = `<i class="fa fa-exclamation-circle"> ${'${msg}'}</i>`;
        if(element) {
            element.select();
        }
    }
</script>

</html>