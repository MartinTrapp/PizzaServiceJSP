<!-- bearbeiten einer Kategorie -->

<%@include file="header.jsp"%>

<sql:query dataSource="${SQLCon}" var="c">
    SELECT * FROM `category`
    WHERE ID = ${param.ID}
</sql:query>
<c:set var="cat" value="${c.rows[0]}"/>


<h1>Produktkategorie &auml;ndern</h1>

<form method="post" action="CatControl">
    <table width="100%" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="15%"><b>Name der Kategorie</b></td>
        <td width="85%"><input type="text" name="name" value="${cat.name}" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Sequenznummer</b></td>
        <td width="85%"><input type="text" name="seqNr" value="${cat.seqNr}" size="5" /></td>
      </tr>
      <tr>
        <td>
            <input type="hidden" name="ID" value="${cat.ID}" />
            <input type="submit" name="edit" value="Kategorie &auml;ndern" />
        </td>
      </tr>
    </table>
</form>

<%@include file="footer.jsp"%>