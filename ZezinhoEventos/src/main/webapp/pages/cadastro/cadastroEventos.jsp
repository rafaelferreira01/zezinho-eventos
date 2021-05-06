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

    <input type="hidden" name="cpId" value="${requestScope.evento.idEvento}" />
    <input type="hidden" name="cpCustoExtra" value="${requestScope.evento.custoExtra}" />
    
    
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
        <input required="" type="date" class="form-control" id="dataEvento" name="cpDataEvento"
             value="${requestScope.time.dataAmericana()}"  >
    </div>
    
        
    <div class="Evento">                 
        <label for="Evento "> Espaço </label> 
        <select name="cpSearchEspaco" id="cpEspacoEvento" class="form-control" >  
            <c:forEach items="${requestScope.espacos}" var="e">
                <option value="${e.idespaco}">${e.descricaoEspaco}</option>                                   
            </c:forEach>  
        </select><br>
        
        
        <div class="form-check">
            <label class="form-check-label" for="flexCheckDefault">
                <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" id="capacidadeReduzida" name="CpCapacidadeReduzida" >
                Capacidade Reduzida
            </label>
        </div>
        
        <div class="Evento" id="custoInicial"><br>
            <label for="custoInicial" class="form-label">Custo Inicial</label>
            <input required type="number" class="form-control" name="cpCustoInicial">
        </div>
        
        
        <div class="Evento" id="valorCadeira"><br>
            <label for="valorCadeira" class="form-label">Valor Cadeira</label>
            <input required type="number" class="form-control" name="cpValorCadeira">
        </div>
        
        <div class="Evento" id="valorVagaEspecial" >
            <label for="valorVagaEspecial" class="form-label">Valor Vaga Especial</label>
            <input required type="number" class="form-control" name="cpVagaEspecial">
        </div>
        
        <div class="Evento" id="valorCabine">
            <label for="valorCabine" class="form-label">Valor Cabine</label>
            <input required type="number" class="form-control" name="cpValorCabine">
        </div><br>
        
        <div class="Evento" id="valorVagaSalao">
            <label for="valorVagaSalao" class="form-label">Valor Vaga Salão</label>
            <input required type="number" class="form-control"  name="cpValorVagaSalao">
        </div><br>
        
        

        <div class = "text-center">
            <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
            </form>
    
<!--    <script>
        
        console.log($("#cpEspacoEvento").val());
        
    </script>-->
    
    
            <script>
                $(function() {
                  $("#cpEspacoEvento").change(function() {
//                    if ($("#salao").is(":selected")) {
                    if ($(this).val() == '1') {
                      $("#valorVagaSalao").show();
                      $("#valorCabine").hide();
                      $("#valorCabine").val(0)
                      $("#valorVagaEspecial").hide();
                      $("#valorVagaEspecial").val(0)
                      $("#valorCadeira").hide();
                      $("#valorCadeira").val(0)
                    } else {
                      $("#valorVagaSalao").hide();
                      $("#valorVagaSalao").val(0)
                      $("#valorCabine").show();
                      $("#valorVagaEspecial").show();
                      $("#valorCadeira").show();
                    }
                  }).trigger('change');
                });
            </script>
            
            
            <!--$("#qJogador").html($(e.currentTarget).data("jogador"));-->