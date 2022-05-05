public class Geometric extends AbstractSeries {

    private double prochainePuisssance=0.0;
    private double derniereVal=0.0;

    public double next() {
        derniereVal+=1.0/Math.pow(2.0, prochainePuisssance);
        prochainePuisssance++;
        return derniereVal;
    }
}