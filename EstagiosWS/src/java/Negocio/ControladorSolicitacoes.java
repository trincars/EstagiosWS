package Negocio;

import Negocio.DAO.IAlunoDAO;
import Negocio.DAO.ICoordenadorDAO;
import Negocio.DAO.ICursoDAO;
import Negocio.DAO.IEmpresaDAO;
import Negocio.DAO.IEstagioDAO;
import Negocio.DAO.ISupervisorDAO;
import Negocio.Entidades.Aluno;
import Negocio.Entidades.Coordenador;
import Negocio.Entidades.Curso;
import Negocio.Entidades.Empresa;
import Negocio.Model.ModelAluno;
import Negocio.Entidades.Estagio;
import Negocio.Entidades.Supervisor;
import Negocio.Model.ModelSupervisor;
import Negocio.Model.ModelCoordenador;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ControladorSolicitacoes {

    private IAlunoDAO alunoDAO;
    private IEmpresaDAO empresaDAO;
    private IEstagioDAO estagioDAO;
    private ISupervisorDAO supervisorDAO;
    private ICoordenadorDAO coordenadorDAO;
    private ICursoDAO cursoDAO;

    public ControladorSolicitacoes(IAlunoDAO alunoDAO, IEmpresaDAO empresaDAO, IEstagioDAO estagioDAO, ISupervisorDAO supervisorDAO, ICoordenadorDAO coordenadorDAO, ICursoDAO cursoDAO) {
        this.alunoDAO = alunoDAO;
        this.empresaDAO = empresaDAO;
        this.estagioDAO = estagioDAO;
        this.supervisorDAO = supervisorDAO;
        this.coordenadorDAO = coordenadorDAO;
        this.cursoDAO = cursoDAO;
    }




    
    public ModelAluno buscar(ModelAluno model) {
        String matricula = model.getMatricula();
        Aluno aluno = alunoDAO.buscarMatricula(matricula);
        model.setNome(aluno.getNome());
        model.setSemestre(aluno.getSemestre());

        List<Empresa> empresas = empresaDAO.bucarListaEmpresas();
        List<String> listaIdEmpresas  = new ArrayList<String>();
        List<String> listaEmpresas = new ArrayList<String>();
        List<String> listaIdSupervisor = new ArrayList<String>();

        for (Empresa empresa : empresas) {
            listaIdEmpresas.add(empresa.getCNPJ());
            listaEmpresas.add(empresa.getRazaoSocial());
            listaIdSupervisor.add(supervisorDAO.buscaSupervisorPeloIdEmpresa(empresa.getCNPJ()).getIdSupervisor());
        }
        
        model.setListaIdEmpresa(listaIdEmpresas);
        model.setListaEmpresas(listaEmpresas);
        model.setListaIdSupervisor(listaIdSupervisor);

        return model;
    }

    public void criarEstagio(ModelAluno model) throws ParseException {
        Estagio estagio =  extraiEstagio(model);
        
        estagioDAO.gravarEstagio(estagio);
    }
    
    
    
    private Estagio extraiEstagio(ModelAluno model) throws ParseException{
        // DATAS //
        String dataStr="";
        SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
        
        dataStr = model.getDataInicio();
        Date dataInicio = new Date(formatDate.parse(dataStr).getTime());

        dataStr = model.getDataFim();
        Date dataFim = new Date(formatDate.parse(dataStr).getTime());

        // HORARIOS //
        formatDate = new SimpleDateFormat("HH:mm");
        String horarioStr = "";

        horarioStr = model.getHoraInicio1();
        Date horaInicio1 = new Date(formatDate.parse(horarioStr).getTime());
        
        horarioStr = model.getHoraFim1();
        Date horaFim1 = new Date(formatDate.parse(horarioStr).getTime());
        
        horarioStr = model.getHoraInicio2();
        Date horaInicio2 = new Date(formatDate.parse(horarioStr).getTime());
        
        horarioStr = model.getHoraFim2();
        Date horaFim2 = new Date(formatDate.parse(horarioStr).getTime());
        
        
        int cargaHoraria = Integer.parseInt(model.getCargaHoraria());
        double valorBolsa = 0;
        //valorBolsa = Double.parseDouble(model.getValorBolsa());
        int tipoValorBolsa = 0;
        //tipoValorBolsa = Integer.parseInt(model.getTipoValorBolsa());
        int diaPagamento = Integer.parseInt(model.getDiaPagamento());
        
        
        String objetivo = model.getObjetivo();
        String atividades = model.getAtividades();
        
        // AVALIACAO //
        String statusSupervisor = "NAO AVALIADO";
        String parecerSupervisor = "";
        String statusCoordenador = "NAO AVALIADO";
        String parecerCoordenador = "";

        String empresa = model.getIdEmpresa();
        String aluno = model.getMatricula();
        String supervisor = model.getIdSupervisor();
        
        // BUSCAR COORDENADOR //
        Aluno al = alunoDAO.buscarMatricula(model.getMatricula());
        Curso cursoAl = cursoDAO.busca(al.getIdCurso());
        String coordenador = cursoAl.getCoordenador().getId();
        
        Estagio estagio = new Estagio(1,
                                      dataInicio, dataFim, 
                                      horaInicio1, horaFim1, horaInicio2, horaFim2,
                                      cargaHoraria, valorBolsa, tipoValorBolsa, diaPagamento,
                                      objetivo, atividades,
                                      statusSupervisor, parecerSupervisor,
                                      statusCoordenador, parecerCoordenador,
                                      empresa, aluno, supervisor, coordenador);

        return estagio;
    }

    public ModelSupervisor busca(ModelSupervisor model) {
        Supervisor supervisor = supervisorDAO.busca(model.getId());
        model.setNome(supervisor.getNome());
        List<Estagio> estagios = estagioDAO.buscaEstagiosSupervisor(model.getId());
        List<String> listaIdEstagios = new ArrayList<String>();
        List<String> listaAlunos = new ArrayList<String>();
        
        for(Estagio estagio : estagios){
            listaIdEstagios.add(estagio.getIdEstagio()+"");
            Aluno aluno = alunoDAO.buscarMatricula(estagio.getAluno());
            listaAlunos.add(aluno.getNome());
        }
        model.setAlunos(listaAlunos);
        model.setListaIdEstagios(listaIdEstagios);
        
        return model;
    }

    public ModelCoordenador buscaEstagio(ModelCoordenador model) {
        Estagio estagio = estagioDAO.buscaEstagio(model.getIdEstagio());
        // ATUALIZA O MODEL COM AS INFORMAÇÕES DO ESTAGIO //
        atualizaModelCoordenador(model, estagio);
        return model;
    }

    public void enviaAvaliacao(ModelSupervisor model) {
        // BUSCA ESTÁGIO
        Estagio estagio = estagioDAO.buscaEstagio(model.getIdEstagio());
        // ATUALIZA PARECER DO SUPERVISOR
        estagio.setParecerSupervisor(model.getParecer());
        // ATUALIZA STATUS DO SUPERVISOR
        estagio.setStatusSupervisor(model.getStatus());
        // ATUALIZA ESTÁGIO NO BANCO
        estagioDAO.atualizaStatusSupervisor(estagio);
    }

    public void notificaStatus() {

    }

    public ModelCoordenador busca(ModelCoordenador model) {
        Coordenador coordenador = coordenadorDAO.busca(model.getId());
        model.setNome(coordenador.getNome());
        
        List<Estagio> estagios = estagioDAO.buscaEstagiosCoordenador(model.getId());
        List<String> listaIdEstagios = new ArrayList<String>();
        List<String> listaAlunos = new ArrayList<String>();
        
        for(Estagio estagio : estagios){
            listaIdEstagios.add(estagio.getIdEstagio()+"");
            Aluno aluno = alunoDAO.buscarMatricula(estagio.getAluno());
            listaAlunos.add(aluno.getNome());
        }
        model.setAlunos(listaAlunos);
        model.setListaIdEstagios(listaIdEstagios);

        return model;
    }

    public void enviaAvaliacao(ModelCoordenador model) {
        // BUSCA ESTÁGIO
        Estagio estagio = estagioDAO.buscaEstagio(model.getIdEstagio());
        // ATUALIZA PARECER DO SUPERVISOR
        estagio.setParecerCoordenador(model.getParecer());
        // ATUALIZA STATUS DO SUPERVISOR
        estagio.setStatusCoordenador(model.getStatus());
        // ATUALIZA ESTÁGIO NO BANCO
        estagioDAO.atualizaStatusCoordenador(estagio);
    }

    public ModelSupervisor buscaEstagio(ModelSupervisor model) {
        Estagio estagio = estagioDAO.buscaEstagio(model.getIdEstagio());
        // ATUALIZA O MODEL COM AS INFORMAÇÕES DO ESTAGIO //
        atualizaModelSupervisor(model, estagio);
        
        return model;
    }
    
    private void atualizaModelSupervisor(ModelSupervisor model, Estagio estagio){
        Aluno aluno = alunoDAO.buscarMatricula(estagio.getAluno());
        model.setNomeAluno(aluno.getNome());
        model.setSemestre(aluno.getSemestre());
        
        //SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        //String result = out.format(in.parse(date.toString())); 
        model.setDataInicial(estagio.getDataInicio().toString());
        model.setDataInicial(estagio.getDataFim().toString());
        model.setHoraInicio1(estagio.getHoraInicio1().toString());
        model.setHoraFim1(estagio.getHoraFim1().toString());
        model.setCargaHoraria(estagio.getCargaHoraria()+"");
        model.setObjetivo(estagio.getObjetivo());
        model.setAtividades(estagio.getAtividades());
    }
    
    private void atualizaModelCoordenador(ModelCoordenador model, Estagio estagio){
        Aluno aluno = alunoDAO.buscarMatricula(estagio.getAluno());
        model.setNomeAluno(aluno.getNome());
        model.setSemestre(aluno.getSemestre());
        
        //SimpleDateFormat in= new SimpleDateFormat("yyyy-MM-dd");
        //SimpleDateFormat out = new SimpleDateFormat("dd/MM/yyyy");
        //String result = out.format(in.parse(date.toString())); 
        model.setDataInicial(estagio.getDataInicio().toString());
        model.setDataInicial(estagio.getDataFim().toString());
        model.setHoraInicio1(estagio.getHoraInicio1().toString());
        model.setHoraFim1(estagio.getHoraFim1().toString());
        model.setCargaHoraria(estagio.getCargaHoraria()+"");
        model.setObjetivo(estagio.getObjetivo());
        model.setAtividades(estagio.getAtividades());
    }

}
