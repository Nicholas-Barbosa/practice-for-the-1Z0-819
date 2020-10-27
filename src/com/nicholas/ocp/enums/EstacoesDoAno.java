package com.nicholas.ocp.enums;

public enum EstacoesDoAno {

	VER�O("Veraneio"), INVERNO("Inverno");

	public final String variavel;

	EstacoesDoAno(String param) {
		this.variavel = param;
	}

	public void printaVariavelFina() {
		System.out.println(this.variavel);
	}
}
