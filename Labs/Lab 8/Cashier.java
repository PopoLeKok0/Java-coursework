import java.util.*;
public class Cashier{
  private Queue<Customer>queue;
  private Customer currentCustomer;
  private int totalWaitTime;
  private int customersServed;
  private int itemsServed;
  public Cashier(){
    queue = new ArrayQueue<Customer>();
    itemsServed = 0;
    customersServed = 0;
    totalWaitTime = 0;
  }
  public void addCustomer(Customer c) { 
    queue.enqueue(c); 
  }

  public int getQueueSize() { 
    return queue.size();
  }
  public void serveCustomers(int currentTime){
   if (currentCustomer==null && queue.size()>0) { 
     currentCustomer=queue.dequeue(); 
     totalWaitTime+=currentTime-currentCustomer.getArrivalTime(); 
      customersServed++; 
    }

    if (currentCustomer!=null) { 
      if (currentCustomer.getNumberOfItems()>0) { 
        currentCustomer.serve(); 
      }

      if (currentCustomer.getNumberOfItems()==0) { 
        itemsServed+=currentCustomer.getNumberOfServedItems(); 
        currentCustomer=null; 
      }
    }
  }
  public int getTotalCustomerWaitTime(){
    return totalWaitTime;
  }
  public int getTotalCustomersServed(){
    return customersServed;
  }
  public int getTotalItemsServed(){
    return itemsServed;
  }
  public String toString(){
    return "Total Wait Time: " + totalWaitTime + "\nCustomers Served: "+ customersServed + "\nTotal Items Served: " + itemsServed;
  }
}
