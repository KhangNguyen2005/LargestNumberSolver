package assign04;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class LargestNumberSolver {
	/**
	 * This generic method sorts the input array using an insertion sort and the
	 * input Comparator object.
	 *
	 * @param <T>
	 * @param arr
	 * @param cmp
	 */
	public static <T> void insertionSort(T[] arr, Comparator<? super T> cmp) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			T key = arr[i];
			int j = i - 1;

			while (j >= 0 && cmp.compare(arr[j], key) > 0) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
	}

	/**
	 * This method returns the largest number that can be formed by arranging the
	 * integers of the given array, in any order. If the array is empty, the largest
	 * number that can be formed is 0.
	 * <p>
	 * This method must not alter the given array and must call your insertionSort
	 * method with a Comparator or lambda expression that you design.
	 *
	 * @param arr
	 * @return
	 */
	public static BigInteger findLargestNumber(Integer[] arr) {
		Comparator<Integer> cmp = (a, b) -> {
			String ab = a.toString() + b.toString();
			String ba = b.toString() + a.toString();
			return ba.compareTo(ab);
		};

		Integer[] sortedArr = new Integer[arr.length];
		for (int i = 0; i < arr.length; i++)
			sortedArr[i] = arr[i];

		insertionSort(sortedArr, cmp);

		StringBuilder result = new StringBuilder();
		for (Integer num : sortedArr) {
			result.append(num);
		}

		return new BigInteger(result.toString());
	}

	/**
	 * This method returns the largest int value that can be formed by arranging the
	 * integers of the given array, in any order.
	 * <p>
	 * An OutOfRangeException Download OutOfRangeException is thrown if the largest
	 * number that can be formed is too large for the int data type.
	 * <p>
	 * Logic for solving the problem of determining the largest number should not
	 * appear again in this method — call an existing public method or a helper
	 * method. This method must not alter the given array.
	 *
	 * @param arr
	 * @return
	 * @throws OutOfRangeException
	 */
	public static int findLargestInt(Integer[] arr) throws OutOfRangeException {
		BigInteger result = findLargestNumber(arr);
		if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) > 0)
			throw new OutOfRangeException("int");

		return result.intValue();
	}

	/**
	 * This method behaves the same as the previous method, but for data type long
	 * instead of data type int.
	 *
	 * @param arr
	 * @return
	 * @throws OutOfRangeException
	 */
	public static long findLargestLong(Integer[] arr) throws OutOfRangeException {
		BigInteger result = findLargestNumber(arr);
		if (result.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0) {
			throw new OutOfRangeException("long");
		}
		return result.longValue();

	}

	/**
	 * This method sums the largest numbers that can be formed by each array in the
	 * given list. This method must not alter the given list.
	 *
	 * @param list
	 * @return
	 */
	public static BigInteger sum(List<Integer[]> list) {
		BigInteger totalSum = BigInteger.ZERO;
		for (Integer[] arr : list) {
			totalSum = totalSum.add(findLargestNumber(arr));
		}
		return totalSum;
	}

	/**
	 * This method determines the kth largest number that can be formed by each
	 * array in the given list.
	 * <p>
	 * E.g., if k=0 returns the largest overall, if k=list.size()-1 returns the
	 * smallest overall. This method returns the original array that represents the
	 * kth largest number, not the kth largest number itself.
	 * <p>
	 * An IllegalArgumentExceptionLinks to an external site. is thrown if k is not a
	 * valid position in the list.
	 * <p>
	 * This method must not alter the given list and must call your insertionSort
	 * method with a Comparator or lambda expression that you design.
	 *
	 * @param list
	 * @param k
	 * @return
	 * @throws IllegalArgumentException
	 */
	public static Integer[] findKthLargest(List<Integer[]> list, int k) throws IllegalArgumentException {
		if (k < 0 || k >= list.size()) {
			throw new IllegalArgumentException("Invalid value of k");
		}

		Comparator<Integer[]> cmp = (a, b) -> findLargestNumber(b).compareTo(findLargestNumber(a));

		Integer[][] sortedList = list.toArray(new Integer[list.size()][]);
//        sortedList.sort(cmp);
//        Arrays.sort(sortedList, cmp);
		insertionSort(sortedList, cmp);

		return sortedList[k];
	}

	/**
	 * This method generates list of integer arrays from an input file, such that
	 * each line corresponds to one array of integers separated by blank spaces, and
	 * returns an empty list if the file does not exist.
	 *
	 * @param filename
	 * @return
	 */
	public static List<Integer[]> readFile(String filename) {
		List<Integer[]> resultList = new ArrayList<>();

		try {
			Scanner input = new Scanner(new File(filename));

			while (input.hasNext()) {
				String line = input.nextLine();
				String[] number = line.split(" ");
				Integer[] arr = new Integer[number.length];
				for (int i = 0; i < number.length; i++) {
					arr[i] = Integer.parseInt(number[i]);
				}
				resultList.add(arr);
			}

		} catch (FileNotFoundException e) {
			return resultList;
		}
		return resultList;
	}
}