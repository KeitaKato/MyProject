<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ include file="header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<%@ include file="headerMenubar.jsp" %>
</head>
<body>
<div id="main">
	<div id="main-center">
		<div id="item_list">
            <s:form value="ItemList">
			     <div id="item_box">
			     	<div id="item_img">
                        <img src='<s:property value="itemImg"/>'>
                    </div>
                    <div id="item_category">
                        <s:property value="itemCategory"/>
                    </div>
					<div id="item_name">
						<a href='<s:url action="HomeAction"><s:param name="id" value="id" /></s:url>'>
							<s:property value="itemName" />
						</a>
					</div>
					<div id="item_price">
                        <s:property value="itemPrice"/><span>円</span>
                    </div>
			     </div>
            </s:form>
		</div>
	</div>
	<div id="left">
        <%@ include file="sidemenu.jsp"%>
    </div>
</div>

</body>
</html>