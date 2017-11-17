
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<jsp:include page="header.jsp" flush="true"/>
<!DOCTYPE html>
<html>

<head>
	<title>UserCreateConfirm画面</title>
	<style type="text/css">
		/* ========TAG LAYOUT======== */
		body {
		   margin:0;
		   padding:0;
		   line-height:1.6;
		   letter-spacing:1px;
		   font-family:Verdana, Helvetica, sans-serif;
		   font-size:12px;
		   color:#333;
		   background:#fff;
		}

		table {
			text-align:center;
			margin:0 auto;
		}

		/* ========ID LAYOUT======== */
		#top {
		   width:780px;
		   margin:30px auto;
		   border:1px solid #333;
		}
		#main {
		   width: 100%;
		   height: 500px;
		   text-align: center;
		}

		#box {
			border: 1px solid #000000;
		}

		#footer {
			width: 100%;
			height: 80px;
			background-color: black;
			clear:both;
		}
	</style>
</head>
<body>
	<div id="main">
		<div id="top">
			<p>UserCreateConfirm</p>
		</div>
		<div>
			<h3>登録する内容は以下でよろしいですか。</h3>
			<table>
				<s:form action="UserCreateCompleteAction">
					<tr id="box">
						<td>
							<label>ログインID:</label>
						</td>
						<td>
							<s:property value="loginUserId" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ログインPASS:</label>
						</td>
						<td>
							<s:property value="loginPassword" escape="false" />
						</td>
					</tr>
					<tr id="box">
						<td>
							<label>ユーザー名:</label>
						</td>
						<td>
							<s:property value="userName" escape="false" />
						</td>
					</tr>
					<tr>
						<td>
							<s:submit value="完了" />
						</td>
					</tr>
				</s:form>
			</table>
		</div>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>