<%-- 
    Document   : listagemClientes
    Created on : 1 de mai. de 2021, 01:01:55
    Author     : Leonardo
--%>

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
                            <tr>
                                <td> Zezinho </td>
                                <td> 0940341492409 </td>
                                <td> Eventos X <td>
                                <td> A X <td>
                            </tr>

