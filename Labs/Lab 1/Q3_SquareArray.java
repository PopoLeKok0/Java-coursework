public class Q3_SquareArray{

	public static int[] createArray(int size) {
		int[] arr1=new int[size];
		for (int i=0; i<=size-1; i++){
		    arr1[i]=i*i;
		}
		return arr1;
	}
	
	public static void main(String[] args){
		int[] arr2=Q3_SquareArray.createArray(12);
		for (int i=0; i<arr2.length-1; i++) {
            System.out.println("The square of " + i + " is: " + arr2[i]);
        }
    }
}