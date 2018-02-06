package br.com.athens.domains;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="pessoa")
@Audited
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="SEQ_PESSOA",allocationSize=1,initialValue=0,sequenceName="SEQ_PESSOA")
	@GeneratedValue(generator="SEQ_PESSOA",strategy=GenerationType.SEQUENCE)		
	@Column(name="id_pessoa")
	protected Long id;
	
	@Column(name="nome",length = 200, nullable = false)
	private String nome;
	
	@Column(name="cpf",length = 11)
	private String cpf;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="genero")
	private Genero genero;
	
	@Column(name="celular",length = 17)
	private String celular;
	
	@Column(name="telefone",length = 17)
	private String telefone;
	
	@Column(name="identificacao_institucional",length = 50)
	private String identificacaoInstitucional;
	
	@Column(name="dt_nascimento")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dataNascimento;
		
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public Long getId() {	
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	public String getIdentificacaoInstitucional() {
		return identificacaoInstitucional;
	}

	public void setIdentificacaoInstitucional(String identificacaoInstitucional) {
		this.identificacaoInstitucional = identificacaoInstitucional;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}	

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
}