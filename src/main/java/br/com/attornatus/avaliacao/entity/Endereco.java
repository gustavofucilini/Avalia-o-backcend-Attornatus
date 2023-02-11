package br.com.attornatus.avaliacao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import br.com.attornatus.avaliacao.validation.AoAlterar;
import br.com.attornatus.avaliacao.validation.AoInserir;

@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Endereco")
@Table(name = "enderecos")
public class Endereco {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "O ID do endereço e obrigatorio", groups = AoAlterar.class)
	@Null(message = "O ID do endereco deve ser nulo", groups = AoInserir.class)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "logradouro")
	@NotNull(message = "O logradouro do endereco deve ser informado")
	@Size(min = 2,max = 124,message = "A quantidade de caracterees do logradouro deve ser entre 2 a 124 caracteres")
	private String logradouro;

	@Column(name = "cep")
	@NotNull(message = "O cep do endereco não deve ser nulo")
	@Positive(message = "O valor do cep deve ser positivo")
	private Integer cep;
	
	@Column(name = "numero")
	@NotNull(message = "O numero do endereco não deve ser nulo")
	@Positive(message = "O valor do numero deve ser positivo")
	private Integer numero;
	
	@Column(name = "cidade")
	@NotNull(message = "A cidade do endereco deve ser informado")
	@Size(min = 2,max = 124,message = "A quantidade de caracterees da cidade deve ser entre 2 a 124 caracteres")
	private String cidade;
	
}
