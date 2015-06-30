<!-- Bearbeiten eines Produktes -->

<%@include file="header.jsp"%>

<sql:query dataSource="${SQLCon}" var="product">
    SELECT * FROM `product`
    WHERE ID = ${param.ID}
</sql:query>
<c:set var="p" value="${product.rows[0]}"/>

<h1>Produkt aendern</h1>
    <form method="post" action="PControl">
    <table width="100%" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="15%"><b>Name</b></td>
        <td width="85%"><input type="text" name="name" value="${p.name}" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Extras</b></td>
        <td width="85%"><input type="text" name="extras" value="${p.extras}" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Size:Price;</b></td>
        <!-- size aus productController -->
        <td width="85%"><input type="text" name="size" value ="${size}" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Kategorie</b></td>
        <td width="85%">
<!-- Auflisten der zur Verfügung stehenden Kategorien -->            
            <sql:query dataSource="${SQLCon}" var="result">
                SELECT * FROM `category` 
            </sql:query>
                
            <select name="cat" size="1">';
                <c:forEach var="row" items="${result.rows}" varStatus="i">          
                    <option value="${row.ID}" ${row.ID == p.catID? "selected" : ""}>${row.name}</option>
                </c:forEach>      
            </select>
        </td>
       </tr> 
      <tr>
        <td colspan="2">
            <input type="hidden" name="ID" value="${p.ID}" />
            <input type="submit" name="edit" value="aendern" />
        </td>
      </tr>
    </table>
    </form>

<%@include file="footer.jsp"%>