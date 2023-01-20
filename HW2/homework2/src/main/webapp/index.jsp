<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <form action="/homework2_war_exploded/res" method="get">
        <h3>Do you like Java?</h3>
        yes<input type="radio" value="yes" name="java1">
        no<input type="radio" value="no" name="java1">
        <h3>Do you like Python?</h3>
        yes<input type="radio" value="yes" name="python2">
        no<input type="radio" value="no"  name="python2">
        <h3 name="cYes">Do you like C?</h3>
        yes<input type="radio" value="yes" name="C">
        no<input type="radio" value="no" name="C">
        <br>
        <button type="submit">ok</button>
    </form>
</body>
</html>