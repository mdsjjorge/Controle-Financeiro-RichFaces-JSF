<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html>
<html>
<head>
    <title>Excluir Pagamento</title>
</head>
<body>
    <f:view>
        <h:form>
            <h:outputText value="#{pagamentoBean.pagamento.numeroPagamento}" />
            <h:outputText value="#{pagamentoBean.pagamento.anoPagamento}" />
            <!-- Adicione mais campos de saída aqui para outros atributos -->
            <h:commandButton value="Excluir" action="#{pagamentoBean.deletarPagamento}" />
        </h:form>
    </f:view>
</body>
</html>
