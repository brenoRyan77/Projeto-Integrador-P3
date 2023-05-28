package br.com.uniesp.model.service.impl;

import java.util.List;

import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;

import br.com.uniesp.exception.ApplicationServiceException;
import br.com.uniesp.model.dto.UsuarioDTO;
import br.com.uniesp.model.entidade.Usuario;
import br.com.uniesp.model.repository.UsuarioRepository;
import br.com.uniesp.model.service.UsuarioService;
import br.com.uniesp.util.CpfRgUtil;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository repository;
	
	@Inject
	public UsuarioServiceImpl(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	@Transactional
	public Usuario incluir(@RequestBody UsuarioDTO dto) throws ApplicationServiceException {
		
		Usuario user = new Usuario();
		
		if(CpfRgUtil.validaCPF(dto.getCpf())) {
			user.setCpf(dto.getCpf());	
		}else {
			throw new ApplicationServiceException("message.erro.cpf.invalido");
		}
		
		Usuario userExiste = repository.buscarPorCpf(dto.getCpf());
		
		if(userExiste != null) {
			throw new ApplicationServiceException("message.erro.user.existente");
		}
		
		user.setEmail(dto.getEmail());
		user.setNome(dto.getNome());
		user.setRg(dto.getRg());
		user.setSobrenome(dto.getSobrenome());
		user.setTelefone(dto.getTelefone());
		
		repository.persist(user);
		
		return user;
	}

	@Override
	public Usuario buscarPorCpf(String cpf) throws ApplicationServiceException {
		
		if(CpfRgUtil.validaCPF(cpf)) {
			
			Usuario usuario = repository.buscarPorCpf(cpf);
			
			if(usuario == null) {
				throw new ApplicationServiceException("message.erro.buscar.cpf");
			}
			
			return usuario;
			
		}else {
			throw new ApplicationServiceException("message.erro.cpf.invalido");
		}
		
		
	}

	@Override
	@Transactional
	public void alterarUsuario(Long id, UsuarioDTO dto) throws ApplicationServiceException {
		
		Usuario usuario = repository.findById(id);
		
		if(usuario != null) {
			
			usuario.setNome(dto.getNome());
			usuario.setEmail(dto.getEmail());
			usuario.setRg(dto.getRg());
			usuario.setSobrenome(dto.getSobrenome());
			usuario.setTelefone(dto.getTelefone());
			usuario.setCpf(dto.getCpf());
			
		}else {
			throw new ApplicationServiceException("message.erro.user.inex");
		}
		
	}

	@Override
	public List<Usuario> listarTodos() throws ApplicationServiceException {
		return repository.findAll().list();
	}

	@Override
	@Transactional
	public void deletar(Long id) throws ApplicationServiceException {
		
		Usuario user = repository.findById(id);
		
		if(user != null) {
			repository.deleteById(user.getId());
			
		}else {
			throw new ApplicationServiceException("message.erro.user.inex");
		}
		
	}

	@Override
	public Usuario buscarUsuarioPorId(Long id) throws ApplicationServiceException {
		
		Usuario user = repository.findById(id);
		
		if(user == null) {
			throw new ApplicationServiceException("message.erro.user.inex");
		}
		return user;
	}

}
