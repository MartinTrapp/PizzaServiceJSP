<!-- Bestellung ausgeben über BestellungsId aus GET Parameter -->

<%@include file="header.jsp"%>

<sql:query dataSource="${SQLCon}" var="customer">
    SELECT o.wish, c.ID, c.title, c.firstName, c.lastName, c.street, c.number, c.zip, c.town, c.tel 
    FROM `order` AS o, `customer` AS c 
    WHERE o.ID = ${param.ID}
    AND o.customerID = c.ID
</sql:query>
<c:set var="c" value="${customer.rows[0]}"/> 


<table width="100%" border="0" cellspacing="1" cellpadding="3">
    <tr>
        <td>
            <c:out value="${c.title}"/> 
            <c:out value="${c.firstName}"/> 
            <c:out value="${c.lastName}"/>
        </td>
    </tr>
    <tr> 
        <td>
            <c:out value="${c.street}"/> 
            <c:out value="${c.number}"/>
        </td>
    </tr>
    <tr> 
        <td>
            <c:out value="${c.zip}"/> 
            <c:out value="${c.town}"/>
        </td>
    </tr>
    <tr> 
        <td>tel: 
            <c:out value="${c.tel}"/>
        </td>
    </tr>
</table>
<br>

<!-- Auflistung der zur Bestellung zugehörigen Produkte -->

<sql:query dataSource="${SQLCon}" var="products">
    SELECT p.name, m.size, m.price, pto.amount, pto.amount * m.price AS summe 
    FROM `producttoorder` AS pto, `product` AS p, `model` AS m 
    WHERE pto.OrderID = ${param.ID}
    AND pto.modelID = m.ID
    AND m.productID = p.ID
</sql:query>

<c:set var="totalSum" value="0"/>     
    
<table width="100%" border="0" cellspacing="1" cellpadding="3">
    <tr>
        <td width="5%">&nbsp;</td>
        <td width="30%">Artikel</td>
        <td>Preis</td>
    </tr>
    <c:forEach var="p" items="${products.rows}" varStatus="i">
        <tr>
            <td><c:out value="${p.amount}"/>x</td>  
            <td>
                <c:out value="${p.name}"/> - 
                <c:out value="${p.size}"/>
            </td> 
            <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${p.summe}" /></td>
        </tr>
        <c:set var="totalSum" value="${totalSum + p.summe}"/>     
    </c:forEach>
    <tr>
        <td colspan="2" align="right">summe: </td>
        <td><fmt:formatNumber currencySymbol="&euro;" type="currency" value="${totalSum}" /></td>
    </tr>
    <tr>
        <td><b>wunsch:</b></td>
        <td><c:out value="${c.wish}"/></td>
    </tr>
</table>

<!-- Bestellung abschließen -->    
<br><br><a href="Order?finish=${param.ID}" class="button"> fertig </a> 


<%@include file="footer.jsp"%>