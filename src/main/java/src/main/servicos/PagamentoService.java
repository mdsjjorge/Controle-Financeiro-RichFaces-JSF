package src.main.servicos;

import src.main.DAO.PagamentoDAO;
import src.main.entidades.Pagamento;

public class PagamentoService {
	private PagamentoDAO pagamentoDAO;

    public PagamentoService() {
        this.pagamentoDAO = new PagamentoDAO();
    }

    public void criarPagamento(Pagamento pagamento) {
        if (pagamentoDAO.verificarPagamentoUnico(pagamento.getNumeroPagamento(), pagamento.getAnoPagamento())) {
            pagamentoDAO.salvarPagamento(pagamento);
        } else {
            throw new RuntimeException("O pagamento com o mesmo número e ano já foi registrado.");
        }
    }

    public void atualizarPagamento(Pagamento pagamento) {
//        if (!pagamentoDAO.verificarPagamentoUnico(pagamento.getNumeroPagamento(), pagamento.getAnoPagamento(), pagamento.getId())) {
//            throw new RuntimeException("O pagamento com o mesmo número e ano já foi registrado.");
//        }

        pagamentoDAO.atualizarPagamento(pagamento);
    }

    public void deletarPagamento(long idPagamento) {
        Pagamento pagamento = pagamentoDAO.buscarPagamentoPorId(idPagamento);

        if (pagamento != null) {
            pagamentoDAO.deletarPagamento(idPagamento);
        } else {
            throw new RuntimeException("Pagamento não encontrado com o ID fornecido.");
        }
    }
}
