package br.com.athens.domains;

public enum TipoNotificacao {

	EMERGENCIA(1), ALERTA(2), NOVIDADE(3), COMUM(4), EVENTO(5);
	
	public int tipoNotificacao;
	
	private TipoNotificacao(int value) {
		this.tipoNotificacao = value;
	}
}
