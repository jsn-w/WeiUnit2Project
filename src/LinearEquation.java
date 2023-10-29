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
        slope();
        yIntercept();
    }

    public String lineInfo () {
        String str = "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of the line is: " + slope;
        str += "\nThe y-intercept of the line is: " + b;
        str += "\nThe distance between these points is: " + distance();
        return str;
    }

    public String equation() {
        String formattedSlope = "";
        String formattedIntercept = "";
        int temp = 0;

        if (x1 == x2) {
            return "x = " + x1;
        } else if (y1 == y2) {
            return "y = " + y1;
        }

        b = yIntercept();
        int numerator = y2 - y1;
        int denominator = x2 - x1;

        if (numerator < 0 && denominator < 0) {
            numerator = Math.abs(numerator);
            denominator = Math.abs(denominator);
        }
        if (denominator < 0) {
            denominator *= -1;
            numerator *= -1;
        }

        if (x1 < 0 && x2 < 0) {
            x1 = Math.abs(x1);
            x2 = Math.abs(x2);
        }
        if (numerator % denominator == 0) {
            int intSlope = numerator/denominator;
            if (intSlope == 1) {
                formattedSlope += "x";
            } else if (intSlope == -1) {
                formattedSlope += "-x";
            } else {
                formattedSlope += intSlope + "x";
            }
        } else {
            formattedSlope += numerator + "/" + denominator + "x";
        }

        double yInt = roundedToHundredth(b);
        if (yInt == 0) {
            formattedIntercept += "";
        } else if (yInt > 0) {
            formattedIntercept += " + " + yInt;
        } else if (yInt < 0) {
            formattedIntercept += " - " + -yInt;
        }

        return "y = " + formattedSlope + formattedIntercept;
    }

    public double slope () {
        slope = ((double)(y2) - y1) / ((double)(x2) - x1);
        return roundedToHundredth(slope);
    }
    public double yIntercept () {
        b = y1 - slope * x1;
        return roundedToHundredth(b);
    }

    public double distance() {
        double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(distance);
    }

    public String coordinateForX(double xValue) {
        if (x1 == x2) {
            return "There is no corresponding value when x = " + xValue;
        } else {
            return "The corresponding point is (" + roundedToHundredth(xValue) + ", " + roundedToHundredth(slope * xValue + b) + ")";
        }
    }

    private double roundedToHundredth(double toRound) {
        toRound = Math.round(toRound * 100) / 100.;
        return toRound;
    }

}
