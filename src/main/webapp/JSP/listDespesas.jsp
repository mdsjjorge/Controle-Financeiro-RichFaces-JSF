<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@ taglib uri="http://richfaces.org/rich" prefix="rich"%>

<!DOCTYPE html>
<html>
<head>
    <title>Listagem de Despesas</title>
</head>
<body>
    <f:view>
        <h:form>
            <rich:dataTable value="#{despesaMB.listaDespesas}" var="despesa">
                <rich:column>
                    <f:facet name="header">Número Protocolo</f:facet>
                    #{despesa.numeroProtocolo}
                </rich:column>
                <rich:column>
                    <f:facet name="header">Tipo de Despesa</f:facet>
                    #{despesa.tipoDespesa}
                </rich:column>
                <!-- Adicione mais colunas aqui para outros atributos -->
            </rich:dataTable>

            <h:panelGrid columns="2">
                <h:inputText value="#{despesaMB.novaDespesa.numeroProtocolo}" />
                <h:inputText value="#{despesaMB.novaDespesa.tipoDespesa}" />
                <!-- Adicione mais campos de entrada aqui para outros atributos -->
                <h:commandButton value="Salvar" action="#{despesaMB.salvarDespesa}" />
            </h:panelGrid>
        </h:form>
    </f:view>
</body>
</html>
