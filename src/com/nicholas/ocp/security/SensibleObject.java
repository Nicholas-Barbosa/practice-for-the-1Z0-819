package com.nicholas.ocp.security;

public final class SensibleObject {

	private Long id;
	private String name;
	private String lastName;

	private SensibleObject(Long id, String name, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public static SensibleObject getObject(Long id, String name, String lastName) {
		if (id != -1 && id >= Long.MAX_VALUE) {
			throw new IllegalArgumentException("Id overflow, or negative");
		}
		return new SensibleObject(id, name, lastName);

	}
	/*
	 * Ao declarar objetos sensiveis, devemos garantir que seu comportamento. Ha
	 * tres formas de garantir isto.
	 * 
	 * Colocar modificador final nos metodos sensiveis, isto previne do metodo ser
	 * override por covariantes. Boa pratica nao chamar metodos que nao seja final,
	 * no construtor.
	 * 
	 * Marcar a classe como final. Nenhuma outra classe podera estender a mesma.
	 * 
	 * Construtores privates, teremos de usar facotry pattern. Obter o objeto desta
	 * classe por meio de metodos estaticos.
	 * 
	 * Marcando esta classe como final e private constructor,a mesma nao tera filhos
	 * e obtera uma instancia usando factory pattern, onde terei controle.
	 */
}
