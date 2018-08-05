<%-- 
    Document   : MostrarUsuario
    Created on : 05/08/2018, 19:57:38
    Author     : mathe
--%>

<%@page import="br.cefetmg.inf.model.domain.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
        <title>Avaliação</title>
    </head>
    <body>
        <div class="container">
            <br>
            <%
                Usuario usuario = (Usuario) request.getAttribute("usuario");
            %>
            
            Nome: <%= usuario.getNomUsuario() %><br>
            Email: <%= usuario.getDesEmail()%><br>
            Data de nascimento: <%= usuario.getDatNascimento()%><br>
            
            <%  
            String tipoUsuario;
            switch(usuario.getIdtTipoUsuario()){
                case 'a':
                    tipoUsuario = "Aluno";
                    break;
                case 'i':
                    tipoUsuario = "Instrutor";
                    break;
                default:
                    tipoUsuario = "Coordenador";
            }
            %>
            
            Função: <%= tipoUsuario%>
            
            <form action="ListaUsuarios.jsp">
                <input type="submit" name="Voltar" value="Voltar">
            </form>
        </div>
    </body>
</html>
