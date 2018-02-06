package br.com.athens.domains;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

@MappedSuperclass
public abstract class AbstractEntity implements IEntity, Serializable {

	private static final long serialVersionUID = 1L;

	private Date dataCadastro;
	
	private Boolean status;
	
	@JsonIgnore
	@Version
	private Long version;
	
	@Override
	public abstract Long getId();
	
	public abstract void setId(Long id);
	
	public AbstractEntity() {
		this.dataCadastro = Calendar.getInstance().getTime();
		this.status = false;
		this.version = 0L;
	}
	
	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Boolean getStatusExcluido() {
		return status;
	}

	public void setStatusExcluido(Boolean statusExcluido) {
		this.status = statusExcluido;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}	
	
	@Override
	public String toString() {
		return this.getClass().toString() + " [id=" + this.getId() + "]";
	}

	@Override
	public int hashCode() {
        return (this.getId() == null) ? 0 : this.getId().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final AbstractEntity other = (AbstractEntity) obj;
		if (!Objects.equals(this.getId(), other.getId()))
			return false;
		System.out.println(obj.getClass().getSimpleName());	
		return true;
	}

	public void assign(AbstractEntity value) {
		
	}
	
}
