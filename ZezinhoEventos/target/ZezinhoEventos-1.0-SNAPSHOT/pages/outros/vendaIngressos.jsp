<%-- 
    Document   : vendaIngressos
    Created on : 1 de mai. de 2021, 17:29:47
    Author     : Leonardo
--%>

<form action="control?ac=ingressoVenda" method="POST">
   
     
    
    <div class="ingressoVenda">
        <label for="Cliente" class="form-label">Nome</label>
        <input required type="text" class="form-control" id="nomeCliente" name="cpNomeCliente">
             
    </div>
    <div class="ingressoVenda">
        <label for="Cliente" class="form-label"> CPF </label>
        <input required="" type="text" class="form-control" id="cpfCliente" name="cpCPF">
    </div>
    
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
</form>