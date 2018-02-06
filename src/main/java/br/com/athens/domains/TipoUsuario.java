package br.com.athens.domains;

public enum TipoUsuario {

	ADMINISTRADOR(1), ALUNO(2), PUBLICO(3), SERVIDOR(4);
	
	public int tipoUsuario;
	
	private TipoUsuario(int value) {
		this.tipoUsuario = value;
	}
}
