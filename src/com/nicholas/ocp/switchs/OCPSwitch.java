package com.nicholas.ocp.switchs;

import java.util.Set;
import java.util.function.Supplier;

public class OCPSwitch {

	/*
	 * Valores aceitos num switch, todos os tipos que sao promovidos para int,
	 * inlusive int e seus wrappers adeqados, enum,string e var se for um desses
	 * tipos.
	 * 
	 * case, so aceita constantes, variavies marcadas como final que sao
	 * inciializadas na mesma expressao q foram declaradas.
	 */
	String teste1 = "";

	public static void main(String[] args) {
		final String myName = "Nicholas";
		final String runtime = new OCPSwitch().getRuntime();
		String test = "Nicholas";

		StringBuilder b = new StringBuilder("rumble");
		b.append(4).deleteCharAt(3).delete(3, b.length() - 1);
		System.out.println(b);

		switch (test) {
		case myName:

			break;
		/*
		 * Nao compila, esta constante depende um metodo que sera executado em tempo de
		 * execucao.Ela nao e atribuida na mesma expressao q foi declarada. case
		 * runtime: break;
		 */
		default:
			break;
		}
	}

	private String getRuntime() {

		return "";
	}
}
