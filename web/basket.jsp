<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table  width="100%" border="0" cellspacing="2" cellpadding="5">
    <tr>
        <td width="15%">&nbsp;</td>
        <td width="30%">Artikel</td>
        <td width="20%">Preis</td>
        <td width="35%">Editieren</td>
    </tr>
    <c:choose>
        <c:when test="${basket.amount > 0}">
            <c:forEach var="row" items="${basket.b}" varStatus="bb">
                <tr>
                    <td><c:out value="${row.amount}"/> x </td>  
                    <td>
                        <c:out value="${row.name}"/> - 
                        <c:out value="${row.size}"/> 
                    </td> 
                    <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${row.totalPrice}" /> </td>
                    <td><a href="basket?add=${row.modelID}&cat=${param.cat}"><img src="img/add.png" width="14" height="14" alt="add" /></a>&nbsp;
                        <a href="basket?sub=${row.modelID}&cat=${param.cat}"><img src="img/minus.png" width="14" height="14" alt="sub" /></a>&nbsp;
                        <c:if test="${row.amount > 0}">
                            <a href="basket?del=${row.modelID}&cat=${param.cat}">&nbsp;<img src="img/can.png" width="14" height="14" alt="del" /></a>
                        </c:if>
                    </td>       
                 </tr>
             </c:forEach>
          <tr>
            <td colspan="2" align="right">summe: </td>
            <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${basket.totalPrice}"/></td>
            <td>            
                <a href="order.jsp">bestellen</a>              
            </td>
          </tr>   
       </c:when>
       <c:otherwise>
        <tr>
            <td colspan="4">keine Artikel im Warenkorb</td>
        </tr>
       </c:otherwise>
    </c:choose>
</table>     