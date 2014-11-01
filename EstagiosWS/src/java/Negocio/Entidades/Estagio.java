package Negocio.Entidades;

import java.sql.Date;



public class Estagio {

    private int idEstagio;
    private Date dataInicio;
    private Date dataFim;
    private Date horaInicio1;
    private Date horaFim1;
    private Date horaInicio2;
    private Date horaFim2;
    private int cargaHoraria;
    private double valorBolsa;
    private int tipoValorBolsa;
    private int diaPagamento;
    private String objetivo;
    private String atividades;
    private String statusSupervisor;
    private String parecerSupervisor;
    private String statusCoordenador;
    private String parecerCoordenador;
    
    private String empresa;
    private String aluno;
    private String supervisor;
    private String coordenador;

    public Estagio(int idEstagio, Date dataInicio, Date dataFim, Date horaInicio1, Date horaFim1, Date horaInicio2, Date horaFim2, int cargaHoraria, double valorBolsa, int tipoValorBolsa, int diaPagamento, String objetivo, String atividades, String statusSupervisor, String parecerSupervisor, String statusCoordenador, String parecerCoordenador, String empresa, String aluno, String supervisor, String coordenador) {
        this.idEstagio = idEstagio;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.horaInicio1 = horaInicio1;
        this.horaFim1 = horaFim1;
        this.horaInicio2 = horaInicio2;
        this.horaFim2 = horaFim2;
        this.cargaHoraria = cargaHoraria;
        this.valorBolsa = valorBolsa;
        this.tipoValorBolsa = tipoValorBolsa;
        this.diaPagamento = diaPagamento;
        this.objetivo = objetivo;
        this.atividades = atividades;
        this.statusSupervisor = statusSupervisor;
        this.parecerSupervisor = parecerSupervisor;
        this.statusCoordenador = statusCoordenador;
        this.parecerCoordenador = parecerCoordenador;
        
        this.empresa = empresa;
        this.aluno = aluno;
        this.supervisor = supervisor;
        this.coordenador = coordenador;
    }

    public int getIdEstagio() {
        return idEstagio;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public Date getHoraInicio1() {
        return horaInicio1;
    }

    public Date getHoraFim1() {
        return horaFim1;
    }

    public Date getHoraInicio2() {
        return horaInicio2;
    }

    public Date getHoraFim2() {
        return horaFim2;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public double getValorBolsa() {
        return valorBolsa;
    }

    public int getTipoValorBolsa() {
        return tipoValorBolsa;
    }

    public int getDiaPagamento() {
        return diaPagamento;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public String getAtividades() {
        return atividades;
    }

    public String getStatusSupervisor() {
        return statusSupervisor;
    }

    public String getParecerSupervisor() {
        return parecerSupervisor;
    }

    public String getStatusCoordenador() {
        return statusCoordenador;
    }

    public String getParecerCoordenador() {
        return parecerCoordenador;
    }

    public String getEmpresa() {
        return empresa;
    }

    public String getAluno() {
        return aluno;
    }

    public String getSupervisor() {
        return supervisor;
    }

    public String getCoordenador() {
        return coordenador;
    }

    public void setIdEstagio(int idEstagio) {
        this.idEstagio = idEstagio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public void setHoraInicio1(Date horaInicio1) {
        this.horaInicio1 = horaInicio1;
    }

    public void setHoraFim1(Date horaFim1) {
        this.horaFim1 = horaFim1;
    }

    public void setHoraInicio2(Date horaInicio2) {
        this.horaInicio2 = horaInicio2;
    }

    public void setHoraFim2(Date horaFim2) {
        this.horaFim2 = horaFim2;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public void setValorBolsa(double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public void setTipoValorBolsa(int tipoValorBolsa) {
        this.tipoValorBolsa = tipoValorBolsa;
    }

    public void setDiaPagamento(int diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public void setStatusSupervisor(String statusSupervisor) {
        this.statusSupervisor = statusSupervisor;
    }

    public void setParecerSupervisor(String parecerSupervisor) {
        this.parecerSupervisor = parecerSupervisor;
    }

    public void setStatusCoordenador(String statusCoordenador) {
        this.statusCoordenador = statusCoordenador;
    }

    public void setParecerCoordenador(String parecerCoordenador) {
        this.parecerCoordenador = parecerCoordenador;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public void setAluno(String aluno) {
        this.aluno = aluno;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor;
    }

    public void setCoordenador(String coordenador) {
        this.coordenador = coordenador;
    }

    
    
}
