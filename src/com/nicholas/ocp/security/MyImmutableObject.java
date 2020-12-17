package com.nicholas.ocp.security;

import java.util.HashSet;
import java.util.Set;

public final class MyImmutableObject {

	/*
	 * Immutable objects, sao aqueles cujo o estado nao muda apos serem criados.
	 * String, Map.of, Set.of,List.of retornam ou sao objetos imutavies. Objetos
	 * imutaveis ajudam na seguranca, ja que vc n precisa se preocupar com as
	 * mudancas de valoes.
	 * 
	 * Estrategia comum de criar um objeto imutavel.
	 * 
	 * 1->Marcar a classe como final, isto evita de sub classes serem mutaveis.
	 * 
	 * 2->Marcar as variavies de instancias como private. Isto ajuda no
	 * encapsulamento, ja que o encapsulamento significa que somente metodos destas
	 * classe possuem acesso a variavel, chamadores devem chamar os getter ou
	 * setter.
	 * 
	 * 3->Nao definir metodos setter e marcar as variaveis como final. Isto garante
	 * que os chamadores e nem a propria classe irao mudar os valores das variaveis.
	 * 
	 * 4->Nao permita que objetos mutaveis sejam modificados. Basicamente nao
	 * devolver o objeto diretamente mas sim uma copia dele.
	 * 
	 * 5->Setar todas as propriedades via um construtor, se for peciso fazer
	 * defensive copy.
	 */

	private final String name;
	private final Set<String> cities;
	

	public MyImmutableObject(String name, Set<String> cities) {
		super();
		this.name = name;
		/*
		 * Defensive copy,pois a copy e feit caso o outro codigo faca algo inesperado.
		 * Como direcao defensiva.
		 */
		this.cities = new HashSet<>(cities);
		
	}

	public String getName() {
		return name;
	}

	public Set<String> getCities() {
		return Set.copyOf(cities);
	}

	public int getCitiesSize() {
		return this.cities.size();
	}
}
