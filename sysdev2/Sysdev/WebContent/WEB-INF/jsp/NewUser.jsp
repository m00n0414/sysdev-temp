<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="globals.css" />
<link rel = "stylesheet" href="NewUser.css">
<link>
<title>ユーザ登録</title>
</head>
<body>
<div class="screen">
      <div class="group-wrapper">
        <div class="group">
          <div class="login">
          
          <form action="/Sysdev/NewUserServlet" method="post">
            <h1>UtilAir</h1>
            <h3>Register</h3>
            <p class="migi">※ユーザ名：<input type="text" class="ao" maxlength = "20" id="name" name= "user_name" placeholder="ユーザ名" required></p>
            <p class="migi">※ユーザID：<input type="text" class="ao" maxlength = "10" id="id" name= "user_id"placeholder="UserID" required></p>
            <p class="migi">※パスワード：<input type="password" class="ao" maxlength = "20" id="name" name= "password" placeholder="P@ssword" required></p>
            <!-- <p class="migi">※確認：<input type="password" class="ao" maxlength = "20" id="name"placeholder="P@ssword" required></p> -->
            <p class="migi">※は必須です。</p>
            <input type="submit" style="position: absolute; left: 77%; top: 84%;" class="log" value="登録">
            </form>
           
          </div>
        </div>
      </div>
    </div>
</body>
</html>
