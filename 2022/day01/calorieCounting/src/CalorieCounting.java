/*
Advent of Code day 1 solution for part 1 and 2.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.nio.file.Paths;

public class CalorieCounting {

	public static void main(String[] args) {
		int counter = 0;
		ArrayList<Integer> elvesWithMostCalories = new ArrayList<>();

		try (Scanner scanner = new Scanner(Paths.get("../input.txt"))) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if (!line.isEmpty()) {
					counter += Integer.parseInt(line);
				} else {
					elvesWithMostCalories.add(counter);
					counter = 0;
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		elvesWithMostCalories.add(counter);
		elvesWithMostCalories.sort(Collections.reverseOrder());

		int amount = 0;
		for (int i = 0; i < 3; i++) {
			amount += elvesWithMostCalories.get(i);
		}
		System.out.println("Most calories is " + elvesWithMostCalories.get(0));
		System.out.println("The amount carried by top 3 elves is " + amount);
	}

}
