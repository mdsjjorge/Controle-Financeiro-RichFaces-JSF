package src.main.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import src.main.entidades.Empenho;
import src.main.servicos.EmpenhoService;

import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class EmpenhoMB implements Serializable {

    private EmpenhoService empenhoService;
    private List<Empenho> listaEmpenhos;
    private Empenho novoEmpenho;

    @PostConstruct
    public void init() {
        empenhoService = new EmpenhoService();
        listaEmpenhos = empenhoService.buscarTodosEmpenhos();
        novoEmpenho = new Empenho();
    }

    public List<Empenho> getListaEmpenhos() {
        return listaEmpenhos;
    }

    public Empenho getNovoEmpenho() {
        return novoEmpenho;
    }

    public void salvarEmpenho() {
        empenhoService.salvarEmpenho(novoEmpenho);
        listaEmpenhos = empenhoService.buscarTodosEmpenhos();
        novoEmpenho = new Empenho();
    }
}
