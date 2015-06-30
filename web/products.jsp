<!-- Auflistung aller Produkte der aufgerufenen Kategorie -->

<%@include file="header.jsp"%>

<!-- cat preset falls keine ID über GET -->
<c:set var="cat" value="${param.cat != null? param.cat : 1}"/>

<sql:query dataSource="${SQLCon}" var="result">
    SELECT * 
    FROM product
    WHERE catID = ${cat}
</sql:query>

<table width="100%" border="0" cellspacing="1" cellpadding="3">
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>
                <h3> <c:out value="${row.name}"/> </h3> 
                <c:out value="${row.extras}"/>
            </td>
        </tr>
<!-- Auflistung der verschiedenen Größen pro Produkt -->        
        <sql:query dataSource="${SQLCon}" var="model">
            SELECT ID, size, price 
            FROM model
            WHERE productID = ${row.ID}
        </sql:query>
                
        <c:forEach var="rowIn" items="${model.rows}">
            <tr>
                <td> <c:out value="${rowIn.size}"/>  - 
                    <a href="basket?add=${rowIn.ID}&cat=${cat}"> 
<!-- formatNumber für Ausgabe in Form von ####.## Euro durch fmt taglib -->
                        <fmt:formatNumber currencySymbol="&euro;" type="currency" value="${rowIn.price}" /> &nbsp;&nbsp;
                        <img src="img/cart.png" width="14" height="14" alt="cart" /> 
                    </a>
                </td>
            </tr>
        </c:forEach>                     
    </c:forEach>
</table>            
    
<%@include file="footer.jsp"%>