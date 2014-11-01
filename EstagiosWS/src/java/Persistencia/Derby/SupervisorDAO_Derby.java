package Persistencia.Derby;

import Negocio.DAO.ISupervisorDAO;
import Negocio.Entidades.Supervisor;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SupervisorDAO_Derby implements ISupervisorDAO {

    private static final String dbName = "sample";
    private Connection conexao = null;
    private ResultSet resultado;

    @Override
    public Supervisor busca(String idSupervisor) {
        PreparedStatement comando = null;
        String sql = "select * from Supervisor where idSupervisor = ?";

        Supervisor supervisor = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, idSupervisor);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {
                supervisor = new Supervisor(resultado.getString("idSupervisor"),
                        resultado.getString("CNPJ"),
                        resultado.getString("Nome"),
                        resultado.getString("Cargo"),
                        resultado.getString("Formacao"),
                        resultado.getString("email"));
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Supervisor", e);
            } catch (Exception ex) {
                Logger.getLogger(SupervisorDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return supervisor;
    }

    @Override
    public Supervisor buscaSupervisorPeloIdEmpresa(String CNPJ) {
        PreparedStatement comando = null;
        // String sql = "select * from Supervisor where idSupervisor = ?";

        String sql = "select supervisor.IDSUPERVISOR from supervisor inner join empresa on empresa.CNPJ = supervisor.CNPJ where empresa.CNPJ = ?";
        Supervisor supervisor = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, CNPJ);
            resultado = (ResultSet) comando.executeQuery();
            resultado.next();
            String idSupervisor = resultado.getString("IDSUPERVISOR");
            supervisor = busca(idSupervisor);

            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Supervisor", e);
            } catch (Exception ex) {
                Logger.getLogger(SupervisorDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return supervisor;

    }
}
