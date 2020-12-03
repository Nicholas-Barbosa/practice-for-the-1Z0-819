package com.nicholas.ocp.iostreams;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class OCPManipulatingStreams {

	/*
	 * Input streams(ler dados)
	 * 
	 * markSupported() -> Retorna se a classe stream suporta mark.
	 * 
	 * mark(int readLimit) -> Marca a current position na stream, readLimit numero
	 * de bytes antes de chamar o reset
	 * 
	 * reset() -> Volta a posicao marcada pelo mark().
	 * 
	 * skip(long n) -> Le e descarta um numero especifico de caracteres.
	 * 
	 * ---Output streams(gravar dados)
	 *
	 * flush()->Solicita que todos os dados cacheados sejam imediatamente gravados
	 * no storage device.
	 */
	public static void main(String[] args) {
		try (var inp = new BufferedReader(new InputStreamReader(System.in))) {
			if (inp.markSupported()) {
				inp.mark(20);
				System.out.println((char) inp.read());
				inp.skip(2);
			
				System.out.println("After two characters " + (char) inp.read());
				inp.reset();
				System.out.println("Before two characters " + (char) inp.read());
			} else
				System.err.print("Mark not supported");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
