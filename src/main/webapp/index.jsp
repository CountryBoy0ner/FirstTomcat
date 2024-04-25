<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>INDEX</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 40px;
            padding: 0;
            background-color: #F1F2EB; /* Зеленый фон */
        }
        .container {
            width: 100%;
            max-width: 430px;
            padding: 15px;
            margin: auto;
        }
        .login-form {
            background-color: #D8DAD3;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.1);
        }
        .login-form h1 {
            margin-bottom: 15px;
            color: #4A4A48; /* Зеленый заголовок */
        }
        .login-form input[type="text"],
        .login-form input[type="password"] {
            margin-bottom: 15px;
            padding: 12px;
            border: 1px solid #4A4A48; /* Зеленая рамка */
            border-radius: 4px;
            width: 100%;
        }
        .login-form input[type="submit"] {
            padding: 12px;
            background-color: #566246; /* Зеленая кнопка */
            border: none;
            color: white;
            border-radius: 4px;
            cursor: pointer;
            width: 100%;
        }
        .login-form input[type="submit"]:hover {
            background-color: #4A4A48; /* Темно-зеленая кнопка при наведении */
        }
    </style>
</head>
<body>
<div class="container">
    <div class="login-form">
        <h1>Вход</h1>
        <form action="controller">
            <input type="hidden" name="command" value="login" />
            <input type="text" name="login" placeholder="Логин" />
            <input type="password" name="pass" placeholder="Пароль" />
            <input type="submit" name="sub" value="Войти" />

            ${login_msg}

        </form>
    </div>
</div>
</body>
</html>
