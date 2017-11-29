<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>

<head>
	<title>BuyItemComplete画面</title>
</head>
<body>
	<div id="top">
			<p>BuyItemComplete</p>
		</div>
	<div id="main">
		
		<div id="main-center">
			<p>購入手続きが完了致しました。</p>
			<div>
				<a href='<s:url action="MyPageAction" />'>マイページ</a><span>から購入履歴の確認が可能です。</span>
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

