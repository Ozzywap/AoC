/*
Advent of Code day 8 solution for part 1 and 2.
Author: Osman Haji
 */
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class TreetopTreeHouse {

	public static void main(String[] args) {
		readLines("../input.txt");
	}

	public static void readLines(String file) {
		ArrayList<String> grid = new ArrayList<String>();
		try (Scanner scanner = new Scanner(Paths.get(file))) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				grid.add(line);
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		int edgeTrees = ((grid.get(0).length()) * 2 + (grid.size()) * 2) - 4;
		int interiorTrees = visibleInteriorTrees(grid); // part 1
		System.out.println(interiorTrees + edgeTrees);

		int scenicScore  = calculateScenicScore(grid); // part 2
		System.out.println(scenicScore);

	}

	public static int calculateScenicScore(ArrayList<String> forest) {
		int columnScore = 0;
		int rowScore = 0;
		int largestScenicScore = 0;
		for (int row = 1; row < forest.size() - 1; row++) {
			for (int column = 1; column < forest.get(row).length() - 1; column++) {

				columnScore = columnScenicScore(row, column, forest);
				rowScore = rowScenicScore(row, column, forest);
				if(columnScore * rowScore > largestScenicScore){
					largestScenicScore = columnScore*rowScore;
				}
			}
		}
		return largestScenicScore;
	}

	public static int columnScenicScore(int row, int column, ArrayList<String> forest) {
		char current = forest.get(row).charAt(column);
		int smallerLeftTrees = 0;
		for (int i = column - 1; i >= 0; i--) {
			if (current <= forest.get(row).charAt(i)) {
				smallerLeftTrees++;
				break;
			} else
				smallerLeftTrees++;
		}

		int smallerRightTrees = 0;
		for (int i = column + 1; i < forest.get(row).length(); i++) {
			if (current <= forest.get(row).charAt(i)) {
				smallerRightTrees += 1;
				break;
			} else
				smallerRightTrees++;
		}

		return smallerRightTrees * smallerLeftTrees;
	}

	public static int rowScenicScore(int row, int column, ArrayList<String> forest) {
		char current = forest.get(row).charAt(column);
		int smallerTopTrees = 0;
		for (int i = row - 1; i >= 0; i--) {
			if (current <= forest.get(i).charAt(column)) {
				smallerTopTrees++;
				break;
			} else
				smallerTopTrees++;
		}

		int smallerBottomTrees = 0;
		for (int i = row + 1; i < forest.get(row).length(); i++) {
			if (current <= forest.get(i).charAt(column)) {
				smallerBottomTrees++;
				break;
			} else
				smallerBottomTrees++;
		}

		return smallerTopTrees * smallerBottomTrees;
	}

	public static int visibleInteriorTrees(ArrayList<String> forest) {
		int visible = 0;
		for (int row = 1; row < forest.size() - 1; row++) {
			for (int column = 1; column < forest.get(row).length() - 1; column++) {

				if (visibleColumn(row, column, forest))
					visible++;
				else if(visibleRow(row, column, forest))
					visible++;
			}
		}
		return visible;
	}

	public static boolean visibleRow(int row, int column, ArrayList<String> forest) {
		char current = forest.get(row).charAt(column);
		int smallerTopTrees = 0;
		int totalTrees = 0;

		for (int i = 0; i < row; i++) {
			totalTrees++;
			if (current > forest.get(i).charAt(column)) {
				smallerTopTrees += 1;
			}
		}

		if (smallerTopTrees != totalTrees) {
			int smallerBottomTrees = 0;
			totalTrees = 0;
			for (int i = row + 1; i < forest.get(row).length(); i++) {
				totalTrees++;
				if (current > forest.get(i).charAt(column)) {
					smallerBottomTrees += 1;
				}
			}

			return smallerBottomTrees == totalTrees;

		} else {
			return true;
		}
	}

	public static boolean visibleColumn(int row, int column, ArrayList<String> forest) {
		char current = forest.get(row).charAt(column);
		int smallerLeftTrees = 0;
		int totalTrees = 0;
		for (int i = 0; i < column; i++) {
			totalTrees++;
			if (current > forest.get(row).charAt(i)) {
				smallerLeftTrees += 1;
			}
		}

		if (smallerLeftTrees != totalTrees) {
			int smallerRightTrees = 0;
			totalTrees = 0;
			for (int i = column + 1; i < forest.get(row).length(); i++) {
				totalTrees++;
				if (current > forest.get(row).charAt(i)) {
					smallerRightTrees += 1;
				}
			}

			return smallerRightTrees == totalTrees;

		} else {
			return true;
		}
	}
}
