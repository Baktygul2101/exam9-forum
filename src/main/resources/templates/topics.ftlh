<#-- импортируем основной шаблон-контейнер который содержит в себе разметку для основной структуры страницы -->
<#import "partials/main.ftlh" as main />

<#-- обрабатываем его, и передаём ему список скриптов, которые необходимо подключить-->

<@main.renderWith scripts=["/js/main.js"]>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <style>
            body {
                font-family: Arial;
            }

            * {
                box-sizing: border-box;
            }

            form.search input[type=text] {
                padding: 10px;
                font-size: 17px;
                border: 1px solid grey;
                float: left;
                width: 80%;
                background: #f1f1f1;
            }

            form.search button {
                float: left;
                width: 20%;
                padding: 10px;
                background: #2196F3;
                color: white;
                font-size: 17px;
                border: 1px solid grey;
                border-left: none;
                cursor: pointer;
            }

            form.search button:hover {
                background: #0b7dda;
            }

            form.search::after {
                content: "";
                clear: both;
                display: table;
            }
        </style>
    </head>
<div>
    <a href="/">back to main</a>
<h1>Products</h1>

    <form method="get" action="/topics" class="search">
        <input type="text" name="search" pattern=".{2,}"placeholder="Search.." required>
        <button type="submit"><i class="fa fa-search"></i></button>
    </form>
</div>

    <div class="flex flex-wrap" id="itemList">
        <#list topics as topic>
            <div class="flex flex-column box flex-v-center">
                <a href="/product/${topic.id}">
                    <div class="flex flex-column flex-v-center box-128">
                        <a href="/product/${topic.id}"><h2>${topic.name}</h2> </a>
                    </div>
                </a>
            </div>
        </#list>
    </div>



</@main.renderWith>