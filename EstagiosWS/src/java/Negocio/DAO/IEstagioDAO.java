package Negocio.DAO;

import Negocio.Entidades.Estagio;
import java.util.List;
import Negocio.Entidades.Coordenador;

public interface IEstagioDAO {

	public void gravarEstagio(Estagio estagio);

	public List<Estagio> buscaEstagiosSupervisor(String idSupervisor);

	public Estagio buscaEstagio(String idEstagio);

	public void atualizaStatusSupervisor(Estagio estagio);
        
        public void atualizaStatusCoordenador(Estagio estagio);

	public List<Estagio> buscaEstagiosCoordenador(String idCoordenador);

}
