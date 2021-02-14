package com.nicholas.ocp;

import java.io.IOException;
import java.util.List;

public class CovarinatRules extends SuperCv {

	@Override
	public List<? super Number> rs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Throwable> rs2() {
		// TODO Auto-generated method stub
		return null;
	}
}

class SuperCv {

	public List<? super Integer> rs() {
		return null;
	}

	public List<? extends Throwable> rs2() {
		return null;
	}
}
