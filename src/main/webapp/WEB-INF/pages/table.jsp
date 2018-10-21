<%--
  Created by IntelliJ IDEA.
  User: vitalii_zhuk
  Date: 21.10.18
  Time: 17:34
  To change this template use File | Settings | File Templates.
--%>
<div class="col-md-12 " id="main-table">
    <table class="table table-hover">
        <thead>
        <tr>
            <th>#</th>
            <th>TEXT</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${elements}" var="element" >
            <tr class="table-element" onclick = "activateElement('${element.id}','${element.text}','${element.orderNo}')">
                <th class="table-element-id" scope="row">${elements.indexOf(element)+1}</th>
                <td class="table-element-text">${element.text}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
