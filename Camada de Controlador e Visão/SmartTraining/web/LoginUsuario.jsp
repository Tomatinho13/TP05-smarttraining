<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<br>
		<h2>SmartTraining</h2>
		<br>
                <form action="ServletWeb" method="post">
                    <input type="hidden" name="acao" value="Logar">
			<label for="username" class="form">Nome de usuário: </label>
			<input type="text" name="username" class="form-control">
			<br>

			<label for="senha" class="form">Senha:</label>
			<input type="password" name="senha" class="form-control">
			<br>

			<input type="submit" name="login" class="btn btn-primary" value="Login">
		</form>
                <a href="CadastrarUsuario.jsp" class="btn btn-primary">Cadastrar</a>
	</div>
</body>
</html>