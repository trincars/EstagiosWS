package Negocio.Model;

import java.util.List;

public class ModelCoordenador {

    // COORDENADOR //
    private String id;
    private String nome;
    private String parecer;
    private String status;
    
    // SUPERVISOR //
    private String idSupervisor;
    private String nomeSupervisor;
    private String parecerSupervisor;
    private String statusSupervisor;
    
    // ALUNO //
    private String matricula;
    private String nomeAluno;
    private String semestre;
    
    // EMPRESA //
    private String idEmpresa;
    private String empresa;

    // ESTAGIO //
    private String idEstagio;
    private String dataInicial;
    private String dataFinal;
    private String horaInicio1;
    private String horaFim1;
    private String cargaHoraria;
    private String objetivo;
    private String atividades;

    // LISTAS //
    private List<String> alunos;
    private List<String> listaIdEstagios;

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getParecer() {
        return parecer;
    }

    public String getStatus() {
        return status;
    }

    public String getIdSupervisor() {
        return idSupervisor;
    }

    public String getNomeSupervisor() {
        return nomeSupervisor;
    }

    public String getParecerSupervisor() {
        return parecerSupervisor;
    }

    public String getStatusSupervisor() {
        return statusSupervisor;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public String getSemestre() {
        return semestre;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getIdEstagio() {
        return idEstagio;
    }

    public String getDataInicial() {
        return dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public String getHoraInicio1() {
        return horaInicio1;
    }

    public String getHoraFim1() {
        return horaFim1;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getAtividades() {
        return atividades;
    }

    public List<String> getAlunos() {
        return alunos;
    }

    public List<String> getListaIdEstagios() {
        return listaIdEstagios;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setParecer(String parecer) {
        this.parecer = parecer;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setIdSupervisor(String idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public void setNomeSupervisor(String nomeSupervisor) {
        this.nomeSupervisor = nomeSupervisor;
    }

    public void setParecerSupervisor(String parecerSupervisor) {
        this.parecerSupervisor = parecerSupervisor;
    }

    public void setStatusSupervisor(String statusSupervisor) {
        this.statusSupervisor = statusSupervisor;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setIdEstagio(String idEstagio) {
        this.idEstagio = idEstagio;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public void setHoraInicio1(String horaInicio1) {
        this.horaInicio1 = horaInicio1;
    }

    public void setHoraFim1(String horaFim1) {
        this.horaFim1 = horaFim1;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public void setAlunos(List<String> alunos) {
        this.alunos = alunos;
    }

    public void setListaIdEstagios(List<String> listaIdEstagios) {
        this.listaIdEstagios = listaIdEstagios;
    }
    
    
    
}
