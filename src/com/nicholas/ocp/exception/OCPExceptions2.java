package com.nicholas.ocp.exception;

public class OCPExceptions2 {

	/*
	 * Exception no finnaly, abrande todas as outras, como no finnaly!
	 */
	public static void main(String[] args) {
		try {
			throw new Exception("exception do try");
		} catch (Exception e) {

			throw new RuntimeException("exception do catch");
		} finally {
			// throw new RuntimeException("exception do finnaly");
		}

	}

}
