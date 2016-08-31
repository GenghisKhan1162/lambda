package only.you.lambda.word;

public class Word implements Comparable<Word> {

	public final int count;
	public final String word;
	
	public Word(String _word, int _count) {
		this.word = _word;		
		this.count = _count;
	}

	@Override
	public int compareTo(Word o) {
		int result = Integer.compare(o.count, this.count);
		if (result == 0)
			result = this.word.compareTo(o.word);
		return result;
	}
}
