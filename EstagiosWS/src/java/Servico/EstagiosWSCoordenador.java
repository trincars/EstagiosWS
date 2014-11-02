/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servico;

import Negocio.FachadaEstagios;
import Negocio.Model.ModelCoordenador;
import javax.jws.WebService;
import javax.jws.WebMethod;

/**
 *
 * @author 00280076
 */
@WebService(serviceName = "EstagiosWSCoordenador")
public class EstagiosWSCoordenador {
    private FachadaEstagios fachaEstagios;

    public EstagiosWSCoordenador() {
        fachaEstagios = new FachadaEstagios();
    }
    

    /**
     * This is a sample web service operation
     */
//    @WebMethod(operationName = "hello")
//    public String hello(@WebParam(name = "name") String txt) {
//        return "Hello " + txt + " !";
//    }
    
    @WebMethod(operationName = "buscarCoordenador")
    public ModelCoordenador buscaCoordenador(ModelCoordenador model) {
        ModelCoordenador modelCoordenador = fachaEstagios.busca(model);
        return modelCoordenador;
    }

    @WebMethod(operationName = "buscarEstagioCoordenador")
    public ModelCoordenador buscaEstagioCoordenador(ModelCoordenador model) {
        ModelCoordenador modelCoordenador = fachaEstagios.buscaEstagio(model);
        return modelCoordenador;
    }
    
    @WebMethod(operationName = "enviarAvaliacaoCoordenador")
    public void enviaAvaliacaoCoordenador(ModelCoordenador model) {
        fachaEstagios.enviaAvaliacao(model);
    }
}
