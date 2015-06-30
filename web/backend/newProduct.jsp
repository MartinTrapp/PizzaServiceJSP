<!-- Neues Produkt hinzufügen -->

<%@include file="header.jsp"%>

<h1>Produkt hinzuf&uuml;gen</h1>
    <form method="post" action="PControl">
    <table width="100%" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="15%"><b>Name</b></td>
        <td width="85%"><input type="text" name="name" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>extras</b></td>
        <td width="85%"><input type="text" name="extras" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Size:Price;</b></td>
        <td width="85%"><input type="text" name="size" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Kategorie</b></td>
        <td width="85%">
 <!-- Auflistung der zur verfügung stehenden Kategorien -->           
            <sql:query dataSource="${SQLCon}" var="result">
                SELECT ID, name FROM `category`
            </sql:query>
            <select name="cat" size="1">';
                <c:forEach var="row" items="${result.rows}" varStatus="i">          
                    <option value=${row.ID}>${row.name}</option>
                </c:forEach>      
            </select>
        </td>
       </tr> 
      <tr>
        <td colspan="2"><input type="submit" name="add" value="Hinzufuegen" /></td>
      </tr>
    </table>
    </form>

<%@include file="footer.jsp"%>