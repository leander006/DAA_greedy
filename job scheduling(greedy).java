// Java implementation of above approach

// Program to find the maximum profit
// job sequence from a given array
// of jobs with deadlines and profits

import java.util.*;

class Main {

	// a class to represent job
	static class Job {
		char job_id;
		int deadline;
		int profit;
		Job(char job_id, int deadline, int profit)
		{
			this.deadline = deadline;
			this.job_id = job_id;
			this.profit = profit;
		}
	}

	static void printJobScheduling(ArrayList<Job> arr)
	{
		int n = arr.size();

		// sorting the array on the
		// basis of their deadlines
		Collections.sort(arr, (a, b) -> {
			return a.deadline - b.deadline;
		});

		// initialise the result array and maxHeap
		ArrayList<Job> result = new ArrayList<>();
		PriorityQueue<Job> maxHeap = new PriorityQueue<>(
			(a, b) -> { return b.profit - a.profit; });

		// starting the iteration from the end
		for (int i = n - 1; i > -1; i--) {
			int slot_available;
			// calculate slots between two deadlines
			if (i == 0) {
				slot_available = arr.get(i).deadline;
			}
			else {
				slot_available = arr.get(i).deadline
								- arr.get(i - 1).deadline;
			}

			// include the profit of job(as priority),
			// deadline and job_id in maxHeap
			maxHeap.add(arr.get(i));

			while (slot_available > 0
				&& maxHeap.size() > 0) {

				// get the job with max_profit
				Job job = maxHeap.remove();

				// reduce the slots
				slot_available--;

				// include the job in the result array
				result.add(job);
			}
		}

		// jobs included might be shuffled
		// sort the result array by their deadlines
		Collections.sort(result, (a, b) -> {
			return a.deadline - b.deadline;
		});
		for (Job job : result) {
			System.out.print(job.job_id + " ");
		}
		System.out.println();
	}

	// Driver Code
	public static void main(String[] args)
	{
		ArrayList<Job> arr = new ArrayList<Job>();
		Scanner l = new Scanner(System.in);
		System.out.println("Enter total number of jobs");
		int n = l.nextInt();
		for(int i =0;i<n;i++){
		        System.out.println("Enter job id ");
		        char p = l.next().charAt(0);
		         System.out.println("Enter job deadline ");
		        int d = l.nextInt();
		         System.out.println("Enter job cost");
		        int cost = l.nextInt();
		        arr.add(new Job(p, d, cost));
		}

// 		arr.add(new Job('a', 2, 100));
// 		arr.add(new Job('b', 1, 19));
// 		arr.add(new Job('c', 2, 27));
// 		arr.add(new Job('d', 1, 25));
// 		arr.add(new Job('e', 3, 15));
		// Function call
		System.out.println("\nFollowing is maximum "
						+ "profit sequence of jobs");

		// Calling function
		printJobScheduling(arr);
	}
}


