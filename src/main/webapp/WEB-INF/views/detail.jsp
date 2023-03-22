<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ page session="false"%>
<c:set var="loginId" value="${pageContext.request.getSession(false)==null ? '' : pageContext.request.session.getAttribute('id')}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/in' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? '로그인' : '로그아웃'}"/>
<!DOCTYPE html>

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>Hello</title>
    <link rel="stylesheet" href="<c:url value='/css/style.css'/>">
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

<%--날짜 데이터--%>
<input type="hidden" name="week" value="${md}">
<%--날짜 데이터--%>



<div class="container">
    <link rel="stylesheet" href="<c:url value='/css/detail.css'/>">
    <h2 class="writing-header">상세내역</h2>
    <br>

    <form id="money">
        <input type="hidden" name="d" value="${d}">
        <input name="money" placeholder="금액을 입력해주세요.">
        <input name="content" placeholder="내용을 입력해주세요.">
        <button type="button" id="minusBtn" class="btn btn-write">지출 등록</button>
        <button type="button" id="plusBtn" class="btn btn-write">입금 등록</button>
    </form>

    <br>
    <br>


    <h3 style="color: red">지출내역</h3>
    <c:forEach items="${minusDto}" var="minusDto">

    <form id="minus">
        <input  name="num" value="아이디 : ${minusDto.id} / 금액 : ${minusDto.money} / 내용 : ${minusDto.content}">
        <input  type="hidden" name="mno" value="${minusDto.mno}">
        <button type="button" id="minusDelete" form="${minusDto.mno}">지출내역 삭제</button>
        <button type="button" id="minusUpdate">지출내역 수정</button>

        <c:if test="${mode eq 'new'}">
            <button type="button" id="minusBtn">등록</button>
        </c:if>

    </form>
    </c:forEach>


    <br>
    <br>


    <h3 style="color: blue">입금내역</h3>
    <c:forEach items="${plusDto}" var="plusDto">

    <form id="${plusDto.pno}">
            <input  name="num" value="아이디 : ${plusDto.id} / 금액 : ${plusDto.money} / 내용 : ${plusDto.content}"> ${mode=="new" ? "" : "readonly='readonly'"}
            <input  type="hidden" name="pno" value="${plusDto.pno}">

            <button type="button" id="plusDelete" form="${plusDto.pno}">입금내역 삭제</button>
            <button type="button" id="plusUpdate">입금내역 수정</button>
        <c:if test="${mode eq 'new'}">
            <button type="button" id="plusBtn">등록</button>
        </c:if>
    </form>
    </c:forEach>



    <br>
    <br>
        <button type="button" id="backBtn" class="btn btn-list"><i class="fa fa-bars"></i> 달력보기</button>

</div>


<script>
    $(document).ready(function(){

    //달력으로 돌아가기 버튼
        $("#backBtn").on("click", function(){
            location.href="<c:url value='/calendar/list'/>";
        });

    //지출 등록 버튼
        $("#minusBtn").on("click", function(){
            let form = $("#money");
            form.attr("action", "<c:url value='/calendar/writeMinus'/>");
            form.attr("method", "post");
            form.submit();
        });
    //입금 등록 버튼
        $("#plusBtn").on("click", function(){
            let form = $("#money");
            form.attr("action", "<c:url value='/calendar/writePlus'/>");
            form.attr("method", "post");
            form.submit();
        });

            //지출내역 삭제 버튼
            $("#minusDelete").on("click", function(){
                <%--$("#minusDelete").parent().attr("action", "<c:url value='/calendar/deleteMinus'/>").attr("method", "post").submit();--%>
                let form =
                form.attr("action", "<c:url value='/calendar/deleteMinus'/>");
            form.attr("method", "post");
            form.submit();
            });

            //입금내역 삭제 버튼
            $("#plusDelete").on("click", function(){
                let form =
                    form.attr("action", "<c:url value='/calendar/deletePlus'/>");
                    form.attr("method", "post");
                    form.submit();
                });

        //지출내역 수정 버튼
        $("#minusUpdate").on("click", function(){
            let form = $("#minus");
            let isReadonly = $("input[name=num]").attr('readonly');
            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $("input[name=num]").attr('readonly', false);
                $("#minusUpdate").html("등록");
                return;
            }
            form.attr("action", "<c:url value='/calendar/updateMinus'/>");
            form.attr("method", "post");
            form.submit();
        });

        //입금내역 수정 버튼
        $("#plusUpdate").on("click", function(){
            let form = $("#plus");
            form.attr("action", "<c:url value='/calendar/updatePlus'/>");
            form.attr("method", "post");
            form.submit();
        });

    });
</script>


</body>
</html>