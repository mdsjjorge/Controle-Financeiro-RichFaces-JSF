<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Excluir Pagamento</title>
</head>
<body>
    <h1>Excluir Pagamento</h1>
    <p>Você está prestes a excluir o pagamento com ID ${idPagamento}. Tem certeza?</p>
    <form action="deletePagamentoAction.jsp" method="post">
        <input type="hidden" name="idPagamento" value="${idPagamento}" />
        <input type="submit" value="Excluir" />
    </form>
    <br />
    <a href="listarPagamentos.jsp">Voltar para a lista de Pagamentos</a>
</body>
</html>
