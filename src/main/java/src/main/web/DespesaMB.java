package src.main.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import src.main.entidades.Despesa;
import src.main.servicos.DespesaService;

import java.io.Serializable;
import java.util.List;



@ManagedBean
@ViewScoped
public class DespesaMB implements Serializable {

    private DespesaService despesaService;
    private List<Despesa> listaDespesas;
    private Despesa novaDespesa;

    @PostConstruct
    public void init() {
        despesaService = new DespesaService();
        listaDespesas = despesaService.buscarTodasDespesas();
        novaDespesa = new Despesa();
    }

    public List<Despesa> getListaDespesas() {
        return listaDespesas;
    }

    public Despesa getNovaDespesa() {
        return novaDespesa;
    }

    public void salvarDespesa() {
        despesaService.salvarDespesa(novaDespesa);
        listaDespesas = despesaService.buscarTodasDespesas();
        novaDespesa = new Despesa();
    }
}
