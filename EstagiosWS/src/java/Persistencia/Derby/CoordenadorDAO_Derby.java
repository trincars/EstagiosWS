package Persistencia.Derby;

import Negocio.DAO.ICoordenadorDAO;
import Negocio.Entidades.Coordenador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CoordenadorDAO_Derby implements ICoordenadorDAO {

    private static final String dbName = "sample";
    private Connection conexao = null;
    private ResultSet resultado;

    @Override
    public Coordenador busca(String idCoordenador) {
        PreparedStatement comando = null;
        String sql = "select * from Coordenador where idCoordenador = ?";

        Coordenador coordenador = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, idCoordenador);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {
                coordenador = new Coordenador(resultado.getString("idCoordenador"),
                        resultado.getString("Nome"),
                        resultado.getString("email"));
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Coordenador", e);
            } catch (Exception ex) {
                Logger.getLogger(CoordenadorDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return coordenador;
    }

}
