/**
 * @author Avery Holmes
 * SENG 505 – Dictionary / Multi-List Word Frequency Analyzer
 *
 * Purpose:
 *   Read the full text of Alice in Wonderland, normalize it into lowercase
 *   words, and load them into a custom Dictionary backed by a multi-list
 *   structure (ArrayList<ArrayList<Entry>>). Each distinct word tracks its
 *   occurrence count and supports frequency, removal, average metrics, and
 *   top-N queries.
 */

import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;

public class Dictionary {

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Scanner input = null;

        try {
            URL url = new URL("https://www.gutenberg.org/files/11/11-0.txt");
            input = new Scanner(url.openStream());

            while (input.hasNextLine()) {
                String line = input.nextLine();
                line = line.replaceAll("[^a-zA-Z]", " ");
                line = line.toLowerCase();

                String[] words = line.split("\\s+");

                for (String word : words) {
                    if (word.length() > 0) {
                        dictionary.put(word);
                    }
                }
            }

            String[] topWords = dictionary.getTopWords(100);
            for (String word : topWords) {
                double freq = dictionary.get(word);
                System.out.println(word + " : " + freq);
            }

        } catch (Exception e) {
            System.out.println("Error try again!");
        } finally {
            if (input != null) {
                input.close();
            }
        }
    }

    private ArrayList<ArrayList<Entry>> buckets;
    private int total;

    public Dictionary() {
        buckets = new ArrayList<ArrayList<Entry>>(26);
        for (int i = 0; i < 26; i++) {
            buckets.add(new ArrayList<Entry>());
        }
        total = 0;
    }

    private int getBucketIndex(String word) {
        char c = word.charAt(0);
        c = Character.toLowerCase(c);
        return c - 'a';
    }

    public void put(String word) {
        if (word == null || word.length() == 0) {
            return;
        }

        word = word.toLowerCase();

        int index = getBucketIndex(word);
        ArrayList<Entry> bucket = buckets.get(index);

        for (Entry e : bucket) {
            if (e.getWord().equals(word)) {
                e.increment();
                total++;
                return;
            }
        }

        bucket.add(new Entry(word));
        total++;
    }

    public double get(String word) {
        if (word == null || word.length() == 0 || total == 0) {
            return 0.0;
        }

        word = word.toLowerCase();
        int index = getBucketIndex(word);
        ArrayList<Entry> bucket = buckets.get(index);

        for (Entry entry : bucket) {
            if (entry.getWord().equals(word)) {
                return (double) entry.getCount() / total;
            }
        }

        return 0.0;
    }

    public double remove(String word) {
        if (word == null || word.length() == 0 || total == 0) {
            return 0.0;
        }

        word = word.toLowerCase();
        int index = getBucketIndex(word);
        ArrayList<Entry> bucket = buckets.get(index);

        for (int i = 0; i < bucket.size(); i++) {
            Entry entry = bucket.get(i);

            if (entry.getWord().equals(word)) {
                double frequency = (double) entry.getCount() / total;
                total -= entry.getCount();
                bucket.remove(i);
                return frequency;
            }
        }

        return 0.0;
    }

    public double getAverageLength() {
        int sumLengths = 0;
        int countDistinct = 0;

        for (ArrayList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                sumLengths += entry.getWord().length();
                countDistinct++;
            }
        }

        if (countDistinct == 0) {
            return 0.0;
        }

        return (double) sumLengths / countDistinct;
    }

    public double getAverageFreq() {
        int distinctCount = 0;

        for (ArrayList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                distinctCount++;
            }
        }

        if (distinctCount == 0 || total == 0) {
            return 0.0;
        }

        return 1.0 / distinctCount;
    }

    public String[] getTopWords(int top) {
        ArrayList<Entry> allEntries = new ArrayList<Entry>();

        for (ArrayList<Entry> bucket : buckets) {
            for (Entry entry : bucket) {
                allEntries.add(entry);
            }
        }

        if (top <= 0 || allEntries.size() == 0) {
            return new String[0];
        }

        if (top > allEntries.size()) {
            top = allEntries.size();
        }

        for (int i = 0; i < allEntries.size() - 1; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < allEntries.size(); j++) {
                if (allEntries.get(j).getCount() > allEntries.get(maxIndex).getCount()) {
                    maxIndex = j;
                }
            }

            if (maxIndex != i) {
                Entry temp = allEntries.get(i);
                allEntries.set(i, allEntries.get(maxIndex));
                allEntries.set(maxIndex, temp);
            }
        }

        String[] result = new String[top];
        for (int k = 0; k < top; k++) {
            result[k] = allEntries.get(k).getWord();
        }

        return result;
    }

    private static class Entry {
        private String word;
        private int count;

        public Entry(String word) {
            this.word = word;
            this.count = 1;
        }

        public String getWord() {
            return word;
        }

        public int getCount() {
            return count;
        }

        public void increment() {
            count++;
        }
    }
}
