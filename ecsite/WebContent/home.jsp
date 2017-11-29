<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ include file="header.jsp" %>

<!DOCTYPE html>
<html>
<head>
	<title>Home画面</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

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