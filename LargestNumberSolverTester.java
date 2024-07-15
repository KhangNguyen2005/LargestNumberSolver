package assign04;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class LargestNumberSolverTester {

	@Test
	void testFindLargestNumber() {
		Integer[] arr = { 1, 45, 9 };
		BigInteger largestNumber = LargestNumberSolver.findLargestNumber(arr);
		assertEquals(new BigInteger("9451"), largestNumber);

	}

	@Test
	void testFindLargestNumberInFile() {
		Integer[] arr = LargestNumberSolver.readFile("src/assign04/integers.txt").get(7);
		BigInteger largestNumber = LargestNumberSolver.findLargestNumber(arr);
		assertEquals(new BigInteger("8851"), largestNumber);

	}

	@Test
	void testFindLargestInt() {
		Integer[] arr = { 1, 45, 9, 80, 3 };
		Integer largestNumber = LargestNumberSolver.findLargestInt(arr);
		assertEquals(9804531, largestNumber);

	}

	@Test
	void testFindLargestIntInFile() {
		Integer[] arr = LargestNumberSolver.readFile("src/assign04/integers.txt").get(13);
		Integer largestNumber = LargestNumberSolver.findLargestInt(arr);
		assertEquals(928973921, largestNumber);

	}

	@Test
	void testFindLargestIntThrow() {
		Integer[] arr = { 999, 639, 1, 7, 58, 9 };

		OutOfRangeException exception = assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestInt(arr);
		});

		assertEquals("The value is too large for the int data type.", exception.getMessage());

	}

	@Test
	void testFindLargestLong() {
		Integer[] arr = { 999, 639, 1, 7, 58, 9 };

		long largestNumber = LargestNumberSolver.findLargestLong(arr);

		assertEquals(99997639581L, largestNumber);

	}

	@Test
	void testFindLargestLongInFile() {
		Integer[] arr = LargestNumberSolver.readFile("src/assign04/integers.txt").get(47);
		Long largestNumber = LargestNumberSolver.findLargestLong(arr);
		assertEquals(762344312111L, largestNumber);

	}

	@Test
	void testFindLargestLongThrow() {
		Integer[] arr = { 922339999, 922339999, 922339999, 922339999, 922339999, 922339999 };

		OutOfRangeException exception = assertThrows(OutOfRangeException.class, () -> {
			LargestNumberSolver.findLargestLong(arr);
		});

		assertEquals("The value is too large for the long data type.", exception.getMessage());

	}

	@Test
	void testFindSum() {
		Integer[] arr = { 1, 45, 9, 80, 3 };
		Integer[] secArr = { 100, 200, 300, 400, 500 };

		List<Integer[]> list = List.of(arr, secArr);
		BigInteger result = LargestNumberSolver.sum(list);

		assertEquals(new BigInteger("500400310004631"), result);

	}

	@Test
	void testFindSumInFile() {
		Integer[] firstSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(7);
		Integer[] secondSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(90);

		List<Integer[]> list = List.of(firstSum, secondSum);

		// Call the findSum method
		BigInteger result = LargestNumberSolver.sum(list);

		// Assert the result
		assertEquals(new BigInteger("106593"), result);
	}

	@Test
	void testFindKthLargestA() {
		Integer[] firstSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(7);
		Integer[] secondSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(90);

		List<Integer[]> list = List.of(firstSum, secondSum);

		Integer[] expected1 = LargestNumberSolver.findKthLargest(list, 0);
		Integer[] result1 = { 7, 42, 97 };
		// Assert the result
		for (int i = 0; i < expected1.length; i++) {
			assertEquals(expected1[i], result1[i]);
		}
	}

	@Test
	void testFindKthLargestB() {
		Integer[] firstSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(7);
		Integer[] secondSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(90);

		List<Integer[]> list = List.of(firstSum, secondSum);

		// Call the findLargestLong method
		Integer[] expected1 = LargestNumberSolver.findKthLargest(list, 1);
		Integer[] result1 = { 88, 51 };
		// Assert the result
		for (int i = 0; i < expected1.length; i++) {
			assertEquals(expected1[i], result1[i]);
		}
	}

	@Test
	void testFindKthLargestDuplicate() {
		Integer[] arr = { 500, 400, 300, 200, 100 };
		Integer[] secArr = { 100, 200, 300, 400, 500 };

		List<Integer[]> list = List.of(arr, secArr);

		Integer[] expected1 = LargestNumberSolver.findKthLargest(list, 1);
		Integer[] result1 = { 100, 200, 300, 400, 500 };

		for (int i = 0; i < expected1.length; i++) {
			assertEquals(expected1[i], result1[i]);
		}
	}

	@Test
	void testFindKthLargestManyArray() {
		Integer[] arr = { 0, 2, 3 };
		Integer[] secArr = { 4, 1, 1 };
		Integer[] thirdArr = { 1, 1, 1 };
		Integer[] fourthArr = { 4, 3, 2 };

		List<Integer[]> list = List.of(arr, secArr, thirdArr, fourthArr);

		Integer[] expected1 = LargestNumberSolver.findKthLargest(list, 0);
		Integer[] result1 = { 4, 3, 2 };

		for (int i = 0; i < expected1.length; i++) {
			assertEquals(expected1[i], result1[i]);
		}
	}

	@Test
	void testFindKthSmallestManyArray() {
		Integer[] arr = { 0, 2, 3 };
		Integer[] secArr = { 4, 1, 1 };
		Integer[] thirdArr = { 1, 1, 1 };
		Integer[] fourthArr = { 4, 3, 2 };

		List<Integer[]> list = List.of(arr, secArr, thirdArr, fourthArr);

		Integer[] expected1 = LargestNumberSolver.findKthLargest(list, 3);
		Integer[] result1 = { 1, 1, 1 };

		for (int i = 0; i < expected1.length; i++) {
			assertEquals(expected1[i], result1[i]);
		}
	}

	@Test
	void testFindKthLargestThrow() {
		Integer[] firstSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(7);
		Integer[] secondSum = LargestNumberSolver.readFile("src/assign04/integers.txt").get(90);

		List<Integer[]> list = List.of(firstSum, secondSum);

		int k = 10; 

		IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
	        LargestNumberSolver.findKthLargest(list, k);
	    });

	    assertEquals("Invalid value of k", exception.getMessage(), "Exception message is not as expected.");
	
	}

	@Test
	public void testReadFileExistingFile() {
		String filename = "src/assign04/integers.txt"; // Provide the path to an existing test file
		List<Integer[]> result = LargestNumberSolver.readFile(filename);

		assertNotNull(result);
	}

	@Test
	public void testReadFileLineAsArray() {
		String filename = "src/assign04/integers.txt"; // Provide the path to an existing test file
		List<Integer[]> file = LargestNumberSolver.readFile(filename);
		Integer[] firstLineArr = file.get(0);

		StringBuilder bigNumber = new StringBuilder();
		for (int i = 0; i <= firstLineArr.length - 1; i++) {
			bigNumber.append(firstLineArr[i]);
			if (i < firstLineArr.length - 1) {
				bigNumber.append(" "); // Add space between elements
			}
		}
		String result = bigNumber.toString();
		assertEquals(
				"410 21 93 80 69 379 20 60 432 13 72 62 70 83 9 3 14 11 62 55 34 83 80 99 56 25 79 51 51 70 79 20 34 67 40 51 41 94 89 116 874 554 137 371 17 77 97 58 83 97 26 17 54 96 33",
				result);
	}

	@Test
	public void testReadFileNonExistingFile() {
		String filename = "nonexistent.txt"; // Provide the path to a non-existing test file

		List<Integer[]> result = LargestNumberSolver.readFile(filename);

		assertTrue(result.isEmpty(), "Result list should be empty when file is not found");
	}

	// edge cases
	@Test
	void testFindLargestNumberSingleElement() {
		Integer[] arr = { 1 };
		BigInteger largestNumber = LargestNumberSolver.findLargestNumber(arr);
		assertEquals(new BigInteger("1"), largestNumber);

	}
	
	@Test
	void testFindLargestNumberAlreadySorted() {
		Integer[] arr = { 1, 2, 3, 4, 5 };
		BigInteger largestNumber = LargestNumberSolver.findLargestNumber(arr);
		assertEquals(new BigInteger("54321"), largestNumber);

	}
	
	@Test
	void testFindLargestNumberDuplicate() {
		Integer[] arr = { 0, 0, 0, 0, 0 };
		BigInteger largestNumber = LargestNumberSolver.findLargestNumber(arr);
		assertEquals(new BigInteger("0"), largestNumber);

	}
	
	
}
