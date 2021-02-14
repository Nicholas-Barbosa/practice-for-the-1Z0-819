package com.nicholas.ocp;

import java.nio.file.Path;

public class TestResolveSibling {

	public static void main(String[] args) {
		Path p1 = Path.of("dir/dir2/dir3");
		System.out.println(p1.resolveSibling("/b"));

	}
}
