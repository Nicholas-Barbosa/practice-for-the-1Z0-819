package com.nicholas.ocp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TestColle extends Super {

	@Override
	public <T extends CharSequence> List<String> transform(Collection<T> list) { return new ArrayList<String>(); };
}

class Super {
	public <T extends CharSequence> Collection<String> transform(Collection<T> list) {
		return new ArrayList<String>();
	}
}
