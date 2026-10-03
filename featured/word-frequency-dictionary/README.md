# Word-Frequency Dictionary

An implementation of the SENG 505 Program Set 2 Part B dictionary assignment. The program reads *Alice in Wonderland*, normalizes the text, and stores words in a custom multi-list dictionary organized into 26 buckets by first letter.

## Concepts
- custom abstract data type
- nested `ArrayList` structures
- frequency counting
- searching and removal
- selection sorting for top-word ranking
- URL/network input with `Scanner`
- encapsulated `Entry` objects

## Run
```bash
cd src
javac Dictionary.java
java Dictionary
```

The program reads the Project Gutenberg copy of *Alice in Wonderland*, so network access is required for the default run path.

## Design note
The assignment specifically required an outer 26-element list with an inner list for each starting letter. The structure is therefore intentionally more explicit than using a built-in `Map` would be in production code.
