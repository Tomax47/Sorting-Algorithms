import java.util.Arrays;
import java.util.Random;

public class HeapSort {
    public static int capacity = 10;
    private int size = numbers.length;

    public static int[] numbers = new int[capacity];


    //Getting the indexes
    public int getLeftChildIndex (int parentIndex) {return (2 * parentIndex) + 1;}
    public int getRightChildIndex (int parentIndex) {return (2 * parentIndex) + 2;}
    public int getParentIndex (int childIndex) {return (childIndex - 1) / 2;}


    //Checking availability
    public boolean hasLeftChild (int parentIndex) {return getLeftChildIndex(parentIndex) < size;}
    public boolean hasRightChild (int parentIndex) {return getRightChildIndex(parentIndex) < size;}
    public boolean hasParent (int index) {return getParentIndex(index) >= 0;}


    //Getting the parents &/or the child element
    public int getLeftChild (int parentIndex) {
        if (!hasLeftChild(parentIndex));
        return numbers[getLeftChildIndex(parentIndex)];}

    public int getRightChild (int parentIndex) {
        if (!hasRightChild(parentIndex));
        return numbers[getRightChildIndex(parentIndex)];}

    public int getParent (int index) {
        if (!hasParent(index));
        return numbers[getParentIndex(index)];}


    //Swapping method
    public void swap(int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }


    //Ensuring the capacity of the array
    public void ensureCapacity() {
        if (size == capacity) {
            numbers = Arrays.copyOf(numbers, capacity*2);
            capacity *= 2;
        }
    }

    //Getting the peak element of the array
    public int getPeek() {
        if (size == 0) throw new IllegalStateException();
        return numbers[0];
    }

    //Removing the smallest element from the array /POLL/
    public int poll(){
        if (size == 0) throw new IllegalStateException();
        int number = numbers[0];
        numbers[0] = numbers[size -1];
        size--;
        heapifyDown();
        return number;
    }

    //Adding an element to the array /ADD/
    public void add(int number) {
        ensureCapacity();
        numbers[size] = number;
        size++;
        heapifyUp();
    }

    public void heapifyUp(){
        int index = size - 1;
        while (hasParent(index) && getParent(index) > numbers[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    public void heapifyDown(){
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && getRightChild(index) < getLeftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (numbers[index] < numbers[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }

    public int[] fillArray() {
        Random rnd = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(-10,10);
        }
        return numbers;
    }

    public void printArray(){
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]+" ");
        }
    }
}


