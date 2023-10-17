import java.util.Scanner;
public class LinearEquationLogic {
    private Scanner scan;
    private String coordinate1;
    private String coordinate2;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private LinearEquation linearEquation;

    public LinearEquationLogic() {
        scan = new Scanner(System.in);
    }

    public void start(){
        userInput();
    }

    private void userInput() {
        System.out.print("Enter coordinate 1 (integers only): ");
        String coor1 = scan.nextLine();
        this.coordinate1 = coor1;
        parseString(coordinate1, 1);
        System.out.print("Enter coordinate 2 (integers only): ");
        String coor2 = scan.nextLine();
        this.coordinate2 = coor2;
        parseString(coordinate2, 2);
        createObject();
        String coorString = linearEquation.lineInfo();
        System.out.println(coorString);
//        System.out.println("Enter x-value");
//        int xValue = scan.nextInt();
        String equation = linearEquation.getEquation();
        System.out.println(equation);
    }

    private void parseString(String coordinate, int num) {
        String coor = coordinate;
        while(coor.indexOf(" ") != -1) {
            int index = coor.indexOf(" ");
            coor = coor.substring(0, index) + coor.substring(index + 1);
        }
        coor = coor.substring(1);
        int firstComma = coor.indexOf(",");
        if (num == 1) {
            x1 = Integer.parseInt(coor.substring(0, firstComma));
        } else {
            x2 = Integer.parseInt(coor.substring(0, firstComma));
        }
        coor = coor.substring(firstComma + 1);
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
