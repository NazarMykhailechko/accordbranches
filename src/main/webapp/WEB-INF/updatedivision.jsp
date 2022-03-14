<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>

    <link rel="shortcut icon" href="/accord.ico">
    <title>Оновити інформацію</title>

    <meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-css/1.4.6/select2-bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.2.1/js/bootstrap.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js"></script>

    <style>
        .blue-button{
            background: #25A6E1;
            padding:3px 5px;
            color:#fff;
            font-family:'Helvetica Neue',sans-serif;
            font-size:12px;
            border-radius:2px;
            -moz-border-radius:2px;
            -webkit-border-radius:4px;
            border:1px solid #1A87B9
        }
        table {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            width: 50%;
        }
        th {
            background: SteelBlue;
            color: white;
        }
        td,th{
            border: 1px solid gray;
            width: 25%;
            text-align: left;
            padding: 5px 10px;
        }
        .text {
            text-align:  center;
        }
        h1 {
            color: red;
        }




        body {
            font-family: "Helvetica Neue", Helvetica, sans-serif;
            /*font-weight: bold;*/
            font-size: x-small;
        }
        .select2-container {
            min-width: 105%;
            margin-bottom: 3px
        }

        .select2-results__option {
            padding-right: 20px;
            vertical-align: middle;
        }
        .select2-results__option:before {
            content: "";
            display: inline-block;
            position: relative;
            height: 20px;
            width: 20px;
            border: 2px solid #e9e9e9;
            border-radius: 4px;
            background-color: #fff;
            margin-right: 20px;
            vertical-align: middle;
        }
        .select2-results__option[aria-selected=true]:before {
            font-family:fontAwesome;
            content: "\f00c";
            color: #fff;
            background-color: red;
            border: 0;
            display: inline-block;
            padding-left: 3px;
        }


        .select2-container--default .select2-results__option[aria-selected=true] {
            background-color: #fff;
        }
        .select2-container--default .select2-results__option--highlighted[aria-selected] {
            background-color: #eaeaeb;
            color: #272727;
        }
        .select2-container--default .select2-selection--multiple {
            margin-bottom: 10px;
        }
        .select2-container--default.select2-container--open.select2-container--below .select2-selection--multiple {
            border-radius: 4px;
        }

        .select2-container--default.select2-container--focus .select2-selection--multiple {
            border-color: red;
            border-width: 2px;
        }

        .select2-container--open .select2-dropdown--below {

            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0,0,0,0.5);

        }
        .select2-selection .select2-selection--multiple:after {
            content: 'hhghgh';
        }

        /* select with icons badges single*/
        .select-icon .select2-selection__placeholder .badge {
            display: none;
        }

        .select-icon .placeholder {
            /* 	display: none; */
        }
        .select-icon .select2-results__option:before,
        .select-icon .select2-results__option[aria-selected=true]:before {
            display: none !important;
            /* content: "" !important; */
        }
        .select-icon  .select2-search--dropdown {
            display: none;
        }

        fieldset.inline {
            display: inline;
        }


        .column {
            float: left;
            width: 50%;
            padding: 10px;
            height: 300px; /* Should be removed. Only for demonstration */
        }

        /* Clear floats after the columns */
        .row:after {
            content: "";
            display: table;
            clear: both;
        }


             /*Style your div container, must specify height*/
         .content {width:100%; height:70%}
        /*Style the p tag inside your div container with half the with of your container, and float left*/
        .content p {width:48%; margin-right:5px;padding-right: 15px; float:left;}



