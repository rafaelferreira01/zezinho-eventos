<%-- 
    Document   : relatorio
    Created on : 1 de mai. de 2021, 02:44:49
    Author     : Leonardo
--%>

<%-- 
    Document   : listagemEventos
    Created on : 1 de mai. de 2021, 01:29:22
    Author     : Leonardo
--%>

<table class="table table-striped">

    <fieldset>
        <legend>Pesquisar</legend>
        <form action="control" method="POST" > 
            <input type="hidden" name="ac" value="relatorio" />

    
                    <div class="row">
                        <div class="col">                  
                            <div class="form-group">                 
                                <label for="listagemEventos"> Espa�o: </label>
                                <select name="cpTipoListagemEspaco" value="tipoEventos" class="form-control">  
                                    <option value="-1"> Todos os Espa�os </option>
                                    <option value="-1"> Sal�o </option>
                                    <option value="2"> Anfiteatro </option>
                                </select>


                            </div> 
                            <div class="row">
                                <div class="col">     
                                    <div class="form-group">                 
                                        <label for="Cliente">Tipos de Eventos:</label> 
                                        <select name="cpTipoListagemEventos" value="tipoEventos" class="form-control">  
                                            <option value="-1"> Todos os tipos </option>
                                            <option value=" 1"> Palestra </option>
                                            <option value="2"> Show </option>
                                            <option value="3"> Curso </option>
                                            <option value="4"> Festa </option>

                                        </select>
                                    </div>
                                </div>

                                <div class="col"> 

                                    <div class="form-group">                 
                                        <label for="time" name="cpdata" value="cpDATA">Data do evento: </label> 
                                        <input type="date" name="cpdata1" value="Inicio" class="form-control"/>  
                                        at� <input type="date" name="cpdata2" value="Fim" class="form-control"/>  

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
                                    <th>Espa�o</th>
                                    <th>Tipo</th>
                                    <th>Ganhos</th>
                                    <th>Despesas</th>
                                    <th>A��o</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td> Sal�o </td>
                                    <td> Show </td>
                                    <td> 8000 </td>
                                    <td> 3000 </td>
                                    <td> A X </td>
                                </tr>