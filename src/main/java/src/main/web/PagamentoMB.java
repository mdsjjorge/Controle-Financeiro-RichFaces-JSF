package src.main.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import src.main.entidades.Pagamento;
import src.main.servicos.PagamentoService;

import java.io.Serializable;
import java.util.List;


@ManagedBean
@ViewScoped
public class PagamentoMB implements Serializable {

    private PagamentoService pagamentoService;
    private List<Pagamento> listaPagamentos;
    private Pagamento novoPagamento;

    @PostConstruct
    public void init() {
        pagamentoService = new PagamentoService();
        listaPagamentos = pagamentoService.buscarTodosPagamentos();
        novoPagamento = new Pagamento();
    }

    public List<Pagamento> getListaPagamentos() {
        return listaPagamentos;
    }

    public Pagamento getNovoPagamento() {
        return novoPagamento;
    }

    public void salvarPagamento() {
        pagamentoService.salvarPagamento(novoPagamento);
        listaPagamentos = pagamentoService.buscarTodosPagamentos();
        novoPagamento = new Pagamento();
    }
}
