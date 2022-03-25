import jdk.jshell.execution.Util;

import java.sql.*;

public class ClienteDAOImpl implements ClienteDAO {


    @Override
    public Connection connect(String urlConexao) throws SQLException {
        String url = "jdbc:sqlite:sqlite_database_marco_2022.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;

    }

    @Override
    public void createTable(String urlConexao) {

        urlConexao = "jdbc:sqlite:sqlite_database_marco_2022.db";

        StringBuffer sql = new StringBuffer();
        sql.append("CREATE TABLE IF NOT EXISTS cliente (");
        sql.append("id integer PRIMARY KEY , ");
        sql.append("nome text NOT NULL, ");
        sql.append("idade integer, ");
        sql.append("cpf text NOT NULL, ");
        sql.append("rg text ");
        sql.append(")");
        try (Connection conn2= DriverManager.getConnection(urlConexao);
             Statement stmt = conn2.createStatement()) {
            stmt.execute(sql.toString());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void insert(String url_conexao, Cliente cliente) {

        String sql = "INSERT INTO cliente(nome,idade, cpf, rg) VALUES(?,?,?,?)";
        try (Connection conn = this.connect(url_conexao);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNome());
            pstmt.setInt(2, cliente.getIdade());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setString(4, cliente.getRg());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void selectAll(String urlConexao) {

        String sql = "SELECT id, nome, idade, cpf, rg FROM cliente";
        try (Connection conn = this.connect(urlConexao);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("nome") + "\t" + rs.getInt("idade") +
                        rs.getString("cpf") + "\t" + rs.getString("rg"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void update(String urlConexao, int id, String name, Integer idade) {
        String sql = "UPDATE cliente SET nome = ?"  + "idade = ? " + "WHERE id = ?";
        try (Connection conn = this.connect(urlConexao);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, name);
            pstmt.setInt(2, idade);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void delete(String urlConexao, int id) {

        String sql = "DELETE FROM cliente WHERE id = " + id;
        try (Connection conn = this.connect(urlConexao);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}



}