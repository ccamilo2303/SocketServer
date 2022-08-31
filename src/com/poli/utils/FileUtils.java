package com.poli.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Camilo Beltrán
 * @since  28/08/2022
 */
public class FileUtils {

	private static File archivo;

	public static void createDataFile() throws IOException {
		Path path = Paths.get("D:/datos.txt");
		archivo = Files.exists(path) ? path.toFile() : Files.createFile(path).toFile();
	}

	public static void writeString(String msg) throws IOException {
		msg = msg + "\n";
		Files.writeString(archivo.toPath(), msg, StandardOpenOption.APPEND);
	}

	public static boolean searchAcount(String account) throws IOException {
		return Files.readAllLines(archivo.toPath()).stream().filter( x -> x.split(",")[0].equals(account)).count() > 0;
	}

}
