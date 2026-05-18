package numbers;

import java.util.List;
import java.util.Set;

import java.util.ArrayList;

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
    return Set.of();
}
}
