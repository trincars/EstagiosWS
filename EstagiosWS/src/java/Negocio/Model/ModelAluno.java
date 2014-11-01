package Negocio.Model;

import java.util.ArrayList;
import java.util.List;

public class ModelAluno {

    // ALUNO //
    private String matricula="";
    private String nome="";
    private String semestre="";

    // SELECAO DE DADOS INICIAIS //
    private List<String> listaIdEmpresa;
    private List<String> listaEmpresas;
    private List<String> listaIdSupervisor;

    // ESTAGIO //
    private String dataInicio="";
    private String dataFim;
    private String horaInicio1;
    private String horaFim1;
    private String horaInicio2;
    private String horaFim2;
    private String cargaHoraria;
    private String valorBolsa;
    private String tipoValorBolsa;
    private String diaPagamento;
    private String objetivo;
    private String atividades;

    // AVALIACAO //
    private String idEmpresa;
    private String empresa;
    private String idSupervisor;
    private String idCoordenador;

    public ModelAluno() {
        this.listaIdEmpresa = new ArrayList<>();
        this.listaEmpresas = new ArrayList<>();
        this.listaIdSupervisor = new ArrayList<>();
        this.dataFim = "01/01/1901";
        this.horaInicio1 = "00:00";
        this.horaFim1 = "00:00";
        this.horaInicio2 = "00:00";
        this.horaFim2 = "00:00";
        this.cargaHoraria = "0";
        this.valorBolsa = "0";
        this.tipoValorBolsa = "0";
        this.diaPagamento = "1";
        this.objetivo = "";
        this.atividades = "";
        this.idEmpresa = "";
        this.empresa = "";
        this.idSupervisor = "";
        this.idCoordenador = "";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public List<String> getListaIdEmpresa() {
        return listaIdEmpresa;
    }

    public void setListaIdEmpresa(List<String> listaIdEmpresa) {
        this.listaIdEmpresa = listaIdEmpresa;
    }

    public List<String> getListaEmpresas() {
        return listaEmpresas;
    }

    public void setListaEmpresas(List<String> listaEmpresas) {
        this.listaEmpresas = listaEmpresas;
    }

    public List<String> getListaIdSupervisor() {
        return listaIdSupervisor;
    }

    public void setListaIdSupervisor(List<String> listaIdSupervisor) {
        this.listaIdSupervisor = listaIdSupervisor;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHoraInicio1() {
        return horaInicio1;
    }

    public void setHoraInicio1(String horaInicio1) {
        this.horaInicio1 = horaInicio1;
    }

    public String getHoraFim1() {
        return horaFim1;
    }

    public void setHoraFim1(String horaFim1) {
        this.horaFim1 = horaFim1;
    }

    public String getHoraInicio2() {
        return horaInicio2;
    }

    public void setHoraInicio2(String horaInicio2) {
        this.horaInicio2 = horaInicio2;
    }

    public String getHoraFim2() {
        return horaFim2;
    }

    public void setHoraFim2(String horaFim2) {
        this.horaFim2 = horaFim2;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(String valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public String getTipoValorBolsa() {
        return tipoValorBolsa;
    }

    public void setTipoValorBolsa(String tipoValorBolsa) {
        this.tipoValorBolsa = tipoValorBolsa;
    }

    public String getDiaPagamento() {
        return diaPagamento;
    }

    public void setDiaPagamento(String diaPagamento) {
        this.diaPagamento = diaPagamento;
    }

    public String getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(String objetivo) {
        this.objetivo = objetivo;
    }

    public String getAtividades() {
        return atividades;
    }

    public void setAtividades(String atividades) {
        this.atividades = atividades;
    }

    public String getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(String idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(String idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getIdCoordenador() {
        return idCoordenador;
    }

    public void setIdCoordenador(String idCoordenador) {
        this.idCoordenador = idCoordenador;
    }

    
}
