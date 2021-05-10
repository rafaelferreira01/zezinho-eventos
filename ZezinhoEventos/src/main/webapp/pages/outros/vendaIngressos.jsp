<%-- 
    Document   : compraIngressos
    Created on : 7 de mai. de 2021, 02:06:00
    Author     : Leonardo
--%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<H1> ${requestScope.evento.nomeEvento} [${requestScope.evento.tipoevento.descricaoTipoEvento}]</HI><br>
${requestScope.espaco.tipoespaco.descricaoEspaco} - 
<fmt:formatDate value="${requestScope.evento.dataEvento}" pattern="dd/MM/yyyy" />

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
    
    <div class="form-group">                 
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

                <div class="Assento" id="vagaCadeira">                 
                    <label for="Assento "> Cadeira -
                        ${requestScope.espaco.quantcadeira-requestScope.cadeirasDisponivels.size()}/${requestScope.espaco.quantcadeira}
                        | R$${requestScope.espaco.valorCadeira} </label> 
                    <select name="cpCadeiras" id="cpCadeiras" class="form-control">  
                        <option value="-1">Não comprar</option>   
                        <c:forEach items="${requestScope.cadeirasDisponivels}" var="cd">
                            <option value="${cd.descricao}">${cd.descricao}</option>                                   
                        </c:forEach>  
                    </select>        
                </div><br>


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
                        | R$${requestScope.espaco.valorVagaEspecial} </label> 
                    <select name="cpVagaEspecial" id="cpVagaEspecial" class="form-control"> 
                        <option value="-1">Não comprar</option>   
                        <c:forEach items="${requestScope.vagasEspeciaisDisponivels}" var="ve">
                            <option value="${ve.descricao}">${ve.descricao}</option>                                   
                        </c:forEach>  
                    </select>        
                </div><br>

            </c:when>
            <c:otherwise><!-- CASO CONTRARIO -->

                <div class="Assento" id="vagaSalao">                 
                    <label for="Assento "> Vaga Salão - 
                        ${requestScope.espaco.quantvagasalao-requestScope.vagasSalaoDisponivels.size()}/${requestScope.espaco.quantvagasalao}
                        | R$${requestScope.espaco.valorVagaSalao} </label> 
                    <span name="cpVagaSalao" id="cpVagaSalao"></span>
<!--                    <select name="cpVagaSalao" id="cpVagaSalao" class="form-control">  
                        <option value="-1">Não comprar</option>   
                        <c:forEach items="${requestScope.vagasSalaoDisponivels}" var="vs">
                            <option value="${vs.descricao}">${vs.descricao}</option>                                   
                        </c:forEach>  
                    </select>        -->
                </div><br>
            </c:otherwise>
        </c:choose>


        <div class = "text-center">
            <button type="submit" class="btn btn-primary bg-dark">Comprar</button>
        </div>
</form>

<style>

    label {

        font-size: 25px;

    }