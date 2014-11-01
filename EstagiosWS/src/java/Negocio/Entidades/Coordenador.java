package Negocio.Entidades;

public class Coordenador {

	private String id;
	private String nome;
	private String email;

    public Coordenador(String id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Coordenador() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

                           
}
