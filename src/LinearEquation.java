public class LinearEquation {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private double slope;
    private double b;
    public LinearEquation (int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        calculateSlope();
        calculateB();
    }

    public String lineInfo () {
        String str = "The two points are: (";
        str += x1 + ", " + y1 + ") and (";
        str += x2 + ", " + y2 + ")";
        return str;
    }
    public void calculateSlope () {
        slope = ((double)(y2) - y1) / ((double)(x2) - x1);
    }
    public void calculateB () {
        b = y1 - slope * x1;
    }

    public String getEquation() {
        return "y = " + slope + "x + " + b;
    }
}
