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
                        <input  type="text" name="cpSearchNomeEvento"  value="${cpSearchNomeEvento}" class="form-control"
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
                                        <input type="date"  value="${cpDataInicio}"  name="cpDataInicio" value="Inicio" class="form-control"/>  
                                        até <input type="date"  value="${cpDataFim}"  name="cpDataFim" value="Fim" class="form-control"/>  
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
                                        <td><a href="control?ac=venderIngresso&id=${e.idEvento}">${e.nomeEvento} </td>
                                        <td> <fmt:formatDate value="${e.dataEvento}"  pattern="dd/MM/yyyy" /> </td>
                                        <td> <a href="control?ac=editEvento&id=${e.idEvento}"><span> <i class="fa fa-edit"></i></span></a>
                                             <a href="#" class="btnExc" data-toggle="modal" data-target="#questionModal" data-evento="${e.nomeEvento}" data-id="${e.idEvento}">
                                         <i class="fa fa-trash"></i>
                   </a>

            </tr>

 </c:forEach>          


    </tbody>


</table>
                        
                        
<!-- Modal -->
<div class="modal fade" id="questionModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header bg-danger">
        <h5 class="modal-title" id="exampleModalLabel">Confirmar exclusão?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
          Confirmar exclusão do evento <span id="qEvento" class="font-weight-bold">  </span>?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"> Não </button>
        <button id="btnExcluir" type="button" class="btn btn-danger"> Sim </button>
      </div>
    </div>
  </div>
</div>

<script>
    
    $(".btnExc").on("click",function(e){
        $("#qEvento").html($(e.currentTarget).data("evento"));
          $("#btnExcluir").data("id",$(e.currentTarget).data("id"))
    });
    
     $("#btnExcluir").on("click",function(e){
        console.log( $(e.currentTarget).data("id"));
        
        window.location = "control?ac=apgEvento&id="+$(e.currentTarget).data("id");
     });

</script>