/*        body {
            font-family: Arial, sans-serif;
            background: url(http://www.shukatsu-note.com/wp-content/uploads/2014/12/computer-564136_1280.jpg) no-repeat;
            background-size: cover;
            height: 100vh;
        }

        h1 {
            text-align: center;
            font-family: Tahoma, Arial, sans-serif;
            color: #06D85F;
            margin: 80px 0;
        }*/

        .box {
            width: 40%;
            margin: 0 auto;
            background: rgba(255,255,255,0.2);
            padding: 35px;
            border: 2px solid #fff;
            border-radius: 20px/50px;
            background-clip: padding-box;
            text-align: center;
        }

        .button {
            font-size: 1em;
            padding: 10px;
            color: #fff;
            border: 2px solid #06D85F;
            border-radius: 20px/50px;
            text-decoration: none;
            cursor: pointer;
            transition: all 0.3s ease-out;
        }
        .button:hover {
            background: #06D85F;
        }

        .overlay {
            position: fixed;
            top: 0;
            bottom: 0;
            left: 0;
            right: 0;
            background: rgba(0, 0, 0, 0.7);
            transition: opacity 500ms;
            visibility: hidden;
            opacity: 0;
        }
        .overlay:target {
            visibility: visible;
            opacity: 1;
        }

        .popup {
            margin: 70px auto;
            padding: 20px;
            background: #fff;
            border-radius: 5px;
            width: 30%;
            position: relative;
            transition: all 5s ease-in-out;
        }

        .popup h2 {
            margin-top: 0;
            color: #333;
            font-family: Tahoma, Arial, sans-serif;
        }
        .popup .close {
            position: absolute;
            top: 20px;
            right: 30px;
            transition: all 200ms;
            font-size: 30px;
            font-weight: bold;
            text-decoration: none;
            color: #333;
        }
        .popup .close:hover {
            color: #06D85F;
        }
        .popup .content {
            max-height: 32%;
            overflow: auto;
        }

        @media screen and (max-width: 700px){
            .box{
                width: 70%;
            }
            .popup{
                width: 70%;
            }
        }

        [type="checkbox"]
        {
            vertical-align: middle;
        }

    </style>
</head>
<body>

