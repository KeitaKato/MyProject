<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<head>
<style type="text/css">
/* ==========HEADERMENU=========== */
#headerMenu{
    width: 100%;
    height: 50px;
    background-color: black;
}
#Menu{
	width: 100%;
	height: 50px;
	display: flex;
    align-items: center;
    justify-content: space-between;
}
#Menu li{
    list-style: none;
    flex-basis: 20%;
    height: 90%;
    border-right: solid;
    border-color: white;
}
    #Menu li a{
    	display: block;
        width: 100%;
        height: 100%;
        text-align: auto;
        line-height: 50px;
        color: white;
    }


</style>
</head>
<body>
<div id=headerMenu>
<ul id="Menu">
	<li><s:a action="ItemLineupAction">全商品一覧</s:a>
	<li><a href="#">飲料</a>
	<li><a href="#">調味料</a>
	<li><a href="#">冷凍</a>
	<li><a href="#">冷蔵</a>
</ul>
</div>
</body>