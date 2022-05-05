public class DoorLock{
	public static final int MAX_NUMBER_OF_ATTEMPTS=3;
	private Combination combination;
	private boolean ouvert;
	private boolean activee;
	private int nombreEssais;
	public DoorLock(Combination combination){
		this.combination=combination;
		ouvert=false;
		activee=true;
		nombreEssais=0;


	}
	public boolean isOpen(){
		return ouvert;
	}
	public boolean isActivated(){
		return activee;
	}
	public void activate(Combination c){
		if (combination.equals(c)){
			activee=true;
		}
	}
	public boolean open(Combination combination) {
        if (activee==true) {
            if (this.combination==combination) {
                ouvert=true;
                activee=true;
                nombreEssais=0;
            }

            else if (this.combination!=combination) {
                ouvert=false;
                activee=false;
                nombreEssais+=1;
                if (nombreEssais>=MAX_NUMBER_OF_ATTEMPTS) {
                    ouvert=false;
                    activee=false;
                    nombreEssais=0;
                }
            }

        }
        return ouvert && activee;
        }

}