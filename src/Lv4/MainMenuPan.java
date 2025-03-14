package Lv4;

public class MainMenuPan {
    private final String[] mainMenu = {"Burgers", "Drinks", "Desserts"};

    public void showMenu() {
        System.out.println( );
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < mainMenu.length; i++) {
            System.out.println((i + 1) + ". " + mainMenu[i]);
        }
        System.out.println("0. 종료      | 종료");

    }
}

