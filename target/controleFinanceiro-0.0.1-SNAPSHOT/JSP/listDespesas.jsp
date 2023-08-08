<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Despesas</title>
</head>
<body>
    <h1>Lista de Despesas</h1>
    <table border="1">
        <tr>
            <th>Número de Protocolo</th>
            <th>Tipo de Despesa</th>
            <th>Data do Protocolo</th>
            <th>Data de Vencimento</th>
            <th>Credor da Despesa</th>
            <th>Descrição da Despesa</th>
            <th>Valor da Despesa</th>
            <th>Ações</th>
        </tr>
        <c:forEach items="${despesas}" var="despesa">
            <tr>
                <td>${despesa.numeroProtocolo}</td>
                <td>${despesa.tipoDespesa}</td>
                <td>${despesa.dataProtocolo}</td>
                <td>${despesa.dataVencimento}</td>
                <td>${despesa.credorDespesa}</td>
                <td>${despesa.descricaoDespesa}</td>
                <td>${despesa.valorDespesa}</td>
                <td>
                    <a href="editDespesa.jsp?idDespesa=${despesa.id}">Editar</a>
                    <a href="deleteDespesa.jsp?idDespesa=${despesa.id}">Excluir</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <br />
    <a href="index.jsp">Voltar para a página inicial</a>
</body>
</html>
