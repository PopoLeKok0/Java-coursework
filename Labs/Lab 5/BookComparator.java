import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

    public int compare(Book a , Book b){
        int authorsCompare = a.getAuthor().compareTo(b.getAuthor());
        int titlesCompare = a.getTitle().compareTo(b.getTitle());
        
        if ( authorsCompare == 0 ) {
            if ( titlesCompare == 0 ) {
                if (a.getYear()<b.getYear()) {
                    return -1;
                }
                else if (a.getYear()>b.getYear()) {
                    return 1;
                }
                else{
                    return 0;
                }
            }
            return titlesCompare;
        } 
        return authorsCompare;
    }       
}