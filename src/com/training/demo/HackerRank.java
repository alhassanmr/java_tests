package com.training;

import java.util.Arrays;
import java.util.jar.Attributes;
import java.util.*;

//task 1
//Different compression techniques are used in order to reduce the size of the messages sent over the web. An algorithm is designed to compress a given string by describing the total number of consecutive occurrences of each character next to it. For example, consider the string "abaasass" Group the consecutive occurrence of each character:
//        • 'a'occurs one time.
//        • 'b'occurs one time.
//        • 'a'occurs two times consecutively.
//        • 's'occurs one time.
//        • 'a'occurs one time.
//        • 's'occurs two times consecutively.
//        If a character only occurs once, it is added to the compressed string.
//        If it occurs consecutive times, the character is added to the string followed by an integer representing the number of consecutive occurrences. Thus the compressed form of the string is "aba2sas?"
//        Function Description
//        Complete the function compressedString in the editor below. The function must return the compressed form of message.
//        compressedString has the following parameter(s):
//        string message: a string
//        Returns:
//        string: the compressed message

public static String compressedString(String message) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        char prev = message.charAt(0);

        for (int i = 1; i < message.length(); i++) {
            char curr = message.charAt(i);
            if (curr == prev) {
                count++;
            } else {
                compressed.append(prev);
                if (count > 1) {
                    compressed.append(count);
                }
                    count = 1;
                    prev = curr;
            }
        }
        compressed.append(prev);
        if (count > 1) {
            compressed.append(count);
        }
        return compressed.toString();
}



//task 2
//        Given a set of words and a set of sentences (composed of those words), determine how many sentences can be created by rearranging the letters of each word in each input sentence, where rearranging words is only possible if the resulting word is also present in the input set of words.
//        Example
//        wordSet = ('listen', 'silent', 'it', 'is']
//        sentence = 'listen it is silent'
//        Note: The words in the set are unique, sentences are composed only of words from the word set and a sentence is composed of words separated by a single' '.
//        Determine that the letters of listen can be rearranged into silent (i.e. these words are anagrams). Those two words can be replaced with each other. The four sentences that can be created are:
//        • listen it is silent
//        • listen it is listen
//        • silent it is silent
//        • silent it is listen
//        Function Description
//        Complete the countSentences function in the editor below.
//        countSentences has the following parameters:
//        string wordSet[n]: an array of unique strings string sentences[m]: an array of strings
//        Returns:
//        in[] an array of m integers that denote the number of sentences that can be formed from each sentence
//        Constraints
//        • 0 <n= 105
//        • 1 s length of each word s 20
//        • 1 sms 1000
//        • 3 s words in a sentence s 20
//        • Each word is made up of characters in the range ascii[a-z].

public static List<Long> countSentences(List<String> wordSet, List<String> sentences) {

        Map<String, List<String>> anagramMap = wordSet.stream()
        .distinct()
        .collect(Collectors.groupingBy(word -> word.chars()
            .mapToObj(c -> (char) c)
            .sorted()
            .map(Object::toString)
            .collect(Collectors.joining())
        ));

        List<Long> result = new ArrayList<>();

        for (String sentence : sentences) {
        String[] words = sentence.split(" ");

        long count = Stream.of(words)
            .map(word -> anagramMap.getOrDefault(word.chars()
                .mapToObj(c -> (char) c)
                .sorted()
                .map(Object::toString)
                .collect(Collectors.joining()),Collections.emptyList()))
            .filter(list -> !list.isEmpty())
            .mapToLong(List::size)
            .reduce(1, (a, b) -> a * b);

        result.add(count);
        }

        return result;
}
//        In this solution, we first create a map of anagrams of the words in the wordSet using the groupingBy() collector. We use a key mapper that sorts the characters in each word and joins them back into a string, which creates a key that is the same for all anagrams of a given word. The resulting map is a Map<String, List<String>> where the keys are the sorted strings and the values are lists of the original words that are anagrams of each other.
//
//        We then iterate over the sentences array and split each sentence into words. For each word, we look up the list of anagrams in the anagramMap using the sorted string as the key. If the list does not contain the original word, we set the count to 0 and break out of the loop. Otherwise, we multiply the count by the size of the list of anagrams for the word.


//task 3
//        give solution in java 8.
//        Given an integer k and a list of integers, count the number of
//        distinct valid pairs of integers (a, b) in the list for which a + k = b.
//        Two pairs of integers (a, b) and (c, d) are considered distinct if at least one element of (a, b) does not also belong to (c, d).
//        Example
//        n =4
//        numbers = [1, 1. 1, 2)
//        k = 1
//        This array has two different valid pairs: (1, 1) and (1, 2). For k = 1,
//        there is only 1 valid pair which satisfies a + k = b: the pair (a, b) = (1, 2).
//        Function Description
//        Complete the function countairs in the editor below.
//        countairs has the following parameter(s):
//        int numbers[n]: array of integers int k: target difference
//        Returns
//        int: number of valid (a, b) pairs in the numbers array that have a difference of k
//        Constraints
//        • 2 <=n <n 2 × 10exponent 5
//        • 0 <= numbers[i]= 10exponent 9, where 0<= i <= n
//        • 0 <= k <= 10exponent 9

public class Solution {
    public static int countPairs(int[] numbers, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<Integer> pairs = new HashSet<>();

        for (int number : numbers) {
            if (seen.contains(number - k)) {
                pairs.add(number - k);
            }
            if (seen.contains(number + k)) {
                pairs.add(number);
            }
            seen.add(number);
        }

        return pairs.size();
    }
}

//    Note that the main change from the previous solution is that we're now using two sets to keep track of the numbers we've seen and the pairs we've found, respectively. This ensures that we don't count the same pair twice, even if the input contains duplicate numbers.