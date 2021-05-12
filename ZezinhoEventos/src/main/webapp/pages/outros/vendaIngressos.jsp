<%-- 
    Document   : compraIngressos
    Created on : 7 de mai. de 2021, 02:06:00
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1> ${requestScope.evento.nomeEvento} [${requestScope.evento.tipoevento.descricaoTipoEvento}]<br>
${requestScope.espaco.tipoespaco.descricaoEspaco} - 
<fmt:formatDate value="${requestScope.evento.dataEvento}" pattern="dd/MM/yyyy" /></h1>

<c:if test="${requestScope.msg != null}">
    
<div class="alert alert-success">
    ${requestScope.msg}
</div>
    
</c:if>

<!--  <div class="Evento">
        <label for="Evento" class="form-label">Evento Selecionado</label>
        <input required type="text" class="form-control" id="nomeEvento" name="cpNomeEvento"
        value="${requestScope.evento.nomeEvento}">
    </div><br>-->
<form action="control?ac=gravarVendaIngresso" method="POST">
    <input type="hidden" name="cpEventoId" value="${requestScope.evento.idEvento}" />
    <input type="hidden" name="cpEspacoId" value="${requestScope.espaco.idespaco}" />
    
        <label for="Cliente">Cliente</label> 
        <select name="cpSearchClientes" class="form-control">  
            <option value="-1"></option>   
            <c:forEach items="${requestScope.clientes}" var="c">
                <option value="${c.cpf}">${c.nome}</option>
            </c:forEach> 
        </select>

        <br>
        
        
        


        
            
        <c:choose>
            <c:when test="${requestScope.espaco.tipoespaco.idTipoEspaco == '2'}"> <!-- SE FOR ANFITEATRO -->

                <div class="mb-3">               
                    <label for="Assento "> Cadeira -
                        ${requestScope.espaco.quantcadeira-requestScope.cadeirasDisponivels.size()}/${requestScope.espaco.quantcadeira}
                        | R$<span id="valcadeira">${requestScope.espaco.valorCadeira}</span>
                        
                        <c:if test="${requestScope.evento.aceitameiaentrada == true}">
                            <div class="form-check">
                                <label class="form-check-label" for="flexCheckDefault">
                                    <input class="form-check-input" type="checkbox" value="" id="meiaentradaCadeiracheck" name="CpmeiaentradaCadeira" >
                                    Meia Entrada
                                </label>
                            </div>
                            <div class="form-check" id="alimentoCadeira">
                                <label class="form-check-label" for="flexCheckDefault">
                                    <input class="form-check-input" type="checkbox"  value="" id="alimentoCadeiracheck" name="CpalimentoCadeira" >
                                    Doação Alimento
                                </label>
                            </div>
                        </c:if>

                    </label> 
                    <select name="cpCadeiras" id="cpCadeiras" class="form-control">  
                        <option value="-1">Não comprar</option>   
                        <c:forEach items="${requestScope.cadeirasDisponivels}" var="cd">
                            <option value="${cd.descricao}">${cd.descricao}</option>                                   
                        </c:forEach>  
                    </select>        
                </div>

                        
                        
                        
                <div class="Assento" id="vagaCabine">                 
                    <label for="Assento "> Cabine - 
                        ${requestScope.espaco.quantcabine-requestScope.cabinesDisponivels.size()}/${requestScope.espaco.quantcabine}
                        | R$${requestScope.espaco.valorCabine} </label> 
                    <select name="cpCabines" id="cpCabines" class="form-control">
                        <option value="-1">Não comprar</option>   
                        <c:forEach items="${requestScope.cabinesDisponivels}" var="cb">
                            <option value="${cb.descricao}">${cb.descricao}</option>                                   
                        </c:forEach>  
                    </select>        
                </div><br>



                
                <div class="Assento" id="vagaEspecial">                 
                    <label for="Assento "> Vaga Especial - 
                        ${requestScope.espaco.quantvagaespecial-requestScope.vagasEspeciaisDisponivels.size()}/${requestScope.espaco.quantvagaespecial}
                        | R$<span id="valvagaespecial">${requestScope.espaco.valorVagaEspecial}</span>

                        <c:if test="${requestScope.evento.aceitameiaentrada == true}">
                            <div class="form-check">
                                <label class="form-check-label" for="flexCheckDefault">
                                    <input class="form-check-input" type="checkbox" value="" id="meiaentradaVagaEspecialcheck" name="CpmeiaentradaVagaEspecial" >
                                    Meia Entrada
                                </label>
                            </div>
                            <div class="form-check" id="alimentoVagaEspecial">
                                <label class="form-check-label" for="flexCheckDefault">
                                    <input class="form-check-input" type="checkbox" value="" id="alimentoVagaEspecialcheck" name="CpalimentoVagaEspecial" >
                                    Doação Alimento
                                </label>
                            </div>
                        </c:if>

                    </label> 
                    <select name="cpVagaEspecial" id="cpVagaEspecial" class="form-control"> 
                        <option value="-1">Não comprar</option>   
                        <c:forEach items="${requestScope.vagasEspeciaisDisponivels}" var="ve">
                            <option value="${ve.descricao}">${ve.descricao}</option>                                   
                        </c:forEach>  
                    </select>        
                </div><br>
                <input type="hidden" name="cpVagaSalao" value="-1" />

            </c:when>
                
                
                
                
                
            <c:otherwise><!-- CASO CONTRARIO -->
                <input type="hidden" name="cpCadeiras" value="-1" />
                <input type="hidden" name="cpCabines" value="-1" />
                <input type="hidden" name="cpVagaEspecial" value="-1" />
                <div class="Assento" id="vagaSalao">                 
                    <label for="Assento "> Vaga Salão - 
                        ${requestScope.NumeroDeVagasSalaoOcupadas}/${requestScope.espaco.quantvagaSalao}
                        | R$<span id="valvagasalao">${requestScope.espaco.valorVagaSalao}</span>
                    
                    
                    <c:if test="${requestScope.evento.aceitameiaentrada == true}">
                            <div class="form-check">
                                <label class="form-check-label" for="flexCheckDefault">
                                    <input class="form-check-input" type="checkbox" value="" id="meiaentradaVagaSalaocheck" name="CpmeiaentradaVagaSalao" >
                                    Meia Entrada
                                </label>
                            </div>
                            <div class="form-check" id="alimentoVagaSalao">
                                <label class="form-check-label" for="flexCheckDefault">
                                    <input class="form-check-input" type="checkbox" value="" id="alimentoVagaSalaocheck" name="CpalimentoVagaSalao" >
                                    Doação Alimento
                                </label>
                            </div>
                        </c:if>
                        
                        
                    
                    </label>
                         <select name="cpVagaSalao" id="cpVagaSalao" class="form-control">
                             <option value="a">Unico</option>
                         </select>
                    <span name="cpVagaSalao" id="cpVagaSalao"></span>
            </c:otherwise>
        </c:choose>

        <div class = "text-center">
            <button type="submit" class="btn btn-primary bg-dark">Comprar</button>
        </div>
