<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {font-family: Arial, Helvetica, sans-serif;}

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 70%;
            padding: 12px 15px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        /* Set a style for all buttons */
        .log-button {
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            opacity: 0.8;
        }


        .container {
            padding: 50px;
        }

        span.psw {
            float: right;
            padding-top: 10px;
        }

        /* The Modal (background) */
        .modal {
            display: none; /* Hidden by default */
            position: fixed; /* Stay in place */
            z-index: 1; /* Sit on top */
            left: 0;
            top: 0;
            width: 100%; /* Full width */
            height: 100%; /* Full height */
            overflow: auto; /* Enable scroll if needed */
            background-color: rgb(0,0,0); /* Fallback color */
            background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
            padding-top: 60px;
        }

        /* Modal Content/Box */
        .modal-content {
            background-color: #fefefe;
            margin: 5% auto 15% auto; /* 5% from the top, 15% from the bottom and centered */
            border: 1px solid #888;
            width: 80%; /* Could be more or less, depending on screen size */
        }

        /* The Close Button (x) */
        .close {
            position: absolute;
            right: 25px;
            top: 0;
            color: #000;
            font-size: 35px;
            font-weight: bold;
        }

        .close:hover,
        .close:focus {
            color: red;
            cursor: pointer;
        }

        /* Add Zoom Animation */
        .animate {
            -webkit-animation: animatezoom 0.6s;
            animation: animatezoom 0.6s
        }

        @-webkit-keyframes animatezoom {
            from {-webkit-transform: scale(0)}
            to {-webkit-transform: scale(1)}
        }

        @keyframes animatezoom {
            from {transform: scale(0)}
            to {transform: scale(1)}
        }

        /* Change styles for span and cancel button on extra small screens */
        @media screen and (max-width: 300px) {
            span.psw {
                display: block;
                float: none;
            }
            .cancelbtn {
                width: 100%;
            }
        }
    </style>
</head>
<h2>Please sign in</h2>
<form action="/login" method="post">

    <div>
        <#if error!false >
            <p style="color:red">Неверные имя пользователя или пароль !</p>
        </#if>
    </div>
    <#if _csrf??>
        <input type="hidden" name="${(_csrf.parameterName)!'csrf'}" value="${(_csrf.token)!'--no-token--'}"/>
    </#if>

    <div>
        <label class="flex flex-v-center ">
            <span class="label-input-text" style="width: 20px">Email</span>
            <input type="text" name="username" placeholder="ваш адрес почты"  value="${(dto.email)!''}" autofocus >
        </label>
    </div>
    <div>
        <label class="flex flex-v-center label-input-text">
            <span class="label-input-text" style="width: 20px">Password:</span>
            <input type="text" name="password" placeholder="пароль" value="">
        </label>
    </div>
    <div>
        <button type="submit" class="log-button">Войти!</button>
    </div>
</form>
<div class="bottom-box">
    <a class="flex box-128" href="/forgot-password">Forget password </a>
    <a href="/">На главную страницу</a>
</div>
</body>
</html>
