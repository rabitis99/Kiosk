package Lv6;

/**
 * 메인 메뉴를 출력하는 클래스
 */
public class MainMenuPan {
    // 메인 메뉴 항목 배열 (카테고리 리스트)
    private final String[] mainMenu = {"Burgers", "Drinks", "Desserts"};

    /**
     * 메인 메뉴를 출력하는 메서드
     */
    public void showMenu() {
        System.out.println();
        System.out.println("[ MAIN MENU ]");
        for (int i = 0; i < mainMenu.length; i++) {
            System.out.println((i + 1) + ". " + mainMenu[i]);
        }
    }
}

