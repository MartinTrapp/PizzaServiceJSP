<!-- Auflistung aller offnen Bestellungen -->

<%@include file="header.jsp"%>

<sql:query dataSource="${SQLCon}" var="result">
    SELECT o.ID, c.lastName 
    FROM `order` AS o
    INNER JOIN customer AS c
    ON o.customerID = c.ID
    WHERE o.done = -1
</sql:query>
    
<c:choose>
    <c:when test="${result.rows[0] != null}">
        <table width="100%" border="0">
           <tr>
               <td colspan="4"><b>Offene Bestellungen f&uuml;r</b></td>
           </tr>
           <c:forEach var="row" items="${result.rows}" varStatus="i">
               <tr>
                   <td width="5%"><c:out value="${i.count}"/></td>
                   <td width="20%"><c:out value="${row.lastName}"/></td>
                   <td><a href="order.jsp?ID=${row.ID}" class="button"> Bestellung einsehen</a></td>
               </tr>              
           </c:forEach>
        </table>
    </c:when>
    <c:otherwise>
        <b>Keine offenen Bestellungen</b>
    </c:otherwise>   
</c:choose>


<%@include file="footer.jsp"%>
