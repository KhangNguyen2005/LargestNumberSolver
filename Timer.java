package assign04;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Timer extends TimerTemplate {
	Random random = new Random();
	private List<Integer[]> num;

	/**
	 * Create a timer
	 *
	 * @param problemSizes array of N's to use
	 * @param timesToLoop  number of times to repeat the tests
	 */
	public Timer(int[] problemSizes, int timesToLoop) {
		super(problemSizes, timesToLoop);
		num = new ArrayList<>();
	}

	@Override
	protected void setup(int n) {
		num.clear();
		for(int i = 0; i < n; i++){
			int length = random.nextInt(1, 100);
			Integer[] arr = new Integer[length];
			for (int j = 0; j < arr.length; j++){
				arr[j] = random.nextInt(100);
			}
			num.add(arr);
		}
	}

	@Override
	protected void timingIteration(int n) {
		LargestNumberSolver.findKthLargest(num, 0);
	}

	@Override
	protected void compensationIteration(int n) {

	}

	public static void main(String[] args) {
		int[] problemSizes = new int[11];
		for (int i = 0; i < problemSizes.length; i++) {
			problemSizes[i] = (i + 1) * 1000;
		}

		int timesToLoop = 50;
		var timer = new Timer(problemSizes, timesToLoop);
		timer.setup(10);
		var results = timer.run();

		for (var result : results) {
			System.out.println(result.n() + ", " + result.avgNanoSecs());
		}
		try {
			FileWriter csvWriter = new FileWriter("findMaxResults2.csv");
			csvWriter.write("n, time\n");

			for (Result result : results) {
				String line = result.n() + ", " + result.avgNanoSecs() + "\n";
				csvWriter.write(line);
			}

			csvWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}