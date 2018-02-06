package br.com.athens.domains;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="usuario")
@Audited
@PrimaryKeyJoinColumn(name = "id_pessoa", referencedColumnName = "id_pessoa", foreignKey = @ForeignKey(name = "FK_USUARIO_PESSOA"))
public class Usuario extends Pessoa {
	
	private static final long serialVersionUID = 1L;
		
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "E-mail inválido")
	@Column(name="email", nullable = false, length = 63)
	private String email;
	
	@NotBlank(message="A senha não pode ser em branco")
	@Column(name="senha", length = 100, nullable = false)
	private String senha;
	
	@Transient
	@Size(min=8, max=32, message="A senha deve ter de 8 a 32 caractéres")
	private String plainPassword;
	
	@Column(name="pin")
	private Integer pin;
		
	@Column(name="foto")
	private Blob foto;
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name="tipo_usuario")
	private TipoUsuario tipoUsuario;
	
	@Column(name="role", length=20)
	private String role;
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public Long getId() {
		return this.id;
	}
	@Override
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Integer getPin() {
		return pin;
	}
	public void setPin(Integer pin) {
		this.pin = pin;
	}
	
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getPlainPassword() {
		return this.plainPassword;
	}
	public void setPlainPassword(String plainPassword) {
		this.senha = "";
		if (!plainPassword.isEmpty()) {
			this.senha = new BCryptPasswordEncoder().encode(plainPassword);			
		}
		this.plainPassword = plainPassword;
	}
	
	
}