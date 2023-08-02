<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html>
<html>
<head>
    <title>Criar/Editar Despesa</title>
</head>
<body>
    <f:view>
        <h:form>
            <h:inputText value="#{despesaBean.despesa.numeroProtocolo}" />
            <h:inputText value="#{despesaBean.despesa.tipoDespesa}" />
            <!-- Adicione mais campos de entrada aqui para outros atributos -->
            <h:commandButton value="Salvar" action="#{despesaBean.salvarDespesa}" />
        </h:form>
    </f:view>
</body>
</html>
