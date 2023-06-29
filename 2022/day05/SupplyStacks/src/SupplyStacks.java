/*
Advent of Code day 5 solution for part 1 and 2.
Author: Osman Haji
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;


public class SupplyStacks {

	public static void main(String[] args) {
		readLines("../input.txt");
	}

	public static void readLines(String file) {
		try {
			String[] input = Files.readString(Path.of(file)).split("\\n\\n");
			ArrayList<Stack<Character>> stacks = buildStack(input[0]);

			for (int i = 0; i < stacks.size(); i++) {
				LinkedList<Character> queue = new LinkedList<>();
				int count = stacks.get(i).size();
				for (int j = 0; j < count; j++) {
					queue.add(stacks.get(i).pop());
				}
				for (int j = 0; j < count; j++) {
					stacks.get(i).push(queue.getFirst());
					queue.removeFirst();
				}
			}

			moveStacksPartTwo(input[1], stacks);

			for (Stack<Character> stack : stacks) {
				System.out.print(stack.peek());
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void moveStacksPartTwo(String instructions, ArrayList<Stack<Character>> stacks) {
		String[] rows = instructions.split("\n");
		for (String row : rows) {
			String[] a = row.split(" ");
			int count = Integer.valueOf(a[1]);
			int from = Integer.valueOf(a[3]) - 1;
			int to = Integer.valueOf(a[5]) - 1;

			Stack<Character> temp = new Stack<>();
			for (int i = 0; i < count; i++) {
				temp.push(stacks.get(from).pop());
			}
			for (int i = 0; i < count; i++) {
				stacks.get(to).push(temp.pop());
			}
		}
	}

	public static void moveStacksPartOne(String instructions, ArrayList<Stack<Character>> stacks) {
		String[] rows = instructions.split("\n");
		for (String row : rows) {
			String[] a = row.split(" ");
			int count = Integer.valueOf(a[1]);
			int from = Integer.valueOf(a[3]) - 1;
			int to = Integer.valueOf(a[5]) - 1;

			for (int i = 0; i < count; i++) {
				stacks.get(to).push(stacks.get(from).pop());
			}
		}
	}

	public static ArrayList<Stack<Character>> buildStack(String crates) {
		ArrayList<Stack<Character>> stacks = new ArrayList<>();

		for (int i = 0; i < 9; i++) { // i value hard coded to number of columns
			stacks.add(new Stack<>());
		}
		String[] rows = crates.split("\n");

		for (int i = 0; i < rows.length - 1; i++) {
			int index = 0;
			for (int j = 1; j < 35; j += 4) { //j value hard coded to length of first line (35)
				if (rows[i].charAt(j) != ' ') {
					stacks.get(index).push(rows[i].charAt(j));
				}
				index++;
			}
		}
		return stacks;
	}
}
