<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="src.main.servicos.PagamentoService" %>
<%@ page import="src.main.entidades.Pagamento" %>

<%
    long idPagamento = Long.parseLong(request.getParameter("idPagamento"));

    PagamentoService pagamentoService = new PagamentoService();
    Pagamento pagamento = pagamentoService.buscarPagamentoPorId(idPagamento);

    if (pagamento != null) {
        pagamentoService.deletarPagamento(idPagamento);
    }
    
    response.sendRedirect("listarPagamentos.jsp");
%>
