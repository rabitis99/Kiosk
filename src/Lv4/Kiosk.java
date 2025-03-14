package Lv4;

import java.util.Scanner;

public class Kiosk {
    private kioskFuncion kioskFuncion;
    private MainMenuPan mainMenuPan= new MainMenuPan();
    private Scanner scanner;
    public Kiosk(Scanner scanner, kioskFuncion kioskFuncion){
        this.scanner=scanner;
        this.kioskFuncion=kioskFuncion;
    }

    public void start(){
        boolean running=true;
        while (running) {
            mainMenuPan.showMenu();
            System.out.print("메뉴를 선택해주세요 : ");
            int menuNum2;
            int menuNum;
            menuNum=scanner.nextInt();
            scanner.nextLine();
            switch (menuNum){
                case 0:
                    running=false;
                    break;
                default:
                    Menu menu=kioskFuncion.printCategory(menuNum);
                    kioskFuncion.printMenuItem(menu);

                    menuNum2=scanner.nextInt();
                    scanner.nextLine();
                    kioskFuncion.printSelction(menu,menuNum2);
            }
        }
    }
}
