/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servico;

import Negocio.FachadaEstagios;
import Negocio.Model.ModelSupervisor;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author 00280076
 */
@WebService(serviceName = "EstagiosWSSupervisor")
public class EstagiosWSSupervisor {
    private FachadaEstagios fachaEstagios;

    public EstagiosWSSupervisor() {
        fachaEstagios = new FachadaEstagios();
    }
    
    
    /**
     * This is a sample web service operation
     * @param model
     * @return 
     */
    //@WebMethod(operationName = "hello")
    //public String hello(@WebParam(name = "name") String txt) {
    //    return "Hello " + txt + " !";
    //}

    @WebMethod(operationName = "buscarSupervisor")
    public ModelSupervisor buscaSupervisor(ModelSupervisor model) {
        ModelSupervisor modelSupervisor = fachaEstagios.busca(model);
        return modelSupervisor;
    }

    @WebMethod(operationName = "buscarEstagioSupervisor")
    public ModelSupervisor buscaEstagioSupervisor(ModelSupervisor model) {
        ModelSupervisor modelSupervisor = fachaEstagios.buscaEstagio(model);
        return modelSupervisor;
    }

    @WebMethod(operationName = "enviarAvaliacaoSupervisor")
    public void enviaAvaliacaoSupervisor(ModelSupervisor model) {
        fachaEstagios.enviaAvaliacao(model);
    }

}
