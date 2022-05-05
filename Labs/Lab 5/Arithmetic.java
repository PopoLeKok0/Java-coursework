public class Arithmetic extends AbstractSeries {

    private double valProchaine = 1.0;
    private double derniereVal = 0.0;

    public double next() {
        derniereVal+=valProchaine;
        valProchaine+=1.0;
        return derniereVal; 
    }
}