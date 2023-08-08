<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="src.main.servicos.DespesaService" %>
<%@ page import="src.main.entidades.Despesa" %>

<%
    long idDespesa = Long.parseLong(request.getParameter("idDespesa"));
    String numeroProtocolo = request.getParameter("numeroProtocolo");
    String tipoDespesa = request.getParameter("tipoDespesa");

    DespesaService despesaService = new DespesaService();
    Despesa despesa = despesaService.buscarDespesaPorId(idDespesa);

    if (despesa != null) {
        despesa.setNumeroProtocolo(numeroProtocolo);
        despesa.setTipoDespesa(tipoDespesa);

        despesaService.atualizarDespesa(despesa);
    }
    
    response.sendRedirect("listarDespesas.jsp");
%>
