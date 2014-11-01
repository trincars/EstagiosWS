package Negocio.Entidades;

public class Supervisor {

	private String idSupervisor;
        private String CNPJ;
	private String nome;
	private String cargo;
	private String formacao;
	private String email;

    public Supervisor() {
    }

    public Supervisor(String idSupervisor, String CNPJ, String nome, String cargo, String formacao, String email) {
        this.idSupervisor = idSupervisor;
        this.CNPJ = CNPJ;
        this.nome = nome;
        this.cargo = cargo;
        this.formacao = formacao;
        this.email = email;
    }

    public String getIdSupervisor() {
        return idSupervisor;
    }

    public void setIdSupervisor(String idSupervisor) {
        this.idSupervisor = idSupervisor;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getFormacao() {
        return formacao;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
