package Lv6;

/**
 * 개별 메뉴 아이템을 관리하는 클래스
 */
public class MenuItem {
    private String name;   // 메뉴 이름
    private double price;  // 메뉴 가격
    private String comment; // 메뉴 설명

    /**
     * MenuItem 생성자
     * @param name 메뉴 이름
     * @param price 메뉴 가격
     * @param comment 메뉴 설명
     */
    public MenuItem(String name, double price, String comment) {
        this.name = name;
        this.price = price;
        this.comment = comment;
    }

    /**
     * 메뉴 아이템 정보를 출력하는 메서드
     */
    public void printMenuItem() {
        System.out.println(name + " | ₩" + price + " | " + comment);
    }

    /**
     * 메뉴 이름을 반환하는 메서드
     * @return 메뉴 이름
     */
    public String getName() {
        return name;
    }

    /**
     * 메뉴 가격을 반환하는 메서드
     * @return 메뉴 가격
     */
    public double getPrice() {
        return price;
    }
}
