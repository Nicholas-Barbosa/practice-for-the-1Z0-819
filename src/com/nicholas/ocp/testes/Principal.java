package com.nicholas.ocp.testes;

public class Principal {
int a= 1;
int b=2;
	public static void main(String[] args) {
		// dogood good
		Principal prin1 = new Principal();
		Principal prin2 = prin1.func(prin1);
		System.out.println("prin1.a " +prin1.a +" prin1.b " +prin1.b);
		System.out.println("prin2.a " +prin2.a +" prin1.b " +prin2.b);
	}
	private Principal func(Principal prin1) {
		Principal prin3 = new Principal();
		prin3 = prin1;
		prin3.a= prin1.a++ + ++prin1.b;
		prin1.b = prin1.b;
		return prin3;
	}

	
	/*
	 * doogood:dogood
	 */
}
interface Im1{
	default void mk() {
		
	}
}
interface Im2{
	default void mk() {
		
	}
}
interface Im3 extends Im1,Im2{
	default void mk() {
		
	}
}