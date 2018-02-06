package br.com.athens.domains;

import java.sql.Blob;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.envers.Audited;

@Entity
@Table(name="publicacao")
@Audited
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Publicacao extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_publicacao")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_PUBLICACAO_ID")
	@SequenceGenerator(name="SEQ_PUBLICACAO_ID", sequenceName="SEQ_PUBLICACAO_ID", initialValue=0, allocationSize = 1)
	private Long id;
		
	@Column(length = 100, nullable = false)
	private String titulo;

	@Column(name="descricao")
	private String descricao;
	
	@Column(name="imagem")
	private Blob imagem;
	
	@NotNull(message = "Informe o Usuário")
	@JoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", nullable = false, foreignKey = @ForeignKey(name = "FK_PUBLICACAO_USUARIO"))
	@ManyToOne
	private Usuario usuario;
		
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;		
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Blob getImagem() {
		return imagem;
	}

	public void setImagem(Blob imagem) {
		this.imagem = imagem;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}	
}