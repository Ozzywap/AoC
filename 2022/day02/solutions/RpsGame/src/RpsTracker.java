/*
Advent of Code day 2 solution for part 1 and 2.
 */

import java.nio.file.Paths;
import java.util.Scanner;

public class RpsTracker {

	public static String ROCK = "X";
	public static String PAPER = "Y";
	public static String SCISSORS = "Z";
	public static String opponentRock = "A";
	public static String opponentPaper = "B";
	public static String opponentScissors = "C";

	public static void main(String[] args) {
		int countShapeSelectedScore = 0;
		int countOutcomeScore = 0;
		try (Scanner scanner = new Scanner(Paths.get("../../input.txt"))) {

			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				String[] parts = line.split(" ");
				String outcome = parts[1];
				String opponentPlay = parts[0];
				if (outcome.equals(ROCK)) {
					countOutcomeScore += 0;
				} else if (outcome.equals(PAPER)) {
					countOutcomeScore += 3;
				} else {
					countOutcomeScore += 6;
				}
				if ((opponentPlay.equals(opponentRock) && outcome.equals(PAPER))
					|| (opponentPlay.equals(opponentScissors) && outcome.equals(SCISSORS))
					|| (opponentPlay.equals(opponentPaper) && outcome.equals(ROCK))) {
					countShapeSelectedScore += 1;
				} else if ((opponentPlay.equals(opponentPaper) && outcome.equals(PAPER))
					|| (opponentPlay.equals(opponentRock) && outcome.equals(SCISSORS))
					|| (opponentPlay.equals(opponentScissors) && outcome.equals(ROCK))) {
					countShapeSelectedScore += 2;
				} else if ((opponentPlay.equals(opponentScissors) && outcome.equals(PAPER))
					|| (opponentPlay.equals(opponentPaper) && outcome.equals(SCISSORS))
					|| (opponentPlay.equals(opponentRock) && outcome.equals(ROCK))) {
					countShapeSelectedScore += 3;
				} else {
					System.out.println("Error!!!");
				}

			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		int totalScore = countOutcomeScore + countShapeSelectedScore;
		System.out.println("Total score for shapes selected: " + countShapeSelectedScore);
		System.out.println("Total score for games: " + countOutcomeScore);
		System.out.println("Total score: " + totalScore);
	}

}
