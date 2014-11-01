package Negocio.Entidades;

public class Empresa {

    public Empresa() {
    }

    private String CNPJ;
    private String RazaoSocial;
    private String Endereco;
    private String Bairro;
    private String CEP;
    private String Telefone;
    private String email;
    private String Cidade;
    private String Estado;

    
    public Empresa(String CNPJ, String RazaoSocial, String Endereco, String Bairro, String CEP, String Telefone, String email) {
        this.CNPJ = CNPJ;
        this.RazaoSocial = RazaoSocial;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Telefone = Telefone;
        this.email = email;
    }

    public Empresa(String CNPJ, String RazaoSocial, String Endereco, String Bairro, String CEP, String Telefone, String email, String Cidade, String Estado) {
        this.CNPJ = CNPJ;
        this.RazaoSocial = RazaoSocial;
        this.Endereco = Endereco;
        this.Bairro = Bairro;
        this.CEP = CEP;
        this.Telefone = Telefone;
        this.email = email;
        this.Cidade = Cidade;
        this.Estado = Estado;
    }
    
    

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getRazaoSocial() {
        return RazaoSocial;
    }

    public void setRazaoSocial(String RazaoSocial) {
        this.RazaoSocial = RazaoSocial;
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
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


}
