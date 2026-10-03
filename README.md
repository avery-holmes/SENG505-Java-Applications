# SENG 505 - Java Applications

Curated Java coursework from **SENG 505: Programming Applications with Java** at West Virginia University. This repository highlights my progression from introductory console programs into object-oriented programming, collections, custom data structures, recursion, stacks/queues, file/network I/O, validation, and simulation.

## Course context and authorship

The Fall 2025 course syllabus describes SENG 505 as an introduction to programming concepts and techniques using Java, with **two individual programming sets** and **one large-scale group application**. This portfolio intentionally focuses on work I authored for the individual assignments.

The collaborative **MediaApp** project is **not included** here because it was the course's group application and included code from teammates and AI-assisted review iterations. I want the code in this repository to be straightforward for a hiring manager or interviewer to discuss with me as my own work.

> **Portfolio note:** The Java source is kept close to the original course submissions so it honestly represents my skill progression at the time. The repository organization, documentation, and build hygiene were cleaned up later for portfolio use.

## Featured projects

| Project | Concepts demonstrated | Why it is featured |
| --- | --- | --- |
| [CPU Scheduler Simulation](featured/cpu-scheduler-simulation/) | `Queue`, `LinkedList`, simulation, randomization, aggregation, file output | Models a clock-driven CPU scheduler and reports throughput and queue metrics. |
| [Word-Frequency Dictionary](featured/word-frequency-dictionary/) | custom ADT, nested `ArrayList`, searching/sorting, URL I/O | Builds a 26-bucket multi-list dictionary and analyzes word frequency in *Alice in Wonderland*. |
| [Polynomial Tool](featured/polynomial-tool/) | `LinkedList`, `ListIterator`, object composition, ordered insertion | Stores polynomial terms in degree order, combines like terms, adds polynomials, and evaluates them. |
| [Palindrome with Stacks](featured/palindrome-stack/) | `Stack`, normalization, algorithmic comparison | Uses a two-stack approach to determine whether user input is a palindrome. |
| [Airplane Seat Assignment](featured/airplane-seat-assignment/) | 2D arrays, parsing, validation, exception handling | Implements an interactive 13-row aircraft seat map with class restrictions and defensive input handling. |
| [Recursive Palindrome Checker](featured/recursive-palindrome-checker/) | recursion, string normalization, base/recursive cases | Demonstrates the same problem solved recursively rather than with an iterative collection. |

## Fundamentals

The [fundamentals](fundamentals/) directory contains smaller early-course exercises that show the foundation behind the later projects: input/output, arithmetic, conditionals, loops, parsing, and use of the Java standard library.

## Running the projects

All projects use the Java standard library only. From a project's `src` directory:

```bash
javac *.java
java <MainClass>
```

Each featured project README identifies its main class and any runtime behavior such as generated output files or network access.

## Skills represented

- Java syntax, methods, and control flow
- Object-oriented decomposition
- Arrays and multidimensional arrays
- `ArrayList`, `LinkedList`, `ListIterator`, `Stack`, and `Queue`
- Custom data structures / ADTs
- Searching and sorting logic
- Recursion
- Defensive input validation and exception handling
- File and network I/O
- Simulation and basic metrics
- Git/GitHub portfolio organization

## About me

I am a software engineering graduate student transitioning from enterprise risk/governance into software development. My current work has moved beyond these Java foundations into mobile development with React Native/TypeScript and full-stack product development. This repository is retained as evidence of the Java foundation and problem-solving progression behind that transition.
