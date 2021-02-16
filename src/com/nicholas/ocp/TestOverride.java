package com.nicholas.ocp;

public class TestOverride {

	public void setId() {
		System.out.println("TestOverride");
	}

	public static void main(String[] args) {
		ChildTestOverride ch = new ChildChildTestOverride();
		ch.setId();
	}
}

class ChildTestOverride extends TestOverride {

}

class ChildChildTestOverride extends ChildTestOverride {

	@Override
	public void setId() {
		System.out.println("ChildChildTestOverride");
	}
}