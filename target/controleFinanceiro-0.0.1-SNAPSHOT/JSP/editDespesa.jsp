<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Despesa</title>
</head>
<body>
    <h1>Editar Despesa</h1>
    <form action="editDespesaAction.jsp" method="post">
        <input type="hidden" name="idDespesa" value="${despesa.id}" />
        <label>Número de Protocolo: <input type="text" name="numeroProtocolo" value="${despesa.numeroProtocolo}" /></label><br />
        <label>Tipo de Despesa: <input type="text" name="tipoDespesa" value="${despesa.tipoDespesa}" /></label><br />
        <label>Data do Protocolo: <input type="text" name="dataProtocolo" value="${despesa.dataProtocolo}" /></label><br />
        <label>Data de Vencimento: <input type="text" name="dataVencimento" value="${despesa.dataVencimento}" /></label><br />
        <label>Credor da Despesa: <input type="text" name="credorDespesa" value="${despesa.credorDespesa}" /></label><br />
        <label>Descrição da Despesa: <input type="text" name="descricaoDespesa" value="${despesa.descricaoDespesa}" /></label><br />
        <label>Valor da Despesa: <input type="text" name="valorDespesa" value="${despesa.valorDespesa}" /></label><br />
        <input type="submit" value="Salvar" />
    </form>
    <br />
    <a href="listarDespesas.jsp">Voltar para a lista de Despesas</a>
</body>
</html>
