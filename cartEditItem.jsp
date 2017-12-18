<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page import="java.io.*" %>
	<%@ page import="java.util.ArrayList" %>
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

#item_box{
    flex-basis: 200px;
    height: 380px;
    margin: 20px 15px 0px;
    background-color:darkkhaki;
}
#item_img img{
	width:200px;
	height:200px;
    margin-bottom: 5px;
}#item_category{
    margin: 5px 0px;
}#item_name{
    margin: 5px 0px;
    font-size: 20px;
}
#item_price{
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
	var countPrice = [];
	function updateTotalPrice(){

		var total_price = document.getElementById("total_price").value;
		var count = document.getElementById("buyCount").value;
		var select = document.getElementById("countSelect").value;
		var price = document.getElementById("itemPrice").value;

		if(count < select){
			total_price += (select - count)*itemPrice;
		}else if(count > select){
			total_price -= (count - select)*itemPrice;
		}

		target = document.getElementById("totalPrice");
		target.innerHTML = total_price;


	}
		function itemDelete(id){
			var id =  document.getElementById(id);
			while (id.firstChild){
				id.removeChild(id.firstChild);
			}
			document.getElementById("deleteFlg").value="on";
		}

		function priceSum(){
			var totalPrice = 0;
			var count = document.getElementsByName("countSelect");
			var price = document.getElementsByName("itemPrice");
			for(var i = 0; i < count.length ; i++){
				var countPrice = parseInt(count[i].value) * parseInt(price[i].value);
				totalPrice += countPrice;
			}

			target = document.getElementById("totalPrice");
			target.innerHTML = totalPrice;
		}

		function totalPrice(iteratorCount){
			var countSelect = document.getElementById("countSelect").selectedIndex;
			var itemPrice = document.getElementById("itemPrice").value;

			if(countPrice.length >= iteratorCount){
				countPrice.push(countSelect * itemPrice);
			}else{
				countPrice[iteratorCount] = countSelect * itemPrice;

			}

		function sum(){
			var sum = 0;
			countPrice.forEach(function(elm){
				sum += elm;
			});

			target = document.getElementById("totalPrice");
			target.innerHTML = totalPrice;
		}

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
			<% int iteratorCount = 0;%>
            <s:iterator value="cartItemList">
            	<div id="<%= iteratorCount %>">
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

                    	<s:form name="" id="countInfo" action="CartUpdateItemAction">
                    		<s:if test='buyCount > 9'>
                    			<input type="text" value='<s:property value="buyCount"/>'/>
                    		</s:if>
                    		<s:else>
                        		<s:select name="countSelect" id="countSelect" form=""
                        		list="#{ '1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10+'}"
                        		value='buyCount' onChange="updateTotalPrice()"/>
                        		<p></p>
                        	</s:else>
                        	<input type="hidden" name="buyCount" id="buyCount" value='<s:property value="buyCount"/>' />

                        	<input type="hidden" name="id" value="id" />
                        	<input type="hidden" name="itemPrice" id="itemPrice" value='<s:property value="itemPrice"/>' />
                        	<input type="hidden" name="deleteFlg" id="deleteFlg" value="of"/>
                    		<a onclick="itemDelete(<%=iteratorCount%>)">削除</a>
                        </s:form>

                    </div>
			     </div>
			   </div>
			     <% iteratorCount++; %>
            </s:iterator>
            <s:property value="cartItemList.get(1).buycount"/>
		</div>
	</div>
    <div id="right">
        <div id="cart_box">
	       <div id="cart_top">
	       </div>
	       <div id="cart_main">
	       	   <b><span>小計 ( 点): </span><span id="totalPrice"><input type="hidden" id="total_price" value='<s:property value="total_price" />'/></span><span>円</span></b><br>
               <a href='' id="regi_link" onClick="cum()">レジに進む</a>
	       </div>
	       <div id="cart_bottom">

	       </div>
        </div>

    </div>
</div>
<script type="text/javasctipt">
	window.onload = total_price();

	function total_price(){

		var total_price = document.getElementById("total_price").value;

		target = document.getElementById("totalPrice");
		target.innerHTML = total_price;
	}
</script>

</body>
</html>