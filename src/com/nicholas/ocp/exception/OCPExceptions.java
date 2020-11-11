package com.nicholas.ocp.exception;

public class OCPExceptions {

	/*
	 * Checked exceptions sao quaisquer exceptions que herdam de Exception mas nao
	 * de RuntimneExcepion.
	 * 
	 * Unchecked aquelas que herdam de runtime ou error.
	 * 
	 * Qualquer exception e filha de throwable, ma pratica capturar um throwable
	 * 
	 * Checked excpetions devem seguir a regra de "handle or declare", isso
	 * significa que elas devem ser empacotadoas num try statement ou declaradas na
	 * assinatura do metodo(throws).
	 * 
	 * Algumas Unchecked exceptions ->NullPointer, CastClass,
	 * IllegalState,IllegalArgumento,NumberFormat,ArrayIndexOutOfBounds, etc
	 * 
	 * Algumas checked exceptions -> SQLException,
	 * IOException,FileNotFoundException, NotSerializableException,ParseException.
	 * 
	 * try-with-resources, conhecido como automatic resource management, ja que
	 * todas as resources definidas nesa statement, sao fechadas apos a conclusao da
	 * clausula try. Sendo assim, try with resource pode ter varias resources que
	 * implementam AutoClosable ou Closable, as mesmas possuem um metodo abstrato
	 * close(), que sera implementado pela resource.As resources sao fechadas na
	 * ordem inversa que foram declaradas.
	 * 
	 * try with resource pode referenciar resources declaradas fora de seu
	 * statement, para isso a resource deve ser final ou efetivamente final.
	 * 
	 * Quando varias exceptions sao lancadas, a primeira e definida como primary
	 * exception, as demais sao agrupadas e definidas como supresses exceptions.
	 * 
	 * Por baixo dos panos, o java fecha as resources num finally implicito, antes
	 * de qualquer outro catch ou finally explicito.
	 * 
	 * Por este motivo podemos empacotar aexceptions lancada num close().
	 */
	public static void main(String[] args) {
		/*
		 * rs1 e efetivamente final
		 */
		Resource1 rs1 = new Resource1();
		try (rs1; Resource2 res = new Resource2()) {
			System.out.println("try bloick");
		} catch (Exception e) {
			System.out.println("exception " + e.getMessage());
			System.out.println("----supresses exception----");
			for (Throwable t : e.getSuppressed()) {
				System.out.println("supressed: " + t.getMessage());
			}

		} finally {
			System.out.println("finnaly!");

		}
	}

}

class Resource1 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close resource1!");
		throw new Exception("Exception resource1");
	}

}

class Resource2 implements AutoCloseable {

	@Override
	public void close() throws Exception {
		System.out.println("close resource2!");
		throw new Exception("Exception resource2");
	}

}