<div class="text">
    <img src="data:image/svg+xml;base64,PHN2ZyBpZD0ibC11LWciIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IiB3aWR0aD0iMTg3LjdweCIgaGVpZ2h0PSI0NC44cHgiIHZpZXdCb3g9IjAgMCAxODcuNyA0NC44IiBzdHlsZT0iZW5hYmxlLWJhY2tncm91bmQ6bmV3IDAgMCAxODcuNyA0NC44OyIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8c3R5bGUgdHlwZT0idGV4dC9jc3MiPg0KCS5zdDB7ZmlsbC1ydWxlOmV2ZW5vZGQ7Y2xpcC1ydWxlOmV2ZW5vZGQ7ZmlsbDojQ0MwMDAwO30NCgkuc3Qxe2ZpbGwtcnVsZTpldmVub2RkO2NsaXAtcnVsZTpldmVub2RkO2ZpbGw6Izk5OTk5OTt9DQo8L3N0eWxlPg0KPHBhdGggY2xhc3M9InN0MCIgZD0iTTQzLjYsMjcuNUwyMi4xLDlMMC42LDI3LjVDMC4yLDI1LjgsMCwyNC4yLDAsMjIuNEMwLDEwLDkuOSwwLDIyLjEsMGMxMi4yLDAsMjIuMSwxMCwyMi4xLDIyLjQgQzQ0LjIsMjQuMiw0NCwyNS44LDQzLjYsMjcuNSBNMTAxLDM1LjFjMy41LDAsNS4yLTAuMiw2LjQtMC41YzIuNC0wLjcsNC0yLjMsNC44LTQuOGMwLjMtMC44LDAuNC0xLjUsMC40LTIuMiBjMC0yLjMtMC45LTQuNC0yLjYtNS45Yy0xLjYtMS40LTMuNi0yLTYtMmgtNC4xYy0wLjUsMC4xLTEsMC4zLTEuMiwwLjdjLTAuMiwwLjQtMC40LDAuOC0wLjUsMS4zdjE5LjZoMi44VjM1LjEgTTEwOC4yLDIyLjggYzAuOCwxLjMsMS4zLDMuMSwxLjMsNC45YzAsMS43LTAuNCwzLjEtMS4zLDQuNGMtMSwxLjQtMi4zLDIuMS0zLjksMi4xbC0zLjMsMFYyMS4xYzAtMC4zLDAuMi0wLjUsMC41LTAuNWwyLjcsMCBDMTA1LjksMjAuNSwxMDcuMywyMS4zLDEwOC4yLDIyLjh6IE04OC4yLDM1LjVjMi4zLDAsNC4yLTAuNyw1LjctMi4yYzEuNS0xLjUsMi4zLTMuNCwyLjMtNS44YzAtMi4zLTAuOC00LjItMi4zLTUuNiBjLTEuNS0xLjUtMy40LTIuMi01LjYtMi4yYy0yLjMsMC00LjIsMC43LTUuNiwyLjJjLTEuNSwxLjUtMi4yLDMuNC0yLjIsNS43YzAsMi4zLDAuNyw0LjIsMi4zLDUuN0M4NC4xLDM0LjgsODYsMzUuNSw4OC4yLDM1LjUgTTkyLjMsMzIuMWMtMSwxLjctMi4zLDIuNi00LDIuNmMtMS43LDAtMy0wLjgtNC0yLjNDODMuNSwzMSw4MywyOS40LDgzLDI3LjZjMC0xLjksMC40LTMuNSwxLjItNC45YzEtMS42LDIuMy0yLjQsNC0yLjQgYzEuNiwwLDIuOSwwLjcsMy45LDIuMmMwLjksMS4zLDEuMywyLjksMS4zLDQuNkM5My41LDI5LjEsOTMuMSwzMC43LDkyLjMsMzIuMXogTTcyLjgsMjQuNmw1LjUtNWgtMS4ybC02LjcsNi4xdi02LjFoLTIuOHYxNS41IGwyLjgtMC4xdi04LjJsMC41LTAuNWw2LjksOC44aDMuMUw3Mi44LDI0LjZ6IE01Ni4yLDEzbC05LjgsMjIuMWgxbDIuOC02LjNoMTBsMi44LDYuM2gzTDU2LjIsMTN6IE01MC43LDI3LjlsNC42LTEwLjNsNC41LDEwLjMgSDUwLjd6IE0xMTQuNSwzNC4ybDUtMTIuM2MwLjEtMC4yLDAuMy0wLjQsMC41LDBjMS42LDQsMy4zLDguMyw0LjksMTIuM0gxMTQuNXogTTExMi4xLDMzLjljMCwwLjUsMC4xLDAuOCwwLjEsMWMwLDAuNiwwLDEtMC4xLDEuMiBoMC4yYzAuMy0wLjMsMC42LTAuNSwxLjEtMC43YzAuNC0wLjEsMC45LTAuMiwxLjUtMC4zYzAuNiwwLDEuNCwwLDIuNSwwaDUuOGMxLjEsMCwyLjYsMCwzLjIsMGMwLjUsMCwxLDAuMSwxLjQsMC4zIGMwLjQsMC4xLDAuNywwLjQsMC45LDAuN2gwLjJjMC0wLjMtMC4xLTAuNy0wLjEtMS4yYzAtMC40LDAtMC43LDAuMS0xaC0xbC01LjUtMTMuMWMtMC4xLTAuMy0wLjMtMC42LTAuNS0wLjggCWMtMC4yLTAuMi0wLjQtMC40LTAuNi0wLjVjLTAuNS0wLjItMC45LTAuMi0xLjQsMGMtMC4yLDAuMS0wLjMsMC4yLTAuNSwwLjRjLTAuMiwwLjItMC4zLDAuNC0wLjUsMC42bC01LjgsMTMuM0gxMTIuMXoiLz4NCjxwYXRoIGNsYXNzPSJzdDEiIGQ9Ik01LjQsMzcuMWwxNi43LTIzbDE2LjcsMjNjLTQuMSw0LjctMTAsNy43LTE2LjcsNy43QzE1LjQsNDQuOCw5LjQsNDEuOCw1LjQsMzcuMSBNMTcyLDE5LjZoLTIuOHY2LjRoLTguMXYtNi40IGgtMi44djE1LjVoMi44di04LjJoOC4xdjguMmgyLjhWMTkuNnogTTE1Mi4xLDIxTDE1Mi4xLDIxYy0wLjItMC40LTAuNC0wLjctMC42LTAuOWMtMC4yLTAuMi0wLjUtMC40LTAuNy0wLjVjLTAuNC0wLjEtMC43LTAuMS0xLjEsMGMtMC4yLDAuMS0wLjQsMC4yLTAuNiwwLjRjLTAuNCwwLjQtMC42LDAuOS0wLjgsMS41bC00LjUsMTMuNmgxLjFsMS4yLTMuN2g2LjhsMS4yLDMuN2gyLjdMMTUyLjEsMjF6ICBNMTQ2LjQsMzAuNGMxLTMsMi02LDMtOWMwLTAuMSwwLjItMC4zLDAuMywwbDIuOCw5SDE0Ni40eiBNMTMxLDIxLjdjMC4xLTAuNSwwLjItMC45LDAuNS0xLjNjMC4zLTAuNSwwLjgtMC43LDEuNC0wLjhsNy44LDB2MC45IGMtMi4yLDAtNC40LDAtNi42LDBjLTAuMiwwLTAuMywwLjEtMC4zLDAuNGwwLDUuNmMwLjIsMCwwLjYsMCwxLjIsMGMwLjUsMCwwLjksMCwxLjIsMGMyLDAsMy41LDAuMiw0LjUsMC43IGMxLjUsMC43LDIuMiwxLjksMi4yLDMuN2MwLDEuMy0wLjUsMi40LTEuNiwzLjJjLTEsMC43LTIuMSwxLjEtMy41LDEuMUgxMzFWMjEuOEMxMzEsMjEuOCwxMzEsMjEuNywxMzEsMjEuN0wxMzEsMjEuNyBNMTM2LjksMjcuNSBjMSwwLDEuOSwwLjMsMi42LDAuOWMwLjcsMC42LDEuMSwxLjQsMS4xLDIuNGMwLDEtMC40LDEuOC0xLjEsMi40Yy0wLjcsMC42LTEuNiwwLjktMi42LDAuOWgtM3YtNi42SDEzNi45eiBNMTc5LjcsMjQuNmw1LjUtNSBsLTEuMiwwbC02LjcsNnYtNi4xaC0yLjh2MTUuNWwyLjgtMC4xdi04LjJsMC41LTAuNWw2LjksOC44aDMuMUwxNzkuNywyNC42eiIvPg0KPC9zdmc+">
