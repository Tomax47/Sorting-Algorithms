public class RedixSort {
    public static void sort(int[] numbers) {
        int maximumNumber = findMaximumNumberIn(numbers);
        int numberOfDigits = numberOfDigits(maximumNumber);
        int placeValue = 1;
        while (numberOfDigits-- > 0) {
            radixSort(numbers, placeValue);
            placeValue *= 10;
        }
    }

    public static void radixSort(int[] numbers, int placeValue) {
        int length = numbers.length;
        int[] sortedValues = new int[length];
        int[] occurTime = new int[10];

        for (int i = 0; i < length; i++) {
            int digit = (numbers[i] / placeValue) % 10;
            occurTime[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            occurTime[i] += occurTime[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            int digit = (numbers[i] / placeValue) % 10;
            sortedValues[occurTime[digit] - 1] = numbers[i];
            occurTime[digit]--;
        }

        System.arraycopy(sortedValues, 0, numbers, 0, length);
    }

    public static int findMaximumNumberIn(int[] numbers) {
        int maximumNumber = numbers[0];
        for (int number : numbers) {
            if (number > maximumNumber) {
                maximumNumber = number;
            }
        }
        return maximumNumber;
    }

    public static int numberOfDigits(int number) {
        if (number == 0) {
            return 1;
        }
        int count = 0;
        while (number != 0) {
            number /= 10;
            count++;
        }
        return count;
    }
}

