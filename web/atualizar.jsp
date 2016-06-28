<%@page contentType="text/html" pageEncoding="ISO-8859-9"%>
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
        <h2><%=fac.atualizarCliente(request)%></h2>
        <br>
        <br>
        [<a href="index.jsp">      Volver a pagina incial </a>]
    </body>
</html>