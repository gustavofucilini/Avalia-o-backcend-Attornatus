package br.com.attornatus.avaliacao.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import br.com.attornatus.avaliacao.validation.AoAlterar;
import br.com.attornatus.avaliacao.validation.AoInserir;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity(name = "Pessoa")
@Table(name = "pessoas")
public class Pessoa {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull(message = "O ID da pessoa e obrigatorio", groups = AoAlterar.class)
	@Null(message = "O ID da pessoa deve ser nulo", groups = AoInserir.class)
	@EqualsAndHashCode.Include
	private Integer id;
	
	@Column(name = "nome")
	@NotNull(message = "O nome da pessoa deve ser informado")
	@Size(min = 2,max = 124,message = "A quantidade de caracterees do nome deve ser entre 2 a 124 caracteres")
	private String nome;
	
	@Column(name = "dt_nascimento")
	@NotNull(message = "A data de nascimento da pessoa e obrigatoria")
	private LocalDate dataDeNascimento;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "codigo_endereco")
	@NotNull(message = "O endereco da pessoa deve ser obrigatória")
	private Endereco endereco;
	
}
