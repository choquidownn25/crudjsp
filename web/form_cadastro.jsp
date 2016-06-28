<%-- Document   : form_cadastro
     Author     : Wesley --%>

<%@page contentType="text/html" pageEncoding="ISO-8859-9"%><%--Se pageEncoding estive UTF mude--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crear nuevo cliente</title>
    </head>
    <body>
        <h1>Crear nuevo cliente</h1>
        <hr>
        <strong>Formulario de registro de clientes.</strong><br/>
        <br/>
        Rellene todos los campos!<br/>
        
        <form action="cadastrar.jsp" method="post">
            Nombre: <input type="text" name="cpNome" id="cpNome" value="" /> <br/>
            Email: <input type="text" name="cpEmail" id="cpEmail" value="" /> <br/>
            Telefono: <input type="text" name="cpTel" id="cpTel" value="" />(XX44445555)<br/>
            Sexo: <input type="radio" name="cpSexo" id="cpSexoM" value="M"> Masculino
                  <input type="radio" name="cpSexo" id="cpSexoF" value="F"> Femenino <br/>
            Datos de Nacimiento: <input type="text" name="cpDataNasc" id="cpDataNasc" value="" />(dd/mm/yyyy) <br/>
            <br/>
            <input type="submit" value="Registrar de cliente"/>  <input type="reset" value="Limpar campos"/>
        </form>
        <br/>
        <br/>
        <a href="index.jsp">Volver a Pagina Inicial</a> <br/> 
    </body>
</html>