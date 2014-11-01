/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.Entidades;

/**
 *
 * @author 00280076
 */
public class Curso {
    private int idCurso;
    private String nome;
    private Coordenador coordenador;

    public Curso() {
        idCurso=1;
        nome="";
        coordenador=null;
    }

    
    public Curso(int idCurso, String nome, Coordenador coordenador) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.coordenador = coordenador;
    }
    

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }
}
