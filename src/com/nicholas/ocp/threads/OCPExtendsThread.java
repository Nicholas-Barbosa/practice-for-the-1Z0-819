package com.nicholas.ocp.threads;

public class OCPExtendsThread extends Thread {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0;i<=10;i++)
		System.out.println("Printing zoo inventory " +i);
	}
}
