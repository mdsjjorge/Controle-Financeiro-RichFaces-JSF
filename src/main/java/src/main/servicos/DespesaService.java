package src.main.servicos;

import java.util.List;

import src.main.DAO.DespesaDAO;
import src.main.entidades.Despesa;

public class DespesaService {

	private DespesaDAO despesaDAO;

    public DespesaService() {
        this.despesaDAO = new DespesaDAO();
    }

    public void criarDespesa(Despesa despesa) {
        if (despesaDAO.verificarNumeroProtocoloUnico(despesa.getNumeroProtocolo())) {
            despesa.atualizarStatus();

            despesaDAO.salvarDespesa(despesa);
        } else {
            throw new RuntimeException("Número de protocolo já existe. Por favor, escolha outro número.");
        }
    }
    
    public List<Despesa> buscarTodasDespesas() {
        return despesaDAO.buscarTodasDespesas();
    }
    
    public void salvarDespesa(Despesa novaDespesa) {
        despesaDAO.salvarDespesa(novaDespesa);
    }

    public void atualizarDespesa(Despesa despesa) {
//        if (!despesaDAO.verificarNumeroProtocoloUnico(despesa.getNumeroProtocolo(), despesa.getId())) {
//            throw new RuntimeException("Número de protocolo já existe. Por favor, escolha outro número.");
//        }

        despesa.atualizarStatus();

        despesaDAO.atualizarDespesa(despesa);
    }

    public void deletarDespesa(long idDespesa) {
        Despesa despesa = despesaDAO.buscarDespesaPorId(idDespesa);

        if (!despesaDAO.verificarDespesaSemEmpenhos(despesa)) {
            throw new RuntimeException("Não é permitido deletar uma despesa que possui empenhos associados.");
        }

        despesaDAO.deletarDespesa(idDespesa);
    }
}
