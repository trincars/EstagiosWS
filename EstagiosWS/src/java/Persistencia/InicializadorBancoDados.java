package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


/*
 *Classe onde faz conexão e cria o banco de dados Derby 
 */
public class InicializadorBancoDados {

    public static final String dbName = "sample";
    private static boolean dropON = true;

    public static boolean isDropON() {
        return dropON;
    }

    public static void setDropON(boolean dropON) {
        InicializadorBancoDados.dropON = dropON;
    }

    /*
     * Metodo que inicializa a conexão com o BD nesse caso DERBY
     */
    public static void inicializar() throws Exception {
        Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
    }

    /*
     * Metodo cria no bando de dados uma tabela Ticket com algumas colunas 
     */
    public static void criarBd() throws Exception {
        if (dropON) {
            DropTable();
        }
        Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
        Statement sta = con.createStatement();
        String sqlCurso = "CREATE TABLE Curso ("
                + "idCurso INTEGER NOT NULL generated always as identity(START with 1,increment by 1),"
                + "Nome VARCHAR(100),"
                + "idCoordenador Integer)";
        String sqlAlterCurso = "ALTER TABLE Curso ADD CONSTRAINT PK_Curso PRIMARY KEY (idCurso)";
        sta.executeUpdate(sqlCurso);
        sta.executeUpdate(sqlAlterCurso);

        String sqlEstado = "CREATE TABLE Estado ("
                + "idEstado INTEGER NOT NULL generated always as identity(START with 1,increment by 1),"
                + "Sigla VARCHAR(3),"
                + "Nome VARCHAR(100))";
        String sqlAlterEstado = "ALTER TABLE Estado ADD CONSTRAINT PK_Estado PRIMARY KEY (idEstado)";
        sta.executeUpdate(sqlEstado);
        sta.executeUpdate(sqlAlterEstado);
        String sqlCidade = "CREATE TABLE Cidade ("
                + "idCidade INTEGER NOT NULL generated always as identity(START with 1,increment by 1),"
                + " idEstado INTEGER NOT NULL,"
                + "Sigla VARCHAR(3),"
                + "Nome VARCHAR(100))";
        String sqlAlterCidade = "ALTER TABLE Cidade ADD CONSTRAINT PK_Cidade PRIMARY KEY (idCidade,idEstado)";
        sta.executeUpdate(sqlCidade);
        sta.executeUpdate(sqlAlterCidade);
        String sqlEmpresa = "CREATE TABLE Empresa("
                + "CNPJ VARCHAR(11) NOT NULL,"
                + "RazaoSocial VARCHAR(100),"
                + "Endereco VARCHAR(100),"
                + "Bairro VARCHAR(100),"
                + "CEP VARCHAR(8),"
                + "Telefone VARCHAR(10),"
                + "Email VARCHAR(100),"
                + "idCidade Integer,"
                + "idEstado Integer)";
        String sqlAlterEmpresa = "ALTER TABLE Empresa ADD CONSTRAINT PK_Empresa PRIMARY KEY (CNPJ)";
        sta.executeUpdate(sqlEmpresa);
        sta.executeUpdate(sqlAlterEmpresa);
        String sqlAluno = "CREATE TABLE Aluno ("
                + "Matricula VARCHAR(10) NOT NULL,"
                + "CPF VARCHAR(11),"
                + "RG VARCHAR(20),"
                + "Nome VARCHAR(100),"
                + "EstadoCivil VARCHAR(10),"
                + "Curso VARCHAR(100),"
                + "Semestre VARCHAR(2),"
                + "Endereco VARCHAR(100),"
                + "Bairro VARCHAR(100),"
                + "Cidade VARCHAR(100),"
                + "Estado VARCHAR(100),"
                + "CEP VARCHAR(8),"
                + "Telefone VARCHAR(10),"
                + "Email VARCHAR(100),"
                + "idCidade Integer,"
                + "idEstado Integer,"
                + "idCurso Integer)";
        String sqlAlterAluno = "ALTER TABLE Aluno ADD CONSTRAINT PK_Aluno PRIMARY KEY (Matricula)";
        String sqlAlterAlunoF = "ALTER TABLE Aluno ADD CONSTRAINT FK_Aluno_1 FOREIGN KEY (idCurso) REFERENCES Curso (idCurso)";
        sta.executeUpdate(sqlAluno);
        sta.executeUpdate(sqlAlterAlunoF);
        sta.executeUpdate(sqlAlterAluno);

        String sqlAlterCoodenador = "ALTER TABLE Coordenador ADD CONSTRAINT PK_Coordenador PRIMARY KEY (idCoordenador)";
        String sqlCoodenador = "CREATE TABLE Coordenador ("
                + "idCoordenador INTEGER NOT NULL generated always as identity(START with 1,increment by 1),"
                + "Nome VARCHAR(100),"
                + "email VARCHAR(100))";
        sta.executeUpdate(sqlCoodenador);
        sta.executeUpdate(sqlAlterCoodenador);

        String sqlSupervisor = "CREATE TABLE Supervisor ("
                + "idSupervisor INTEGER NOT NULL generated always as identity(START with 1,increment by 1),"
                + "CNPJ VARCHAR(11),"
                + "Nome VARCHAR(100),"
                + "Cargo VARCHAR(100),"
                + "Formacao VARCHAR(100),"
                + "email VARCHAR(100))";
        String sqlAlterSupervisor = "ALTER TABLE Supervisor ADD CONSTRAINT Supervisor PRIMARY KEY (idSupervisor)";
        sta.executeUpdate(sqlSupervisor);
        sta.executeUpdate(sqlAlterSupervisor);

        String sqlEstagio = "CREATE TABLE Estagio ("
                + "idEstagio  INTEGER NOT NULL generated always as identity(START with 1,increment by 1),"
                + "DataInicio DATE,"
                + "DataFim DATE,"
                + "HoraInicio1 DATE,"
                + "HoraFim1 DATE,"
                + "HoraInicio2 DATE,"
                + "HoraFim2 DATE,"
                + "cargaHoraria NUMERIC(10),"
                + "ValorBolsa DOUBLE PRECISION,"
                + "TipoValorBolsa NUMERIC(2),"
                + "DiaPagamento NUMERIC(2),"
                + "Objetivo VARCHAR(1000),"
                + "Atividades VARCHAR(1000),"
                + "StatusSupervisor VARCHAR(50),"
                + "parecerSupervisor VARCHAR(1000),"
                + "StatusCoordenador VARCHAR(50),"
                + "parecerCoordenador VARCHAR(1000),"
                + "CNPJ VARCHAR(11),"
                + "Matricula VARCHAR(10),"
                + "idSupervisor Integer,"
                + "idCoordenador Integer)";
        String sqlAlterEstagio = "ALTER TABLE Estagio ADD CONSTRAINT PK_Estagio PRIMARY KEY (idEstagio)";
        String sqlCidadeF = "ALTER TABLE Cidade ADD CONSTRAINT FK_Cidade_0 FOREIGN KEY (idEstado) REFERENCES Estado (idEstado)";
        String sqlEmpresaF = "ALTER TABLE Empresa ADD CONSTRAINT FK_Empresa_0 FOREIGN KEY (idCidade,idEstado) REFERENCES Cidade (idCidade,idEstado)";
        String sqlAlunoF = "ALTER TABLE Aluno ADD CONSTRAINT FK_Aluno_0 FOREIGN KEY (idCidade,idEstado) REFERENCES Cidade (idCidade,idEstado)";
        String sqlEstagioF = "ALTER TABLE Estagio ADD CONSTRAINT FK_Estagio_0 FOREIGN KEY (CNPJ) REFERENCES Empresa (CNPJ)";
        String sqlAlterEstagioF = "ALTER TABLE Estagio ADD CONSTRAINT FK_Estagio_1 FOREIGN KEY (Matricula) REFERENCES Aluno (Matricula)";
        String estagio2 = "ALTER TABLE Estagio ADD CONSTRAINT FK_Estagio_2 FOREIGN KEY (idSupervisor) REFERENCES Supervisor (idSupervisor)";
        String estagio3 = "ALTER TABLE Estagio ADD CONSTRAINT FK_Estagio_3 FOREIGN KEY (idCoordenador) REFERENCES Coordenador (idCoordenador)";
        String sqlCursoF = "ALTER TABLE Curso ADD CONSTRAINT FK_Curso_0 FOREIGN KEY (idCoordenador) REFERENCES Coordenador (idCoordenador)";
        sta.executeUpdate(sqlCursoF);
        sta.executeUpdate(sqlEstagio);
        sta.executeUpdate(sqlAlterEstagio);
        sta.executeUpdate(sqlCidadeF);
        sta.executeUpdate(sqlEmpresaF);
        sta.executeUpdate(sqlAlunoF);
        sta.executeUpdate(sqlEstagioF);
        sta.executeUpdate(sqlAlterEstagioF);
        sta.executeUpdate(estagio2);
        sta.executeUpdate(estagio3);

        sta.close();
        con.close();
    }

    /*
     * Metodo abaixo drop a tabela 
     */
    private static void DropTable() throws Exception {
        Connection conexao = null;
        PreparedStatement comando = null;
        String dropEstado = "DROP TABLE APP.ESTADO CASCADE CONSTRAINTS";
        String dropCidade = "DROP TABLE CIDADE cascade constraints";
        String dropEmpresa = "DROP TABLE EMPRESA cascade constraints";
        String dropAluno = "DROP TABLE ALUNO cascade constraints";
        String dropEstagio = "DROP TABLE ESTAGIO cascade constraints";
        String dropCoodenador = "DROP TABLE Coordenador cascade constraints";
        try {
            conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/" + dbName, "app", "app");
            comando = conexao.prepareStatement(dropEstado);
            comando.execute();
            comando = conexao.prepareStatement(dropCidade);
            comando = conexao.prepareStatement(dropEmpresa);
            comando = conexao.prepareStatement(dropAluno);
            comando = conexao.prepareStatement(dropEstagio);
            comando = conexao.prepareStatement(dropCoodenador);
            comando.execute();
            comando.close();
            conexao.close();
        } catch (Exception e) {
           // comando.execute();
          //  comando.close();
            conexao.close();
        }

    }

}
