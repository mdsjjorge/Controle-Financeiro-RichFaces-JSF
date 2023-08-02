<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Detalhes do Empenho</title>
</head>
<body>
    <h1>Detalhes do Empenho</h1>
    <p><strong>Ano do Empenho:</strong> ${empenho.anoEmpenho}</p>
    <p><strong>Número do Empenho:</strong> ${empenho.numeroEmpenho}</p>
    <p><strong>Data do Empenho:</strong> ${empenho.dataEmpenho}</p>
    <p><strong>Valor do Empenho:</strong> ${empenho.valorEmpenho}</p>
    <p><strong>Observação:</strong> ${empenho.observacao}</p>
    <br />
    <a href="listEmpenhos.jsp">Voltar para a lista de Empenhos</a>
</body>
</html>
