package com.nicholas.ocp;

import java.util.List;

public class TestGenereicsOverride extends SuperGene {

	@Override
	List<CharSequence> number() {
		super.i=10;
		return null;
	
	}

}

class SuperGene {
int i =10;
	 List<CharSequence> number() {
		return null;
	}
}
