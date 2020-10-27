package com.nicholas.ocp.enums;

public enum EstacoesDoAno {

	VERÃO("Veraneio"), INVERNO("Inverno");

	public final String variavel;

	EstacoesDoAno(String param) {
		this.variavel = param;
	}

	public void printaVariavelFina() {
		System.out.println(this.variavel);
	}
}
