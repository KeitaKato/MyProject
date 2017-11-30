<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<%@ include file="headerMenubar.jsp" %>
<head>
	<title>Login画面</title>
</head>
<body>
		<div id="top">
			<p>Login</p>
		</div>
	<div id="main">
		<div id="main-center">
			<h3>商品を購入する際にはログインをお願いします。</h3>
			<s:form action="LoginAction">
				<s:textfield name="loginUserId"/>
				<s:password name="loginPassword"/>
				<s:submit value="ログイン"/>
			</s:form>
			<br/>
			<div id="text-link">
				<p>新規ユーザー登録は<a href='<s:url action="UserCreateAction" />'>こちら</a></p>
				<p>Homeへ戻る場合は<a href='<s:url action="GoHomeAction" />'>こちら</a></p>
			</div>
		</div>
		<div id="left">
		</div>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>