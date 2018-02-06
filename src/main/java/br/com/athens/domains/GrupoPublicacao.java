package br.com.athens.domains;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table (name="grupo_publicacao")
@Audited
public class GrupoPublicacao extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_grupo_publicacao")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GRUPO_PUBLICACAO")
	@SequenceGenerator(name = "SEQ_GRUPO_PUBLICACAO", sequenceName = "SEQ_GRUPO_PUBLICACAO", initialValue = 0, allocationSize = 1)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_publicacao", referencedColumnName = "id_publicacao" , foreignKey = @ForeignKey(name = "FK_GRUPO_PUBLICACAO_PUBLICACAO"))
	private Publicacao publicacao;

	@ManyToOne
	@JoinColumn(name="id_grupo", referencedColumnName = "id_grupo", foreignKey = @ForeignKey(name = "FK_GRUPO_PUBLICACAO_GRUPO"))
	private Grupo grupo;
		
	@Column(name="liberada")
	private Boolean  liberada;
	
	@Column(name="status")
	private Boolean status;

	public Publicacao getPublicacao() {
		return publicacao;
	}

	public void setPublicacao(Publicacao publicacao) {
		this.publicacao = publicacao;
	}

	public Boolean getLiberada() {
		return liberada;
	}

	public void setLiberada(Boolean liberada) {
		this.liberada = liberada;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.setId(id);
		
	}
	
}
