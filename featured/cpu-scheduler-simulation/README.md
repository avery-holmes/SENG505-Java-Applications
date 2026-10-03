# CPU Scheduler Simulation

A clock-driven simulation of a multi-user CPU scheduler. Jobs arrive over time, wait for CPU access, rotate through time slices based on whether they are I/O-bound or CPU-bound, and produce summary statistics when the simulation completes.

## Concepts
- `Queue` and `LinkedList`
- discrete-time simulation
- randomized job generation
- nested aggregation of metrics
- file output with `PrintWriter`
- small domain object (`Job`) modeled as an inner class

## Run
```bash
cd src
javac CpuSim.java
java CpuSim
```

Enter the number of jobs to simulate. The program writes its report to `cpusim.txt` in the current working directory.

## What I learned
This assignment connected collection choice to system behavior: a queue is not just an API call here; it models jobs waiting and rotating through a constrained resource. It also required tracking enough state to produce useful performance measurements after the simulation.
