<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="headerMenubar.jsp" %>
<head>
<title>カート画面</title>
    <style type=text/css>
        /* ===========ITEMLIST========== */

#item_list{
    display: flex;
    flex-flow:row wrap;
    justify-content: center;
    align-items:flex-start;
    align-content: flex-start;
    padding: 0px 15px 0px;
}


#item_list #item_box{
    flex-basis: 200px;
    height: 380px;
    margin: 20px 15px 0px;
    background-color:darkkhaki;
}

#item_list #item_box #item_img img{
	width:200px;
	height:200px;
    margin-bottom: 5px;
}
#item_list #item_box #item_category{
    margin: 5px 0px;
}

#item_list #item_box #item_name{
    margin: 5px 0px;
    font-size: 20px;
}

#item_list #item_box #item_price{
    margin: 5px 0px;
    color:red;
    font-size: 20px;
}
        span{
            font-size: 15px;
        }

    </style>
</head>
<body>
<div id="top">
</div>
<div id="main">
	<div id="main-center">
		<div id="item_list">
            <s:iterator value="cartItemList">
			     <div id="item_box">
			     	<div id="item_img">
                        <img src='<s:property value="itemImg"/>'>
                    </div>
                    <div id="item_category">
                        <s:property value="itemCategory"/>
                    </div>
					<div id="item_name">
						<a href='<s:url action="DetailItemAction"><s:param name="id" value="id" /></s:url>'>
							<s:property value="itemName" />
						</a>
					</div>
					<div id="item_price">
                        <s:property value="itemPrice"/><span>円</span>
                    </div>
			     </div>
            </s:iterator>
		</div>
	</div>
	<div id="left">
        <%@ include file="sidemenu.jsp"%>
    </div>
</div>

</body>
</html>