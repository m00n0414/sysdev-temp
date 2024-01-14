<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="globals.css" />
<link rel="stylesheet" href="MissLogin.css" />
<title>ログイン</title>
</head>
<body>
	<div class="screen">
		<div class="group-wrapper">
			<div class="group">
				<div class="login">
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

						<br> <br> <br> <br>
						<p class="aka">
							IDもしくはパスワードが間違っています。<br> 入力し直してください。
						</p>
						<label class="open" for="popup">パスワードをお忘れの場合</label><input
							type="submit" class="log" value="ログイン"> <input
							type="checkbox" id="popup">
						<div class="overlay">
							<div class="window">
								<label class="close" for="popup">×</label>
								<p class="text">頑張って思い出して下さい。</p>
					</form>
				</div>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>
</html>
