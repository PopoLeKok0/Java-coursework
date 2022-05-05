public class Q3_ReverseSortDemo {
	public static void main(String[] args){
		char[] unorderedLetters;
		unorderedLetters = new char[]{'b', 'm', 'z', 'a', 'u'};
		reverseSort(unorderedLetters);
		for (int i = 0 ; i < unorderedLetters.length; i++ )
			System.out.println(unorderedLetters[i]);
	}
	
	public static void reverseSort(char[] values){
		char ch;
		for (int i = 0; i < values.length-1; i++) {
		    for (int j = 0; j < values.length-i-1; j++) {
                if(values[j] < values[j+1]){
		           ch = values[j];
                   values[j] = values[j+1];
                   values[j+1] = ch;
                }
		    }
		}	
	}
}