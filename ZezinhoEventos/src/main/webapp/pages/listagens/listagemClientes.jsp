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

                            <div class="form-group">                 
                                <label for="Cliente">Eventos:</label> 
                                <select name="cpSearchEventos" value="Eventos" class="form-control">  
                                    <<option value="-1"> Todos Eventos </option>
                                    <c:forEach items="${requestScope.eventos}" var="e">
                                    <option value="${e.idEvento}">${e.nomeEvento}</option>
                                </c:forEach> 
                                </select>
                            </div>
                        </div>


                        <div class="form-group">               
                            <button type="submit" class="btn btn-primary" >Pesquisar</button>
                        </div>



                        </form>

                        </fieldset>

                        <thead>
                            <tr>
                                <th>Nome do Cliente</th>
                                <th>CPF</th>
                                <th>Evento</th>
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
                <td>${cliente.evento} </td>
                <td> 
                    <a href="control?ac=editCliente&cpf=${cliente.cpf}"><span> <i class="fa fa-edit"></i></span></a>
                    <a href="#" class="btnExc" data-toggle="modal" data-target="#questionModal" data-time="${t.nome}" data-id="${t.idtime}">
                    <i class="fa fa-trash"></i>
                   </a>
                     
          

            </tr>

        </c:forEach>          




    </tbody>


</table>

