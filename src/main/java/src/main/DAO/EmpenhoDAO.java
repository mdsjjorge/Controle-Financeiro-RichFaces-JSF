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

import src.main.entidades.Empenho;
import src.main.util.PostgreSQLConnectionUtil;

public class EmpenhoDAO {

	public boolean verificarEmpenhoUnico(int ano, String numeroEmpenho) {
        String sql = "SELECT COUNT(*) FROM empenho WHERE ano = ? AND numero_empenho = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, ano);
            preparedStatement.setString(2, numeroEmpenho);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }

        return true; 
    }
	
	private EntityManagerFactory entityManagerFactory;
	
    public List<Empenho> buscarTodosEmpenhos() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        String jpql = "SELECT e FROM Empenho e";
        TypedQuery<Empenho> query = entityManager.createQuery(jpql, Empenho.class);
        List<Empenho> empenhos = query.getResultList();
        entityManager.close();
        return empenhos;
    }

//    public void salvarEmpenho(Empenho empenho) {
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.persist(empenho);
//        entityManager.getTransaction().commit();
//        entityManager.close();
//    }
    
	public boolean verificarEmpenhoSemPagamentos(Empenho empenho) {
        String sql = "SELECT COUNT(*) FROM pagamento WHERE id_empenho = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, empenho.getId()); 

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }

        return true;
    }
	
	public void salvarEmpenho(Empenho empenho) {
        String sql = "INSERT INTO empenho (id_despesa, numero_empenho, ano_empenho, data_empenho, valor_empenho, observacao) " +
                     "VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, empenho.getIdDespesa());
            preparedStatement.setString(2, empenho.getNumeroEmpenho());
            preparedStatement.setInt(3, empenho.getAnoEmpenho());
            preparedStatement.setDate(4, (Date) empenho.getDataEmpenho());
            preparedStatement.setDouble(5, empenho.getValorEmpenho());
            preparedStatement.setString(6, empenho.getObservacao());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar o empenho.");
        }
    }
	
	public boolean verificarEmpenhoUnico(String numeroEmpenho, int anoEmpenho) {
        String sql = "SELECT COUNT(*) FROM empenho WHERE numero_empenho = ? AND ano_empenho = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroEmpenho);
            preparedStatement.setInt(2, anoEmpenho);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao verificar empenho único.");
        }

        return true; 
    }
	
	 public boolean verificarEmpenhoUnico(String numeroEmpenho, int anoEmpenho, long idEmpenho) {
	        String sql = "SELECT COUNT(*) FROM empenho WHERE numero_empenho = ? AND ano_empenho = ? AND id <> ?";

	        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setString(1, numeroEmpenho);
	            preparedStatement.setInt(2, anoEmpenho);
	            preparedStatement.setLong(3, idEmpenho);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    int count = resultSet.getInt(1);
	                    return count == 0;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Erro ao verificar empenho único.");
	        }

	        return true; 
	    }
	 
	 public void atualizarEmpenho(Empenho empenho) {
	        String sql = "UPDATE empenho SET id_despesa = ?, numero_empenho = ?, ano_empenho = ?, data_empenho = ?, " +
	                     "valor_empenho = ?, observacao = ? WHERE id = ?";

	        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setLong(1, empenho.getIdDespesa());
	            preparedStatement.setString(2, empenho.getNumeroEmpenho());
	            preparedStatement.setInt(3, empenho.getAnoEmpenho());
	            preparedStatement.setDate(4, (Date) empenho.getDataEmpenho());
	            preparedStatement.setDouble(5, empenho.getValorEmpenho());
	            preparedStatement.setString(6, empenho.getObservacao());
	            preparedStatement.setLong(7, empenho.getId());

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Erro ao atualizar o empenho.");
	        }
	    }
	 
	 public Empenho buscarEmpenhoPorId(long idEmpenho) {
	        String sql = "SELECT * FROM empenho WHERE id = ?";

	        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setLong(1, idEmpenho);

	            try (ResultSet resultSet = preparedStatement.executeQuery()) {
	                if (resultSet.next()) {
	                    return new Empenho(
	                            resultSet.getLong("id"),
	                            resultSet.getLong("id_despesa"),
	                            resultSet.getString("numero_empenho"),
	                            resultSet.getInt("ano_empenho"),
	                            resultSet.getDate("data_empenho"),
	                            resultSet.getDouble("valor_empenho"),
	                            resultSet.getString("observacao")
	                    );
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Erro ao buscar o empenho por ID.");
	        }

	        return null; 
	    }
	 
	 public void deletarEmpenho(long idEmpenho) {
	        String sql = "DELETE FROM empenho WHERE id = ?";

	        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
	             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	            preparedStatement.setLong(1, idEmpenho);

	            preparedStatement.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            throw new RuntimeException("Erro ao deletar o empenho.");
	        }
	    }
}
