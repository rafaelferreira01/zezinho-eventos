<%-- 
    Document   : cadastroClientes
    Created on : 1 de mai. de 2021, 00:14:42
    Author     : Leonardo
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>${requestScope.titulo}</h1>


<c:if test="${requestScope.msg != null}">
    
<div class="alert alert-success">
    ${requestScope.msg}
</div>
    
</c:if>

<form action="control?ac=clienteCad" method="POST">
     <input type="hidden" name="cpCPF" value="${requestScope.cliente.cpf}" />
 
    
    <div class="cadCliente">
        <label for="Cliente" class="form-label">Nome</label>
        <input required type="text" class="form-control" id="nomeCliente" name="cpNomeCliente"
               value = ${requestScope.cliente.nome}>
             
    </div>
    <div class="cadCliente">
        <label for="Cliente" class="form-label"> CPF </label>
        <input required="" type="number" class="form-control" id="cpfCliente" name="cpCPF"
                value = ${requestScope.cliente.cpf}>
    </div>
    
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
</form>