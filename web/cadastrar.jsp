<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="fac" class="facade.FormFacade"/>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmación de Registro</title>
    </head>
    <body>
        <h1>Descripcion de Resultados</h1>
        <hr>
        <h2><%=fac.salvarCliente(request)%></h2>
        <br>
        <br>
        [<a href="formulario.jsp"> Suscribirse a otro candidato </a>] 
        [<a href="index.jsp">      Volver a la página principal </a>]
    </body>
</html>
