package com.nicholas.ocp.iostreams;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

public class OCPSeriarizationAndDeserialization {

	/*
	 * Serialization, processo de converter um objeto na memoria, em uma byte
	 * stream.
	 * 
	 * Deserialization, processo de converter uma byte stream em um objeto.
	 * 
	 */

	public static void main(String[] args) {
		serializeGorila();
		System.out.println("Depois da desserializacao: " + deserialGorila());
	}

	private static void serializeGorila() {
		/*
		 * ObjectOutputStream, usada para serializar objetos.
		 */
		try (ObjectOutputStream serial = new ObjectOutputStream(new BufferedOutputStream(
				new FileOutputStream(new File("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\gorilaSerial"))))) {
			serial.writeObject(new Gorila(78, "Alfredo"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Gorila deserialGorila() {
		try (ObjectInputStream deser = new ObjectInputStream(new BufferedInputStream(
				new FileInputStream("C:\\Users\\Nicholas Henrique\\Documents\\IO streams\\gorilaSerial")))) {
			return (Gorila) deser.readObject();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	static class Gorila implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private Integer age;

		private String name;

		private transient LocalDate birthday;

		public Gorila(Integer age, String name) {
			super();
			this.age = age;
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public String getName() {
			return name;
		}

		public LocalDate getBirthday() {
			return birthday;
		}

		@Override
		public String toString() {
			return "Gorila [age=" + age + ", name=" + name + "]";
		}

	}
}
