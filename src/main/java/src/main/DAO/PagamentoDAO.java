package src.main.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

import src.main.entidades.Pagamento;
import src.main.util.PostgreSQLConnectionUtil;

public class PagamentoDAO {
	public boolean verificarPagamentoUnico(String numeroPagamento, int anoPagamento) {
        String sql = "SELECT COUNT(*) FROM pagamento WHERE numero_pagamento = ? AND ano_pagamento = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroPagamento);
            preparedStatement.setInt(2, anoPagamento);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao verificar pagamento único.");
        }

        return true; 
    }
	
	private EntityManagerFactory entityManagerFactory;
	
	public List<Pagamento> buscarTodosPagamentos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String jpql = "SELECT p FROM Pagamento p";
        TypedQuery<Pagamento> query = entityManager.createQuery(jpql, Pagamento.class);
        List<Pagamento> pagamentos = query.getResultList();
        entityManager.close();
        return pagamentos;
    }

//    public void salvarPagamento(Pagamento pagamento) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(pagamento);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
	
	public void salvarPagamento(Pagamento pagamento) {
        String sql = "INSERT INTO pagamento (id_empenho, numero_pagamento, ano_pagamento, data_pagamento, valor_pagamento, observacao) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, pagamento.getIdEmpenho());
            preparedStatement.setString(2, pagamento.getNumeroPagamento());
            preparedStatement.setInt(3, pagamento.getAnoPagamento());
            preparedStatement.setDate(4, (Date) pagamento.getDataPagamento());
            preparedStatement.setDouble(5, pagamento.getValorPagamento());
            preparedStatement.setString(6, pagamento.getObservacao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o pagamento.");
        }
    }
	
	public boolean verificarPagamentoUnico(String numeroPagamento, int anoPagamento, long idPagamento) {
        String sql = "SELECT COUNT(*) FROM pagamento WHERE numero_pagamento = ? AND ano_pagamento = ? AND id <> ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroPagamento);
            preparedStatement.setInt(2, anoPagamento);
            preparedStatement.setLong(3, idPagamento);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao verificar pagamento único.");
        }

        return true; 
    }
	
	public void atualizarPagamento(Pagamento pagamento) {
        String sql = "UPDATE pagamento SET id_empenho = ?, numero_pagamento = ?, ano_pagamento = ?, data_pagamento = ?, " +
                     "valor_pagamento = ?, observacao = ? WHERE id = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, pagamento.getIdEmpenho());
            preparedStatement.setString(2, pagamento.getNumeroPagamento());
            preparedStatement.setInt(3, pagamento.getAnoPagamento());
            preparedStatement.setDate(4, (Date) pagamento.getDataPagamento());
            preparedStatement.setDouble(5, pagamento.getValorPagamento());
            preparedStatement.setString(6, pagamento.getObservacao());
            preparedStatement.setLong(7, pagamento.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar o pagamento.");
        }
    }
	
	public Pagamento buscarPagamentoPorId(long idPagamento) {
        String sql = "SELECT * FROM pagamento WHERE id = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idPagamento);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Pagamento(
                            resultSet.getLong("id"),
                            resultSet.getLong("id_empenho"),
                            resultSet.getString("numero_pagamento"),
                            resultSet.getInt("ano_pagamento"),
                            resultSet.getDate("data_pagamento"),
                            resultSet.getDouble("valor_pagamento"),
                            resultSet.getString("observacao")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar o pagamento por ID.");
        }

        return null; 
    }
	
	public void deletarPagamento(long idPagamento) {
        String sql = "DELETE FROM pagamento WHERE id = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idPagamento);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar o pagamento.");
        }
    }
}
