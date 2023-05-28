package br.com.uniesp.rest;

import java.util.List;
import java.util.Set;

import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import br.com.uniesp.model.dto.EntityErrorDTO;
import br.com.uniesp.model.dto.UsuarioDTO;
import br.com.uniesp.model.entidade.Usuario;
import br.com.uniesp.model.service.UsuarioService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/usuario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(description = "Responsável por todas as operações relacionadas a Usuários.", name = "Usuário")
public class UsuarioResource {

	private UsuarioService service;
	private Validator validator;
	
	@Inject
	public UsuarioResource(UsuarioService service, Validator validator) {
		this.service = service;
		this.validator = validator;
	}
	
	@POST
	@Transactional
	public Response incluir(UsuarioDTO dto) {
		
		Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(dto);
		
		if(!violations.isEmpty()) {
			return EntityErrorDTO.createFromValidation(violations)
					.withStatusCode(EntityErrorDTO.UNPROCESSABLE_ENTITY_STATUS);
		}
		try {
			Usuario user = service.incluir(dto);
			return Response.status(Response.Status.CREATED.getStatusCode()).entity(user).build();
		}catch (Exception e) {
			return EntityErrorDTO.createFromException(e.getMessage())
					.withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
		}
	}
	
	@GET
	@Path("/{cpf}")
	public Response buscarPorCpf(@PathParam("cpf") String cpf) {
		
		try {
			Usuario user = service.buscarPorCpf(cpf);
			return Response.ok(user).build();
		}catch (Exception e) {
			return EntityErrorDTO.createFromException(e.getMessage())
					.withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
		}
	}
	
	@PUT
	@Path("/{id}")
	public Response alterar(@PathParam("id") Long id, UsuarioDTO dto) {
		
		Set<ConstraintViolation<UsuarioDTO>> violations = validator.validate(dto);
		
		if(!violations.isEmpty()) {
			return EntityErrorDTO.createFromValidation(violations)
					.withStatusCode(EntityErrorDTO.UNPROCESSABLE_ENTITY_STATUS);
		}
		
		try {
			service.alterarUsuario(id, dto);
			return Response.noContent().build();
		}catch (Exception e) {
			return EntityErrorDTO.createFromException(e.getMessage())
					.withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
		}
	}
	
	@GET
	public Response listarTodos() {
		
		try {
			List<Usuario> users = service.listarTodos();
			return Response.ok(users).build();
		}catch (Exception e) {
			return EntityErrorDTO.createFromException(e.getMessage())
					.withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
		}
	}
	
	@DELETE
	@Path("/{id}")
	public Response deletar(@PathParam("id") Long id) {
		
		try {
			service.deletar(id);
			return Response.noContent().build();
		}catch (Exception e) {
			return EntityErrorDTO.createFromException(e.getMessage())
					.withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
		}
	}
	
	@GET
	@Path("/{id}")
	public Response buscarUsuarioPorId(@PathParam("id") Long id) {
		
		try {
			Usuario user = service.buscarUsuarioPorId(id);
			return Response.ok(user).build();
		}catch (Exception e) {
			return EntityErrorDTO.createFromException(e.getMessage())
					.withStatusCode(Response.Status.BAD_REQUEST.getStatusCode());
		}
	}
}
