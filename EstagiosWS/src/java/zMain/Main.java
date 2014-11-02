/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package zMain;

import Persistencia.InicializadorBancoDados;

/**
 *
 * @author paulo.bittencourt
 */
public class Main {
    public static void main(String[] args) throws Exception {
        // Inicialização do Banco //
        
        //
        InicializadorBancoDados.inicializar();
        InicializadorBancoDados.setDropON(true);
        InicializadorBancoDados.criarBd();
    }
}
