import java.util.Iterator;
public class ITIStringBuffer {
    private String a;
    private SinglyLinkedList<String> strs;
    private int size;
    private boolean new1;

    public ITIStringBuffer() {
        a="";
        strs=new SinglyLinkedList<String>();
        size=0;
        new1=false;
    }

    public ITIStringBuffer(String  firstString){
        this();
        append(firstString);
    }

    public void append(String nextString){
        strs.add(nextString);
        size+=nextString.length();
        new1=true;
    }

    public String toString(){
        if (new1) {
            int i = 0;
            Iterator<String> iterator=strs.iterator();
            char[] ch=new char[size];
            while(iterator.hasNext()) {
                char[] b=iterator.next().toCharArray();
                for (int j=0; j<b.length; j++) {
                    ch[i]=b[j];
                    i++;
                }
            }
            a=new String(ch);
            new1=false;
        }

        return a;
    }
}
