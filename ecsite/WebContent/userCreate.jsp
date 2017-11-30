<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>

<head>
	<title>UserCreate画面</title>
	<style type="text/css">
    #create #createForm{
    	display: block;
        margin: 0 auto;
    }
	</style>
	<script type="text/javascript">
	function chkHissu(frm){
		/* 必須入力のname属性 */
		var hissu = Array("userEmail","loginUserId","loginPassword","userName","userNameKana");
		/* アラーと表示用 */
		var hissu_label = Array("メールアドレス","ユーザID","パスワード","名前","フリガナ");
		/* 必須入力の数 */
		var len = hissu.length;
		for(i=0; i<len; i++){
			var obj = frm.elements[hissu[i]];
			/* テキストボックス or テキストエリアが入力されているか調べる */
			if (obj.type=="text" || obj.type=="password"){
				if(obj.value==""){
					/* 入力されていなかったらアラート表示 */
					alert(hissu_label[i]+"を入力してください");
					/* 未入力項目にフォーカスを当てる */
					frm.elements[hissu[1]].focus();
					return false;
				}
			}
		}
		return true;
	}
	</script>
</head>
<body>
		<div id="top">
			<p>UserCreate</p>
		</div>
	<div id="main">
		<div id="create">
			<s:if test="errorMassage != ''">
				<s:property value="errorMassage" escape="false" />
			</s:if>
			<s:form id="createForm" action="UserCreateConfirmAction" onsubmit="return chkHissu(this)">
				<div class="form-group">
					<label>メールアドレス</label>
					<input type="text" class="form-control" size=40 name="userEmail"/>
				</div>

				<div class="form-group">
					<label>ユーザＩＤ</label>
					<input type="text" class="form-control" name="loginUserId"/>
				</div>

				<div class="form-group">
					<label>パスワード</label>
					<input type="password" class="form-control" name="loginPassword"/>
				</div>
				<div class="form-group">
					<label>名前</label>
					<input type="text" class="form-control" name="userName"/>
				</div>
				<div class="form-group">
					<label>フリガナ</label>
					<input type="text" class="form-control" name="userNameKana"/>
				</div>
				<s:submit type="submit" value="登録"/>
			</s:form>
			<div>
				<span>前画面に戻る場合は</span><a href='<s:url action="HomeAction" />'>こちら</a>
			</div>
		</div>
	</div>
		<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>