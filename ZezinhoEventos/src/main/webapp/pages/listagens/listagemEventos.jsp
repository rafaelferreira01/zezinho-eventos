<%-- 
    Document   : listagemEventos
    Created on : 1 de mai. de 2021, 01:29:22
    Author     : Leonardo
--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped">
    
    <c:if test="${requestScope.msg != null}">
    
<div class="alert alert-success">
    ${requestScope.msg}
</div>
    
</c:if>

    <fieldset>
        <legend>Pesquisar</legend>
        <form action="control" method="POST" > 
            <input type="hidden" name="ac" value="listaEventos" />

            <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="listagemEventos">Nome do Evento:</label>
                        <input  type="text" name="cpSearchNomeEvento" class="form-control"
                                placeholder="Nome do Evento"/>  
                    </div> 
                    <div class="row">
                        <div class="col">                  
                            <div class="form-group">                 
                                <label for="Evento "> Espaço </label> 
                                <select name="cpEspacoEvento" id="cpEspacoEvento" class="form-control" >  
                                    <c:forEach items="${requestScope.espacos}" var="e">
                                        <option value="${e.idTipoEspaco}">${e.descricaoEspaco}</option>                                   
                                    </c:forEach>  
                                </select>
                            </div> 

                            <div class="row">
                                <div class="col">     
                                    <div class="form-group">                 
                                        <label for="cpTipoEvento "> Tipo de Evento </label> 
                                        <select name="cpTipoEvento"  class="form-control">  
                                            <option value="-1"> Todos os tipos </option>
                                            <c:forEach items="${requestScope.tipoEventos}" var="te">
                                                <option value="${te.idTipoEvento}">${te.descricaoTipoEvento}</option>                                   
                                            </c:forEach>  
                                        </select>  
                                    </div>
                                </div>

                                <div class="col"> 

                                    <div class="form-group">                 
                                        <label for="time" name="cpdata" value="cpDATA">Data do evento: </label> 
                                        <input type="date" name="cpDataInicio" value="Inicio" class="form-control"/>  
                                        até <input type="date" name="cpDataFim" value="Fim" class="form-control"/>  
                                    </div>
                                </div>
                            </div>

                            <div class="form-group">               
                                <button type="submit" class="btn btn-primary" >Pesquisar</button>
                            </div>


                            </form>

                            </fieldset>

                            <thead>
                                <tr>
                                    <th>Nome do Evento</th>
                                    <th>Data</th>
                                    <th>Ação</th>

                                </tr>
                            </thead>
                            <tbody>

                                <c:if test="${requestScope.eventos.size() == 0}">
                                    <tr>
                                        <td class="text-center" colspan="3"> 0 eventos criados.</td>
                                    </tr> 
                                </c:if>

                                <c:forEach var="e" items="${requestScope.eventos}">
                                    <tr>
                                        <td><a href="control?ac=venderIngresso&id=${e.idEvento}">${e.nomeEvento}</td>
                                        <td>${e.dataEvento}</td>
                                        <td>A X</td>
                                    </tr>
                                </c:forEach>       
                            </tbody>


                            </table>

