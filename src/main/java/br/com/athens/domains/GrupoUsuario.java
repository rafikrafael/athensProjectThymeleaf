package br.com.athens.domains;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name="grupo_usuario")
@Audited
public class GrupoUsuario {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_GRUPO_USUARIO")
	@SequenceGenerator(name="SEQ_GRUPO_USUARIO", sequenceName="SEQ_GRUPO_USUARIO", initialValue=0, allocationSize = 1)		
	@Column(name="id_grupo_usuario")
	private Long id;
	
	@Column(name = "dt_inicio_participacao")
	private Calendar dtInicioParticipacao;
	
	@ManyToOne()
	@JoinColumn(name="id_pessoa", referencedColumnName = "id_pessoa",  foreignKey = @ForeignKey(name = "FK_GRUPO_USUARIO_USUARIO"))
	private Usuario usuario;
	
	@ManyToOne()
	@JoinColumn(name="id_grupo", referencedColumnName = "id_grupo", foreignKey = @ForeignKey(name = "FK_GRUPO_USUARIO_GRUPO"))
	private Grupo grupo;

	public Calendar getDtInicioParticipacao() {
		return dtInicioParticipacao;
	}

	public void setDtInicioParticipacao(Calendar dtInicioParticipacao) {
		this.dtInicioParticipacao = dtInicioParticipacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
