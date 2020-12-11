package com.nicholas.ocp.localization;

import java.util.Properties;

public class OCPProperties {

	/*
	 * Esta classe leva o mesmo conceito de map, exceto que tanto as keys tanto os
	 * values sao strings.
	 * 
	 * Properties herda de Map<Object, Object>
	 */

	public static void main(String[] args) {
		var props = new Properties();
		props.put("Name", "Nicholas");
		props.put("Last", "Barbosa");
		props.merge("Last","Barbosads", (v1,v2) -> "Nicholas " +v2);
		/*
		 * Este metodo getProperty, nos retorna o value mapeado pela key ou um valor
		 * default,passado como segundo parametro
		 */
		System.out.println(props.getProperty("Br","Brasil!!!!"));
		System.out.println(props.get("Name"));
		System.out.println(props.get("Last"));
	}
}
