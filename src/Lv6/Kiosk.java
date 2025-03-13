package Lv6;

import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 시스템 클래스
 * - 메인 메뉴를 출력하고 사용자 입력을 받아 동작을 수행함.
 */
public class Kiosk extends InputValidator {
    private KioskFunction kioskFunction;  // 키오스크 기능 담당 클래스
    private MainMenuPan mainMenuPan = new MainMenuPan();  // 메인 메뉴 출력 클래스
    private Scanner scanner;  // 사용자 입력을 받는 Scanner
    private Cart cart;  // 장바구니 객체
    private Order order;  // 주문 처리 객체

    /**
     * Kiosk 생성자
     * @param scanner 사용자 입력을 받는 Scanner 객체
     * @param kioskFunction 키오스크 기능을 담당하는 객체
     */
    public Kiosk(Scanner scanner, KioskFunction kioskFunction) {
        this.scanner = scanner;
        this.kioskFunction = kioskFunction;
        this.cart = new Cart();
        this.order = new Order(cart, scanner);
    }

    /**
     * 키오스크 실행 메서드
     * - 메인 메뉴를 출력하고 사용자 입력을 처리함.
     */
    public void start() {
        boolean running = true;
        while (running) {
            mainMenuPan.showMenu();  // 메인 메뉴 출력

            // 장바구니에 아이템이 있을 경우 추가 메뉴 출력
            if (!cart.getCartlist().isEmpty()) {
                System.out.println("[ ORDER MENU ]");
                System.out.println("4. Orders");
                System.out.println("5. Cancel");
            }

            // 종료 메뉴 출력
            System.out.println("0. 종료 | 종료");
            System.out.print("메뉴를 선택해주세요: ");
            int menuNum = getValidInt(scanner);  // 사용자 입력 받기

            switch (menuNum) {
                case 0:
                    running = false;  // 프로그램 종료
                    break;

                case 4:
                    if (!cart.getCartlist().isEmpty()) {
                        cart.showCart();  // 현재 장바구니 출력
                        System.out.println("1. 메뉴 삭제  2. 메뉴판 3. 주문 하기");
                        int choice = getValidInt(scanner);
                        running = order.startOrder(choice);  // 주문 처리
                    } else {
                        System.out.print("⚠ 선택하신 제품이 없습니다\n");
                    }
                    break;

                case 5:
                    if (!cart.getCartlist().isEmpty()) {
                        List<MenuItem> cartlist =cart.getCartlist();
                        for (int i=0; i<cartlist.size();i++){
                            cartlist.remove(i);
                        }
                        cart.setCartlist(cartlist);// 장바구니 비우기
                        System.out.print("장바구니가 비워졌습니다.");
                    } else {
                        System.out.print("⚠ 선택하신 제품이 없습니다\n");
                    }
                    break;

                default:
                    try {
                        // 사용자 선택한 카테고리 출력
                        Menu menu = kioskFunction.printCategory(menuNum - 1);
                        MenuItem menuItem=null;
                        int stack=0;
                        while(stack<5) {
                            try {
                                kioskFunction.printMenu(menu);
                                System.out.print("메뉴를 선택해주세요: ");
                                int menuNum2 = getValidInt(scanner) - 1;
                                menuItem = kioskFunction.printSelection(menu, menuNum2);
                                break;
                            } catch (IllegalArgumentException e) {
                                System.out.println(e.getMessage());
                                stack++;
                                if(stack==4){
                                    start();
                                }
                            }
                        }
                        System.out.print("1. 장바구니 담기 2. 취소 -> ");
                        int putToCartNum = getValidInt(scanner);

                        switch (putToCartNum) {
                            case 1:
                                cart.putToCart(menuItem);
                                System.out.println(menuItem.getName() + "을(를) 장바구니에 담았습니다.");
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("⚠ 잘못된 입력입니다.");
                        }
                    } catch (Exception e) {
                        System.out.println("⚠ 오류 발생: " + e.getMessage());
                    }
            }
        }
    }
}
