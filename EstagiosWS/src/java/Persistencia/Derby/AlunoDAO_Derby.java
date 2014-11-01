package Persistencia.Derby;

import Negocio.DAO.IAlunoDAO;
import Negocio.Entidades.Aluno;
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

public class AlunoDAO_Derby implements IAlunoDAO {

    private Connection conexao = null;
    private ResultSet resultado;
    private ResultSet resultadoCurso;

    @Override
    public Aluno buscarMatricula(String matricula) {

        PreparedStatement comando = null;
        PreparedStatement comandoCurso = null;
        String sql = "select * from Aluno where Matricula = ?";

        Aluno aluno = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, matricula);
            resultado = (ResultSet) comando.executeQuery();

            String IDCurso = "";
            Curso curso = new Curso();
            while (resultado.next()) {
                aluno = new Aluno(resultado.getString("Matricula"),
                        resultado.getString("CPF"),
                        resultado.getString("RG"),
                        resultado.getString("Nome"),
                        resultado.getString("EstadoCivil"),
                        resultado.getString("Semestre"),
                        resultado.getString("Endereco"),
                        resultado.getString("Bairro"),
                        resultado.getString("Cidade"),
                        resultado.getString("Estado"),
                        resultado.getString("CEP"),
                        resultado.getString("Telefone"),
                        resultado.getString("Email"),
                        curso);
                IDCurso = resultado.getString("idCurso");
            }
            String idCoordenador = "";
            Coordenador coordenador = new Coordenador();
            String sqlCurso = "select * from Curso where idCurso = ?";
            comandoCurso = conexao.prepareStatement(sqlCurso);
            comandoCurso.setString(1, IDCurso);
            resultadoCurso = (ResultSet) comandoCurso.executeQuery();
            while (resultadoCurso.next()) {
                curso.setIdCurso(resultadoCurso.getInt("idCurso"));
                curso.setNome(resultadoCurso.getString("Nome"));
                idCoordenador = resultadoCurso.getString("idCoordenador");
            }
            
            
            String sqlCoordenador = "select * from Coordenador where idCoordenador = ?";
            comandoCurso = conexao.prepareStatement(sqlCoordenador);
            comandoCurso.setString(1, idCoordenador);
            resultadoCurso = (ResultSet) comandoCurso.executeQuery();
            while (resultadoCurso.next()) {
                coordenador.setId(resultadoCurso.getString("idCoordenador"));
                coordenador.setNome(resultadoCurso.getString("Nome"));
                coordenador.setEmail(resultadoCurso.getString("email"));
                curso.setCoordenador(coordenador);
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Aluno", e);
            } catch (Exception ex) {
                Logger.getLogger(AlunoDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return aluno;
    }

}
