<%-- 
    Document   : compraIngressos
    Created on : 7 de mai. de 2021, 02:06:00
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1> COMPRANDO INGRESSOS AQUI </HI>


  <div class="Evento">
        <label for="Evento" class="form-label">Evento Selecionado</label>
        <input required type="text" class="form-control" id="nomeEvento" name="cpNomeEvento"
        value="${requestScope.eventosIngresso.nomeEvento}">
    </div><br>

<div class="form-group">                 
    <label for="Cliente">Clientes:</label> 
    <select name="cpSearchClientes" class="form-control">  
        <c:forEach items="${requestScope.clientes}" var="c">
            <option value="${c.cpf}">${c.nome}</option>
        </c:forEach> 
    </select>

    <br>

<div class="form-group">                 
    <label for="Cliente"> Cadeiras</label> 
    <select name="cpSearchClientes" class="form-control">  
     
    </select>


<div class="form-group">                 
    <label for="Cliente"> Vaga Especial</label> 
    <select name="cpSearchClientes" class="form-control">  
      
    </select>


<div class="form-group">                 
    <label for="Cliente"> Cabine </label> 
    <select name="cpSearchClientes" class="form-control">  
        
    </select>

   
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Comprar</button>
</form>

<style>

label {
  
  font-size: 25px;
  
}



