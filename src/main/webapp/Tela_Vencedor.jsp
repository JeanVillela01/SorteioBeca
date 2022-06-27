<%--
  Created by IntelliJ IDEA.
  User: Guilh
  Date: 24/06/2022
  Time: 10:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">


<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
            crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/8e5cd4c014.js" crossorigin="anonymous"></script>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="style.css">
    <link rel="icon" href="fogueira.png">
    <script src="script.js"></script>
    <title>Novo Participante</title>


</head>

<body style="overflow: hidden; background-image: url(vencedor.png);">
<div class="pyro">
    <div class="before"></div>
    <div class="after"></div>
</div>


<div class="btn-group">
    <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown"
            aria-expanded="false">
        Menu
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <li><a class="dropdown-item" href="/SorteioBeca/">Sorteio</a></li>
        <li><a class="dropdown-item" href="ListaParticipantes">Lista de Participantes</a></li>
        <li><a class="dropdown-item" href="Tela_Forms">Adicionar Participantes</a></li>
    </ul>
</div>

<div class="form2">
    <%
        String nomeDoVencedor = (String) request.getAttribute("nomeSorteado");
    %>
    <h1><%= nomeDoVencedor%></h1>
</div>

<div class="form">
    <form action="/SorteioBeca/" method="post">
    <input type="submit" name= "botaoConfirmar"  class="botaoBack" value="CONFIRMAR" >
        <i class="fa-solid fa-check" ></i> </input>

     <input type="submit" value="Sortear"  name="botaoRefazer" class="botaoBack2" >
        SORTEAR <i class="fa-solid fa-arrow-rotate-left"> </i></input>
    </form>
</div>

</body>




<script>
    function teste(){
        document.forms[0].acao.value="teste";
        document.forms[0].action="pagina.jsp";
        document.forms[0].submit();

    }
</script>
</html>
