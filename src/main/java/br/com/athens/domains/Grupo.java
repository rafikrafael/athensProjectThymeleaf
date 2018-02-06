package br.com.athens.domains;

import java.util.Calendar;

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

@Entity
@Table(name="grupo")
@Audited
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Grupo extends AbstractEntity {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_grupo")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_GRUPO_ID")
	@SequenceGenerator(name="SEQ_GRUPO_ID", sequenceName="SEQ_GRUPO_ID", initialValue=0, allocationSize = 1)
	private Long id;

	@Column(length = 100, nullable = false)
	private String titulo;
	
	@Column(length = 255)
	private String descricao;
	
	@Column(name = "dt_inicio", nullable = false)
	private  Calendar dtInicio;
	
	@Enumerated(EnumType.ORDINAL)	
	private Ambiente ambiente;
	
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

	public Calendar getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Calendar dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}	
		
}