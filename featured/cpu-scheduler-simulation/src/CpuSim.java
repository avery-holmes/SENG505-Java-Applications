/**
 * @author Avery Holmes
 * SENG 505
 * Assignment: CPU Simulator
 *
 * Purpose:
 * This program simulates a clock-driven CPU scheduler in a multi-user system.
 * Jobs arrive one at a time, enter a wait queue, and then move into a CPU queue
 * where they receive time slices: 1 second if they are I/O-bound and 2 seconds
 * if they are CPU-bound.
 */

import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CpuSim {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        PrintWriter out = new PrintWriter("cpusim.txt");

        System.out.println("Enter number of jobs to simulate: ");
        int totalJobs = keyboard.nextInt();
        keyboard.nextLine();

        out.println("Number of jobs to be generated: " + totalJobs);

        Queue<Job> waitQueue = new LinkedList<>();
        Queue<Job> cpuQueue = new LinkedList<>();

        Random rand = new Random();

        int clock = 0;
        int jobsCreated = 0;
        int jobsCompleted = 0;

        int cpuBusySeconds = 0;
        int cpuIdleSeconds = 0;

        int totalWaitTime = 0;

        int[][] jobCounts = new int[2][4];
        int[][] totalCpuQueueTime = new int[2][4];

        while (jobsCompleted < totalJobs || !waitQueue.isEmpty() || !cpuQueue.isEmpty()) {
            clock++;

            if (jobsCreated < totalJobs) {
                Job j = new Job();

                j.id = jobsCreated + 1;
                j.ioBound = rand.nextBoolean();

                int[] cpuOptions = {10, 20, 30, 60};
                j.totalCpuTime = cpuOptions[rand.nextInt(cpuOptions.length)];
                j.remainingCpuTime = j.totalCpuTime;

                j.timeSlice = j.ioBound ? 1 : 2;

                j.arrivalTime = clock;
                j.firstCpuTime = -1;
                j.finishTime = -1;
                j.sliceUsed = 0;

                int typeIndex = j.ioBound ? 0 : 1;
                int cpuIndex = cpuTimeIndex(j.totalCpuTime);
                jobCounts[typeIndex][cpuIndex]++;

                waitQueue.add(j);

                if (clock <= 600) {
                    out.println("Time " + clock
                            + "s: Job " + j.id
                            + " class=" + (j.ioBound ? "IO" : "CPU")
                            + " cpuTime=" + j.totalCpuTime
                            + " ENTERED system");
                }

                jobsCreated++;
            }

            while (!waitQueue.isEmpty() && cpuQueue.size() < 10) {
                Job next = waitQueue.remove();

                if (next.firstCpuTime == -1) {
                    next.firstCpuTime = clock;
                    int waitTime = next.firstCpuTime - next.arrivalTime;
                    totalWaitTime += waitTime;
                }

                cpuQueue.add(next);
            }

            if (!cpuQueue.isEmpty()) {
                cpuBusySeconds++;

                Job current = cpuQueue.peek();

                current.remainingCpuTime--;
                current.sliceUsed++;

                if (current.remainingCpuTime <= 0) {
                    current.finishTime = clock;
                    jobsCompleted++;

                    int typeIndex = current.ioBound ? 0 : 1;
                    int cpuIndex = cpuTimeIndex(current.totalCpuTime);

                    int cpuQueueTime = current.finishTime - current.firstCpuTime;
                    totalCpuQueueTime[typeIndex][cpuIndex] += cpuQueueTime;

                    cpuQueue.remove();
                } else if (current.sliceUsed >= current.timeSlice) {
                    cpuQueue.remove();
                    current.sliceUsed = 0;
                    cpuQueue.add(current);
                }
            } else {
                cpuIdleSeconds++;
            }

            if (clock > 600 && clock % 60 == 0) {
                Job frontCpuJob = cpuQueue.peek();
                int frontId = (frontCpuJob == null) ? -1 : frontCpuJob.id;

                out.println("\n=== System summary at " + clock + " seconds ===");
                out.println("Jobs in wait queue: " + waitQueue.size());
                out.println("Jobs in CPU queue:  " + cpuQueue.size());
                out.println("Front CPU job id:   " + (frontId == -1 ? "none" : frontId));
            }
        }

        out.println("\n===== Simulation complete =====");
        out.println("Total simulated time (seconds): " + clock);
        out.println("Total jobs created: " + jobsCreated);
        out.println("Total jobs completed: " + jobsCompleted);

        double avgWait = (jobsCompleted == 0) ? 0.0 :
                (double) totalWaitTime / jobsCompleted;
        out.println("\nAverage time in WAIT queue (seconds): " + avgWait);

        out.println("\nAverage time in CPU queue (seconds), by class and CPU time:");
        int[] cpuOptions = {10, 20, 30, 60};
        for (int typeIndex = 0; typeIndex < 2; typeIndex++) {
            String className = (typeIndex == 0) ? "IO-bound" : "CPU-bound";
            out.println("  " + className + ":");
            for (int i = 0; i < cpuOptions.length; i++) {
                int count = jobCounts[typeIndex][i];
                if (count > 0) {
                    double avgCpuQ = (double) totalCpuQueueTime[typeIndex][i] / count;
                    out.println("    CPU " + cpuOptions[i] + "s: "
                            + count + " job(s), avg CPU queue time = " + avgCpuQ);
                } else {
                    out.println("    CPU " + cpuOptions[i] + "s: 0 jobs");
                }
            }
        }

        double busyPercent = (clock == 0) ? 0.0 :
                (100.0 * cpuBusySeconds / clock);
        out.println("\nCPU busy time: " + cpuBusySeconds + " seconds");
        out.println("CPU idle time: " + cpuIdleSeconds + " seconds");
        out.println("CPU busy percentage: " + busyPercent + "%");

        double hours = (clock == 0) ? 0.0 : (clock / 3600.0);
        double throughput = (hours == 0.0) ? 0.0 : (jobsCompleted / hours);
        out.println("\nSystem throughput (jobs per hour): " + throughput);

        out.close();
        keyboard.close();
    }

    private static int cpuTimeIndex(int cpuTime) {
        if (cpuTime == 10) return 0;
        if (cpuTime == 20) return 1;
        if (cpuTime == 30) return 2;
        return 3;
    }

    private static class Job {
        int id;
        boolean ioBound;
        int totalCpuTime;
        int remainingCpuTime;
        int timeSlice;
        int arrivalTime;
        int firstCpuTime;
        int finishTime;
        int sliceUsed;
    }
}
