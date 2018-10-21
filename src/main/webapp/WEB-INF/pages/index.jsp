<%--
  Created by IntelliJ IDEA.
  User: vitalii_zhuk
  Date: 17.10.18
  Time: 21:12
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap-theme.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <%--<script src="resources/js/main.js" type="text/javascript"></script>--%>
    <script src = "https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <%--<script type="text/javascript" src="jquery.js"></script>--%>

    <%--<script src="/javascripts/jquery.js" type="text/javascript"></script>--%>
    <script type="text/javascript" src="resources/js/main.js"></script>

</head>
<body>
<div class="container">
    <div class="col-md-12 " id="main-table">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>TEXT</th>
            </tr>
            </thead>
            <tbody>
                <c:forEach items="${elements}" var="element">
                    <tr class="table-element" onclick = "activateElement('${element.id}','${element.text}','${element.orderNo}')">
                        <th class="table-element-id" scope="row">${elements.indexOf(element)+1}</th>
                        <td class="table-element-text">${element.text}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
    <div class="col-md-12 config-input">
        <div class="col-md-11">
            <input class="form-control form-control-lg input-text" id="input-field" type="text" >
        </div>
        <div class="col-md-1">
            <button type="button" id="add-button" class="btn btn-primary btn-md">Добавить</button>
        </div>
    </div>

    <div class="col-md-12 config-buttons">
        <div class="col-md-2">
            <button type="button" id="save-button" class="btn btn-primary btn-md button-disable">Сохранить</button>
        </div>
        <div class="col-md-2">
            <button type="button" id="up-button" class="btn btn-primary btn-md button-disable">Вверх</button>
        </div>
        <div class="col-md-2">
            <button type="button" id="down-button" class="btn btn-primary btn-md button-disable">Вниз</button>
        </div>
        <div class="col-md-2">
            <button type="button" id="remove-button" class="btn btn-primary btn-md button-disable">Удалить</button>
        </div>
    </div>

</div>

</body>
</html>
