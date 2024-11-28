<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <form action="/ch2/login" method="post" name="toURL" id="login">
<!--		<input type="hidden" name="toURL" value="<%= request.getParameter("toURL") != null ? request.getParameter("toURL") : "/" %>" /> -->
		아이디 <input type="text" name="id" id="id" value="<%= request.getAttribute("rememberedId") != null ? request.getAttribute("rememberedId") : "" %>" form="login" required placeholder ="아이디를 입력하세요"></br>
		패스워드 <input type="password" name="pwd" id="passwd" form="login" required placeholder ="비밀번호를 입력하세요" ></br>
	    <input type="checkbox" name="rememberId" form="login" <% if(request.getAttribute("rememberedId") != null) { %> checked <% } %>> 아이디 기억하기
		</br><input type="submit" value="Login">

		
<!--			<input type="text" id="id" name="id" maxlength="41" autocapitalize="none" value="" title="아이디" aria-label="아이디">
		<input type="password" id="pwd" name="pwd" title="비밀번호" maxlength="16" aria-label="비밀번호">
		
        <button type="submit" id="log.login" value="로그인"></button>
-->		
	</form>
</body>
</html>