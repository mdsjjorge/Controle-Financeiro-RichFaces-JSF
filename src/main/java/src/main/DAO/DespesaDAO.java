package src.main.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import src.main.entidades.Despesa;
import src.main.util.PostgreSQLConnectionUtil;

public class DespesaDAO {

	public boolean verificarNumeroProtocoloUnico(String numeroProtocolo) {
        String sql = "SELECT COUNT(*) FROM despesa WHERE numero_protocolo = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroProtocolo);

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
	
	public boolean verificarNumeroProtocoloUnico(String numeroProtocolo, long idDespesa) {
        String sql = "SELECT COUNT(*) FROM despesa WHERE numero_protocolo = ? AND id <> ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, numeroProtocolo);
            preparedStatement.setLong(2, idDespesa);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao verificar número de protocolo.");
        }

        return true; 
    }
	
	public boolean verificarDespesaSemEmpenhos(Despesa despesa) {
        String sql = "SELECT COUNT(*) FROM empenho WHERE id_despesa = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, despesa.getId());

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
	
	public void salvarDespesa(Despesa despesa) {
        String sql = "INSERT INTO despesa (numero_protocolo, tipo_despesa, data_protocolo, data_vencimento, credor, descricao, valor) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, despesa.getNumeroProtocolo());
            preparedStatement.setString(2, despesa.getTipoDespesa());
            preparedStatement.setDate(3, (Date) despesa.getDataProtocolo());
            preparedStatement.setDate(4, (Date) despesa.getDataVencimento());
            preparedStatement.setString(5, despesa.getCredor());
            preparedStatement.setString(6, despesa.getDescricao());
            preparedStatement.setDouble(7, despesa.getValor());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao salvar a despesa.");
        }
    }
	
	public void atualizarDespesa(Despesa despesa) {
        String sql = "UPDATE despesa SET numero_protocolo = ?, tipo_despesa = ?, data_protocolo = ?, " +
                     "data_vencimento = ?, credor = ?, descricao = ?, valor = ? WHERE id = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, despesa.getNumeroProtocolo());
            preparedStatement.setString(2, despesa.getTipoDespesa());
            preparedStatement.setDate(3, (Date) despesa.getDataProtocolo());
            preparedStatement.setDate(4, (Date) despesa.getDataVencimento());
            preparedStatement.setString(5, despesa.getCredor());
            preparedStatement.setString(6, despesa.getDescricao());
            preparedStatement.setDouble(7, despesa.getValor());
            preparedStatement.setLong(9, despesa.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao atualizar a despesa.");
        }
    }
	
	public Despesa buscarDespesaPorId(long idDespesa) {
        String sql = "SELECT * FROM despesa WHERE id = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idDespesa);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return new Despesa(
                            resultSet.getLong("id"),
                            resultSet.getString("numero_protocolo"),
                            resultSet.getString("tipo_despesa"),
                            resultSet.getDate("data_protocolo"),
                            resultSet.getDate("data_vencimento"),
                            resultSet.getString("credor"),
                            resultSet.getString("descricao"),
                            resultSet.getDouble("valor"),
                            resultSet.getString("status")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao buscar a despesa por ID.");
        }

        return null; 
    }
	
	public void deletarDespesa(long idDespesa) {
        if (!verificarDespesaSemEmpenhos(idDespesa)) {
            throw new RuntimeException("Não é permitido deletar uma despesa que possui empenhos associados.");
        }

        String sql = "DELETE FROM despesa WHERE id = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idDespesa);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao deletar a despesa.");
        }
    }

    public boolean verificarDespesaSemEmpenhos(long idDespesa) {
        String sql = "SELECT COUNT(*) FROM empenho WHERE id_despesa = ?";

        try (Connection connection = PostgreSQLConnectionUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, idDespesa);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count == 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao verificar empenhos associados à despesa.");
        }

        return true; 
    }
	
}
