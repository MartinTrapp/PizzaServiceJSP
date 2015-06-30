<!-- Neue Kategorie hinzufügen -->

<%@include file="header.jsp"%>

<h1>Produkt Kategorie hinzuf&uuml;gen</h1>

<form method="post" action="CatControl">
    <table width="100%" border="0" cellspacing="1" cellpadding="3">
      <tr>
        <td width="15%"><b>Name der Kategorie</b></td>
        <td width="85%"><input type="text" name="name" size="60" /></td>
      </tr>
      <tr>
        <td width="15%"><b>Sequenznummer</b></td>
        <td width="85%"><input type="text" name="seqNr" size="5" /></td>
      </tr>
      <tr>
        <td><input type="submit" name="add" value="Kategorie hinzuf&uuml;gen" /></td>
      </tr>
    </table>
</form>

<%@include file="footer.jsp"%>