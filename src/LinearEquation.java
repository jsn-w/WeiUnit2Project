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
    public double calculateSlope () {
        slope = ((double)(y2) - y1) / ((double)(x2) - x1);
        return slope;
    }
    public double calculateB () {
        b = y1 - slope * x1;
        return b;
    }

    public String getEquation() {
        if (x1 == x2) {
            return "x = " + x1;
        }
        return "y = " + (y2 - y1) + "/" + (x2 - x1) + "x + " + Math.round(b * 100) / 100.;
    }

    private void calculateDistance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        System.out.println("The distance between the two points is: " + distance);
    }

    public void coordinateForX(double xValue) {
        if (x1 == x2) {
            System.out.println("There is no corresponding point when x = " + xValue);
        }
        System.out.println("The point on the line is (" + xValue + ", " + (slope * xValue + b) + ")");
    }
}
