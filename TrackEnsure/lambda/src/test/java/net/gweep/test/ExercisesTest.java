package net.gweep.test;

import org.junit.jupiter.api.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class ExercisesTest {

// Exercise 1: Print out all the words in wordList, which is
// a static List<String> defined at the bottom of this file.

	@Test
	@Disabled
	public void printAllWords() {
		/* TODO */
		// no assertions
		wordList.forEach(System.out::println);
	}

// Exercise 2: Convert all words in wordList to upper case,
// and gather the result into an output list.

	@Test
	@Disabled
	public void upperCaseWords() {
		List<String> output = null; /* TODO */

		output = wordList.stream().map(String::toUpperCase).collect(Collectors.toList());

		assertEquals(Arrays.asList("EVERY", "PROBLEM", "IN", "COMPUTER", "SCIENCE", "CAN", "BE", "SOLVED", "BY",
				"ADDING", "ANOTHER", "LEVEL", "OF", "INDIRECTION"), output);
	}

// Exercise 3: Find all the words in wordList that have even length
// and put them into an output list.

	@Test
	@Disabled
	public void findEvenLengthWords() {
		List<String> output = null; /* TODO */

		output = wordList.stream().filter(s -> s.length() % 2 == 0).collect(Collectors.toList());

		System.out.println(output);

		assertEquals(Arrays.asList("in", "computer", "be", "solved", "by", "adding", "of"), output);
	}

// Exercise 4: Count the number of lines in a file. The field *reader*
// is a BufferedReader which will be opened for you on the text file.
// See the JUnit @Before and @After methods at the bottom of this file.
// The text file is "SonnetI.txt" (Shakespeare's first sonnet) which is
// located at the root of this project.

	@Test
	@Disabled
	public void countLinesInFile() throws IOException {
		long count = 0L; /* TODO */

		count = reader.lines().count();

		assertEquals(14, count);
	}

// Exercise 5: Join lines 3-4 from the text file into a single string.

	@Test
	@Disabled
	public void joinLineRange() throws IOException {
		String output = null; /* TODO */

		output = reader.lines().skip(2).limit(2).collect(Collectors.joining());

		System.out.println(output);

		assertEquals("But as the riper should by time decease," + "His tender heir might bear his memory:", output);
	}

// Exercise 6: Find the length of the longest line in the file.

	@Test
	@Disabled
	public void lengthOfLongestLine() throws IOException {
		int longest = 0; /* TODO */

		longest = reader.lines().mapToInt(String::length).max().getAsInt();

		Stream.of();

		assertEquals(longest, 53);
	}

// Exercise 7: Collect all the words from the text file into a list.
// Hint: use String.split(REGEXP) to split a string into words.
// Splitting this way results in "words" that are the empty string,
// which should be discarded. REGEXP is defined at the bottom of this file.

	@Test
	@Disabled
	public void listOfAllWords() throws IOException {
		List<String> output = null; /* TODO */

		// Stream<Stream<String> -> flatMap -> Stream<String>

		output = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("From", "fairest", "creatures", "we", "desire", "increase", "That", "thereby",
				"beauty", "s", "rose", "might", "never", "die", "But", "as", "the", "riper", "should", "by", "time",
				"decease", "His", "tender", "heir", "might", "bear", "his", "memory", "But", "thou", "contracted", "to",
				"thine", "own", "bright", "eyes", "Feed", "st", "thy", "light", "s", "flame", "with", "self",
				"substantial", "fuel", "Making", "a", "famine", "where", "abundance", "lies", "Thy", "self", "thy",
				"foe", "to", "thy", "sweet", "self", "too", "cruel", "Thou", "that", "art", "now", "the", "world", "s",
				"fresh", "ornament", "And", "only", "herald", "to", "the", "gaudy", "spring", "Within", "thine", "own",
				"bud", "buriest", "thy", "content", "And", "tender", "churl", "mak", "st", "waste", "in", "niggarding",
				"Pity", "the", "world", "or", "else", "this", "glutton", "be", "To", "eat", "the", "world", "s", "due",
				"by", "the", "grave", "and", "thee"), output);
	}

// Exercise 8: Create a list containing the words, lowercased, in alphabetical order.

	@Test
	@Disabled
	public void sortedLowerCase() throws IOException {
		List<String> output = null; /* TODO */

		output = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
				.map(String::toLowerCase).sorted().collect(Collectors.toList());

		assertEquals(
				Arrays.asList("a", "abundance", "and", "and", "and", "art", "as", "be", "bear", "beauty", "bright",
						"bud", "buriest", "but", "but", "by", "by", "churl", "content", "contracted", "creatures",
						"cruel", "decease", "desire", "die", "due", "eat", "else", "eyes", "fairest", "famine", "feed",
						"flame", "foe", "fresh", "from", "fuel", "gaudy", "glutton", "grave", "heir", "herald", "his",
						"his", "in", "increase", "lies", "light", "mak", "making", "memory", "might", "might", "never",
						"niggarding", "now", "only", "or", "ornament", "own", "own", "pity", "riper", "rose", "s", "s",
						"s", "s", "self", "self", "self", "should", "spring", "st", "st", "substantial", "sweet",
						"tender", "tender", "that", "that", "the", "the", "the", "the", "the", "the", "thee", "thereby",
						"thine", "thine", "this", "thou", "thou", "thy", "thy", "thy", "thy", "thy", "time", "to", "to",
						"to", "to", "too", "waste", "we", "where", "with", "within", "world", "world", "world"),
				output);
	}

