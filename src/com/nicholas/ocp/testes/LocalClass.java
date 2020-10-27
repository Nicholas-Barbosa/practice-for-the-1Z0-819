package com.nicholas.ocp.testes;

public class LocalClass {

	/*
	 * COMO uma variavel local, ela existe quando o metodo é invocado e seu escopo
	 * se delimita ao mesmo.
	 * 
	 * 4 principios
	 * 
	 * 1->Nenhum modificador de acesso
	 * 
	 * 2->Nao pode ter variaveis ou metodos static, exeto para static
	 * final(constantes)
	 * 
	 * 3-Possui o acesso de todos os fields e metodos da outer class
	 * 
	 * 4->Pode acessar variaveis locais, desde que sejam finals ou efetivamente
	 * finals.
	 */
	private int x = 0;

	public void localClass() {
		int y = 10;
	class local {
			int x9 = 10;

			{

				LocalClass.this.x = 9;
				System.out.println(y);
				System.out.println(x);
			}
		}

	}
}
