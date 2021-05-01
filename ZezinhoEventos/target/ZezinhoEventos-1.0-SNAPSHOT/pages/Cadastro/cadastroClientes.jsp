<%-- 
    Document   : cadastroClientes
    Created on : 1 de mai. de 2021, 00:14:42
    Author     : Leonardo
--%>

<form action="control?ac=clienteCad" method="POST">
   
     
    
    <div class="cadCliente">
        <label for="Cliente" class="form-label">Nome</label>
        <input required type="text" class="form-control" id="nomeCliente" name="cpNomeCliente">
             
    </div>
    <div class="cadCliente">
        <label for="Cliente" class="form-label"> CPF </label>
        <input required="" type="text" class="form-control" id="cpfCliente" name="cpCPF">
    </div>
    
    <div class = "text-center">
        <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
</form>