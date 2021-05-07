<%-- 
    Document   : listagemEventos
    Created on : 1 de mai. de 2021, 01:29:22
    Author     : Leonardo
--%>


<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="table table-striped">

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
                                <label for="listagemEventos"> Espaço: </label>
                                <select name="cpTipoListagemEspaco" value="tipoEventos" class="form-control">  
                                    <option value="-1"> Todos os Espaços </option>
                                    <option value="-1"> Salão </option>
                                    <option value="2"> Anfiteatro </option>
                                </select>


                            </div> 
                            <div class="row">
                                <div class="col">     
                                    <div class="form-group">                 
                                        <label for="Cliente">Tipos de Eventos:</label> 
                                        <select name="cpTipoListagemEventos" value="tipoEventos" class="form-control">  
                                            <option value="-1"> Todos os tipos </option>
                                            <option value=" 1"> Palestra </option>
                                            <option value="2"> Show </option>
                                            <option value="3"> Curso </option>
                                            <option value="4"> Festa </option>

                                        </select>
                                    </div>
                                </div>

                                <div class="col"> 

                                    <div class="form-group">                 
                                        <label for="time" name="cpdata" value="cpDATA">Data do evento: </label> 
                                        <input type="date" name="cpdata1" value="Inicio" class="form-control"/>  
                                        até <input type="date" name="cpdata2" value="Fim" class="form-control"/>  

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
                <td> <a href="control?ac=comprarIngresso">
                    ${e.nomeEvento}
                </td>
                <td>${e.dataEvento}</td>
                <td>A X</td>
             </tr>

        </c:forEach>       
             
         



    </tbody>


</table>

