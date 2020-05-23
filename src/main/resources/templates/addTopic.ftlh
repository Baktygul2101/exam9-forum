<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Создание своей темы</title>
</head>
<body>



<form action="/addTopic" method="post">

    <label>Name</label>
    <input type="text" name="name" id="name" required="required" placeholder="topic"><br>

    <label>Description</label>
    <input type="text" name="description" required="required" id="description" placeholder=" description"><br>

    <label>Date</label>
    <input type="datetime-local" name="date" required="required"  id="date" placeholder="post date"><br>


    <input type="submit" value="add topic">
</form>
</body>


</html>
