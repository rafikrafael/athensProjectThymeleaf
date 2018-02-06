package br.com.athens.domains;

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
@Table(name="notificacao")
@Audited
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Notificacao extends AbstractEntity {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name= "id_notificacao" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="SEQ_NOTIFICACAO_ID")
	@SequenceGenerator(name="SEQ_NOTIFICACAO_ID", sequenceName="SEQ_NOTIFICACAO_ID", initialValue=0, allocationSize = 1)	
	private Long id;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="tipo_notificacao")
	private TipoNotificacao tipoNotificacao;
		
	@Override
	public Long getId() {		
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
