package Lv4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        MenuDataBase menuDataBase=new MenuDataBase();
        kioskFuncion kioskFuncion=new kioskFuncion(menuDataBase);
        Kiosk kiosk=new Kiosk(scanner,kioskFuncion);
        kiosk.start();
    }
}
