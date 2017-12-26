<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
	<head><link rel="stylesheet" type="text/css" href="css/prefSelectExtension.css" />
	<script type="text/javascript" src="js/prefSelectExtension.js"></script>
	<title>住所登録画面</title>

	<style type="text/css">

	#header{
	display: none;

	}
	b{
		color:red;
	}
	</style>
    <script>
    </script>

</head>
<body>
	<div id="main">
		<div id="main-center">
		    <h1>住所を設定してください</h1>
		    <b><s:property value="errorMessage"/></b>
			<s:form action="AddressCompleteAction" >
				氏名<br>
				<input type="text" name="name" value='<s:property value="name" />'/>
				<br>
				郵便番号<br>
				<input type="text" name="postal" value='<s:property value="postal" />'/>
				<br>
				都道府県<br>
				<select name="pref" class="pref">
				<option value="0">選択してください</option>
				<optgroup label="北海道">
				<option value="1">北海道</option>
				</optgroup>
				<optgroup label="東北">
				<option value="2">青森</option>
				<option value="3">秋田</option>
				<option value="4">岩手</option>
				<option value="5">山形</option>
				<option value="6">宮城</option>
				<option value="7">福島</option>
				</optgroup>
				<optgroup label="関東">
				<option value="8">栃木</option>
				<option value="9">群馬</option>
				<option value="10">茨城</option>
				<option value="11">埼玉</option>
				<option value="12">千葉</option>
				<option value="13">東京</option>
				<option value="14">神奈川</option>
				</optgroup>
				<optgroup label="中部">
				<option value="15">山梨</option>
				<option value="16">長野</option>
				<option value="17">新潟</option>
				<option value="18">富山</option>
				<option value="19">石川</option>
				<option value="20">福井</option>
				<option value="21">静岡</option>
				<option value="22">岐阜</option>
				<option value="23">愛知</option>
				</optgroup>
				<optgroup label="近畿">
				<option value="24">三重</option>
				<option value="25">和歌山</option>
				<option value="26">奈良</option>
				<option value="27">滋賀</option>
				<option value="28">京都</option>
				<option value="29">大阪</option>
				<option value="30">兵庫</option>
				</optgroup>
				<optgroup label="中国">
				<option value="31">鳥取</option>
				<option value="32">岡山</option>
				<option value="33">島根</option>
				<option value="34">広島</option>
				<option value="35">山口</option>
				</optgroup>
				<optgroup label="四国">
				<option value="36">徳島</option>
				<option value="37">香川</option>
				<option value="38">愛媛</option>
				<option value="39">高知</option>
				</optgroup>
				<optgroup label="九州">
				<option value="40">福岡</option>
				<option value="41">佐賀</option>
				<option value="42">長崎</option>
				<option value="43">熊本</option>
				<option value="44">大分</option>
				<option value="45">宮崎</option>
				<option value="46">鹿児島</option>
				<option value="47">沖縄</option>
				</optgroup>
				</select>
				<br>
				住所<br>
				<input type="text" name="city" value='<s:property value="city" />'/>
				<br>
				アパート・マンション名<br>
				<input type="text" name="room" value='<s:property value="room" />'/>
				<br>
				電話番号<br>
				<input type="text" name="number" value='<s:property value="number" />'/>
				<br>
				<s:submit value="送信"/>
			</s:form>


		</div>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>