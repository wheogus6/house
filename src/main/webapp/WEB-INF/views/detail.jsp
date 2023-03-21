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

<div class="container">
    <link rel="stylesheet" href="<c:url value='/css/boardStyle.css'/>">
    <h2 class="writing-header">게시판 ${mode=="new" ? "글쓰기" : "읽기"}</h2>
    <form id="form" class="frm" action="" method="post">
        <input type="hidden" name="num" value="${boardDto.num}">

        <input name="title" type="text" value="<c:out value= '${boardDto.title}'/>" placeholder="  제목을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><br>
        <textarea name="content" rows="20" placeholder=" 내용을 입력해 주세요." ${mode=="new" ? "" : "readonly='readonly'"}><c:out value='${boardDto.content}'/></textarea><br>

        <c:if test="${mode eq 'new'}">
            <button type="button" id="writeBtn" class="btn btn-write"><i class="fa fa-pencil"></i> 등록</button>
        </c:if>

        <c:if test="${boardDto.writer eq loginId}">
            <button type="button" id="modifyBtn" class="btn btn-modify"><i class="fa fa-edit"></i> 수정</button>
            <button type="button" id="removeBtn" class="btn btn-remove"><i class="fa fa-trash"></i> 삭제</button>
        </c:if>
        <button type="button" id="listBtn" class="btn btn-list"><i class="fa fa-bars"></i> 목록</button>
    </form>
</div>
<script>
    $(document).ready(function(){
        let formCheck = function() {
            let form = document.getElementById("form");
            if(form.title.value=="") {
                alert("제목을 입력해 주세요.");
                form.title.focus();
                return false;
            }
            if(form.content.value=="") {
                alert("내용을 입력해 주세요.");
                form.content.focus();
                return false;
            }
            return true;
        }

        $("#writeBtn").on("click", function(){
            let form = $("#form");
            form.attr("action", "<c:url value='/board/write'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });
        $("#modifyBtn").on("click", function(){
            let form = $("#form");
            let isReadonly = $("input[name=title]").attr('readonly');
            // 1. 읽기 상태이면, 수정 상태로 변경
            if(isReadonly=='readonly') {
                $(".writing-header").html("게시판 수정");
                $("input[name=title]").attr('readonly', false);
                $("textarea").attr('readonly', false);
                $("#modifyBtn").html("<i class='fa fa-pencil'></i> 등록");
                return;
            }
            // 2. 수정 상태이면, 수정된 내용을 서버로 전송
            form.attr("action", "<c:url value='/board/modify${searchCondition.queryString}'/>");
            form.attr("method", "post");
            if(formCheck())
                form.submit();
        });
        $("#removeBtn").on("click", function(){
            if(!confirm("정말로 삭제하시겠습니까?")) return;
            let form = $("#form");
            form.attr("action", "<c:url value='/board/remove${searchCondition.queryString}'/>");
            form.attr("method", "post");
            form.submit();
        });
        $("#listBtn").on("click", function(){
            location.href="<c:url value='/board/list${searchCondition.queryString}'/>";
        });

    });
</script>
</body>
<br>
<!-- 댓글 작성란 -->
<div>
    <c:if test="${mode ne 'new'}">
        <link rel="stylesheet" href="<c:url value='/css/commentStyle.css'/>">
    <form method="post" class="commentWrite" action="<c:url value="/comments/write"/>">

        <p>
            <textarea class="commentArea" rows="5" cols="50" name="comment" placeholder="댓글 쓰기..."></textarea>
        </p>
        <p>
            <input type="hidden" name="num" value="${boardDto.num}">
            <button type="submit" class="comment write-btn"><i class="fa fa-pencil"></i> 댓글 작성</button>
            <br>
            <br>
        <h3 class="commentCnt">댓글 ${boardDto.comment_cnt}개</h3>
        <br><br>
        </p>
    </form>
</c:if>
</div>


<!-- 댓글 리스트 -->

<c:forEach items="${comment}" var="comment">
    <li>
        <form id="commentList" class="comment_list" action="" method="">

            <input type="hidden" name="cno" value="${comment.cno}">
            <input type="hidden" name="num" value="${comment.num}">
<%--            <input  name="commenter" value="${comment.commenter}">--%>

<%--            <p>${comment.cno}</p>--%>
            <p class="commenter">작성자 : ${comment.commenter}</p>
<%--            <p>${comment.num}</p>--%>
            <textarea rows="3" name="comment" ${commentMode=="modify" ? "" : "readonly='readonly'"}>${comment.comment}</textarea>
            <p>
                <c:if test="${comment.commenter eq loginId}">
                    <a class="commentMod" href="<c:url value="/comments/modify?num=${boardDto.num}&cno=${comment.cno}"/>" ><i class="fa fa-edit"></i> 댓글 수정</a>
<%--                    <a class="commentMod" href= "javascript:popup()" ><i class="fa fa-edit"></i> 댓글 수정</a>--%>
                </c:if>
            </p>
            <br>
        </form>
    </li>
</c:forEach>



</body>

</html>