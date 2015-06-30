<!-- Navigationspunkte ergeben sich aus der Summe der abgefragen Kategorien -->

<sql:query dataSource="${SQLCon}" var="result">
    SELECT ID,name from category
    ORDER BY seqNr DESC;
</sql:query>

<li>
    <c:forEach var="row" items="${result.rows}">
        <ul>
            <p>
                <a class="navilink" href="products.jsp?cat=${row.ID}">${row.name}</a>
            </p>
        </ul>               
    </c:forEach>
</li>                

