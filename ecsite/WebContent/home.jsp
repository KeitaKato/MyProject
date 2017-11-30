<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="headerMenubar.jsp" %>
<head>
	<title>Home画面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

	<style type="text/css">
	/* ===========BXSLIDER========== */
        #top-slider{
            width: 80%;
            margin: 0px auto;
            margin-top 0 ;
            margin-bottom: 10px;
            display:block;
        }
        .slider{
            width: 80%;
            height: 300px;
        }
        .slider img{
            width: 96%;
            height: 350px;
            margin: 0 auto;
            display:block;

        }
    <!--
    .bx-wrapper{ margin: 0 auto !important;}
    ul.bxslider {
        margin:0;
        padding:0;
    }
    .bx-wrapper .bx-viewport{
    -moz-box-shadow: 0 0 0 ;
    -webkit-box-shadow: 0 0 0 ;
    box-shadow: 0 0 0 ;
    border: 0;
    left: 0;
    background: #fff;
    }
    -->
	</style>
    <script>
      $(document).ready(function(){
        $('.slider').bxSlider({
            auto: true,
            mode: 'fade',
            speed: 1000,
            infiniteLoop: true,
            pager: false

        });
      });
    </script>

</head>
<body>
    <div id="top-slider">
        <div class="slider">
            <div><img src="picture/bxSlider/ELF85_IMG_0836_TP_V.jpg"></div>
            <div><img src="picture/bxSlider/PPP_cyuukaman_TP_V.jpg"></div>
            <div><img src="picture/bxSlider/stockhiroDSCF5504_TP_V.jpg"></div>
            <div><img src="picture/bxSlider/tachiaraiIMGL4582_TP_V.jpg"></div>
            <div><img src="picture/bxSlider/YAMA_DSC0728_TP_V.jpg"></div>
        </div>
   </div>
	<div id="main">
		<div id="main-center">
			<div id="text-center">
				<s:form action="HomeAction">
					<s:submit value="商品購入"/>
				</s:form>
				<s:if test="#session.id != null">
					<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
				</s:if>
			</div>
			<a href="buyItem.jsp">商品購入</a><br>
			<a href="buyItemComplete.jsp">購入完了</a><br>
			<a href="buyItemConfirm.jsp">購入確認</a><br>
			<a href="error.jsp">エラー画面</a><br>
			<a href="login.jsp">ログイン画面</a><br>
			<a href="myPage.jsp">マイページ</a><br>
			<a href="search.jsp">検索結果</a><br>
			<a href="userCreate.jsp">ユーザー登録画面</a><br>
			<a href="userCreateComplete.jsp">ユーザー登録完了画面</a><br>
			<a href="userCreateConfirm.jsp">ユーザー登録確認画面</a><br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>

		</div>
		<div id="left">
            <%@ include file="sidemenu.jsp"%>
		</div>
		<div id="right">
		</div>
	</div>
	<div id="footer">
	 	<div id="pr">
		</div>
	</div>
</body>
</html>