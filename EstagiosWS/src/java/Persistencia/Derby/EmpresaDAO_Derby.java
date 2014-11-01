package Persistencia.Derby;

import Negocio.DAO.IEmpresaDAO;
import Negocio.Entidades.Empresa;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpresaDAO_Derby implements IEmpresaDAO {

    private static final String dbName = "sample";
    private Connection conexao = null;
    private ResultSet resultado;

    @Override
    public List bucarListaEmpresas() {

        PreparedStatement comando = null;
        String sql = "select * from Empresa";
        List list = new ArrayList<>();
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {
                Empresa empresa = new Empresa(resultado.getString("CNPJ"),
                        resultado.getString("RazaoSocial"),
                        resultado.getString("Endereco"),
                        resultado.getString("Bairro"),
                        resultado.getString("CEP"),
                        resultado.getString("Telefone"),
                        resultado.getString("Email"));
                list.add(empresa);
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Aluno", e);
            } catch (Exception ex) {
                Logger.getLogger(EmpresaDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }

    @Override
    public Empresa buscar(String CNPJ) {
        PreparedStatement comando = null;
        String sql = "select * from Empresa where CNPJ = ?";
         Empresa empresa = null;
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, CNPJ);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {
                  empresa = new Empresa(resultado.getString("CNPJ"),
                        resultado.getString("RazaoSocial"),
                        resultado.getString("Endereco"),
                        resultado.getString("Bairro"),
                        resultado.getString("CEP"),
                        resultado.getString("Telefone"),
                        resultado.getString("Email"));
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Empresa", e);
            } catch (Exception ex) {
                Logger.getLogger(EmpresaDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return empresa;
    }
}
