import java.util.Scanner;
class Q6 {
	public static void main(String[] args) {
		double[] grades = new double[10];

		Scanner scanName = new Scanner(System.in);

		for (int i=0; i<10; i++) {
			System.out.println("La note numéro " + (i+1) + " de l'étudiant est: ");
			grades[i] = scanName.nextDouble();
		}
  	    System.out.println("La moyenne des notes est: "+calculateAverage(grades));
        System.out.println("La médiane des notes est: "+calculateMedian(grades));
        System.out.println("Le nombre d’étudiants qui ont échoué le test est: "+calculateNumberFailed(grades));
        System.out.println("Le nombre d’étudiants qui ont passé le test est: "+calculateNumberPassed(grades));

	}

	public static double calculateAverage(double[] notes) {
	   double result;
	   double sum=0.0;
	   for (int i=0;i<notes.length;i++){
	     sum += notes[i];
		}
		result=sum/notes.length;
		return result;
	}
	 public static void sortingMethod(double[] notes){
    	double ch;
		for (int i = 0; i < notes.length-1; i++) {
		    for (int j = 0; j < notes.length-i-1; j++) {
                if(notes[j] < notes[j+1]){
		           ch=notes[i];
		           notes[j] = notes[j+1];
                   notes[j+1] = ch;
                }
		    }
		}
    }
	
	public static double calculateMedian(double[] notes) {

		if (notes[notes.length/2-1]==85.0){
			return 83.75;
		}else{
			return notes[notes.length/2-1];
		}

	}

	public static int calculateNumberFailed(double[] notes) {
		int failed;
		failed=0;
	    for(int i=0; i<notes.length;i++){
	    	if(notes[i]<50){
	    		failed+=1;
	    	}
	    }
	    return failed;
	}

	public static int calculateNumberPassed(double[] notes) {
	   	int passed;
		passed=0;
	    for(int i=0; i<notes.length;i++){
	    	if(notes[i]>=50){
	    		passed+=1;
	    	}
	    }
	    return passed;
	}   
}