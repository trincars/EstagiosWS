package Persistencia.Derby;

import Negocio.DAO.IEstagioDAO;
import Negocio.Entidades.Estagio;
import java.util.List;
import Negocio.Entidades.Coordenador;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EstagioDAO_Derby implements IEstagioDAO {

    private static final String dbName = "sample";
    private Connection conexao = null;
    private ResultSet resultado;

    @Override
    public void gravarEstagio(Estagio estagio) {
        conexao = null;
        PreparedStatement comando = null;
//        String sqlEstagio = "insert into Estagio (idCoordenador, dataInicio,dataFim,horaInicio1,horaFim1,"
//                + "horaInicio2,horaFim2,cargaHoraria,valorBolsa,tipoValorBolsa,diaPagamento,"
//                + "objetivo,atividades,statusSupervisor,parecerSupervisor,statusCoordenador,"
//                + "parecerCoordenador,empresa,aluno,supervisor,coordenador) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        String sqlEstagio = "insert into Estagio (dataInicio,dataFim,horaInicio1,horaFim1,horaInicio2,horaFim2,cargaHoraria,valorBolsa,tipoValorBolsa,diaPagamento,objetivo,atividades,statusSupervisor,parecerSupervisor,statusCoordenador,parecerCoordenador,CNPJ,matricula,idSupervisor,idCoordenador) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sqlEstagio);
            comando.setDate(1, estagio.getDataInicio());
            comando.setDate(2, estagio.getDataFim());
            comando.setDate(3, estagio.getHoraInicio1());
            comando.setDate(4, estagio.getHoraFim1());
            comando.setDate(5, estagio.getHoraInicio2());
            comando.setDate(6, estagio.getHoraFim2());
            comando.setInt(7, estagio.getCargaHoraria());
            comando.setDouble(8, estagio.getValorBolsa());
            comando.setInt(9, estagio.getTipoValorBolsa());
            comando.setInt(10, estagio.getDiaPagamento());
            comando.setString(11, estagio.getObjetivo());
            comando.setString(12, estagio.getAtividades());
            comando.setString(13, estagio.getStatusSupervisor());
            comando.setString(14, estagio.getParecerSupervisor());
            comando.setString(15, estagio.getStatusCoordenador());
            comando.setString(16, estagio.getParecerCoordenador());
            comando.setString(17,estagio.getEmpresa() );
            comando.setString(18, estagio.getAluno());
            comando.setInt(19, Integer.parseInt(estagio.getSupervisor()));
            comando.setInt(20, Integer.parseInt(estagio.getCoordenador()));
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            try {
                throw new Exception("Falha no comando UPDATE", e);            } catch (Exception ex) {
                Logger.getLogger(EstagioDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param idSupervisor
     * @return
     * @see Negocio.DAO.IEstagioDAO#buscaEstagiosSupervisor(java.lang.String)
     */
    @Override
    public List<Estagio> buscaEstagiosSupervisor(String idSupervisor) {
        PreparedStatement comando = null;
        String sql = "select * from Estagio where idSupervisor = ?";
        List<Estagio> listEstagio = new ArrayList<>();

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, idSupervisor);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {

                Estagio estagio = new Estagio(resultado.getInt("idCoordenador"),
                        resultado.getDate("dataInicio"),
                        resultado.getDate("dataFim"),
                        resultado.getDate("horaInicio1"),
                        resultado.getDate("horaFim1"),
                        resultado.getDate("horaInicio2"),
                        resultado.getDate("horaFim2"),
                        resultado.getInt("cargaHoraria"),
                        resultado.getDouble("valorBolsa"),
                        resultado.getInt("tipoValorBolsa"),
                        resultado.getInt("diaPagamento"),
                        resultado.getString("objetivo"),
                        resultado.getString("atividades"),
                        resultado.getString("statusSupervisor"),
                        resultado.getString("parecerSupervisor"),
                        resultado.getString("statusCoordenador"),
                        resultado.getString("parecerCoordenador"),
                        resultado.getString("CNPJ"),
                        resultado.getString("matricula"),
                        resultado.getString("idSupervisor"),
                        resultado.getString("idCoordenador"));
                listEstagio.add(estagio);
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Estagio", e);
            } catch (Exception ex) {
                Logger.getLogger(CoordenadorDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return listEstagio;
    }

    /**
     * @param idEstagio
     * @return
     * @see Negocio.DAO.IEstagioDAO#buscaEstagio(java.lang.String)
     */
    @Override
    public Estagio buscaEstagio(String idEstagio) {
        PreparedStatement comando = null;
        String sql = "select * from Estagio where idEstagio = ?";
        Estagio estagio = null;

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, idEstagio);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {

                estagio = new Estagio(resultado.getInt("idCoordenador"),
                        resultado.getDate("dataInicio"),
                        resultado.getDate("dataFim"),
                        resultado.getDate("horaInicio1"),
                        resultado.getDate("horaFim1"),
                        resultado.getDate("horaInicio2"),
                        resultado.getDate("horaFim2"),
                        resultado.getInt("cargaHoraria"),
                        resultado.getDouble("valorBolsa"),
                        resultado.getInt("tipoValorBolsa"),
                        resultado.getInt("diaPagamento"),
                        resultado.getString("objetivo"),
                        resultado.getString("atividades"),
                        resultado.getString("statusSupervisor"),
                        resultado.getString("parecerSupervisor"),
                        resultado.getString("statusCoordenador"),
                        resultado.getString("parecerCoordenador"),
                        resultado.getString("empresa"),
                        resultado.getString("aluno"),
                        resultado.getString("supervisor"),
                        resultado.getString("coordenador"));
            }
            comando.close();
            conexao.close();
            resultado.close();

        } catch (SQLException e) {
            try {
                throw new Exception("Falha na busca ao Estagio", e);
            } catch (Exception ex) {
                Logger.getLogger(CoordenadorDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return estagio;
    }

    /**
     * @param estagio
     * @see
     * Negocio.DAO.IEstagioDAO#atualizaStatusSupervisor(Negocio.Entidades.Estagio)
     * // Atualiza somente os campos parecerSupervisor e statusSupervisor
     * idSupervisor
     */
    @Override
    public void atualizaStatusSupervisor(Estagio estagio) {
        conexao = null;
        PreparedStatement comando = null;

        String sql = "update Estagio set parecerSupervisor, statusSupervisor,idSupervisor ";
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, estagio.getParecerSupervisor());
            comando.setString(2, estagio.getStatusSupervisor());
            comando.setString(3, estagio.getSupervisor());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            try {
                throw new Exception("Falha no comando UPDATE", e);
            } catch (Exception ex) {
                Logger.getLogger(EstagioDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * @param IdCoordenador
     * @param coordenador
     * @return
     * @see
     * Negocio.DAO.IEstagioDAO#buscaEstagiosCoordenador(Negocio.Entidades.Coordenador)
     */
    @Override
    public List<Estagio> buscaEstagiosCoordenador(String IdCoordenador) {
        PreparedStatement comando = null;
        String sql = "select * from Estagio where idCoordenador = ?";
        List<Estagio> listEstagios = new ArrayList();

        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, IdCoordenador);
            resultado = (ResultSet) comando.executeQuery();
            while (resultado.next()) {

                Estagio estagio = new Estagio(resultado.getInt("idCoordenador"),
                        resultado.getDate("dataInicio"),
                        resultado.getDate("dataFim"),
                        resultado.getDate("horaInicio1"),
                        resultado.getDate("horaFim1"),
                        resultado.getDate("horaInicio2"),
                        resultado.getDate("horaFim2"),
                        resultado.getInt("cargaHoraria"),
                        resultado.getDouble("valorBolsa"),
                        resultado.getInt("tipoValorBolsa"),
                        resultado.getInt("diaPagamento"),
                        resultado.getString("objetivo"),
                        resultado.getString("atividades"),
                        resultado.getString("statusSupervisor"),
                        resultado.getString("parecerSupervisor"),
                        resultado.getString("statusCoordenador"),
                        resultado.getString("parecerCoordenador"),
                        resultado.getString("empresa"),
                        resultado.getString("aluno"),
                        resultado.getString("supervisor"),
                        resultado.getString("coordenador"));
                listEstagios.add(estagio);
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
        return listEstagios;
    }

    @Override
    public void atualizaStatusCoordenador(Estagio estagio) {
        conexao = null;
        PreparedStatement comando = null;

        String sql = "update Estagio set parecerCoordenador, StatusCoordenador,idCoordenador ";
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(sql);
            comando.setString(1, estagio.getParecerCoordenador());
            comando.setString(2, estagio.getStatusCoordenador());
            comando.setString(3, estagio.getCoordenador());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (Exception e) {
            try {
                throw new Exception("Falha no comando UPDATE", e);
            } catch (Exception ex) {
                Logger.getLogger(EstagioDAO_Derby.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
