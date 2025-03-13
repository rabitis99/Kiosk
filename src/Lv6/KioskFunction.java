package Lv6;

import java.util.List;

/**
 * KioskFunction 클래스
 * - 메뉴 관련 기능을 수행하는 클래스
 */
public class KioskFunction {
    private MenuDataBase menuDataBase; // 메뉴 데이터베이스 객체

    /**
     * KioskFunction 생성자
     * @param menuDataBase 메뉴 데이터를 관리하는 데이터베이스 객체
     */
    public KioskFunction(MenuDataBase menuDataBase) {
        this.menuDataBase = menuDataBase;
    }

    /**
     * 특정 인덱스의 메뉴 카테고리를 출력하고 해당 메뉴를 반환하는 메서드
     * @param i 선택한 메뉴의 인덱스
     * @return 선택한 메뉴 객체
     * @throws IllegalArgumentException 메뉴 선택 범위를 초과한 경우 예외 발생
     */
    public Menu printCategory(int i) {
        try {
            Menu menu = menuDataBase.getMenuList().get(i);
            System.out.println(menu.getCategory()); // 카테고리 출력
            return menu;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("⚠ 메뉴 선택 범위를 초과했습니다.");
        }
    }

    /**
     * 특정 메뉴의 모든 메뉴 아이템을 출력하는 메서드
     * @param menu 출력할 메뉴 객체
     */
    public void printMenu(Menu menu) {
        for(int i=0; i<menu.getMenuItems().size(); i++){
            MenuItem menuItems=menu.getMenuItems().get(i);
            System.out.print((i+1)+". ");
            menuItems.printMenuItem();
        }
    }

    /**
     * 특정 메뉴에서 선택한 메뉴 아이템을 출력하고 반환하는 메서드
     * @param menu 메뉴 객체
     * @param i 선택한 메뉴 아이템의 인덱스
     * @return 선택한 메뉴 아이템 객체
     * @throws IllegalArgumentException 메뉴 아이템 선택 범위를 초과한 경우 예외 발생
     */
    public MenuItem printSelection(Menu menu, int i) {
        try {
            MenuItem selectedItem = menu.getMenuItems().get(i);
            int selectedpirce= (int)(selectedItem.getPrice()*1000);
            System.out.println(selectedItem.getName() + " " + selectedpirce+ "원을 선택하셨습니다.");
            return selectedItem;
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("⚠ 메뉴 아이템 선택 범위를 초과했습니다.");
        }
    }
}
