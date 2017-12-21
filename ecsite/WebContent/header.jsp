<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="imagetoolbar" content="no" />
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="" />
	<meta name="keywords" content="" />
	<meta charset="utf-8">
    <link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="./css/style.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/jquery.balloon.js"></script>

    <script type="text/javascript">

    </script>

	<style type="text/css">
		#header {
		    width: 100%;
            height: 70px;
            background-color: #f0f0f0;
			display: flex;
			align-items: center;
			justify-content: space-between;
		}

		#title a{
			display: block;
            width: 200px;
            padding-left: 10px;
            font-size: 30px;
			color: black;
		}

        #header_list div{
        	display: flex;
        	margin-top: 1px;
            margin-right: auto;
            margin-bottom: 1px;
        }
        #header_list div a{
            width: 125px;
            text-align: center;
        }
        #sample {
 padding:10px;
 margin-bottom:10px;
}
#sample .text {
 width:212px;
 height:30px;
 border:5px solid #CCC;
 border-radius:20px;
 text-indent:10px;
}
#sample .btn {
 height:40px;
 border:5px solid #CCC;
 width:40px;
 border-radius:20px;
 margin-left:-44px;
}

	</style>
</head>
<body>
    <div id="header">
            <div  id="title">
            	<a href="home.jsp">
	 		        ECサイト
	 		    </a>

            </div>
            <s:form action="SearchAction">
            	<div id="sample">
            			<input type="text" name="searchValue" class="text" placeholder="商品検索">
            			<s:submit class="btn" type="button" value="検索">
            				<i class='glyphicon glyphicon-search' onclick="onSubmit()"></i>
            			</s:submit>


            	</div>
            </s:form>


            	<div  id="header_list">
                    <div id="account_menu" class="list-group">
                        <a href="#" class="list-group-item">こんにちは、
                        <s:if test="session.login_user_id != null">
                            <br><b><s:property value="session.userName"/></b>
                        </s:if>
                        <s:else>
                            <br><b>ゲスト</b>
                        </s:else>
				            様</a>
				        <a href="#" class="list-group-item">アカウント設定</a>
                        <a href="#" class="list-group-item">注文履歴</a>
                        <a href='<s:url action="CartEditItemAction"></s:url>' class="list-group-item">カート</a>
                    </div>
            </div>
            </div>
</body>
</html>