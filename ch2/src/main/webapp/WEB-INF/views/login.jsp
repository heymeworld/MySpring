<%@ page contentType="text/html;charset=utf-8" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <form action="/ch2/user-info" method="post" id="login">
		<label for="id">아이디</label>
        <input type="text" name="id" id="id" form="login" required placeholder ="아이디를 입력하세요"></br>
		<label for="passwd">패스워드</label>
		<input type="password" name="pw" id="passwd" form="login" required placeholder ="비밀번호를 입력하세요" ></br>
	    </br><input type="submit" value="Login">

		
<!--			<input type="text" id="id" name="id" maxlength="41" autocapitalize="none" value="" title="아이디" aria-label="아이디">
		<input type="password" id="pw" name="pw" title="비밀번호" maxlength="16" aria-label="비밀번호">
		
        <button type="submit" id="log.login" value="로그인"></button>
-->		
	</form>
</body>
</html>