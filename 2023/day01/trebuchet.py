with open("input.txt") as file:
    lines = [line.rstrip() for line in file]


def find_calibration_value(lines):
    calibration_values = [[] for _ in range(len(lines))]

    for i, line in enumerate(lines):
        for char in line:
            try:
                calibration_values[i].append(int(char))
            except:
                pass

    calibration_values_sum = 0
    for i in calibration_values:
        calibration_values_sum += int(str(i[0]) + str(i[-1]))
    
    return calibration_values_sum

print(find_calibration_value(lines))