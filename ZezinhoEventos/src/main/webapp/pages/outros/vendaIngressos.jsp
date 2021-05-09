<%-- 
    Document   : compraIngressos
    Created on : 7 de mai. de 2021, 02:06:00
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1> COMPRANDO INGRESSOS AQUI </HI>

<div class="form-group">                 
    <label for="Cliente">Clientes:</label> 
    <select name="cpSearchClientes" value="Clientes" class="form-control">  
        <c:forEach items="${requestScope.clientes}" var="c">
            <option value="${c.cpf}">${c.nome}</option>
        </c:forEach> 
    </select>
</div>
</div>