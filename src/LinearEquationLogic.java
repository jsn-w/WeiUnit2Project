import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private String coordinate1;
    private String coordinate2;
    private int x1, y1, x2, y2;
    private LinearEquation linearEquation;
    private boolean isRunning;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
        start();
    }

    public void start(){
        isRunning = true;
        while (isRunning) {
            inputCoor();
            System.out.println(linearEquation.lineInfo());
            inputValue();
            repeatMessage();
        }
    }

    private void inputCoor() {
        System.out.print("Enter coordinate 1 (integers only): ");
        String coor1 = scan.nextLine();
        this.coordinate1 = coor1;
        parseString(coordinate1, 1);

        System.out.print("Enter coordinate 2 (integers only): ");
        String coor2 = scan.nextLine();
        this.coordinate2 = coor2;
        parseString(coordinate2, 2);
        // if both coordinates are equal to each other
        while (x1 == x2 && y1 == y2) {
            System.out.print("Enter a distinct coordinate (integers only): ");
            coor2 = scan.nextLine();
            this.coordinate2 = coor2;
            parseString(coordinate2, 2);
        }

        createObject();
    }
    private void inputValue() {
        System.out.print("Enter x-value: ");
        int xValue = scan.nextInt();
        scan.nextLine();
        double slope = linearEquation.slope();
        double b = linearEquation.yIntercept();
        System.out.println(linearEquation.coordinateForX(xValue));
    }

    private void repeatMessage() {
        System.out.print("Would you like to enter another pair of coordinates?: ");
        String repeatInput = scan.nextLine();
        if (repeatInput.indexOf("y") == -1) {
            isRunning = false;
        }
    }

    private void parseString(String coordinate, int num) {
        String coor = coordinate;
        while(coor.indexOf(" ") != -1) {
            int index = coor.indexOf(" ");
            coor = coor.substring(0, index) + coor.substring(index + 1);
        }
        coor = coor.substring(1);
        int firstComma = coor.indexOf(",");
        // find the x-value
        if (num == 1) {
            x1 = Integer.parseInt(coor.substring(0, firstComma));
        } else {
            x2 = Integer.parseInt(coor.substring(0, firstComma));
        }
        coor = coor.substring(firstComma + 1);
        // find the y-value
        if (num == 1) {
            y1 = Integer.parseInt(coor.substring(0, coor.length() - 1));
        } else {
            y2 = Integer.parseInt(coor.substring(0, coor.length() - 1));
        }
    }

    private void createObject() {
        linearEquation = new LinearEquation(x1, y1, x2, y2);
    }

}
