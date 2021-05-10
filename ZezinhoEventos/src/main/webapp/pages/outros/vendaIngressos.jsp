<%-- 
    Document   : compraIngressos
    Created on : 7 de mai. de 2021, 02:06:00
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1> ${requestScope.evento.nomeEvento} </HI>


  <div class="Evento">
        <label for="Evento" class="form-label">Evento Selecionado</label>
        <input required type="text" class="form-control" id="nomeEvento" name="cpNomeEvento"
        value="${requestScope.evento.nomeEvento}">
    </div><br>

<div class="form-group">                 
    <label for="Cliente">Clientes:</label> 
    <select name="cpSearchClientes" class="form-control">  
        <c:forEach items="${requestScope.clientes}" var="c">
            <option value="${c.cpf}">${c.nome}</option>
        </c:forEach> 
    </select>

    <br>

    <div class="Assento">                 
        <label for="Assento "> Cadeira </label> 
        <select name="cpCadeiras" id="cpCadeiras" class="form-control">  
            <c:forEach items="${requestScope.cadeirasDisponivels}" var="cd">
                <option value="${cd.idCadeira}">${cd.descricao}</option>                                   
            </c:forEach>  
        </select>        
    </div><br>


    <div class="Assento">                 
        <label for="Assento "> Cabine </label> 
        <select name="cpCabines" id="cpCabines" class="form-control">  
            <c:forEach items="${requestScope.cabinesDisponivels}" var="cb">
                <option value="${cb.idCabine}">${cb.descricao}</option>                                   
            </c:forEach>  
        </select>        
    </div><br>
    
    <div class="Assento">                 
        <label for="Assento "> Vaga Especial </label> 
        <select name="cpVagaEspecial" id="cpVagaEspecial" class="form-control">  
            <c:forEach items="${requestScope.vagasEspeciaisDisponivels}" var="ve">
                <option value="${ve.idVagaEspecial}">${ve.descricao}</option>                                   
            </c:forEach>  
        </select>        
    </div><br>
    
    <div class="Assento">                 
        <label for="Assento "> Vaga Salão </label> 
        <select name="cpVagaSalao" id="cpVagaSalao" class="form-control">  
            <c:forEach items="${requestScope.vagasSalaoDisponivels}" var="vs">
                <option value="${vs.idVagaSalao}">${vs.descricao}</option>                                   
            </c:forEach>  
        </select>        
    </div><br>
    
    
    
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Comprar</button>
</form>

<style>

label {
  
  font-size: 25px;
  
}