</div>
<%--<h5 class="text">Created by Nazar Mykhailechko</h5>
<br>--%>

<br>
<%--<h2 class="text">Нова кредитна заявка:</h2>--%>
<%--<% String homeDirectory = System.getProperty("user.name"); %>--%>
<%--<h3 class="text"><%=homeDirectory%></h3>--%>

<sec:authorize access="hasRole('ROLE_CORP')">
<form:form action="/update" method="POST" modelAttribute="division" style="text-align:center" id="myform">

    <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
    <br>
    <br>
    <form:hidden path="id" style="width:10%" placeholder="example" />

    <fieldset class="inline" style="margin-left: 10px;width:20%;height:1600px;border: 1px solid crimson">
        <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>
            <%--            <form:hidden path="id" style="width:10%" placeholder="example" />--%>
        <div style="text-align: left">
            <label for="num">Номер відділення:</label>
            <form:input id="sel1" disabled="false" path="num" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="address" style="alignment: left">Адреса:</label>
            <form:input id="sel22222" disabled="false" path="address" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="comments" style="alignment: left">Примітки:</label>
            <form:input id="sel22222" disabled="false" path="comments" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datescreated">Дата створення заявки:</label>
            <form:input id="sel3" disabled="false" required="true" type="date" path="datescreated" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesplaned">Планова дата відкриття ТТ:</label>
            <form:input id="sel4" disabled="false" required="true" type="date" path="datesplaned" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesorenda">Підписання договору оренди:</label>
            <form:input id="sel511111" disabled="false" path="datesorenda" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datessafesRev">Замовлення сейфів:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel6" disabled="false" required="true" type="date" path="datessafesRev" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/>
                <form:checkbox id="sel1111111111" path="statussafesRev" placeholder="example"/>
            </div><br>
            <label for="commentssafesRev" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentssafesRev" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesvideoLoz">Система відеонагляду:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel7" disabled="false" required="true" type="date" path="datesvideoLoz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusvideoLoz" placeholder="example"/>
            </div><br>
            <label for="commentsvideoLoz" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsvideoLoz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datessignalLoz">Охоронна сигналізація:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel8" disabled="false" required="true" type="date" path="datessignalLoz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statussignalLoz" placeholder="example"/>
            </div><br>
            <label for="commentssignalLoz" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentssignalLoz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesfiresignalLoz">Пожежна сигналізація:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel9" disabled="false" required="true" type="date" path="datesfiresignalLoz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusfiresignalLoz" placeholder="example"/>
            </div><br>
            <label for="commentsfiresignalLoz" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsfiresignalLoz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesworkplacePos">Розробка схеми розміщення роб. місць:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel10" disabled="false" required="true" type="date" path="datesworkplacePos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusworkplacePos" placeholder="example"/>
            </div><br>
            <label for="commentsworkplacePos" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsworkplacePos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesremontPos">Ремонт всередині:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel11" disabled="false" required="true" type="date" path="datesremontPos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusremontPos" placeholder="example"/>
            </div><br>
            <label for="commentsremontPos" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsremontPos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datescasacabinsPos">Касові кабіни:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel12" disabled="false" required="true" type="date" path="datescasacabinsPos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscasacabinsPos" placeholder="example"/>
            </div><br>
            <label for="commentscasacabinsPos" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentscasacabinsPos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesbannerShyan">Вивіска на відділенні:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel13" disabled="false" required="true" type="date" path="datesbannerShyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusbannerShyan" placeholder="example"/>
            </div><br>
            <label for="commentsbannerShyan" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsbannerShyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesforextabloShyan">Валюто-обмінне табло:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel14" disabled="false" required="true" type="date" path="datesforextabloShyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusforextabloShyan" placeholder="example"/>
            </div><br>
            <label for="commentsforextabloShyan" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsforextabloShyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesposterShyan">Плакати та наклейки:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel15" disabled="false" required="true" type="date" path="datesposterShyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusposterShyan" placeholder="example"/>
            </div><br>
            <label for="commentsposterShyan" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsposterShyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesconnectionSem">Побудова каналу звязку:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel16" disabled="false" required="true" type="date" path="datesconnectionSem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusconnectionSem" placeholder="example"/>
            </div><br>
            <label for="commentsconnectionSem" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsconnectionSem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datessksSem">Побудова СКС:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel17" disabled="false" required="true" type="date" path="datessksSem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statussksSem" placeholder="example"/>
            </div><br>
            <label for="commentssksSem" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentssksSem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datescomputersSem">Закупівля та встановлення комп. техніки:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel18" disabled="false" required="true" type="date" path="datescomputersSem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscomputersSem" placeholder="example"/>
            </div><br>
            <label for="commentscomputersSem" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentscomputersSem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesstampsTsup">Доставка печаток та штампів:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel19" disabled="false" required="true" type="date" path="datesstampsTsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusstampsTsup" placeholder="example"/>
            </div><br>
            <label for="commentsstampsTsup" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsstampsTsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datescleaningTsup">Клінінг приміщення:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel20" disabled="false" required="true" type="date" path="datescleaningTsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscleaningTsup" placeholder="example"/>
            </div><br>
            <label for="commentscleaningTsup" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentscleaningTsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datescashregistersGritch">Закупівля касової техніки:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel21" disabled="false" required="true" type="date" path="datescashregistersGritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscashregistersGritch" placeholder="example"/>
            </div><br>
            <label for="commentscashregistersGritch" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentscashregistersGritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
            <label for="datesmebliGritch">Закупівля меблів:</label><br>
            <div style="display: inline-flex">
                <form:input id="sel22" disabled="false" required="true" type="date" path="datesmebliGritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusmebliGritch" placeholder="example"/>
            </div><br>
            <label for="commentsmebliGritch" style="alignment: left">Коментарі:</label>
            <form:input id="sel22222" disabled="false" path="commentsmebliGritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
        </div>
    </fieldset>

