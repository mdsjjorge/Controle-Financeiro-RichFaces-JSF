package src.main.servicos;

import java.util.List;

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
            throw new RuntimeException("O pagamento com o mesmo n�mero e ano j� foi registrado.");
        }
    }
    
    public void salvarPagamento(Pagamento novoPagamento) {
        pagamentoDAO.salvarPagamento(novoPagamento);
    }
    
    public Pagamento buscarPagamentoPorId(long idPagamento) {
        return pagamentoDAO.buscarPagamentoPorId(idPagamento);
    }

    public void atualizarPagamento(Pagamento pagamento) {
//        if (!pagamentoDAO.verificarPagamentoUnico(pagamento.getNumeroPagamento(), pagamento.getAnoPagamento(), pagamento.getId())) {
//            throw new RuntimeException("O pagamento com o mesmo n�mero e ano j� foi registrado.");
//        }

        pagamentoDAO.atualizarPagamento(pagamento);
    }
    
    public List<Pagamento> buscarTodosPagamentos() {
        return pagamentoDAO.buscarTodosPagamentos();
    }

    public void deletarPagamento(long idPagamento) {
        Pagamento pagamento = pagamentoDAO.buscarPagamentoPorId(idPagamento);

        if (pagamento != null) {
            pagamentoDAO.deletarPagamento(idPagamento);
        } else {
            throw new RuntimeException("Pagamento n�o encontrado com o ID fornecido.");
        }
    }
}
