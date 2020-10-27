package com.nicholas.ocp.testes;

public class InnerClass {

	/*
	 * É um tipo não estatico definido no nivel de membro da classe, como metodos,
	 * variaves de instancias e construtores
	 * 
	 * 5 propriedades
	 * 
	 * 1-Elas podem ser marcadas como private,private-package, public ou protected
	 * 2-Podem extender qualquer classe e implementar qualquer interface 3-Podem sem
	 * marcadas como abstract ou final 4-Metodos e variaveis nao podem ser marcadas
	 * como static, exceto para variaveis static final 5-Podem acessar os membros da
	 * outer class
	 * 
	 * Observação, o compilador ira criar dois .class -> OuterClass$Inner.class
	 */
	private int x = 10;

	public class NonStatic {

		private int x = 100;

		class NonStatic2  {

			private int x = 900;

			void teste() {
				System.out.println(x);
				System.out.println(NonStatic.this.x);
				System.out.println(InnerClass.this.x);
			}

			class NonStatic3 {

				private int x = 900;

				void teste() {
					System.out.println(x);
					System.out.println(NonStatic.this.x);
					System.out.println(InnerClass.this.x);
				}
			}
		}
	}

	public static void main(String[] args) {
		InnerClass in = new InnerClass();
		NonStatic non = in.new NonStatic();
		NonStatic.NonStatic2 non2 = non.new NonStatic2();
		InnerClass.NonStatic.NonStatic2.NonStatic3 non3 = non2.new NonStatic3();
		non2.teste();
	}
}
