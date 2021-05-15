<%-- 
    Document   : relatorio
    Created on : 1 de mai. de 2021, 02:44:49
    Author     : Leonardo
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<table class="table table-striped">

    <fieldset>
        <legend>Pesquisar</legend>
        <form action="control" method="POST" > 
            <input type="hidden" name="ac" value="relatorio" />

    
                    <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="listagemEventos">Nome do Evento:</label>
                        <input  type="text" name="cpSearchNomeEvento" value="${cpSearchNomeEvento}" class="form-control"
                                placeholder="Nome do Evento"/>  
                    </div> 
                    <div class="row">
                        <div class="col">                  
                            <div class="form-group">                 
                                <label for="Evento "> Espaço </label> 
                                <select name="cpEspacoEvento" id="cpEspacoEvento" class="form-control" > 
                                    <option value="-1"> Todos Espaços </option>
                                    <c:forEach items="${requestScope.espacos}" var="e">
                                        <option value="${e.idTipoEspaco}"
                                                <c:if test="${e.idTipoEspaco == requestScope.cpEspacoEvento}">
                                                    selected
                                                </c:if>
                                                >${e.descricaoEspaco}</option>                                   
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
                                                <option value="${te.idTipoEvento}"
                                                        <c:if test="${te.idTipoEvento == requestScope.cpTipoEvento}">
                                                            selected
                                                        </c:if>
                                                        >${te.descricaoTipoEvento}</option>                                   
                                            </c:forEach>  
                                        </select>  
                                    </div>
                                </div>

                                <div class="col"> 

                                    <div class="form-group">                 
                                        <label for="time" name="cpdata" value="cpDATA">Data do evento: </label> 
                                        <input type="date"  value="${cpDataInicio}"  name="cpDataInicio" class="form-control"/>  
                                        até <input type="date"  value="${cpDataFim}"  name="cpDataFim" class="form-control"/>  
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
                                    <th>Evento</th>
                                    <th>Custos</th>
                                    <th>Receitas</th>
                                    <th>Balanço</th>
                                </tr>
                            </thead>
                            <tbody>
                                <%--<c:forEach items="${requestScope.listaEventos}" var="re">--%>
                                <%--<c:forEach items="${requestScope.lucroTotalCadeiras}" var="c" varStatus="">--%>
                                <c:forEach items="${requestScope.listaEventos}" var="evento" varStatus="corre">
                                    <tr>
                                        <td>${evento.nomeEvento}</td>
                                        <td>${requestScope.custoEventos[corre.index]}</td>
                                        <td>${requestScope.lucroIngressos[corre.index]}</td>
                                        <td id="balanco">${requestScope.lucroIngressos[corre.index] - requestScope.custoEventos[corre.index]}</td>
                                    </tr>
                                    </tr>
                                </c:forEach>

                                    