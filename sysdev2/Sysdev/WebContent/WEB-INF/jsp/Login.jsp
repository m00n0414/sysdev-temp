<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/globals.css" />
<link rel="stylesheet" href="css/Login.css" />

<title>ログイン</title>
</head>
<body>
	<div class="screen">
		<div class="group-wrapper">
			<div class="group">
				<div class="login">

					<h1>UtilAir</h1>
					<h3>Login</h3>

					<form action="/Sysdev/LoginServlet" method="post">

						<p>ユーザID</p>

						<p>
							<input type="text" class="ao" maxlength="10" id="id"
								name="user_id" placeholder="UserID" class="form-control"
								required>
						</p>

						<p>パスワード</p>

						<p>
							<input type="password" class="ao" maxlength="20" id="pass"
								name="password" placeholder="Pass" class="form-control" required>
						</p>

						<a href="/Sysdev/NewUserServlet">アカウントを作成</a> <input type="submit"
							class="log" value="ログイン">

					</form>



				</div>
			</div>
		</div>
	</div>
</body>
</html>


















