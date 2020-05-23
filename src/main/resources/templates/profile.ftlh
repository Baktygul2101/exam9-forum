<#import "partials/main.ftlh" as main />

<@main.renderWith>
    <#if dto??>
        <h1>Ваши учетные данные!</h1>
        <p>${(dto.fullname)!'-- missing --'} - ${(dto.email)!'-- email missing --'}</p>

        <div class="bottom-box">
            <a href="/addTopic">Добавить тему для обсуждения</a>
        </div>
    <#else>
        <h1>Пользователь не найден! Вы не можете добавить свою тему или ответ!</h1>
    </#if>
    <div class="bottom-box">
        <a href="/">На главную страницу</a>
    </div>
</@main.renderWith>