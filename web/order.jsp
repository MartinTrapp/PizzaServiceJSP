<!-- Kundendatenformular -->

<%@include file="header.jsp"%>

<!-- Bean mit Kundendaten für die input values sowie Error Hashmap für Fehlerausgabe 
     als Request-Attribute aus app.controller.Ordercontroller verfügbar -->

<jsp:useBean id="customer" class="app.beans.Costumer" scope="request"/>

<form method="POST" action="order">
    <table width="100%" border="0" cellspacing="1" cellpadding="3">
        <tr>
            <td width="15%">Anrede</td>
            <td width="85%"><input type="text" name="title" value="${customer.title}" size="30"/></td>
        </tr>
        <tr>
            <td width="15%">Vorname*</td>
            <td width="85%">
                <input type="text" name="firstName" value="${customer.firstName}" size="30"/>
                <c:out value="${customer.errors['firstName']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">Nachname*</td>
            <td width="85%">
                <input type="text" name="lastName" value="${customer.lastName}" size="30"/>
                <c:out value="${customer.errors['lastName']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">Strasse*</td>
            <td width="85%">
                <input type="text" name="street" value="${customer.street}" size="30"/>
                <c:out value="${customer.errors['street']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">Hausnummer*</td>
            <td width="85%">
                <input type="text" name="number" value="${customer.number}" size="30"/>
                <c:out value="${customer.errors['number']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">PLZ*</td>
            <td width="85%">
<!-- value für (int)zip wenn 0 => leerer String zurück -->                
                <input type="text" name="zip" value="${customer.zip == 0? "":costumer.zip}" size="30"/>
                <c:out value="${customer.errors['zip']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">Stadt*</td>
            <td width="85%">
                <input type="text" name="town" value="${customer.town}" size="30"/>
                <c:out value="${customer.errors['town']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">Telefon*</td>
            <td width="85%">
                <input type="text" name="tel" value="${customer.tel}" size="30"/>
                <c:out value="${customer.errors['tel']}"/>
            </td>
        </tr>
        <tr>
            <td width="15%">Sonstiger Wunsch</td>
            <td width="85%">
                <textarea name="wish" cols="25" rows="5">
                    <c:out value="${customer.wish}"/>
                </textarea>
            </td>
        </tr>   
        <tr>
            <td colspan="2"><input type="submit" name="send" value="Abschicken" /></td>
        </tr>
     </table>
  </form>

<%@include file="footer.jsp"%>