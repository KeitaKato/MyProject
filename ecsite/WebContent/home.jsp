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
            width: 100%;
            margin: 0px auto;
            margin-top 0 ;
            margin-bottom: 10px;
            display:block;
        }
        .slider{
            width: 80%;
            height: 200px;
        }
        .slider img{
            width: 96%;
            height: 200px;
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

#scrapy{
	margin: 10px;
	margin-top: 20px;
	background-color:skyblue;
	width: 95vw auto;
	height: 15vw;
  display: flex;
  justify-content: center;
  align-items: center;
}
*,
*:before,
*:after {
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}

.clearfix:after {
    content:"";
    clear:both;
    display:block;
}

#searchform {
  margin:0 auto;
  width: 90%;
  height: 65%;
  position:relative;
  display: flex;
  flex-wrap: nowrap;
}
#searchform span{
  align-self: center;
  font-size: 5vmax;
}

#keyword,
#submit {
  border:none;
  padding:10px;
  position:absolute;
  font-size: 5vmax;
}

#keyword {
  border-radius:10px 0 0 10px;
  background:#dfdfdf;
  right:20%;
  transition:all 0.3s;
  width:20%;
  height: 100%;
}

#keyword:focus {
  width:80%;
  z-index:1;
}

#submit {
  border-radius:0 10px 10px 0;
  background:#0E7AC4;
  color:#fff;
  font-family:FontAwesome;
  right:0;
  width:20%;
  height: 100%;
}

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
<div id="scrapy" >
  <s:form name="myForm" id="searchform" action="#" class="clearfix" theme="simple">
  	<label for="keyword">
	<span>Webレシピ検索</span>
    </label>
    <s:textfield name="keyword" id="keyword"/>
    <div class="search-button"><s:submit id="submit" value="検索"/></div>
  </s:form>
</div>
	<div id="main">
		<div id="main-center">
			<div id="graph_img">
                <img id="graphImg" src='<s:property value="graphImg"/>'>
            </div>
    		<div id="top-slider">
        		<div class="slider">
            		<div><img src="picture/bxSlider/ELF85_IMG_0836_TP_V.jpg"></div>
            		<div><img src="picture/bxSlider/PPP_cyuukaman_TP_V.jpg"></div>
           			<div><img src="picture/bxSlider/stockhiroDSCF5504_TP_V.jpg"></div>
            		<div><img src="picture/bxSlider/tachiaraiIMGL4582_TP_V.jpg"></div>
            		<div><img src="picture/bxSlider/YAMA_DSC0728_TP_V.jpg"></div>
        		</div>
   			</div>
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
			<a href="address.jsp">住所登録</a>
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
	<script>
		$(function(){
	    	setInterval(function(){
	    		$.ajax({
	    			url:		'./PythonGraphAction.action',
	    			type:		'GET',
	    			dataType:	'json',
	    			success:	function(json){
	    							$('#graphImg').attr('src','graphImg' + '?' + new Date().getTime());
	    						}
	    		})
	    	},3000);
		});
	</script>
</body>
</html>