</form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_OREN')">
    <form:form action="/updaterev" method="POST" modelAttribute="divisionRev" style="text-align:center" id="myform">


        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idrev" style="width:10%" placeholder="example" />

<fieldset class="inline" style="margin-left: 10px;width:20%;height:200px;border: 1px solid crimson">
    <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

    <div style="text-align: left">

        <label for="num">Номер відділення:</label>
        <form:input id="sel333" disabled="false" readonly="true" path="numrev" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
        <label for="address"  style="alignment: left">Адреса:</label>
        <form:input id="sel222" disabled="false" readonly="true" path="addressrev" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
        <form:checkbox id="sel111" path="statussafesrev" placeholder="example"/>
        <label for="sel111">Замовлення сейфів:</label><br>
        <label for="commentssafesrev" style="alignment: left">Коментарі:</label>
        <form:input id="sel22222" disabled="false" path="commentssafesrev" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

    </div>
</fieldset>

    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_SECU')">
    <form:form action="/updateloz" method="POST" modelAttribute="divisionLoz" style="text-align:center" id="myform">

        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idloz" style="width:10%" placeholder="example" />

        <fieldset class="inline" style="margin-left: 10px;width:20%;height:300px;border: 1px solid crimson">
            <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

            <div style="text-align: left">

                <label for="num">Номер відділення:</label>
                <form:input id="sel333" disabled="false" readonly="true" path="numloz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <label for="address"  style="alignment: left">Адреса:</label>
                <form:input id="sel222" disabled="false" readonly="true" path="addressloz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusvideoloz" placeholder="example"/>
                <label for="sel111">Система відеонагляду:</label><br>
                <label for="commentsvideoloz" style="alignment: left">Коментарі:</label><br>
                <form:input id="sel22222" disabled="false" path="commentsvideoloz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statussignalloz" placeholder="example"/>
                <label for="sel111">Охоронна сигналізація:</label><br>
                <label for="commentssignalloz" style="alignment: left">Коментарі:</label><br>
                <form:input id="sel22222" disabled="false" path="commentssignalloz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusfiresignalloz" placeholder="example"/>
                <label for="sel111">Пожежна сигналізація:</label><br>
                <label for="commentsfiresignalloz" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsfiresignalloz" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

            </div>
        </fieldset>

    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_REMO')">
    <form:form action="/updatepos" method="POST" modelAttribute="divisionPos" style="text-align:center" id="myform">

        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idpos" style="width:10%" placeholder="example" />

        <fieldset class="inline" style="margin-left: 10px;width:20%;height:300px;border: 1px solid crimson">
            <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

            <div style="text-align: left">

                <label for="num">Номер відділення:</label>
                <form:input id="sel333" disabled="false" readonly="true" path="numpos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <label for="address"  style="alignment: left">Адреса:</label>
                <form:input id="sel222" disabled="false" readonly="true" path="addresspos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusworkplacepos" placeholder="example"/>
                <label for="sel111">Розробка схеми розміщення роб. місць:</label><br>
                <label for="commentsworkplacepos" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsworkplacepos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusremontpos" placeholder="example"/>
                <label for="sel111">Ремонт всередині:</label><br>
                <label for="commentsremontpos" style="alignment: left">Коментарі:</label><br>
                <form:input id="sel22222" disabled="false" path="commentsremontpos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscasacabinspos" placeholder="example"/>
                <label for="sel111">Касові кабіни:</label><br>
                <label for="commentscasacabinspos" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentscasacabinspos" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

            </div>
        </fieldset>

    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_BANN')">
    <form:form action="/updateshyan" method="POST" modelAttribute="divisionShyan" style="text-align:center" id="myform">

        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idshyan" style="width:10%" placeholder="example" />

        <fieldset class="inline" style="margin-left: 10px;width:20%;height:300px;border: 1px solid crimson">
            <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

            <div style="text-align: left">

                <label for="num">Номер відділення:</label>
                <form:input id="sel333" disabled="false" readonly="true" path="numshyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <label for="address"  style="alignment: left">Адреса:</label>
                <form:input id="sel222" disabled="false" readonly="true" path="addressshyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusbannershyan" placeholder="example"/>
                <label for="sel111">Вивіска на відділенні:</label><br>
                <label for="commentsbannershyan" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsbannershyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusforextabloshyan" placeholder="example"/>
                <label for="sel111">Валюто-обмінне табло:</label><br>
                <label for="commentsforextabloshyan" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsforextabloshyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuspostershyan" placeholder="example"/>
                <label for="sel111">Плакати та наклейки:</label><br>
                <label for="commentspostershyan" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentspostershyan" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

            </div>
        </fieldset>

    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_COMP')">
    <form:form action="/updatesem" method="POST" modelAttribute="divisionSem" style="text-align:center" id="myform">

        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idsem" style="width:10%" placeholder="example" />

        <fieldset class="inline" style="margin-left: 10px;width:20%;height:300px;border: 1px solid crimson">
            <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

            <div style="text-align: left">

                <label for="num">Номер відділення:</label>
                <form:input id="sel333" disabled="false" readonly="true" path="numsem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <label for="address"  style="alignment: left">Адреса:</label>
                <form:input id="sel222" disabled="false" readonly="true" path="addresssem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusconnectionsem" placeholder="example"/>
                <label for="sel111">Побудова каналу звязку:</label><br>
                <label for="commentsconnectionsem" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsconnectionsem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusskssem" placeholder="example"/>
                <label for="sel111">Побудова СКС:</label><br>
                <label for="commentsskssem" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsskssem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscomputerssem" placeholder="example"/>
                <label for="sel111">Закупівля та встановлення комп. техніки:</label><br>
                <label for="commentscomputerssem" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentscomputerssem" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

            </div>
        </fieldset>

    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_CLEA')">
    <form:form action="/updatetsup" method="POST" modelAttribute="divisionTsup" style="text-align:center" id="myform">

        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idtsup" style="width:10%" placeholder="example" />

        <fieldset class="inline" style="margin-left: 10px;width:20%;height:300px;border: 1px solid crimson">
            <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

            <div style="text-align: left">

                <label for="num">Номер відділення:</label>
                <form:input id="sel333" disabled="false" readonly="true" path="numtsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <label for="address"  style="alignment: left">Адреса:</label>
                <form:input id="sel222" disabled="false" readonly="true" path="addresstsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusstampstsup" placeholder="example"/>
                <label for="sel111">Доставка печаток та штампів:</label><br>
                <label for="commentsstampstsup" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsstampstsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscleaningtsup" placeholder="example"/>
                <label for="sel111">Клінінг приміщення:</label><br>
                <label for="commentscleaningtsup" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentscleaningtsup" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

            </div>
        </fieldset>

    </form:form>
