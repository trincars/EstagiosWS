package Negocio.DAO;

import Negocio.Entidades.Empresa;
import java.util.List;

public interface IEmpresaDAO {

	public List<Empresa> bucarListaEmpresas();
        public Empresa buscar(String CNPJ);

}
