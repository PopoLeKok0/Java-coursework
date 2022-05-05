import java.util.NoSuchElementException;

public class Dictionary implements Map<String, Integer> {

    private final static int INITIAL_CAPACITY = 10;
    private final static int INCREMENT = 5;
    private int count;

    private Pair[] elems;

    public int getCount() {
      return count;
    }

    public int getCapacity() {
      return elems.length;
    }

    public Dictionary() {
        elems = new Pair[INITIAL_CAPACITY];
        this.count = 0;
    }

    @Override
    public void put(String key, Integer value) {
         if (key == null || value == null) { 
            throw new NullPointerException("key not found"); 
        }
        if (count == elems.length) { 
            increaseCapacity();
        }
    }

    private void increaseCapacity() {
         if (count >= getCapacity()) { 
            Pair[] temp = elems;  
            elems = new Pair[temp.length + INCREMENT];
            for (int i = 0; i < temp.length; i++) {
                elems[i] = temp[i]; 
            }   
        }
    }

    @Override
    public boolean contains(String key) {
        if (key == null){
            throw new NullPointerException("key is null");
        }
        for (Pair temp: elems) {
            if(temp != null && temp.getKey().equals(key)) 
                return true;
        }
        return false;
    }

    @Override
    public Integer get(String key) {
         boolean flag = false;
        if (key == null) {
            throw new NullPointerException("null value");
        } else {

            for (int i = elems.length - 1; i >= 0; i--) {
                if (elems[i] != null && elems[i].getKey().equals(key)) {
                    flag = true;
                    return elems[i].getValue();
                }
            }
            if (!flag) {
                throw new NoSuchElementException("does not exist");
            }
            return null;
        }
    }

    @Override
    public void replace(String key, Integer value) {
        if(key == null || value == null){
            throw new NullPointerException("null value or key");
        }if(!contains(key)){
            throw new NoSuchElementException("does not exist");
        }for (int i=count-1; i>=0; i--) {
            Pair temp = elems[i];
            if(temp != null && temp.getKey().equals(key)){
                temp.setValue(value);
            }
        }
    }

    @Override
    public Integer remove(String key) {
         if (key == null) { 
            throw new NullPointerException("key not there loser"); 
        }
        if (count == 0) {
            throw new java.util.NoSuchElementException("Nothing to remove here"); 
        }    
        replace(null, null); 
        count--; 
        return get(key); 
    }

    @Override
    public String toString() {
      String res;
      res = "Dictionary: {elems = [";
      for (int i = count-1; i >= 0 ; i--) {
          res += elems[i];
          if(i > 0) {
              res += ", ";
          }
      }
      return res +"]}";
    }

}