</form>

    <script>
        $(function () {
            //CADEIRA
            $("#alimentoCadeiracheck").change(function () {
                        if ($("#alimentoCadeiracheck").is(":checked")) {
                            $("#valcadeira").text(0);
                } else {
                    $("#valcadeira").text(${requestScope.espaco.valorCadeira}/2);
                }
            }).trigger('change');
            
            $("#meiaentradaCadeiracheck").change(function () {
                        if ($("#meiaentradaCadeiracheck").is(":checked")) {
                            $("#valcadeira").text(${requestScope.espaco.valorCadeira/2});
                    $("#alimentoCadeira").show();
                } else {
                    $("#valcadeira").text(${requestScope.espaco.valorCadeira});
                    $("#alimentoCadeira").hide();
                }
            }).trigger('change');
            
            
            //VAGA ESPECIAL
            $("#alimentoVagaEspecialcheck").change(function () {
                            if ($("#alimentoVagaEspecialcheck").is(":checked")) {
                                $("#valvagaespecial").text(0);
                    } else {
                        $("#valvagaespecial").text(${requestScope.espaco.valorCadeira}/2);
                    }
                }).trigger('change');
                
            $("#meiaentradaVagaEspecialcheck").change(function () {
                        if ($("#meiaentradaVagaEspecialcheck").is(":checked")) {
                             $("#valvagaespecial").text(${requestScope.espaco.valorVagaEspecial/2});
                    $("#alimentoVagaEspecial").show();
                } else {
                    $("#valvagaespecial").text(${requestScope.espaco.valorVagaEspecial});
                    $("#alimentoVagaEspecial").hide();
                }
            }).trigger('change');
        
        
            //VAGA ESPECIAL
            $("#alimentoVagaSalaocheck").change(function () {
                            if ($("#alimentoVagaSalaocheck").is(":checked")) {
                                $("#valvagasalao").text(0);
                    } else {
                        $("#valvagasalao").text(${requestScope.espaco.valorVagaSalao}/2);
                    }
                }).trigger('change');
                
            $("#meiaentradaVagaSalaocheck").change(function () {
                        if ($("#meiaentradaVagaSalaocheck").is(":checked")) {
                             $("#valvagasalao").text(${requestScope.espaco.valorVagaSalao/2});
                    $("#alimentoVagaSalao").show();
                } else {
                    $("#valvagasalao").text(${requestScope.espaco.valorVagaSalao});
                    $("#alimentoVagaSalao").hide();
                }
            }).trigger('change');
        });
    </script>
