import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class PreliminaryTester {

	public static void main(String[] args) {
		if (!test(100)) {
			System.out.println("GL on the SATs!");
		} else {
			System.out.println("Failed a test case");
		}
	}

	public static boolean test(int tests) {
		boolean fail = false;

		System.out.println("Same val test case.");

		for (int test = 0; test < tests; test++) {
			ArrayList<Integer> shuffle = new ArrayList<Integer>(test);
			for (int i = 0; i < test; i++) {
				shuffle.add(test);
			}

			int[] checkCopy = shuffle.stream().mapToInt(Integer::intValue).toArray();//Integer ArrayList to int.
			Collections.shuffle(shuffle);
			int[] passThrough = shuffle.stream().mapToInt(Integer::intValue).toArray();

			int pivot = Preliminary.partition(passThrough, 0, test - 1);
			if (test == 0) {
				//Just so it doesn't throw index out of bounds error, which it should only do when passign through 0 length array, which only occurs at test=0.
			} else if (checkCopy[pivot] == passThrough[pivot]) {
				//System.out.println("Same val test: " + test + " passed.");
			} else {
				System.out.println("Same val test: " + test + " failed.");
				fail = true;
			}
		}

		System.out.println("Linear val test case.");

		for (int test = 0; test < tests; test++) {
			ArrayList<Integer> shuffle = new ArrayList<Integer>(test);
			for (int i = 0; i < test; i++) {
				shuffle.add(i);
			}

			int[] checkCopy = shuffle.stream().mapToInt(Integer::intValue).toArray();//Integer ArrayList to int.
			Collections.shuffle(shuffle);
			int[] passThrough = shuffle.stream().mapToInt(Integer::intValue).toArray();

			int pivot = Preliminary.partition(passThrough, 0, test - 1);
			if (test == 0) {
				//Just so it doesn't throw index out of bounds error, which it should only do when passign through 0 length array, which only occurs at test=0.
			} else if (checkCopy[pivot] == passThrough[pivot]) {
				//System.out.println("Linear vals test: " + test + " passed.");
			} else {
				System.out.println("Linear vals test: " + test + " failed.");
				fail = true;
			}
			//checks all values are still there.
			Arrays.sort(passThrough);
			for (int i = 0; i < checkCopy.length; i++) {
				if (passThrough[i] == checkCopy[i]) {
					//System.out.println("Value preserved.");
				} else {
					System.out.println("Value not preserved.");
					fail = true;
				}
			}
		}

		System.out.println("Random val test case.");

		for (int test = 0; test < tests; test++) {
			Random rng = new Random(test);
			ArrayList<Integer> shuffle = new ArrayList<Integer>(test);
			for (int i = 0; i < test; i++) {
				shuffle.add(rng.nextInt());
			}

			int[] passThrough = shuffle.stream().mapToInt(Integer::intValue).toArray();//It already starts random
			Collections.sort(shuffle);//Sort the random values.
			int[] checkCopy = shuffle.stream().mapToInt(Integer::intValue).toArray();//Integer ArrayList to int

			int pivot = Preliminary.partition(passThrough, 0, test - 1);
			if (test == 0) {
				//Just so it doesn't throw index out of bounds error, which it should only do when passign through 0 length array, which only occurs at test=0.
			} else if (checkCopy[pivot] == passThrough[pivot]) {
				//System.out.println("Random vals test: " + test + " passed.");
			} else {
				System.out.println("Random vals test: " + test + " failed.");
				fail = true;
			}
			//checks all values are still there.
			Arrays.sort(passThrough);
			for (int i = 0; i < checkCopy.length; i++) {
				if (passThrough[i] == checkCopy[i]) {
					//System.out.println("Value preserved.");
				} else {
					System.out.println("Value not preserved.");
					fail = true;
				}
			}
		}

		return fail;
	}

}
