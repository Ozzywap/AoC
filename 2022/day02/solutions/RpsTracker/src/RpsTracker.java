/*
Advent of Code day 2 solution for part 1 and 2 using streams.
 */

import java.nio.file.Files;
import java.nio.file.Paths;

public class RpsTracker {

	public static void main(String[] args) {
		part2("../../input.txt");
	}

	public static void part2(String file) {
		try {
			int totalScore = Files
				.lines(Paths.get(file))
				.map(s -> {
					if (s.charAt(2) == 'X') {
						return decideShape('X', s.charAt(0));
					} else if (s.charAt(2) == 'Y') {
						return 3 + decideShape('Y', s.charAt(0));
					} else {
						return 6 + decideShape('Z', s.charAt(0));
					}

				})
				.reduce(0, Integer::sum);
			System.out.println("Total score: " + totalScore);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static int decideShape(char u, char o) {
		if (u == 'X' && o == 'B' || u == 'Y' && o == 'A' || u == 'Z' && o == 'C') {
			return 1;
		} else if (u == 'X' && o == 'C' || u == 'Y' && o == 'B' || u == 'Z' && o == 'A') {
			return 2;
		} else {
			return 3;
		}
	}

	public static void part1(String file) {
		try {
			int totalScore = Files
				.lines(Paths.get(file))
				.map(s -> {
					if (s.charAt(2) == 'X') {
						return 1 + mapWinner('X', s.charAt(0));
					} else if (s.charAt(2) == 'Y') {
						return 2 + mapWinner('Y', s.charAt(0));
					} else {
						return 3 + mapWinner('Z', s.charAt(0));
					}

				})
				.reduce(0, Integer::sum);
			System.out.println("Total score: " + totalScore);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static int mapWinner(char u, char o) {
		if (u == 'X' && o == 'A' || u == 'Y' && o == 'B' || u == 'Z' && o == 'C') {
			return 3;
		} else if (u == 'X' && o == 'C' || u == 'Y' && o == 'A' || u == 'Z' && o == 'B') {
			return 6;
		} else {
			return 0;
		}
	}
}
