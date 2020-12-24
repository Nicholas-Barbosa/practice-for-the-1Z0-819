package com.nicholas.ocp.fundamentals;

public class OCPInnerClassAndStatic {

	private String myName = "Nicholas";

	private class MyInnerClass {
		/*
		 * Inner class e um tipo nao estatico definido no nivel de membro de uma
		 * classe(como metodos,construtores e variaveis de instancias).
		 * 
		 * Possui as seguintes propriedades:
		 * 
		 * 1->Pode ter qualquer modificador de acesso.
		 * 
		 * 2->Pode extender qualquer classe e implementar qualquer interface.
		 * 
		 * 3-Pode ser marcada como abstract ou final.
		 * 
		 * 4-Nao pode ter metodos ou variaveis estaticas, exceto para variaveis static
		 * final.
		 * 
		 * 5-Pode acessar os membros da outer class, incluindo os privates
		 * 
		 * Obs: Precisa da instancia da outer class para ser chamada.
		 */
		public void myMethod() {
			myName += " Barbosa";

		}

	}

	private static final class MyStaticInnerClass {
		/*
		 * Tipo static definido no nivel de membro da classe.
		 * 
		 * Diferente da inner class, este tipo de classe pode ser instanciada sem uma
		 * instancia da outer class, desvantagem que vc n pode acessar os membros da
		 * outer class diretamente.
		 * 
		 * 1-Qualquer modificador de acesso.
		 * 
		 * 2-Pode extender qualquer classe, implementar qualquer interface.
		 * 
		 * 3-Pode ser marcada como abstract ou final.
		 * 
		 * 4-Pode ter metodos e variavies static, mesmo as variavies nao sendo
		 * constantes.
		 * 
		 * 5-Nao tem acesso direto a membros da outer class.
		 */
		public void myMethod() {
			OCPInnerClassAndStatic outer = new OCPInnerClassAndStatic();
			outer.myName += " Barbosa";
			System.out.println("name " + outer.myName);
		}

	}

	public static void main(String[] args) {
		OCPInnerClassAndStatic outerClass = new OCPInnerClassAndStatic();
		MyInnerClass innerClass = outerClass.new MyInnerClass();
		innerClass.myMethod();
		System.out.println(outerClass.myName);
		System.out.println();
		MyStaticInnerClass staticInnerClass = new MyStaticInnerClass();
		staticInnerClass.myMethod();

	}
}
