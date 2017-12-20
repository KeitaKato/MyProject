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
<title>購入確認画面</title>
    <style type=text/css>
        /* ===========ITEMLIST========== */
#top{
}
#item_list{
	width: 90%;
    margin: 0 auto;
    border-bottom: solid 1px;
    border-color: lightgray;

}
.item_box{
	width: 100%;
    height: 140px;
    border-top: solid 1px;
    border-color: lightgray;
    display:flex;
    justify-content: space-between;
}
#item_img img{
	width: 20%;
	height:100%;
    margin-bottom: 5px;
}
#item_info{
	width: 54%
}
#item_category{
    margin: 5px 0px;
        }
#item_name{
    margin: 5px 0px;
    font-size: 20px;
}
#deleteFlg{
}
#item_price{
    margin: 5px 0px;
    color:red;
    font-size: 20px;
}
        span{
            font-size: 15px;
        }

#box_label{
}

#item_count{
	display: flex;
	flex-direction: column;

}
#countSelect{
	margin-top: 10px;
}
#update{
        background-color: transparent;
        border: none;
        cursor: pointer;
        outline: none;
        padding: 0;
        appearance: none;
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

</head>
<body>
<div id="top">
	<h1>ショッピングカート</h1>
</div>
<div id="main">
	<div id="main-center">
		<div id="item_list">
            <s:iterator value="cartItemList" status="st" >
            	<s:form name="itemForm" id="itemForm" theme="simple" action="CartUpdateItemAction">



			     <div id="item_box" class="item_box">
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

						<input type="hidden" name="index" value='<s:property value="%{#st.index}"/>'/>
                    	<s:submit name="deleteFlg" type="button" value="on" id="delete_link" class="not_event">削除</s:submit>

					</div>
					<div id="item_price">
                        <s:property value="itemPrice"/><span>円</span>
                    </div>

                    <div id="item_count">
                        <s:select name="selectList" id="countSelect"
                        		list="#{ '1':'1','2':'2','3':'3','4':'4','5':'5','6':'6','7':'7','8':'8','9':'9','10':'10+'}"
                        		value='buyCount' onchange='onSubmit()'/>
                    	<s:submit value="変更" id="update" class="not_event"/>

                    </div>
			     </div>
                    <input type="hidden" name="idList" value='<s:property value="id"/>' />
                    <input type="hidden" name="priceList" value='<s:property value="itemPrice"/>' />
			   </s:form>
            </s:iterator>
            <s:property value="CartResult"/>
		</div>
	</div>
    <div id="right">
    	<noscript>
    		<p>javascript無効状態でページを離れると、<br>
    		変更状態が維持されません！</p>
    	</noscript>
        <div id="cart_box">
	       <div id="cart_top">
	       </div>
	       <div id="cart_main">
	       	   <b><span>小計 ( 点): </span><s:property value="total_price" /><span>円</span></b><br>
               <s:submit type="button" name="branch" value="regi" form="itemForm">レジに進む</s:submit>
	       </div>
	       <div id="cart_bottom">

	       </div>
        </div>

    </div>
</div>
<script type="text/javascript">

	function onSubmit(){
		document.getElemenById("itemForm").action = 'CartUpdateItemAction';
		document.getElemenById("itemForm").submit();
	}

	function deleteSubmit(){
		document.getElemenById("itemForm").action = 'CartDeleteItemAction';
		document.getElemenById("itemForm").submit();
	}

</script>
</body>
</html>