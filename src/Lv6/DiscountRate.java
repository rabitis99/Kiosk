package Lv6;


/**
 * 할인율을 정의하는 열거형 (Enum)
 * 각각의 클래스를 만들어준다.
 */
public enum DiscountRate {
    국가유공자(0.90F, 1), // 10% 할인
    군인(0.95F, 2),      // 5% 할인
    학생(0.97F, 3),      // 3% 할인
    일반(1.00F, 4);      // 할인 없음

    private final float rate; // 할인율
    private final int labelNum; // 식별 번호()


    /**
     * 생성자: 할인율과 식별 번호를 초기화
     * @param rate 할인율
     * @param labelNum 식별 번호
     */

    DiscountRate(float rate, int labelNum) {
        this.rate = rate;
        this.labelNum = labelNum;
    }


    /**
     * 할인율을 반환하는 메서드
     * @return 할인율 (float)
     */

     public float getRate() {
        return rate;
    }

    /**
     * 식별 번호를 반환하는 메서드
     * @return 식별 번호 (int)
     */

    public int getLabelNum() {
        return labelNum;
    }

    /**
     * 할인 정보를 출력하는 메서드
     * discountPercentage 정확한 값을위해 반올림 처리
     */

    public static void showDiscount() {
        System.out.println("번호 | 할인 유형 | 할인율");
        System.out.println("------------------------");
        for (DiscountRate discountRate : DiscountRate.values()) {
            // 할인율을 퍼센트로 변환하여 정수형으로 출력
            int discountPercentage = Math.round((1 - discountRate.rate) * 100);
            System.out.println(discountRate.labelNum + ". " + discountRate.name() + "     " + discountPercentage + "%");
        }
    }

    /**
     * 입력된 식별 번호에 해당하는 할인율을 반환하는 메서드
     * @param labelNum 사용자 입력 식별 번호
     * @return 해당하는 DiscountRate 객체
     * @throws IllegalArgumentException 유효하지 않은 번호 입력 시 예외 발생
     */

     public static DiscountRate discount(int labelNum) {

         for (DiscountRate discountRate : DiscountRate.values()) {
            if (labelNum == discountRate.labelNum) {
                return discountRate;
            }
        }
        throw new ArithmeticException("잘못된 입력입니다.");
    }
}
