<%-- 
    Document   : listagemClientes
    Created on : 1 de mai. de 2021, 01:01:55
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1>Listagem de Clientes</h1>

<table class="table table-striped">

    <fieldset>
        <legend>Pesquisar</legend>
        <form action="control" method="POST" > 
            <input type="hidden" name="ac" value="listaClientes" />

            <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="Cliente">Nome do Cliente:</label>


                        <input  type="text" name="cpSearchNomeCliente" class="form-control"
                                placeholder="Nome"/>  
                    </div> 


                    <div class="row">
                        <div class="col">                  
                            <div class="form-group">                 
                                <label for="Cliente">CPF:</label>
                                <input  type="text" name="cpSearchCPF" class="form-control"
                                        placeholder="CPF"/>  
                            </div> 
                        </div> 
                    </div>
                    <div class="row">
                        <div class="form-group">  
                            <div>
                                <button type="submit" class="btn btn-primary" >Pesquisar</button>
                            </div>
                        </div>
                    </div>


                        </form>

                        </fieldset>

                        <thead>
                            <tr>
                                <th>Nome do Cliente</th>
                                <th>CPF</th>
                                <th>Ação</th>
                            </tr>
                        </thead>
                        <tbody>

        <c:if test="${requestScope.clientes.size() == 0}">
            <tr>
                <td class="text-center" colspan="4"> 0 clientes cadastrados.</td>
            </tr> 
        </c:if>

            <c:forEach var="cliente" items="${requestScope.clientes}">

            <tr>
                <td>${cliente.nome}</td>
                <td>${cliente.cpf}</td>
                <td> 
                    <a href="control?ac=editCliente&cpf=${cliente.cpf}"><span> <i class="fa fa-edit"></i></span></a>
                    <a href="#" class="btnExc" data-toggle="modal" data-target="#questionModal" data-cliente="${cliente.nome}" data-cpf="${cliente.cpf}">
                    <i class="fa fa-trash"></i>
                   </a>
                     
          

            </tr>

        </c:forEach>          




    </tbody>


</table>

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
          Deseja excluir o cliente <span id="qCliente" class="font-weight-bold">  </span> ?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal"> Não </button>
        <button id="btnExcluirClick" type="button" class="btn btn-danger"> Sim </button>
      </div>
    </div>
  </div>
</div>

<script>
    
    $(".btnExc").on("click",function(e){
     
         $("#qCliente").html($(e.currentTarget).data("cliente"));
          $("#btnExcluirClick").data("cpf",$(e.currentTarget).data("cpf"))
    });
    
    $("#btnExcluirClick").on("click",function(e){
       
        
      window.location = "control?ac=apgCliente&cpf="+$(e.currentTarget).data("cpf");
    });

</script>


