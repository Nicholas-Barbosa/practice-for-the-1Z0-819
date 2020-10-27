package com.nicholas.ocp.testes;

import com.nicholas.ocp.enums.EstacoesDoAno;

public class TesteEnum {

	public static void main(String[] args) {
		EstacoesDoAno es = EstacoesDoAno.VERÃO;
		EstacoesDoAno es2 = EstacoesDoAno.INVERNO;
		System.out.println(es == es2);
		System.out.println(es.equals(es2));
		switch (es2) {
		case INVERNO:
			System.out.println(es2.variavel);
			break;

	
		}
	}
}
