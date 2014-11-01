package Negocio.DAO;

import Negocio.Entidades.Supervisor;

public interface ISupervisorDAO {

	public Supervisor busca(String idSupervisor);
        public Supervisor buscaSupervisorPeloIdEmpresa(String CNPJ);

}
