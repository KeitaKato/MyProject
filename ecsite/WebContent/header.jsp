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
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<style type="text/css">
		#header {
		    width: 100%;
		    height: 70px;
		    background-color: #fff;
		}
		#title {
            float: left;
            width: 200px;
            padding-left: 10px;
			color: black;
		}

        #header_list div{

        }
        #header_list div a{
            float:left;
        }
        #float_clear{float:clear;
            width: 100%;
            height: 50px;
            background-color: black;
        }
	</style>
</head>
<body>
	<div id="header" class="row">
            <div id="title" class="col-md-4">
	 		        <h1>ECサイト</h1>
            </div>
            <div id="search_window" class="col-md-4">
            		<div class="input-group">
            			<input type="text" class="form-control">
            			<span class="input-group-btn">
            				<button class="btn btn-default" type="submit">検索
            					<i class='glyphicon glyphicon-search'></i>
            				</button>
            			</span>
            		</div>
            </div>
            <div id="header_list" class="col-md-4">
                    <div class="pull-right">
                    <div class="list-group">
                        <div class="pull-left">
                        <a href="#" class="list-group-item">こんにちは、
                        <s:if test="#session.id != null">
                            <b><s:property value="session.userName"/></b>
                        </s:if>
                        <s:else>
                            <b>ゲスト</b>
                        </s:else>
				            様</a>
                        <a href="#" class="list-group-item">アカウント設定</a>
                        <a href="#" class="list-group-item">注文履歴</a>
                        <a href="#" class="list-group-item">カート</a>
                        </div>
                    </div>
                    </div>
                
            </div>
	</div>
    <div id=float_clear>
        </div>
</body>
</html>