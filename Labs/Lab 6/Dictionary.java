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
        count = 0;
    }

    @Override
    public void put(String key, Integer value) {
        elems[count++] = new Pair(key, value);
        if (count == elems.length){
            this.increaseCapacity();
        }
    }

    private void increaseCapacity() {
         Pair[] elems2 = new Pair[this.getCapacity()+INCREMENT];
        for (int i = 0; i<elems.length; i++) {
            elems2[i] = elems[i];
        }
        elems = elems2;
    }

    @Override
    public boolean contains(String key) {
       for (int i = count-1; i > -1; i--) {
            return elems[i].getKey().equals(key);
        }
        return false;

    }

    @Override
    public Integer get(String key) {
        for (int i = count-1; i>=0; i--){
            if (elems[i].getKey().equals(key)) {
                return elems[i].getValue();
            }
        }
        return -1;
    }

    @Override
    public void replace(String key, Integer value) {
         for (int i = count-1; i > -1; i--) {
            if(elems[i].getKey().equals(key))elems[i].setValue(value);
        }
    }

    @Override
    public Integer remove(String key) {
       Integer retourne=null;
        for (int i=count-1; i>=0; i--) {
            Pair p=elems[i];
            if (p!=null && p.getKey().equals(key)) {
                retourne=p.getValue();
                elems[i] = null;
                count--;
                break;
            }
        }
        return retourne;
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