</sec:authorize>

<sec:authorize access="hasRole('ROLE_MEBL')">
    <form:form action="/updategritch" method="POST" modelAttribute="divisionGritch" style="text-align:center" id="myform">

        <input type="submit" value="Зберегти дані по відділенню" style="width: 20%;  margin-left: 10px;margin-top: 5px;background-color: crimson;color: white">
        <br>
        <br>

        <form:hidden path="idgritch" style="width:10%" placeholder="example" />

        <fieldset class="inline" style="margin-left: 10px;width:20%;height:300px;border: 1px solid crimson">
            <legend style="text-decoration: underline;color: crimson"><strong>ІНФОРМАЦІЯ ПРО ВІДДІЛЕННЯ:</strong></legend>

            <div style="text-align: left">

                <label for="num">Номер відділення:</label>
                <form:input id="sel333" disabled="false" readonly="true" path="numgritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <label for="address"  style="alignment: left">Адреса:</label>
                <form:input id="sel222" disabled="false" readonly="true" path="addressgritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statuscashregistersgritch" placeholder="example"/>
                <label for="sel111">Закупівля касової техніки:</label><br>
                <label for="commentscashregistersgritch" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentscashregistersgritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>
                <form:checkbox id="sel111" path="statusmebligritch" placeholder="example"/>
                <label for="sel111">Закупівля меблів:</label><br>
                <label for="commentsmebligritch" style="alignment: left">Коментарі:</label>
                <form:input id="sel22222" disabled="false" path="commentsmebligritch" style="width:100%;margin-bottom: 5px;font-size: small;" placeholder="example"/><br>

            </div>
        </fieldset>

    </form:form>