// Exercise 9: Sort unique, lower-cased words by length, then alphabetically
// within length, and place the result into an output list.

	@Test
	@Disabled
	public void sortedLowerCaseDistinctByLengthThenAlphabetically() throws IOException {
		List<String> output = null; /* TODO */

		output = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
				.map(String::toLowerCase).distinct()
				.sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
				.collect(Collectors.toList());

		assertEquals(Arrays.asList("a", "s", "as", "be", "by", "in", "or", "st", "to", "we", "and", "art", "bud", "but",
				"die", "due", "eat", "foe", "his", "mak", "now", "own", "the", "thy", "too", "bear", "else", "eyes",
				"feed", "from", "fuel", "heir", "lies", "only", "pity", "rose", "self", "that", "thee", "this", "thou",
				"time", "with", "churl", "cruel", "flame", "fresh", "gaudy", "grave", "light", "might", "never",
				"riper", "sweet", "thine", "waste", "where", "world", "beauty", "bright", "desire", "famine", "herald",
				"making", "memory", "should", "spring", "tender", "within", "buriest", "content", "decease", "fairest",
				"glutton", "thereby", "increase", "ornament", "abundance", "creatures", "contracted", "niggarding",
				"substantial"), output);
	}

// Exercise 10: Categorize the words into a map, where the map's key is
// the length of each word, and the value corresponding to a key is a
// list of words of that length. Don't bother with uniqueness or lower-
// casing the words.

	@Test
	@Disabled
	public void mapLengthToWordList() throws IOException {
		Map<Integer, List<String>> map = null; /* TODO */

		map = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
				.collect(Collectors.groupingBy(String::length));

		assertEquals(6, map.get(7).size());
		assertEquals(Arrays.asList("increase", "ornament"), map.get(8));
		assertEquals(Arrays.asList("creatures", "abundance"), map.get(9));
		assertEquals(Arrays.asList("contracted", "niggarding"), map.get(10));
		assertEquals(Arrays.asList("substantial"), map.get(11));
		assertFalse(map.containsKey(12));
	}

// Exercise 11: Gather the words into a map, accumulating a count of the
// number of occurrences of each word. Don't worry about upper case and
// lower case. Extra challenge: implement two solutions, one that uses
// groupingBy() and the other that uses toMap().

	@Test
	@Disabled
	public void wordFrequencies() throws IOException {
		Map<String, Long> map = null; /* TODO */
//
//		map = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
//				.collect(Collectors.groupingBy(s -> s, Collectors.counting()));

		map = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
				.collect(Collectors.toMap(s -> s, s -> 1L, Long::sum));

		assertEquals(2L, (long) map.get("tender"));
		assertEquals(6L, (long) map.get("the"));
		assertEquals(1L, (long) map.get("churl"));
		assertEquals(2L, (long) map.get("thine"));
		assertEquals(3L, (long) map.get("world"));
		assertFalse(map.containsKey("lambda"));
	}

// Exercise 12: Create nested maps, where the outer map is a map from the
// first letter of the word to an inner map. (Use a string of length one
// as the key.) The inner map, in turn, is a mapping from the length of the
// word to a list of words with that length. Don't bother with any lowercasing
// or uniquifying of the words.
//
// For example, given the words "foo bar baz bazz" the string
// representation of the result would be:
//     {f={3=[foo]}, b={3=[bar, baz], 4=[bazz]}}.

	@Test
	// @Disabled
	// use without stream after flatMap
	public void nestedMaps() throws IOException {
		Map<String, Map<Integer, List<String>>> map = new HashMap<>(); /* TODO */

//		map = reader.lines().flatMap(s -> Stream.of(s.split(REGEXP))).filter(s -> !s.isEmpty())
//				.collect(Collectors.groupingBy(s -> s.substring(0, 1), Collectors.groupingBy(String::length)));

		map = new Main().nestedMapNew();

		assertEquals("[From, Feed]", map.get("F").get(4).toString());
		assertEquals("[by, be, by]", map.get("b").get(2).toString());
		assertEquals("[the, thy, thy, thy, too, the, the, thy, the, the, the]", map.get("t").get(3).toString());
		assertEquals("[beauty, bright]", map.get("b").get(6).toString());
	}

// ===== TEST INFRASTRUCTURE ==================================================

	static List<String> wordList = Arrays.asList("every", "problem", "in", "computer", "science", "can", "be", "solved",
			"by", "adding", "another", "level", "of", "indirection");
	// Butler Lampson

	static final String REGEXP = "\\W+"; // for splitting into words

	private BufferedReader reader;

	@BeforeEach
	public void setUpBufferedReader() throws IOException {
		reader = Files.newBufferedReader(Paths.get("/home/gweep/eclipse-workspace/lambda/SonnetI.txt"),
				StandardCharsets.UTF_8);
	}

	@AfterEach
	public void closeBufferedReader() throws IOException {
		reader.close();
	}
}