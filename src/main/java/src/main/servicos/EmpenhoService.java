package src.main.servicos;

import java.util.List;

import src.main.DAO.EmpenhoDAO;
import src.main.entidades.Empenho;

public class EmpenhoService {

	private EmpenhoDAO empenhoDAO;

    public EmpenhoService() {
        this.empenhoDAO = new EmpenhoDAO();
    }

    public void criarEmpenho(Empenho empenho) {
        if (empenhoDAO.verificarEmpenhoUnico(empenho.getNumeroEmpenho(), empenho.getAnoEmpenho())) {
        	
            empenhoDAO.salvarEmpenho(empenho);
        } else {
            throw new RuntimeException("O empenho com o mesmo n�mero e ano j� foi registrado.");
        }
    }
    
    public void salvarEmpenho(Empenho novoEmpenho) {
        empenhoDAO.salvarEmpenho(novoEmpenho);
    }
    
    public List<Empenho> buscarTodosEmpenhos() {
        return empenhoDAO.buscarTodosEmpenhos();
    }

    public void atualizarEmpenho(Empenho empenho) {
//        if (!empenhoDAO.verificarEmpenhoUnico(empenho.getNumeroEmpenho(), empenho.getAnoEmpenho(), empenho.getId())) {
//            throw new RuntimeException("O empenho com o mesmo n�mero e ano j� foi registrado.");
//        }

        empenhoDAO.atualizarEmpenho(empenho);
    }

    public void deletarEmpenho(long idEmpenho) {
        Empenho empenho = empenhoDAO.buscarEmpenhoPorId(idEmpenho);

        if (!empenhoDAO.verificarEmpenhoSemPagamentos(empenho)) {
            throw new RuntimeException("N�o � permitido deletar um empenho que possui pagamentos associados.");
        }

        empenhoDAO.deletarEmpenho(idEmpenho);
    }
}
