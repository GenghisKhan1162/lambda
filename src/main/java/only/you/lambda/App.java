package only.you.lambda;

import only.you.lambda.word.WordCounter;

public class App 
{
    public static void main( String[] args )
    {
        int count = WordCounter.getWordsCount();
    	System.out.println( "Всего: " + count );
    }
}
