package numbers;

import java.util.List;
import java.util.Set;

import java.util.ArrayList;

import java.util.Arrays;

import java.util.LinkedHashSet;

class NumbersImpl implements Numbers {

    @Override
public long sum(int[] numbers) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    long result = 0;

    for (int number : numbers) {
        result += number;
    }

    return result;
}

@Override
public long sumPositiveEvenNumbers(int[] numbers) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    long result = 0;

    for (int number : numbers) {
        if (number > 0 && number % 2 == 0) {
            result += number;
        }
    }

    return result;
}

@Override
public long sumRecursive(int[] numbers, int i) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    if (i >= numbers.length) {
        return 0;
    }

    return numbers[i] + sumRecursive(numbers, i + 1);
}

    @Override
public int findFirst(int[] numbers, int x) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == x) {
            return i;
        }
    }

    return -1;
}

@Override
public int findLast(int[] numbers, int x) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    for (int i = numbers.length - 1; i >= 0; i--) {
        if (numbers[i] == x) {
            return i;
        }
    }

    return -1;
}

@Override
public List<Integer> findAll(int[] numbers, int x) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    List<Integer> indices = new ArrayList<>();

    for (int i = 0; i < numbers.length; i++) {
        if (numbers[i] == x) {
            indices.add(i);
        }
    }

    return indices;
}
@Override
public Set<Pair> findSums(int[] numbers, int sum) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    Set<Pair> result = new LinkedHashSet<>();

    for (int i = 0; i < numbers.length; i++) {
        for (int j = i + 1; j < numbers.length; j++) {
            if (numbers[i] + numbers[j] == sum) {

                int a = Math.min(numbers[i], numbers[j]);
                int b = Math.max(numbers[i], numbers[j]);

                result.add(new Pair(a, b));
            }
        }
    }

    return result;
}

@Override
public Set<Set<Integer>> findAllSums(int[] numbers, int sum) {
    if (numbers == null) {
        throw new IllegalArgumentException("illegal argument: null");
    }

    Set<Set<Integer>> result = new LinkedHashSet<>();

    int[] sortedNumbers = Arrays.copyOf(numbers, numbers.length);
    Arrays.sort(sortedNumbers);

    findAllSumsRecursive(sortedNumbers, sum, 0, 0, new LinkedHashSet<>(), result);

    return result;
}

private void findAllSumsRecursive(
    int[] numbers,
    int targetSum,
    int startIndex,
    int currentSum,
    Set<Integer> currentCombination,
    Set<Set<Integer>> result
) {
    if (currentSum == targetSum) {
        result.add(new LinkedHashSet<>(currentCombination));
        return;
    }

    if (currentSum > targetSum) {
        return;
    }

    for (int i = startIndex; i < numbers.length; i++) {
        int nextSum = currentSum + numbers[i];

        if (nextSum > targetSum) {
            break;
        }

        currentCombination.add(numbers[i]);

        findAllSumsRecursive(
            numbers,
            targetSum,
            i + 1,
            nextSum,
            currentCombination,
            result
        );

        currentCombination.remove(numbers[i]);
    }
}
}
