
<%@page import="br.cefetmg.inf.model.domain.Exercicio"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">

        <title>Remover Exercicio</title>
    </head>
    <body>
        <div class="container">
            <br>
            <h2 class="h2">SmartTraining - Remover Exercicio</h2>
            <form action="ServletWeb" method="post">
                <input type="hidden" name="acao" value="RemoverExercicio">

                <h4>Selecione o exercício que deseja remover:</h4>
                <select>
                    <%
                        Exercicio exercicio = new Exercicio();
                        List<Exercicio> listaExercicios = (List) request.getAttribute("exercicios");
                        for (int i = 0; i < listaExercicios.size(); i++) {
                            exercicio = listaExercicios.get(i);
                    %>

                    <option value=" <%= exercicio.getNomeExercicio()%> "><%= exercicio.getNomeExercicio()%></option>

                    <%
                        }
                    %>
                </select>

                <input type="submit" name="removerExercicio" class="btn btn-primary" value="Remover">
            </form>

            <a class="btn btn-primary" onclick="voltar()">
                Voltar
            </a>

        </div>
        <script>
            function voltar() {
                window.history.back();
            }
        </script>
    </body>
</html>