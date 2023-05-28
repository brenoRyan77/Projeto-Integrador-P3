package br.com.uniesp.model.repository;

import br.com.uniesp.model.entidade.Usuario;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioRepository implements PanacheRepository<Usuario>{
	
	public Usuario buscarPorCpf(String cpf) {
		
		var param = Parameters.with("cpf", cpf).map();
		
		PanacheQuery<Usuario> query = find("cpf = :cpf", param);
		
		return query.firstResult();
	}

}
