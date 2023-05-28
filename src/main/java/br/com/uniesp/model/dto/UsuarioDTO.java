package br.com.uniesp.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioDTO {

	@NotBlank(message = "O nome do usuário é obrigatório.")
	@Size(min = 3, max = 100, message = "O nome precisa ter entre 3 a 100 caracteres.")
	@Pattern(regexp = "^[\\p{L}\\s]+$", message = "O campo 'nome' deve conter apenas letras e espaços.")
	private String nome;
	
	@Size(min = 3, max = 100, message = "O nome precisa ter entre 3 a 100 caracteres.")
	@Pattern(regexp = "^[\\p{L}\\s]+$", message = "O campo 'nome' deve conter apenas letras e espaços.")
	@NotBlank(message = "O sobrenome do usuário é obrigatório.")
	private String sobrenome;
	
	@NotBlank(message = "O email do usuário é obrigatório.")
	@Email(message = "Digite um email válido.")
	private String email;
	
	@NotBlank(message = "O CPF do usuário é obrigatório.")
	@Pattern(regexp = "^[0-9]+$", message = "O CPF do usuário deve conter apenas números.")
	@Size(max = 14, message = "O CPF do usuário deve ter no máximo {max} caracteres.")
	private String cpf;
	
	@NotBlank(message = "O RG do usuário é obrigatório.")
	@Pattern(regexp = "^[0-9]+$", message = "O RG do usuário deve conter apenas números.")
	@Size(max = 9, message = "O RG do usuário deve ter no máximo {max} caracteres.")
	private String rg;
	
	@NotBlank(message = "O telefone do usuário é obrigatório.")
	@Pattern(regexp = "^[0-9]+$", message = "O telefone do usuário deve conter apenas números.")
	private String telefone;
}
