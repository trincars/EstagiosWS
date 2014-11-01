/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Derby;

import Negocio.DAO.ICursoDAO;
import Negocio.Entidades.Coordenador;
import Negocio.Entidades.Curso;
import static Persistencia.InicializadorBancoDados.dbName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 00280076
 */
public class CursoDAO_Derby implements ICursoDAO {

    private static final String dbName = "sample";
    private Connection conexao = null;
    private ResultSet resultado;
    

    @Override
    public int buscaCoordenador(String idCurso) {
        PreparedStatement comando = null;
        String sql = "select * from Curso where idCurso = ?";

        Coordenador coordenador = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, idCurso);
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
        return Integer.parseInt(coordenador.getId());
    }

    @Override
    public Curso busca(String idCurso) {
        PreparedStatement comando = null;
        String sqlCurso = "select * from Curso where idCurso = ?";
        Curso curso = new Curso();
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sqlCurso);
            comando.setString(1, idCurso);
            resultado = (ResultSet) comando.executeQuery();
            String idCoordenador = "";
            while (resultado.next()) {
                curso.setIdCurso(resultado.getInt("idCurso"));
                curso.setNome(resultado.getString("Nome"));
                idCoordenador = resultado.getString("idCoordenador");
            }
            comando.close();
            conexao.close();
            resultado.close();
            CoordenadorDAO_Derby coorDAO = new CoordenadorDAO_Derby();
            Coordenador coordenador = coorDAO.busca(idCoordenador);
            curso.setCoordenador(coordenador);
            //Coordenador coordenador = new Coordenador();
//            String sqlCoordenador = "select * from Coordenador where idCoordenador = ?";
//            comando = conexao.prepareStatement(sqlCoordenador);
//            comando.setString(1, idCoordenador);
//            resultado = comando.executeQuery();
//            while (resultado.next()) {
//                coordenador.setId(resultado.getString("idCoordenador"));
//                coordenador.setNome(resultado.getString("Nome"));
//                coordenador.setEmail(resultado.getString("email"));
//                curso.setCoordenador(coordenador);
//            }
            
            
        } catch (Exception e) {
            try {
                throw new Exception("Falha na busca ao Curso", e);
            } catch (Exception ex) {
                Logger.getLogger(CursoDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        return curso;
    }
}
