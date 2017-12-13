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

#item_table{
    padding: 0px 15px 0px;
    height: 65px;
}


#item_table tr{
    height: 65px;
}
#item_table tr #plus_itme{
    display: flex;
    flex-flow:row wrap;
    justify-content: center;
    align-items:flex-start;
    align-content: flex-start;
}
#item_info {
	height: 65px;
	width: 65px;
}
.img {
	width:65px;
	height: 50px;
    position: relative;
      padding: 0;
      margin: 0;
    }
.img img{
	width:50px;
	height:50x;
}
.fukidashi {
    display: none;
	position: relative;
	background: #fff;
	border: 2px solid #999999;
	overflow: visible;

}
.fukidashi:after, .fukidashi:before {
	bottom: 100%;
	left: 50%;
	border: solid transparent;
	content: " ";
	height: 0;
	width: 0;
	position: absolute;
	pointer-events: none;
}

.fukidashi:after {
	border-color: rgba(255, 255, 255, 0);
	border-bottom-color: #fff;
	border-width: 10px;
	margin-left: -10px;
}
.fukidashi:before {
	border-color: rgba(153, 153, 153, 0);
	border-bottom-color: #999999;
	border-width: 13px;
	margin-left: -13px;
}
.img:hover + .fukidashi {
	display: block;
}
#item_table #item_info #item_category{
    margin: 5px 0px;
}

#item_table #item_info #item_name{
    margin: 5px 0px;
    font-size: 20px;
}

#item_table #item_info #item_price{
    margin: 5px 0px;
    color:red;
    font-size: 20px;
}
        span{
            font-size: 15px;
        }
#item_table #item_info #item_count{
    margin: 5px 0px;
    font-size: 20px;
}

    </style>
</head>
<body>
<div id="top">
</div>
<div id="main">
	<div id="main-center">
            <table border=1 id="item_table" style="table-layout:fixed;">
			     <tr>
			     	<td id="plus_itme">
           				<s:iterator value="cartItemList">
           					<div id="item_info">
			     				<p class="img">
                        			<img src='<s:property value="itemImg"/>'>
								</p>
								<p class="fukidashi">
			     				<a href= '<s:url action= " DetailItemAction"><s:param name= " id" value= " id" /></s:url>'>
									<s:property value= " itemName" />
								</a><br>

        						<s:property value="itemCategory"/><br>

        						<s:property value="itemPrice"/><span>円</span><br>
								</p>
							</div>
							<s:property value="cartResult"/>
                    		<s:property value="buyCount"/>
            			</s:iterator>
                    </td>
                    <td>
						<b><span>カート内の小計 </span></b><b><s:property value="totalPrice" /> <span>円</span> </b>
						<a href='<s:url action ="CartEditItemAction" ></s:url>' id="cart_link">カートの編集</a>
						<a href='#' id="regi_link">レジに進む</a>

                    </td>
                 </tr>
           </table>
	</div>
</div>

</body>
</html>