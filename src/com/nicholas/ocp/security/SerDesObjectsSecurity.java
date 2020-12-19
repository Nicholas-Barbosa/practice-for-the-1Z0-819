package com.nicholas.ocp.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.time.LocalDate;

public class SerDesObjectsSecurity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;

	private transient String password;

	private LocalDate birthday;

	private String country;

	/*
	 * WhiteList para fields que serao serializados
	 */
	private static final ObjectStreamField[] serial = { new ObjectStreamField("name", String.class),
			new ObjectStreamField("birthday", LocalDate.class), new ObjectStreamField("country", String.class) };

	public SerDesObjectsSecurity(String name, String password, LocalDate birthday, String country) {
		super();
		this.name = name;
		this.password = password;
		this.birthday = birthday;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getCountry() {
		return country;
	}

	public String getPassword() {
		return password;
	}

	private void writeObject(ObjectOutputStream ob) throws IOException {
		/*
		 * Serializa opcionalmente usando putField.
		 */
		ObjectOutputStream.PutField fields = ob.putFields();
		fields.put("name", name);
		fields.put("birthday", birthday);
		fields.put("country", country);
		/*
		 * exception! fields.put("password", password);
		 */

		ob.writeFields();

	}

	private void readObject(ObjectInputStream in) throws Exception {
		/*
		 * Desserializa opcionalmente usando getField
		 */
		ObjectInputStream.GetField fields = in.readFields();
		this.name = (String) fields.get("name", null);
		this.birthday = (LocalDate) fields.get("birthday", null);
		this.country = (String) fields.get("country", null);
	}

	private Object readResolve() {
		System.out.println("readResolve");
		/*
		 * Este metodo e chamado apos o readObject(), vc pode modificar o objeto
		 * resultado da desserializacao. Ou seja,permite substituir o objeto apos a
		 * desserializacao. Pode ter qualquer modificador, menos static.
		 */
		if (this.password == null) {
			this.password = "Encrypted";
		}
		return this;
	}

	private Object writeReplace() {
		System.out.println("Chamados antes da serializacao");

		return this;
	}

	/*
	 * Nao e boa pratica por campos condifenciais no toString(), mas para teste
	 * serve.
	 */
	@Override
	public String toString() {
		return "SerDesObjectsSecurity [name=" + name + ", password=" + password + ", birthday=" + birthday
				+ ", country=" + country + "]";
	}

	public static void main(String[] args) throws Exception {
		SerDesObjectsSecurity object = new SerDesObjectsSecurity("Nicholas", "1234", LocalDate.now(), "Brazil");
		try (ObjectOutputStream objectOut = new ObjectOutputStream(
				new FileOutputStream("C:\\Users\\Nicholas Henrique\\Documents\\serEDessecurity\\object"))) {
			objectOut.writeObject(object);
		}
		System.out.println("desserializacao---");
		try (ObjectInputStream ob = new ObjectInputStream(
				new FileInputStream("C:\\Users\\Nicholas Henrique\\Documents\\serEDessecurity\\object"))) {
			SerDesObjectsSecurity objectDes = (SerDesObjectsSecurity) ob.readObject();
			System.out.println(objectDes);

		}
		/*
		 * void readObject(ObjectInputstream) -> Desserializa objeto usando GetField
		 * 
		 * Object readResolve() -> Permite modificar, substituir o objeto
		 * desserializado. Este metodo e chamado depois da desserializacao(readObject)
		 * 
		 * void writeObject(ObjectOutputStream) -> Serializa usando PutField
		 * 
		 * Object writeReplace() -> Permite modificar o objeto a ser serializado.
		 * Chamado antes da serializacao(writeObject)
		 */
	}

}
