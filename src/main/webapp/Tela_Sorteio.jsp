<%@page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="pt-br">


<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
    crossorigin="anonymous"></script>
  <meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="style.css">
  <link rel="icon" href="fogueira.png">
  <title>Novo Participante</title>


</head>

<body style="overflow: hidden; background-image: url(sorteio.png);">
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

  <div id="teste">
  </div>
  <form>
      <%int numeroParticipantes = (int)request.getParameter("numeroParticipantes")%>
  <p>Temos até o momento <%=numeroParticipantes %> de participantes no sorteio!</p>
   
    <a href="/SorteioBeca/realizarSorteio"><button type="button" class="btn btn-success botaoEnviar"
                                                   >SORTEAR</button></a>
  </form>

</body>

</html>