package only.you.lambda.word;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class WordCounter {

	public static int getWordsCount() {
		String fileName = "D:\\q\\Harry_Potter_and_the_Chamber_of_Secrets.txt";
		Map<String, Integer> map = new HashMap<>();
		try (Stream<String> stream = Files.lines(Paths.get(fileName), StandardCharsets.ISO_8859_1)) {
			stream.flatMap(Pattern.compile(" ")::splitAsStream)
					.map(WordCounter::removePunctuationMarks)
					.forEach(s -> map.put(s, map.get(s) == null ? 1
							: map.get(s).intValue() + 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		List<Word> list = new LinkedList<>();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			Word w = new Word(entry.getKey(), entry.getValue());
			list.add(w);
		}
		Collections.sort(list);
		for (Word wc : list) {
			System.out.println(wc.word + " -> " + wc.count);
		}
		return list.size();
	}
	
	public static String removePunctuationMarks(String source){
		return source.replace(".", "")
				     .replace(",", "")
				     .replace(":", "")
				     .replace(";", "")
				     .replace("(", "")
				     .replace(")", "")
				     .replace("?", "")
				     .replace("!", "")
				     .toLowerCase()
				     .trim();
	}
}

// Harry_Potter_and_the_Chamber_of_Secrets.txt
