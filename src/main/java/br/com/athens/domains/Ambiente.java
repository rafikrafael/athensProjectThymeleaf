package br.com.athens.domains;

public enum Ambiente {

	INTERNO(1), EXTERNO(2); 
	
	public int ambiente;

	private Ambiente(int ambiente) {
		this.ambiente = ambiente;
	}	
}
