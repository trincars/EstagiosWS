/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Negocio.FachadaEstagios;
import Negocio.Model.ModelAluno;
import java.text.ParseException;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author 00280076
 */
@WebService(serviceName = "EstagioWSAluno")
public class EstagioWSAluno {

    private FachadaEstagios fachaEstagios;

    public EstagioWSAluno() {
        fachaEstagios = new FachadaEstagios();
    }

    /**
     * This is a sample web service operation
     *
     * @param model
     * @return
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
    @WebMethod(operationName = "buscarAluno")
    public ModelAluno buscarAluno(ModelAluno model) {
        ModelAluno modelAluno = fachaEstagios.buscar(model);
        //ModelAluno modelAluno = new ModelAluno();
        modelAluno.setAtividades("dasdasda");
        modelAluno.setCargaHoraria("vxcvxcd");
        return modelAluno;
    }

    @WebMethod(operationName = "enviarEstagio")
    public void enviarEstagioAluno(ModelAluno model) throws ParseException {
        System.out.println(">>>>>>>>>>>>>> ESTOU INDO <<<<<<<<<<<<<");
        fachaEstagios.enviaEstagio(model);
    }

}
