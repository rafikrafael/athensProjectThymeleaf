package br.com.athens.domains;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Table(name="usuario_notificacao")
@Audited
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class UsuarioNotificacao extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "id_usuario_notificacao" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_USUARIO_NOTIFICACAO")
	@SequenceGenerator(name="SEQ_USUARIO_NOTIFICACAO", sequenceName="SEQ_USUARIO_NOTIFICACAO", initialValue=0, allocationSize = 1)	
	private Long id;

	@Column(name="statusVisualizacao")
	private Boolean statusVisualizacao;
	
	@ManyToOne
	@JoinColumn(name="id_usuario", foreignKey = @ForeignKey(name = "FK_USUARIO_NOTIFICACAO_USUARIO"))
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name="id_notificacao", foreignKey = @ForeignKey(name = "FK_USUARIO_NOTIFICACAO_NOTIFICAO"))
	private Notificacao notificacao;
	
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getStatusVisualizacao() {
		return statusVisualizacao;
	}

	public void setStatusVisualizacao(Boolean statusVisualizacao) {
		this.statusVisualizacao = statusVisualizacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Notificacao getNotificacao() {
		return notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

}
