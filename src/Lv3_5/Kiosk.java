package Lv3_5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {
    private List<MenuItem> hamburgerMenu = new ArrayList<>();
    private List<MenuItem> dessertMenus = new ArrayList<>();
    private List<MenuItem> drinkMenus = new ArrayList<>();
    Scanner scanner;

    Kiosk(Scanner scanner) {
        this.scanner = scanner;
        hamburgerMenu.add(new MenuItem("ShackBurger ", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        hamburgerMenu.add(new MenuItem("Hamburger", 5.4, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinkMenus.add(new MenuItem("Coke", 2.0, "시원한 코카콜라"));
        drinkMenus.add(new MenuItem("Lemonade", 3.0, "상큼한 레모네이드"));
        drinkMenus.add(new MenuItem("Iced Coffee", 3.5, "시원한 아이스 커피"));
        drinkMenus.add(new MenuItem("Milkshake", 4.5, "부드럽고 달콤한 밀크쉐이크"));

        dessertMenus.add(new MenuItem("Vanilla Ice Cream", 3.5, "부드러운 바닐라 아이스크림"));
        dessertMenus.add(new MenuItem("Chocolate Brownie", 4.2, "진한 초콜릿 브라우니"));
        dessertMenus.add(new MenuItem("Cheesecake", 5.0, "크리미한 치즈케이크"));
        dessertMenus.add(new MenuItem("Apple Pie", 4.8, "달콤한 사과 파이"));
    }

    public void start() {
        int menuNum;
        List<MenuItem> menuItemList = null;

        while (true) {
            System.out.println("1: 햄버거, 2: 음료, 3: 디저트, 0: 종료");
            try {
                System.out.print("숫자를 입력해주세요: ");
                menuNum = scanner.nextInt();
                scanner.nextLine();

                if (menuNum == 0) {
                    System.out.println("프로그램을 종료합니다.");
                    return;
                }

                switch (menuNum) {
                    case 1:
                        menuItemList = hamburgerMenu;
                        break;
                    case 2:
                        menuItemList = drinkMenus;
                        break;
                    case 3:
                        menuItemList = dessertMenus;
                        break;
                    default:
                        System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                        continue;
                }

                System.out.println("=== 메뉴 리스트 ===");
                for (int i = 0; i < menuItemList.size(); i++) {
                    System.out.println((i + 1) + ". " + menuItemList.get(i).name);
                }
                System.out.println("0: 이전 메뉴로 돌아가기");

                int quit;
                while (true) {
                    System.out.print("메뉴 번호를 선택해주세요: ");
                    try {
                        quit = scanner.nextInt();
                        scanner.nextLine();

                        if (quit == 0) {
                            break;
                        }

                        if (quit < 1 || quit > menuItemList.size()) {
                            System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
                            continue;
                        }

                        menuItemList.get(quit - 1).printMenuItem();
                        System.out.println("====================================");
                    } catch (InputMismatchException e) {
                        System.out.println("숫자만 입력해주세요.");
                        scanner.nextLine();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("숫자만 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}