</sec:authorize>

<div id="popup1" class="overlay">
    <div class="popup">
        <h2>Here i am</h2>
        <a class="close" href="#" onclick="MyFunction();return true;">&times;</a>
        <div class="content">
            <label>Введіть дату:</label><br/>
            <input type="date" id="dates"><br/><br/>
            <label>Коментарі:</label><br/>
            <textarea rows="10" cols="55" id="comment"></textarea>
            <%--<input type="text" id="data">--%>
            <%--Thank to pop me out of that button, but now i'm done so you can close this window.--%>
        </div>
    </div>
</div>
<div id="popup2" class="overlay">
    <div class="popup">
        <h2>Here i am</h2>
        <a class="close" href="#" onclick="MyFunction();return true;">&times;</a>
        <div class="content">
            <label>Коментарі:</label><br/>
            <textarea rows="13" cols="55" id="comment1"></textarea>
            <%--Thank to pop me out of that button, but now i'm done so you can close this window.--%>
        </div>
    </div>
</div>

</body>

<script language="javascript">


    function JSGetSelectedItem() {
        let dropdownIndex = document.getElementById('sel').selectedIndex;
        let dropdownValue = document.getElementById('sel')[dropdownIndex].text;
        /*alert("Hello JSCript " + dropdownValue);*/
        if (dropdownValue === 'Так'){
            document.getElementById("divId").innerHTML= dropdownValue + "<h3>Питання 2: Якщо відповідь «Так», то надайти свої дані:</h3><p><label for='firstname'>ПІБ (повна назва): </label><input name='pib'  type='text' required/></p><p><label for='date'>Дата народження: </label><input name='birth' type='date' value='2000-01-01' required/></p>"
        }else{
            document.getElementById("divId").innerHTML=""
        }
    }


    function JSGetSelectedItem1() {

        let dropdownIndex = document.getElementById('sel1').selectedIndex;
        let dropdownValue = document.getElementById('sel1')[dropdownIndex].text;
if (dropdownValue === 'Оберіть відповідь'){

}

        alert(dropdownValue);

    }

    function validateSelects()
    {
        let m = false;


        if ( $('#sel').val() !== '' && $('#sel1').val() !== '' && $('#sel2').val().length !== 0 && $('#sel3').val() !== '' && $('#sel4').val() !== ''){  m=true; }
        else{
        alert("Ви не заповнили всі поля!");
        return false
    }
        alert("Дякуємо! Кредитну заявку оновлено!");
        return(m);
    }
    // For the functionality.
    $('#myform').on('submit',function()
    {
        return validateSelects();
    });


    $(".js-select2").select2({
        closeOnSelect : false,
        placeholder : "Оберіть відповідь",
        //allowHtml: true,
        //allowClear: true,
        multiple: true
        // tags: true // создает новые опции на лету
    })

    $(".js-select").select2({
        placeholder: "Оберіть відповідь",
        //allowClear: true
         tags: false // создает новые опции на лету
    })


    $("#status").change(function () {

        var selectedvalue = this.value;

        if (selectedvalue === 'запланована зустріч' || selectedvalue === "запланований повторний дзвінок"){
            window.location.href = "#popup1";
        }else{
            window.location.href = "#popup2";
        }

/*
        $("#comments").val(selectedvalue);*/
    });
    function MyFunction(){

        if ($("#status").val() === 'запланована зустріч' || $("#status").val() === "запланований повторний дзвінок"){
            $("#data").val(new Date($("#dates").val()).toLocaleDateString("be-BY"));
            //$("#data").val($("#dates").val());
            $("#comments").val($("#comment").val());
        }else{
            $("#data").val("");
            $("#comments").val($("#comment1").val());
        }
        //new Date().toLocaleTimeString('en-US', { hour12: false, hour: "numeric", minute: "numeric", secend: "numeric"});
        $("#clienthistory").val($("#clienthistory").val() + String.fromCharCode(8730) + " " + $("#status").val() + "\n" +
            String.fromCharCode(174) + " " + new Date().toLocaleDateString("be-BY") + " " +
            new Date().toLocaleTimeString('en-US', { hour12: false, hour: "numeric", minute: "numeric", secend: "numeric"}) + "\n" + "\n");

    }
</script>

</html>