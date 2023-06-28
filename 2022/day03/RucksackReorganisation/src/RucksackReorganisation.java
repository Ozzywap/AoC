import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class RucksackReorganisation {

	public static void main(String[] args) {
		part2("../input.txt");
	}

	public static void part2(String file) {
		int sumOfPriorities = 0;
		try {
			String a = Files.lines(Paths.get(file))
				.reduce("", (previousWord, word) -> previousWord + word + "\n");
			String[] blocks = a.split("\n");
			char commonLetter = ' ';
			for (int i = 0; i < blocks.length - 2; i += 3) {
				commonLetter = findCommonLetterBetweenThree(blocks[i], blocks[i + 1],
					blocks[i + 2]);
				int priority = findPriorityOfLetter(commonLetter);
				sumOfPriorities += priority;
			}
			System.out.println(sumOfPriorities);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static char findCommonLetterBetweenThree(String a, String b, String c) {
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				for (int k = 0; k < c.length(); k++) {
					if (a.charAt(i) == b.charAt(j) && b.charAt(j) == c.charAt(k)) {
						return a.charAt(i);
					}
				}
			}
		}
		return ' ';
	}

	public static void part1(String file) {
		int sumOfPriorities = 0;
		try (Scanner scanner = new Scanner(Paths.get(file))) {

			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				int mid = row.length() / 2;
				System.out.println(row.substring(0, mid).length() == row.substring(mid).length());
				char commonLetter = findCommonLetter(row.substring(0, mid), row.substring(mid));
				int priority = findPriorityOfLetter(commonLetter);
				sumOfPriorities += priority;

			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println(sumOfPriorities);
	}

	public static char findCommonLetter(String a, String b) {
		for (int i = 0; i < a.length(); i++) {
			for (int j = 0; j < b.length(); j++) {
				if (a.charAt(i) == b.charAt(j)) {
					return a.charAt(i);
				}
			}
		}
		return ' ';
	}

	public static int findPriorityOfLetter(char a) {
		if (a <= 90) {
			return a - 38;
		} else {
			return a - 96;
		}
	}

}
