package Lv6;

import java.util.Scanner;

/**
 * Order 클래스: 사용자의 주문을 처리하는 역할을 담당
 */
public class Order extends InputValidator {
    private Cart cart; // 장바구니 객체
    private Scanner scanner; // 사용자 입력을 받는 Scanner 객체

    /**
     * Order 클래스 생성자
     * @param cart 장바구니 객체
     * @param scanner 사용자 입력을 받는 Scanner 객체
     */
    public Order(Cart cart, Scanner scanner) {
        this.cart = cart;
        this.scanner = scanner;
    }

    /**
     * 사용자의 주문 관련 선택을 처리하는 메서드
     * @param choice 사용자의 선택 (1: 메뉴 삭제, 2: 메뉴판으로 돌아가기, 3: 주문하기)
     * @return 주문 프로세스를 계속 진행할지 여부 (true: 계속, false: 종료)
     */
    public boolean startOrder(int choice) {
        boolean running=true;
        switch (choice) {
            case 1:
                // 메뉴 삭제 기능
                running=delelMenu();
                break;
            case 2:
                // 메뉴판으로 돌아가기
                System.out.println("메뉴판으로 돌아갑니다.");
                running=true;
                break;

            case 3:
                // 주문 진행
                running=processOrder();
                break;

            default:
                // 올바르지 않은 입력 처리
                System.out.println("⚠ 잘못된 입력입니다.");
                running=true;
        }
        return running;
    }

    /**
     * 장바구니에서 아이템을 삭제하는 메서드
     * @return 계속 진행 여부
     */
    private boolean delelMenu() {
        System.out.print("1 : 메뉴 삭제  2: 취소");
        int cancelChoiceNum = getValidInt(scanner);

        switch (cancelChoiceNum) {
            case 1:
                // 삭제할 메뉴 번호 입력받기
                System.out.print("삭제할 메뉴의 번호를 입력해주세요");
                int cancelNum = getValidInt(scanner);
                cart.removeCart(cancelNum);
                break;
            case 2:
                // 취소 선택 시 아무 동작 없이 종료
                break;
            default:
                System.out.println("⚠ 잘못된 입력입니다.");
        }
        return true;
    }
    /**
     * *주문을 처리하는 메서드
     * @return 계속 진행 여부
     */
    private boolean processOrder() {
        System.out.println("1 : 주문하기  2: 취소");
        int orderChoiceNum = getValidInt(scanner);

        switch (orderChoiceNum) {
            case 1:
                // 총 가격 계산 및 출력
                cart.calculateTotalprice();
                cart.printCart();

                // 할인율 선택 및 적용
                DiscountRate.showDiscount();
                int labelNum = getValidInt(scanner);
                DiscountRate discountRate = null;
                try {
                    discountRate = DiscountRate.discount(labelNum);
                }catch (ArithmeticException e){
                    System.out.println(e.getMessage());
                }
                // 할인 적용 후 총 금액 계산 (10원 단위 반올림)
                int totalRateRound = (Math.round((discountRate.getRate() * cart.getTotal()) / 10)) * 10;
                System.out.println("할인 적용 후 총 금액: " + totalRateRound+"원");

                // 최종 주문 내역 출력
                cart.printCart();

                return false; // 주문 완료 후 종료
            case 2:
                // 주문 취소 후 계속 진행
                return true;
            default:
                System.out.println("⚠ 잘못된 입력입니다.");
        }
        return true;
    }
}

