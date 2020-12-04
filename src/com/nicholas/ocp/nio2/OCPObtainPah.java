package com.nicholas.ocp.nio2;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OCPObtainPah {

	public static void main(String[] args) throws URISyntaxException {
		Path firstPath = Path.of("C:\\Users\\Nicholas Henrique\\Documents\\nio.2");
		System.out.format("%s", firstPath).println();

		Path secondPath = Paths.get("C:" + "Users" + "Nicholas Henrique" + "Documents" + "nio.2");
		System.out.println(secondPath);

		/*
		 * URI(Uniform Resource Identity) e uma String de carcteres para identificar um
		 * resource. Comeca com um scheme que indica o tipo do resource, como
		 * file://,http://,etc
		 */
		URI uri = new URI("file://C://icecream.txt");
		Path pathUri = Path.of(uri);
		Path paths = Paths.get(uri);
		URI toUri = pathUri.toUri();
		System.out.format("%s e %s", paths, toUri);

		File fileToPath = new File("");
		Path fromFile = fileToPath.toPath();

		File fromPathToFile = fromFile.toFile();
		System.out.println(fromPathToFile);
	}
}
