package com.nicholas.ocp.interfaces;

public interface Interfaces {

	/*
	 * 6 Regras
	 * 
	 * 1-Não pode ser instanciada
	 * 
	 * 2-Como as top-level, n pode se marcada como protected ou private
	 * 
	 * 3-Pode conter 0 ou mais metodos abstratos ou n abstratos
	 * 
	 * 4-Não pode ser marcada como final
	 * 
	 * 5-Pode "extends" qualquer numero de interfaces
	 * 
	 * 6-Pode haver um cast de uma referencia de interface para um outro tipo desde
	 * que implemente essa inetrfaces, caso contrario será lançado
	 * castClassExceptuion metodos
	 * 
	 * 7-O compilador ira reclamar com a operação de inestance of com a interface do
	 * lado direito se a classe do lado esquerdo for final!
	 * 
	 * 8-Métodos com body, devem ser default,static,private ou private static Regras
	 * para métodos abstratos
	 * 
	 * 1-Só podem ser definidos em classes ou interfaces abstratas
	 * 
	 * 2-Não pode ser marcadas como private final
	 * 
	 * 3-Deve fornecer um body ao implementalas
	 * 
	 * 4-São implicitamente public abstract
	 */

	public static void main(String[] args) {
		Interfaces in = new Prin();
	}
}

class Prin implements Interfaces {

}
final class Prin2  {

}
