package dev.codenmore.tilegame.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Classe qui gere les utilitaires du jeu (bufferedreader, scanner, etc).
 * 
 * @author maurel
 *
 */
public class Utils {

	/**
	 * Methode qui pemet de charger un fichier et le transforme en string.
	 * 
	 * @param path
	 *            (url du fichier)
	 * @return le fichier convertit dans un string
	 */
	public static String loadFileAsString(String path) {
		StringBuilder builder = new StringBuilder();

		try {
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while ((line = br.readLine()) != null)
				builder.append(line + "\n");

			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return builder.toString();
	}

	/**
	 * Methode qui convertit un string en int
	 * 
	 * @param number
	 * @return le nombre convertit
	 */
	public static int parseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			return 0;
		}
	}

}
