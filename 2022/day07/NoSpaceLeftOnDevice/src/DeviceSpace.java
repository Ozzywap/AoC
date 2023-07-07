/*
Advent of Code day 7 solution for part 1 and 2.
Author: Osman Haji
 */

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DeviceSpace {

	public static void main(String[] args) {

		readLines("../input.txt");
	}

	public static void readLines(String file) {
		try {

			List<String> lines = Files.readAllLines(Path.of(file));
			ArrayList<Object> fileSystem = buildFileSystem(lines);

			ArrayList<Integer> sizes = new ArrayList<>();
			int totalSize = calculateSize(fileSystem, sizes);

			System.out.println(sizes.stream().filter(size -> size < 100000).mapToInt(i -> i).sum());
			sizeOfDirectoryToDelete(sizes, totalSize);

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}

	public static void sizeOfDirectoryToDelete(ArrayList<Integer> sizes, int totalSize) {
		int unusedSpace = 70000000 - totalSize;
		int spaceNeeded = 30000000 - unusedSpace;
		System.out.println(
			sizes.stream().filter(space -> space > spaceNeeded).min(Integer::compare).get());
	}

	public static int calculateSize(Object rootDirectoryX, ArrayList<Integer> sizes) {
		ArrayList<Object> rootDirectory = (ArrayList<Object>) rootDirectoryX;
		int size = 0;
		for (Object directory : rootDirectory) {
			if (directory instanceof ArrayList) {
				size += calculateSize(directory, sizes);
			} else {
				String file = (String) directory;
				if (!file.matches("[a-z]*")) {
					size += Integer.parseInt(file.split(" ")[0]);
				}
			}
		}
		sizes.add(size);
		return size;
	}

	public static ArrayList<Object> buildFileSystem(List<String> lines) {
		ArrayList<Object> rootDirectory = new ArrayList<>();
		Stack<ArrayList<Object>> directories = new Stack<>();
		ArrayList<Object> currentDirectory = rootDirectory;
		for (String line : lines) {
			if (line.charAt(0) != '$') {
				if (line.charAt(0) == 'd') {
					ArrayList<Object> dir = new ArrayList<>();
					dir.add(line.split(" ")[1]);
					currentDirectory.add(dir);

				} else {
					currentDirectory.add(line);
				}
			} else { // dealing with commands
				String[] command = line.split(" ");
				if (!command[1].equals("ls")) {
					if (command[2].equals("/")) {
						currentDirectory = rootDirectory;
					} else if (command[2].equals("..")) {
						currentDirectory = directories.pop();
					} else {
						for (Object directory : currentDirectory) {
							if (directory instanceof ArrayList) {
								ArrayList<Object> d = (ArrayList<Object>) directory;
								if (d.get(0).equals(command[2])) {
									directories.add(currentDirectory);
									currentDirectory = d;
								}
							}
						}
					}
				}
			}
		}
		return rootDirectory;
	}
}
