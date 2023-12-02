from trebuchet import find_calibration_value

with open("input.txt") as file:
    lines = [line.rstrip() for line in file]

updated_lines = []

for i in lines:
    updated_lines.append(i.replace("one", "o1e").replace("two", "t2o").replace("three", "t3ree").replace("four", "f4ur")\
        .replace("five", "f5ve").replace("six", "s6x").replace("seven", "s7ven").replace("eight", "e8ght").replace("nine", "n9ne"))

print(find_calibration_value(updated_lines))