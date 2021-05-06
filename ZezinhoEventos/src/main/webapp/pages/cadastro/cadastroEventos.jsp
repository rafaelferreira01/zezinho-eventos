<%-- 
    Document   : cadastroEventos
    Created on : 1 de mai. de 2021, 00:23:03
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="model.evento.Evento"%>
<%@page import="model.evento.TipoEvento"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="control?ac=clienteCad" method="POST">

    <input type="hidden" name="cpId" value="${requestScope.evento.idevento}" />
    
    
    <div class="Evento">
        <label for="Evento" class="form-label">Nome</label>
        <input required type="text" class="form-control" id="nomeEvento" name="cpNomeEvento">
    </div><br>
    
    <div class="Evento">                 
        <label for="Evento "> Tipo de Evento </label> 
        <select name="cpSearchEvento"  class="form-control">  
            <c:forEach items="${requestScope.tipoEventos}" var="te">
                <option value="${te.idTipoEvento}">${te.descricaoTipoEvento}</option>                                   
            </c:forEach>  
        </select>        
    </div><br>
    
    <div class="mb-3">
        <label for="dataEvento" class="form-label">Data do evento</label>
        <input required="" type="date" class="form-control" id="dataEve" name="cpDataEvento"
             value="${requestScope.time.dataAmericana()}"  >
    </div>
    
        
    <div class="Evento">                 
        <label for="Evento "> Espaço </label> 
        <select name="cpSearchEspaco"  class="form-control">  
            <c:forEach items="${requestScope.espacos}" var="e">
                <option value="${e.idespaco}">${e.descricaoEspaco}</option>                                   
            </c:forEach>  
        </select><br>
        
        
        <div class="form-check">
            <label class="form-check-label" for="flexCheckDefault">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" id="capacidadeNormal" name="CpCapacidade" >
                Capacidade Reduzida
            </label>
        </div><br>

       
        
        


        <div class = "text-center">
            <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
            </form>