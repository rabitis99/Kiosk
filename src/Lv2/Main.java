package Lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int quit = 0;
        List<MenuItem> hamburgerMenu = new ArrayList<>();
        hamburgerMenu.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Hamburger  ", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));
        do {
            for (MenuItem menuItem : hamburgerMenu) {
                menuItem.printMenuItem();
            }
            System.out.print("숫자를 입력해주세요 : ");
            quit = scanner.nextInt();
            scanner.nextLine();
            switch (quit) {

                case 0:
                    break;
                case 1:
                    hamburgerMenu.get(0).printMenuItem();
                    break;
                case 2:
                    hamburgerMenu.get(1).printMenuItem();
                    break;
                case 3:
                    hamburgerMenu.get(2).printMenuItem();
                    break;
                case 4:
                    hamburgerMenu.get(3).printMenuItem();
                    break;
            }
            System.out.println(" ====================================" );

        } while (quit != 0);
    }
}
