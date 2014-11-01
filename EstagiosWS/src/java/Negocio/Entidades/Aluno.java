package Negocio.Entidades;

public class Aluno {

    private String Matricula;
    private String CPF;
    private String RG;
    private String Nome;
    private String EstadoCivil;
    //private String Curso;
    private String Semestre;
    private String Endereco;
    private String Bairro;
    private String Cidade;
    private String Estado;
    private String CEP;
    private String Telefone;
    private String Email;
    
    private Curso curso;
    private String idCurso;

    public Aluno(String Matricula, String CPF, String RG, String Nome, String EstadoCivil, String Semestre, String Endereco, String Bairro, String Cidade, String Estado, String CEP, String Telefone, String Email, Curso curso) {
        this.Matricula = Matricula;
        this.CPF = CPF;
        this.RG = RG;
        this.Nome = Nome;
        this.EstadoCivil = EstadoCivil;
        this.Semestre = Semestre;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
        this.Cidade = Cidade;
        this.Estado = Estado;
        this.CEP = CEP;
        this.Telefone = Telefone;
        this.Email = Email;
        this.curso = curso;
        this.idCurso= curso.getIdCurso()+"";
    }



    public String getMatricula() {
        return Matricula;
    }

    public void setMatricula(String Matricula) {
        this.Matricula = Matricula;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getEstadoCivil() {
        return EstadoCivil;
    }

    public void setEstadoCivil(String EstadoCivil) {
        this.EstadoCivil = EstadoCivil;
    }

//    public String getCurso() {
//        return Curso;
//    }
//
//    public void setCurso(String Curso) {
//        this.Curso = Curso;
//    }

    public String getSemestre() {
        return Semestre;
    }

    public void setSemestre(String Semestre) {
        this.Semestre = Semestre;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String Endereco) {
        this.Endereco = Endereco;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public String getCidade() {
        return Cidade;
    }

    public void setCidade(String Cidade) {
        this.Cidade = Cidade;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Curso getCurso() {
        return curso;
    }

    public String getIdCurso() {
        return idCurso;
    }
    
    
}
