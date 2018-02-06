package br.com.athens.domains;

public enum Genero {
	
	MASCULINO(1), FEMININO(2); 
	
	public int genero;

	private Genero(int genero) {
		this.genero = genero;
	}	

}
