package com.nicholas.ocp;

import java.util.Arrays;
import java.util.List;

public class TestsWithWildCards extends SuperWd {

	@Override
	public List<? super Object> lista() {
		// TODO Auto-generated method stub
		return Arrays.asList(null);
	}
}

class SuperWd {
	public List<? super Number> lista() {
		return null;
	}
}