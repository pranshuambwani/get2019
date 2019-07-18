package assignment3;

import java.util.Scanner;


class JobScheduler{
	public static void main(String[] args) {
		int fcfs[][] = new int[10][10];
		int ct[] = completionTime(fcfs);
		int tat[] = turnAroundTime(ct,fcfs);
		int wt[] = waitingTime(tat,fcfs);
		Scanner input = new Scanner(System.in);	
		System.out.println("Enter the number of process: ");
		int numberOfProcess = input.nextInt();
		
		for(int loop = 0; loop < numberOfProcess; loop++){
			System.out.println("Arrival time: ");
			fcfs[loop][0] = input.nextInt();
			
			System.out.println("Burst time: ");
			fcfs[loop][1] = input.nextInt();
		}
		
		
		for(int i=0;i<4;i++){
			System.out.println("Completion time of process " + i + ": " + ct[i]);
			System.out.println("Turn Around Time of process " + i + ": " + tat[i]);
			System.out.println("Waiting Time of process " + i + ": " + wt[i]);
			System.out.println("************************************************");	
		}
		System.out.println("Average Waiting Time : " + averageWaitingTime(wt));

		int max[] = maxWait(wt);
		System.out.println("longest waiting time for a process " + max[1] + "is : " + max[0]);
	}
	public static int[] completionTime(int fcfs[][]){
		int ct[] = new int[10];

		for(int loop1 = 0; loop1 < 4; loop1++){
			for(int loop2 = 0; loop2 < 2; loop2++){
				if(fcfs[loop1][loop2] == 0 && ct[0] == 0){
					loop2 += 1;
					ct[loop1] = fcfs[loop1][loop2];
				}
				else if(fcfs[loop1][loop2] < ct[loop1-1]){
					loop2 += 1;
					ct[loop1] = ct[loop1-1] + fcfs[loop1][loop2];
				}
				else if(fcfs[loop1][loop2] > ct[loop1]){
					ct[loop1] = fcfs[loop1][loop2] + fcfs[loop1][loop2+1];
					loop2 = 1;
				}
			}
		}
		return ct;
	}
	
	public static int[] turnAroundTime(int ct[],int fcfs[][]){
		int tat[] = new int[4];
		int col = 0;
		for(int row = 0; row < 4; row++){
			tat[row] = ct[row] - fcfs[row][col];
		}
		return tat;
	}

	public static int[] waitingTime(int tat[],int fcfs[][]){
			int wt[] = new int[4];
			int col=1;
			for(int row = 0; row < 4; row++){
				wt[row] = tat[row] - fcfs[row][col];
			}
		return wt;
	}

	public static int averageWaitingTime(int wt[]){
		int totalWaitingTime = 0;
		for(int w = 0; w < wt.length; w++){
			totalWaitingTime += wt[w];
		}
		return totalWaitingTime/wt.length;
	}

	public static int[] maxWait(int wt[]){
		int []max = new int[2]; 
		max[0] = wt[0];
		for(int w = 1; w < wt.length; w++){
			if(max[0] < wt[w]){
				max[0] = wt[w];
				max[1] = w;
			}
		}
		return max;
	}
}
