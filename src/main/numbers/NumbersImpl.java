package numbers;

import java.util.List;
import java.util.Set;

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
        return -1;
    }

    @Override
    public int findLast(int[] numbers, int x) {
        return -1;
    }

    @Override
    public List<Integer> findAll(int[] numbers, int x) {
        return List.of();
    }

    @Override
    public Set<Pair> findSums(int[] numbers, int sum) {
        return Set.of();
    }

    @Override
    public Set<Set<Integer>> findAllSums(int[] numbers, int sum) {
        return Set.of();
    }
}
