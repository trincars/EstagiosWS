package Negocio;

import Negocio.DAO.IAlunoDAO;
import Negocio.DAO.ICoordenadorDAO;
import Negocio.DAO.ICursoDAO;
import Negocio.DAO.IEmpresaDAO;
import Negocio.DAO.IEstagioDAO;
import Negocio.DAO.ISupervisorDAO;
import Negocio.Model.ModelAluno;
import Negocio.Model.ModelSupervisor;
import Negocio.Model.ModelCoordenador;
import Persistencia.Derby.AlunoDAO_Derby;
import Persistencia.Derby.CoordenadorDAO_Derby;
import Persistencia.Derby.CursoDAO_Derby;
import Persistencia.Derby.EmpresaDAO_Derby;
import Persistencia.Derby.EstagioDAO_Derby;
import Persistencia.Derby.SupervisorDAO_Derby;
import Persistencia.InicializadorBancoDados;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FachadaEstagios {

    private ControladorSolicitacoes ctrlSolicitacoes;
    private IAlunoDAO alunoDAO;
    private IEmpresaDAO empresaDAO;
    private IEstagioDAO estagioDAO;
    private ISupervisorDAO supervisorDAO;
    private ICoordenadorDAO coordenadorDAO;
    private ICursoDAO cursoDAO;

    public FachadaEstagios() {
        try {
            // Inicialização do Banco //
            InicializadorBancoDados.inicializar();
        } catch (Exception ex) {
            Logger.getLogger(FachadaEstagios.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        alunoDAO = new AlunoDAO_Derby();
        empresaDAO = new EmpresaDAO_Derby();
        estagioDAO = new EstagioDAO_Derby();
        supervisorDAO = new SupervisorDAO_Derby();
        coordenadorDAO = new CoordenadorDAO_Derby();
        cursoDAO = new CursoDAO_Derby();


        
        ctrlSolicitacoes = new ControladorSolicitacoes(alunoDAO, empresaDAO, estagioDAO, supervisorDAO, coordenadorDAO, cursoDAO);
    }

    public ModelAluno buscar(ModelAluno model) {
        ModelAluno modelAluno = ctrlSolicitacoes.buscar(model);
        return modelAluno;
    }

    public void enviaEstagio(ModelAluno model) throws ParseException {
//        System.out.println(">>>>>>>>>>>> CHEGUEI <<<<<<<<<<<<");
//        System.out.println("Matricula: "+model.getMatricula());
//        System.out.println("Nome: "+model.getNome());
//        System.out.println("Semestre: "+model.getSemestre());
//        System.out.println("ListaEmpresas: "+model.getListaEmpresas());
//        //--------------------------
//        System.out.println("Empresa: "+model.getEmpresa());
//        //System.out.println("idEmpresa: "+model.getIdEmpresa() + " -> " + empresaDAO.buscar(model.getIdEmpresa()).getRazaoSocial());
//        System.out.println("DataInicio: "+model.getDataInicio());
//        System.out.println("DataFim: "+model.getDataFim());
//        System.out.println("HoraInicio1: "+model.getHoraInicio1());
//        System.out.println("HoraFim1: "+model.getHoraFim1());
//        System.out.println("CargaHoraria: "+model.getCargaHoraria());
//        System.out.println("IdEmpresa: "+model.getIdEmpresa());
//        System.out.println("TipoValorBolsa: "+model.getTipoValorBolsa());
//        System.out.println("ValorBolsa: "+model.getValorBolsa());
//        System.out.println("DiaPagamento: "+model.getDiaPagamento());
//        System.out.println("Objetivo: "+model.getObjetivo());
//        System.out.println("Atividades: "+model.getAtividades());
//        System.out.println(">>>>>>>>>>>> ====== <<<<<<<<<<<<");
        ctrlSolicitacoes.criarEstagio(model);
    }

    public ModelSupervisor busca(ModelSupervisor model) {
        ModelSupervisor modelSupervisor = ctrlSolicitacoes.busca(model);
        modelSupervisor=modelSupervisor;
        return modelSupervisor;
    }

    public ModelCoordenador buscaEstagio(ModelCoordenador model) {
        ModelCoordenador modelCoordenador = ctrlSolicitacoes.buscaEstagio(model);
        return modelCoordenador;

    }

    public void enviaAvaliacao(ModelSupervisor model) {
        ctrlSolicitacoes.enviaAvaliacao(model);
    }

    public ModelCoordenador busca(ModelCoordenador model) {
        ModelCoordenador modelCoordenador = ctrlSolicitacoes.busca(model);
        return modelCoordenador;
    }

    public void enviaAvaliacao(ModelCoordenador model) {
        ctrlSolicitacoes.enviaAvaliacao(model);
    }

    public ModelSupervisor buscaEstagio(ModelSupervisor model) {
        ModelSupervisor modelSupervisor = ctrlSolicitacoes.buscaEstagio(model);
        return modelSupervisor;
    }

}
