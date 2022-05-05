public class Q3_ArrayInsertionDemo{

    public static int[] insertIntoArray(int[] beforeArray, int indexToInsert, int valueToInsert){
     int afterArray[] =new int[beforeArray.length+1];
     if (indexToInsert==0){
        afterArray[0]=valueToInsert;
      }else if (indexToInsert==beforeArray.length){
        afterArray[beforeArray.length]=valueToInsert;
      }
     for(int i=0;i<beforeArray.length;i++){
      if(i==indexToInsert){
        afterArray[i]=valueToInsert;
        afterArray[indexToInsert+1]=beforeArray[indexToInsert];
      }else if(i<indexToInsert){
        afterArray[i]=beforeArray[i];
      }else if(i>indexToInsert){
        afterArray[i+1]=beforeArray[i];
      }
     }
     return afterArray;
    }

    public static void main(String[] args){
      int beforeArray2[]= {1,5,4,7,9,6};
      int indexToInsert2= 3;
      int valueToInsert2= 15;
      System.out.println("Array avant l'insertion:");
    for (int item1:beforeArray2){
      System.out.println(item1);
    }
    System.out.println("Array après l'insertion de " +valueToInsert2 +" à position " + indexToInsert2 +":");
    int arr2[] = insertIntoArray(beforeArray2,indexToInsert2,valueToInsert2);
    for (int item2: arr2){
      System.out.println(item2);
     }
  }
  }
