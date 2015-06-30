<!-- Auflistung aller Produkte, Geordnet nach Kategorie -->

<%@include file="header.jsp"%>

<sql:query dataSource="${SQLCon}" var="result">
    SELECT ID, name 
    FROM `category`
</sql:query>

<a href="newProduct.jsp">Neues Produkt anlegen</a>


<table width="100%" border="0" cellspacing="1" cellpadding="3">
    <c:forEach var="row" items="${result.rows}" varStatus="i">
        <tr>
            <td colspan='4'><h3>${row.name}</h3></td>
          </tr>
          <sql:query dataSource="${SQLCon}" var="product">
                 SELECT ID, name 
                 FROM `product`
                 WHERE catID = ${row.ID}
          </sql:query>
          <c:forEach var="p" items="${product.rows}" varStatus="i">
            <tr>
                <td width="15%">${p.name}</td>
                <td width="5%"><a href="PControl?pID=${p.ID}" class="button"> edit</a></td>
                <td align="left"><a href="PControl?del=${p.ID}" class="button"> delete</a></td>
            </tr>        
          </c:forEach>           
    </c:forEach>                      
</table>          

<%@include file="footer.jsp"%>

