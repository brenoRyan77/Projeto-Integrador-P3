package br.com.uniesp.model.service;

import java.util.List;

import br.com.uniesp.exception.ApplicationServiceException;
import br.com.uniesp.model.dto.UsuarioDTO;
import br.com.uniesp.model.entidade.Usuario;

public interface UsuarioService {

	Usuario incluir(UsuarioDTO dto) throws ApplicationServiceException;
	
	Usuario buscarPorCpf(String cpf) throws ApplicationServiceException;
	
	void alterarUsuario(Long id, UsuarioDTO dto) throws ApplicationServiceException;
	
	List<Usuario> listarTodos() throws ApplicationServiceException;
	
	void deletar(Long id) throws ApplicationServiceException;
	
	Usuario buscarUsuarioPorId(Long id) throws ApplicationServiceException;;
}
