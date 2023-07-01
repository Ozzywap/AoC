/*
Advent of Code day 6 solution for part 1 and 2.
Author: Osman Haji
 */

import java.nio.file.Files;
import java.nio.file.Path;

public class TuningTrouble {

	public static void main(String[] args) {
		readLines("../input.txt");
	}

	public static void readLines(String file) {
		try {
			String input = Files.readString(Path.of(file));
			System.out.println(startOfPacket(input));
			System.out.println(startOfMessage(input));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static int startOfMessage(String data) {
		int counter = 0;
		for (int i = 0; i < data.length(); i++) {
			for (int j = i; j < i + 14; j++) {
				String others = data.substring(i, i + 14);
				if (compareAgainstOthers(data.charAt(j), others)) {
					counter = 0;
					break;
				} else {
					counter += 1;
				}
				if (counter == 13) {
					return i + 14;
				}
			}
		}
		return -1; // no pattern found
	}

	public static boolean compareAgainstOthers(Character self, String others) {
		for (int i = 0; i < others.length(); i++) {
			if (others.indexOf(self) != i && self == others.charAt(i)) {
				return true;
			}
		}
		return false;
	}

	public static int startOfPacket(String data) {
		for (int i = 0; i < data.length(); i++) {
			char currentCharacter = data.charAt(i);
			if (currentCharacter != data.charAt(i + 1)
				&& currentCharacter != data.charAt(i + 2)
				&& currentCharacter != data.charAt(i + 3)
				&& data.charAt(i + 1) != data.charAt(i + 2)
				&& data.charAt(i + 1) != data.charAt(i + 3)
				&& data.charAt(i + 2) != data.charAt(i + 3)) {
				return i + 4; // + 1 as we start from index 0, + 3 as we need end of pattern
			}
		}
		return -1; // no pattern found
	}

}
