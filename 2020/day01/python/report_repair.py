with open("input.txt", 'r') as f:
    lines = f.readlines()

# part 1
def find_two_numbers(lines):
    n = len(lines)
    for i in range(n):
        for j in range(i+1, n):
            if int(lines[i]) + int(lines[j]) == 2020:
                return int(lines[i]) * int(lines[j])

# part 2
def find_three_numbers(lines):
    n = len(lines)
    for i in range(n):
        for j in range(i+1, n):
            for k in range(j+1, n):
                if int(lines[i]) + int(lines[j]) + int(lines[k]) == 2020:
                    return int(lines[i]) * int(lines[j]) * int(lines[k])
