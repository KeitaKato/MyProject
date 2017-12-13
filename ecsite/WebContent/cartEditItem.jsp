<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<%@ include file="headerMenubar.jsp" %>
<head>
<title>カート内商品一覧</title>
    <style type=text/css>
        /* ===========ITEMLIST========== */
#top{
	float:left;
}
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
}#item_category{
    margin: 5px 0px;
}#item_name{
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
#cart_box{
	width:300px;
	height: 275px;
    -moz-border-radius: 5px;
    -webkit-border-radius: 5px;
    border-radius: 5px;
    border: 1px solid;
    background-color: lightyellow;
}
        #cart_box #cart_top{
            height:18%;
        }

#cart_box #cart_main{
	height: 65%;
	border-top: 1px solid;
	border-color:lightgray;
    text-align: center;
}

        #cart_main #regi_link{
            text-align: center;

        }

#cart_box #cart_bottom{
    width: 88%;
    height: 17%;
    border-top: 1px solid;
    border-color: lightgray;
    margin: 0 auto;
}

    </style>
    <script type="text/javascript">
		function buttonAction(){
			var target = document.getElementById("cartCount");
			target.submit();
		}

		function total_calculation(){
			var cauntSelect = document.cartCount;
		}
	</script>
</head>
<body>
<div id="top">
	<h1>ショッピングカート</h1>
</div>
<div id="main">
	<div id="main-center">
		<div id="item_list">
            <s:iterator value="cartItemList">
			     <div id="item_box">
			     	<div id="item_img">
                        <img src='<s:property value="itemImg"/>'>
                    </div>
                    <div id="item_info">
                    	<div id="item_category">
                        	<s:property value="itemCategory"/>
                    	</div>
						<div id="item_name">
							<a href='<s:url action="DetailItemAction"><s:param name="id" value="id" /></s:url>'>
								<s:property value="itemName" />
							</a>
						</div>
					</div>
					<div id="item_price">
                        <s:property value="itemPrice"/><span>円</span>
                    </div>
                    <div id="item_count">
                    	<s:property value="cartItemList.get(0).getitemName()" />

                    	<s:form name="" id="countInfo" action="CartEditItemAction">
                        		<select name="countSelect">
                        			<option selected='<s:property value="buyCount"/>'></option>
                            		<option value="1" >1</option>
                            		<option value="2">2</option>
                            		<option value="3">3</option>
                            		<option value="4">4</option>
                            		<option value="5">5</option>
                            		<option value="6">6</option>
                            		<option value="7">7</option>
                            		<option value="8">8</option>
                            		<option value="9">9</option>
                            		<option value="10+">10</option>
                        		</select>
                        		<input type="hidden"  value='<s:property value="itemPrice"/>' name="price"/>
                        		<s:property value="buyCount"/>
                        </s:form>

                        <%

                        %>

                    </div>
			     </div>
            </s:iterator>
		</div>
	</div>
    <div id="right">
        <div id="cart_box">
	       <div id="cart_top">
	       </div>
	       <div id="cart_main">
	       	   <b><span>小計 (3 点): </span><s:property value="total_price"/><span>円</span></b><br>
               <a href='' id="regi_link">レジに進む</a>
	       </div>
	       <div id="cart_bottom">
	       </div>
        </div>

    </div>
</div>

</body>
</html>