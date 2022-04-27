<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
</head>
<body style="background-color: #F8C5BA;">
	<center>
		<h1>Introduce tus credenciales</h1>
		<form action="Login" method="post">
			Usuario: <input type="text" name="usuario" required /> <br> <br>
			Contraseña: <input type="password" name="password" required /> <br>
			<br> <input type="submit" value="Entrar" />
		</form>
	</center>
</body>
</html>