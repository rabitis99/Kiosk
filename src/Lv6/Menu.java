package Lv6;

import java.util.List;

/**
 * 특정 카테고리의 메뉴를 관리하는 클래스
 */
public class Menu {
    private String category; // 메뉴 카테고리명
    private List<MenuItem> menuItems; // 해당 카테고리의 메뉴 아이템 리스트

    /**
     * Menu 생성자
     * @param category 메뉴 카테고리명
     * @param menuItems 해당 카테고리의 메뉴 아이템 리스트
     */
    public Menu(String category, List<MenuItem> menuItems) {
        this.category = category;
        this.menuItems = menuItems;
    }

    /**
     * 카테고리명을 반환하는 메서드
     * @return 카테고리명
     */
    public String getCategory() {
        return category;
    }

    /**
     * 해당 카테고리의 메뉴 아이템 리스트를 반환하는 메서드
     * @return 메뉴 아이템 리스트
     */
    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}

