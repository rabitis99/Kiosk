package Lv3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Kiosk kiosk=new Kiosk(scanner);
        kiosk.start();

    }
}
