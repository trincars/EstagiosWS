/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Negocio.DAO;

import Negocio.Entidades.Curso;

/**
 *
 * @author 00280076
 */
public interface ICursoDAO {
    
    public Curso busca(String idCurso);
    public int buscaCoordenador(String idCurso);
}
