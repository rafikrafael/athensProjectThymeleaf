package br.com.athens.domains;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;


@Entity
@Table(name="calendario")
@Audited
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Calendario extends AbstractEntity  {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_calendario")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_CALENDARIO_ID")
	@SequenceGenerator(name="SEQ_CALENDARIO_ID", sequenceName="SEQ_CALENDARIO_ID", initialValue=0, allocationSize = 1)
	private Long id;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name = "calendario_usuario", 
	joinColumns = {@JoinColumn (name = "id_pessoa", foreignKey = @ForeignKey(name = "FK_CALENDARIO_USUARIO_USUARIO") )}, 
	inverseJoinColumns = {@JoinColumn (name = "id_calendario", foreignKey = @ForeignKey(name = "FK_CALENDARIO_USUARIO_CALENDARIO"))})
	private List<Usuario> usuarios = new LinkedList<Usuario>();
	
	@Column(length = 100, nullable = false)
	private String titulo;
	
	@Column(length = 50)
	private String bloco;
	
	@Column(length = 255)
	private String descricao;
	
	@Column(length = 50, nullable = false)
	private String sala;
	
	@Column(name = "dt_inicio", nullable = false)
	private Calendar dtInicio;
	
	@Column(name = "hr_inicio", nullable = false)
	private Calendar hrInicio;
	
	@Column(name = "dt_final", nullable = false)
	private Calendar dtFinal;
	
	@Column(name = "hr_final", nullable = false)
	private Calendar hrFinal;	
	
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

	public String getBloco() {
		return bloco;
	}

	public void setBloco(String bloco) {
		this.bloco = bloco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getSala() {
		return sala;
	}

	public void setSala(String sala) {
		this.sala = sala;
	}

	public Calendar getDtInicio() {
		return dtInicio;
	}

	public void setDtInicio(Calendar dtInicio) {
		this.dtInicio = dtInicio;
	}

	public Calendar getHrInicio() {
		return hrInicio;
	}

	public void setHrInicio(Calendar hrInicio) {
		this.hrInicio = hrInicio;
	}

	public Calendar getDtFinal() {
		return dtFinal;
	}

	public void setDtFinal(Calendar dtFinal) {
		this.dtFinal = dtFinal;
	}

	public Calendar getHrFinal() {
		return hrFinal;
	}

	public void setHrFinal(Calendar hrFinal) {
		this.hrFinal = hrFinal;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void addUsuario(Usuario usuario) {
		this.getUsuarios().add(usuario);
	}
	
	public void removeUsuario(Usuario usuario) {
		this.getUsuarios().remove(usuario);
	}
	
}
