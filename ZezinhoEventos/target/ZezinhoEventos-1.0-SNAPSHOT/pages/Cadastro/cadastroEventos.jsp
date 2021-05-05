<%-- 
    Document   : cadastroEventos
    Created on : 1 de mai. de 2021, 00:23:03
    Author     : Leonardo
--%>

<form action="control?ac=clienteCad" method="POST">



    <div class="Evento">
        <label for="Evento" class="form-label">Nome</label>
        <input required type="text" class="form-control" id="nomeEvento" name="cpNomeEvento">

    <div class="Evento">                 
        <label for="Evento "> Espaço </label> 
        <select name="cpSearchEspaco"  class="form-control">  
            <<option value="salao"> Salão </option>
            <<option value="anfiteatro"> Anfiteatro </option>
        </select>
        
        <input type="radio" id="capacidadeNormal" name="CpCapacidade" value="normal">
        <label for="Capacidadenormal"> Capacidade Normal </label><br>
        <input type="radio" id="female" name="cpCapacidade" value="reduzida">
        <label for="Capacidadereduzida">Capacidade Reduzida</label><br>
        
        <div class="Evento">                 
        <label for="Evento "> Tipo de Evento </label> 
        <select name="cpSearchEvento"  class="form-control">  
            <option value="palestra"> Palestra </option>
            <option value="show"> Show </option>
            <option value="curso"> Curso </option>
            <option value="festa"> Festa </option>
        </select>


        <div class = "text-center">
            <button type="submit" class="btn btn-primary bg-dark">Cadastrar</button>
            </form>