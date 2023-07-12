
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ReportRepair {

	public static void main(String[] args) {
		readLines("input.txt");
	}

	public static void readLines(String file) {
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(Path.of(file));
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		int part1 = findTwoNumbers(lines);
		int part2 = findThreeNumbers(lines);
		System.out.println(part1);
		System.out.println(part2);

	}

	public static int findThreeNumbers(List<String> numbers){
		for(int i = 0; i < numbers.size(); i++){
			for(int j = 0; j < i; j++){
				for(int k = 0; k < j; k++){
					int num1 = Integer.parseInt(numbers.get(i));
					int num2 = Integer.parseInt(numbers.get(j));
					int num3 = Integer.parseInt(numbers.get(k));
					if(num1 + num2 + num3 == 2020){
						return num1 * num2 * num3;
					}
				}
			}
		}
		return -1;
	}

	public static int findTwoNumbers(List<String> numbers) {
		for(int i = 0; i < numbers.size(); i++){
			for(int j = i+1; j < numbers.size(); j++){
				int num1 = Integer.parseInt(numbers.get(i));
				int num2 = Integer.parseInt(numbers.get(j));
				if(num1 + num2 == 2020){
					return num1 * num2;
				}
			}
		}
		return -1;
	}
}
