
public class Combination{
	private int first; 
	private int second;
	private int third;
	public Combination(int first, int second, int third){
		this.first=first;
		this.second=second;
		this.third=third;
	}
	 public boolean equals(Combination other){
	 	if (other==null){
			return false;
		}else if ((other.first==first) && (other.second==second) && (other.third==third)){
	 		return true;
	 	}else{
	 		return false;
	 	}

	 }
	public String toString(){
		return first +":"+second+":"+third;
	} 
}

