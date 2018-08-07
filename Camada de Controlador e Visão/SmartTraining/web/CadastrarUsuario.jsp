<!DOCTYPE html>
<html>
<head>
	<title>SmartTraining - Cadastrar</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
	
</head>
<body>
	<div class="container">
            <br>
            <h2>SmartTraining - Cadastrar</h2>
            <br>
            <form action="ServletWeb" method="post">
                <input type="hidden" name="acao" value="CadastrarAluno">

                <label for="nome">Nome: </label>
                <input type="text" name="nome" class="form-control">
                <br>

                <label for="senha">Senha:</label>
                <input type="password" name="senha" class="form-control">
                <br>

                <label for="senhaRepetida">Repita a senha:</label>
                <input type="password" name="senhaRepetida" class="form-control">
                <br>

                <label for="cpf">CPF: </label>
                <input type="text" name="cpf" maxlength="14" OnKeyPress="formatar('###.###.###-##', this)" class="form-control">
                <br>

                <label for="email">Email: </label>
                <input type="email" name="email" class="form-control">
                <br>

                <label for="datNasc">Data de Nascimento: </label>
                <input type="date" name="datNasc" class="form-control">
                <br>

                Você é um:<br>
                <input type="radio" name="tipoConta" value="instrutor" id="radioInst">Instrutor<br>
                <input type="radio" name="tipoConta" value="aluno" id="radioAl">Aluno<br><br>

                <label for="cref">CREF: </label>
                <input type="text" name="cref" class="form-control" id="cref" disabled>
                <br>

                <input type="submit" name="Cadastrar" class="btn btn-primary" value="Cadastrar">
            </form>
	</div><br>
        
        <a href="LoginUsuario.jsp" class="btn btn-primary">Voltar</a>

	<script>
		let instrutorEl = document.getElementById('radioInst');
		let alunoEl = document.getElementById('radioAl');
		instrutorEl.addEventListener('click', isInstrutor);
		alunoEl.addEventListener('click', isInstrutor);

		function formatar(mascara, documento){
		  var i = documento.value.length;
		  var saida = mascara.substring(0,1);
		  var texto = mascara.substring(i)
		  
		  if (texto.substring(0,1) != saida){
		            documento.value += texto.substring(0,1);
		  }
		  
		}

		function isInstrutor(){
			if(instrutorEl.checked){
				document.getElementById('cref').removeAttribute("disabled","");
			}else{
				document.getElementById('cref').setAttribute("disabled","");
			}
		}
	</script>
</body>
</html>