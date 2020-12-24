package com.nicholas.ocp.fundamentals;

public class NewMethodsImpl implements InterfaceNewMethods {

	public static void main(String[] args) {
		InterfaceNewMethods.myStaticMethod();
		InterfaceNewMethods in = new NewMethodsImpl();
		in.myMethodDf();
	}

	@Override
	public void myMethodDf() {
		System.out.println("Chamando metodo da interface");
		InterfaceNewMethods.super.myMethodDf();
	}
}
