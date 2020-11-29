package com.nicholas.ocp.iostreams;

public class OCPIoStream {

	/*
	 * I/O refere-se a natureza de como ira acessar tal arquivo, I=input/O=output.
	 * 
	 * Streams devem ser conceitualmente consideradas como "stream of water", na
	 * qual os dados sao como uma onda, vem um de cada vez.
	 * 
	 * Um dado e armazenado no file system(ou em memoria) como 0 e 1, chamado de
	 * bit. Como para os humanos e dificil de ler, estes bits sao agrupados em
	 * conjuntos de 8 bits, chamandos de bytes.
	 * 
	 * Ha dois segmentos de streams, binary stream e character stream.
	 * 
	 * Binary streams sao primariamente uteis para read/write dados binarios(0 e 1)
	 * como imagens, arquivos executaveis, etc. Suas classes terminam com
	 * InputStream ou OutputStream.
	 * 
	 * Character streams, read/write dados textos e suas classes terminam com Reader
	 * ou Writer.
	 * 
	 * Pelo fato de binary stream trabalharem com tudo q e binario e string e
	 * binario. Parece meio inutil os character streams, mas com o character streams
	 * vc n precisa se preocupar com character enconding.
	 * 
	 * Character enconding define como os dados serao codificados e armazenados em
	 * bytes num stream e posteriormente decodificados em caracteres ou lidos.
	 * 
	 * Ha ainda tipos de streams alem de character streams e binary streams,
	 * low-level stream e high-level stream.
	 * 
	 * Low-level stream se conecta diretamente na fonte dos dados, como arquivos,
	 * arrays ou String.Low-level streams processam dados e resources brutos, que sao acessados de maneira
	 * direta e nao filtrada.
	 * 
	 * High-level stream, e construida em cima de outra stream, usando
	 * wrapping.Wrapping e o processo na qual uma instancia e passada para o construtor de
	 * outra classe, e as operacoes nesta instancia resultante sao filtradas e
	 * aplicadas na instancia original.
	 */
}
