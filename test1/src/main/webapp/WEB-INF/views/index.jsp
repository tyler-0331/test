<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var = "loginLink" value= "${sessionScope.id == null? '/login/login':'/login/logout'}"></c:set>
<c:set var = "loginOut" value= "${sessionScope.id == null? 'login':'logout'}"></c:set>
<c:set var = "NoSignIn" value= "${sessionScope.id == null? 'Sign in': null}"></c:set>


<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>fastcampus</title>
    <link rel="stylesheet" href="<c:url value='/css/menu.css'/>">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css"/>    
</head>
<body>
<div id="menu">
	<ul id="menu">
	    <li id="logo">fastcampus</li>
	    <li><a href="<c:url value='/'/>">Home</a></li>
	    <li><a href="<c:url value='/board/list'/>">Board</a></li>
	    <li><a href="<c:url value='${loginLink}'/>">${loginOut}</a></li>
	    <c:if test="${sessionScope.id == null }" >
	    	<li><a href="<c:url value='/register/add'/>">${NoSignIn}</a></li>
	    </c:if>
	    <li><a href=""><i class="fas fa-search small"></i></a></li>
	</ul> 
	
	
</div>
<div style="text-align:center">
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
	<h1>This is HOME</h1>
</div>
