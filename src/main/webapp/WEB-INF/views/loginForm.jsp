<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
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
    <link rel="stylesheet" href="<c:url value='/css/loginFormStyle.css'/>">
    <script src="https://kit.fontawesome.com/437ac62fbf.js" crossorigin="anonymous"></script>
    <script src="../p5.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.11.3.js"></script>
</head>

<body>
<nav class="nav">


    <ul class="list">
        <li><a href="<c:url value='/calendar/list'/>">가계부</a></li>
        <li><a href="<c:url value='${loginOutLink}'/>">${loginOut}</a></li>
            <li><a href="<c:url value='/register/addUser'/>">회원가입</a></li>
    </ul>


</nav>

<form action="<c:url value="/login/in"/>" method="post" onsubmit="return formCheck(this);">
    <h2 id="title">로그인</h2>
    <div id="msg">
        <c:if test="${not empty param.msg}">
            <i class="fa fa-exclamation-circle"> ${URLDncoder.decode(param.msg)}</i>
        </c:if>
    </div>
    <input type="text" name="id" value="${cookie.id.value}" placeholder="아이디" autofocus>
    <input type="password" name="pwd" placeholder="비밀번호">
    <input type="hidden" name="toURL" value="${param.toURL}">
    <button>로그인</button>
    <div>
        <label><input type="checkbox" name="rememberId" value="on" ${empty cookie.id.value ? "":"checked"}> 아이디 기억</label>

    </div>
    <script>
        function formCheck(frm) {
            let msg ='';
            if(frm.id.value.length==0) {
                setMessage('id를 입력해주세요.', frm.id);
                return false;
            }
            if(frm.pwd.value.length==0) {
                setMessage('password를 입력해주세요.', frm.pwd);
                return false;
            }
            return true;
        }
        function setMessage(msg, element){
            document.getElementById("msg").innerHTML = ` ${'${msg}'}`;
            if(element) {
                element.select();
            }
        }
    </script>
</form>

</body>
</html>