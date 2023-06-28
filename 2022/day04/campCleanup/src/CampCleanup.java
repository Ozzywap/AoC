/*
Advent of Code day 4 solution for part 1 and 2.
author: Osman Haji
 */
import java.nio.file.Paths;
import java.util.Scanner;

public class CampCleanup {

	public static void main(String[] args) {
		part2("../input.txt");
	}

	public static void part2(String file) {
		int result = 0;
		try (Scanner scanner = new Scanner(Paths.get(file))) {
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				String[] parts = row.split(",");
				String[] firstPair = parts[0].split("-");
				String[] secondPair = parts[1].split("-");
				int x1 = Integer.parseInt(firstPair[0]);
				int x2 = Integer.valueOf(firstPair[1]);
				int y1 = Integer.valueOf(secondPair[0]);
				int y2 = Integer.valueOf(secondPair[1]);
				if (overlap(x1, x2, y1, y2)) {
					result += 1;
				}
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println(result);
	}


	public static boolean overlap(int x1, int x2, int y1, int y2) {
		return !(x1 < y1 && x2 < y1
			|| x1 > y2 && x2 > y2); // check if points don't overlap and return inverse
	}

	public static void part1(String file) {
		int result = 0;
		try (Scanner scanner = new Scanner(Paths.get(file))) {
			while (scanner.hasNextLine()) {
				String row = scanner.nextLine();
				String[] parts = row.split(",");
				String[] firstPair = parts[0].split("-");
				String[] secondPair = parts[1].split("-");

				int x1 = Integer.valueOf(firstPair[0]);
				int x2 = Integer.valueOf(firstPair[1]);
				int y1 = Integer.valueOf(secondPair[0]);
				int y2 = Integer.valueOf(secondPair[1]);
				if (fullyContained(x1, x2, y1, y2)) {
					System.out.println("Values are " + x1 + " " + x2 + " " + y1 + " " + y2);
					result += 1;
				}

			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		System.out.println(result);
	}

	public static boolean fullyContained(int x1, int x2, int y1, int y2) {
		if (x1 < y1) {
			return x2 >= y2;
		} else if (x1 == y1) {
			return x2 >= y2 || x2 < y2;
		} else {
			return y2 >= x2;
		}
	}
}
