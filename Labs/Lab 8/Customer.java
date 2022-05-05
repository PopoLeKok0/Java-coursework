import java.util.*;
public class Customer{
  private int arrivalTime;
  private int numItems;
  private int numServedItems;
  private static final int MAX_NUM_ITEMS = 20;
  private Random generator = new Random();
public Customer(int arrivalTime){
 this.arrivalTime = arrivalTime;
 numItems=0;
 numItems = generator.nextInt(MAX_NUM_ITEMS-1)+1;
}
 public int getArrivalTime(){
    return arrivalTime;   
  }
  
  public int getNumberOfItems(){
    return numItems;
  }
  
  public int getNumberOfServedItems(){
    return numServedItems;
  }
  
  public void serve(){
    numItems--;
    numServedItems++;
  }
}