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
            
            <p>Nome: <%= usuario.getNomUsuario() %></p><br>
            <p>Email: <%= usuario.getDesEmail()%></p><br>
            <p>Data de nascimento: <%= usuario.getDatNascimento()%></p><br>
            
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
            
            <p>Função: <%= tipoUsuario%></p><br>
            
            <a href="ListaUsuarios.jsp" class="btn btn-primary">Voltar</a>
        </div>
    </body>
</html>
