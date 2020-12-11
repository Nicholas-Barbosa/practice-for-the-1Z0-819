package com.nicholas.ocp.localization;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class OCPResourceBundle {

	/*
	 * resource bundle contem um objeto locale especifico usado pelo programa. E
	 * como um map de keys e values. O resource bundle e commemnte armazenado num
	 * properties file.
	 * 
	 * properties file e um arquivo de formato especifico, mapeado key/value.
	 * Conceitualmente parecido ao map.
	 * 
	 */
	public static void main(String[] args) {
		/*
		 * Caminho do java para achar o resource bundle.
		 * 
		 * Primeiro ele tentar achar pelo locale que vc esta passando, se nao achar ele
		 * vai para o locale default, se tambem nao achar ele vai por properties
		 * default.
		 * 
		 * 
		 */
		Locale.setDefault(new Locale("en"));
		ResourceBundle resource = ResourceBundle.getBundle("Zoo");
		resource.keySet().stream().map(x -> x + " : " + resource.getString(x)).forEach(System.out::println);
		messageFormat();
	}

	private static void messageFormat() {
		/*
		 * MessageFormat substiui os parametros entre {} que passamos no resource bundle
		 */
		var rs = ResourceBundle.getBundle("Zoo", new Locale("pt"));
		String format = rs.getString("hello");
		System.out.println(MessageFormat.format(format, "Nicholas"));
	}
}
