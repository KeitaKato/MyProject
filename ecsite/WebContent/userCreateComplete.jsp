<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="headerMenubar.jsp" %>
<head>
	<title>UserCreateComplete画面</title>
</head>
<body>
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
	<div id="main">
		<div id="main-center"><br>
			<h3>ユーザーの登録が完了致しました。</h3>

			<div>
				<a href='<s:url action="HomeAction" />'>ログインへ</a>
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

