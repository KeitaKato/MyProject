<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="headerMenubar.jsp" %>
<title><s:property value="itemName"/></title>


<style type="text/css">

#item {
    margin: 40px 20px 10px;
    display: flex;

}
    #item #item_img{
    width:340px;
	height: 450px;
    }

    #item #item_img img{
	    width:340px;
	    height: 340px;
	    border: solid;
        border-width: thin;
        border-color: lightgray;
    }
#item_info {
    width: 410px;
    height: 450px;
    margin-left: 20px;
    text-align: left;
}

    #item_info #item_category{

    }

    #item_info #item_name{
        font-size: 18px;
    }

    #item_info #item_price{
        align-self: center;
        font-size: 35px;
        color:red;
        height: 70px;
        display: block;
        text-align: center;
        margin: 40px auto;
    }
    #item_info #item_price span{
        font-size: 20px;
    }

    #item_info #item_cart{
        width: 100%;
        height: 100px;
        background-color: lightgray;
        display: flex;
        align-items: center;
        justify-content: center;
    }
    #item_info #item_cart #purchase_count{
        width: 50px;
        height: 50px;
        text-align: center;
}
    #item_info #item_cart #cart_button{
        width: 180px;
        height: 50px;
        background-color: yellow;
}

</style>
</head>
<body>
<div id="main">
	<div id="main-center">
        <div id="item">
            <div id="item_img">
                <img src='<s:property value="itemImg"/>'>
            </div>
        <div id="item_info">
            <div id="item_category">
                <s:property value="itemCategory"/>
            </div>
            <div id="item_name">
				<b><s:property value="itemName" /></b>
            </div>
            <div id="item_price">
                <b><s:property value="itemPrice"/></b><span>円</span>
            </div>
                <s:form id="item_cart" action="CartInItemAction">
                    <div id="purchase_count">
                        <span>数量</span>
                        <select name="buyCountList">
                            <option value="1" selected="selected">1</option>
                            <option value="2">2</option>
                            <option value="3">3</option>
                            <option value="4">4</option>
                            <option value="5">5</option>
                            <option value="6">6</option>
                            <option value="7">7</option>
                            <option value="8">8</option>
                            <option value="9">9</option>
                            <option value="10">10</option>
                        </select>
                    </div>
                        <input type="hidden" value='<s:property value="id"/>' name="idList"/>
                        <s:submit id="cart_button" value="カートに入れる" />
                        <i class="fa fa-shopping-cart" aria-hidden="true"></i>
                </s:form>
        </div>
        </div>
    </div>
	<div id="left">
        <%@ include file="sidemenu.jsp"%>
    </div>
</div>

</body>
</html>