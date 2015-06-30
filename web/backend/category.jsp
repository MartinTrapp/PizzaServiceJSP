<!-- Auflistung aller Kategorien mit möglichkeit diese zu bearbeiten und löschen -->

<%@include file="header.jsp"%>

<sql:query dataSource="${SQLCon}" var="result">
    SELECT ID, name FROM `category`
</sql:query>

<a href="newCategory.jsp">Neue Kategorie hinzuf&uuml;gen</a>
<table width="100%" border="0" cellspacing="1" cellpadding="3">
    <c:forEach var="row" items="${result.rows}" varStatus="i">
        <tr>
            <td width="15%">${row.name}</td>
            <td width="5%"><a href="editCategory.jsp?ID=${row.ID}"> edit</a></td>
            <td align="left"><a href="CatControl?del=${row.ID}"> delete</a></td>
          </tr>          
    </c:forEach>
</table>          

<%@include file="footer.jsp"%>
