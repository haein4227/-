import java.util.Scanner;

public class jhi20231977_mid1 {
    public static void main(String[] args) {
        int user = 0;
        int com = (int)(Math.random() * 3); // 0,1,2
        Scanner scan = new Scanner(System.in);

        System.out.println("===========가위바위보 게임을 시작합니다============");
        System.out.print("가위(0), 바위(1), 보(2) 입력: ");
        user = scan.nextInt();

        // 결과 값 출력
        System.out.print("컴퓨터: ");
        switch (com) {
            case 0:
                System.out.print("가위");
                break;
            case 1:
                System.out.print("바위");
                break;
            case 2:
                System.out.print("보");
                break;
        }
        System.out.print(", 사용자: ");
        switch (user) {
            case 0:
                System.out.println("가위");
                break;
            case 1:
                System.out.println("바위");
                break;
            case 2:
                System.out.println("보");
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                return;
        }

        // 승패 판단
        if (user == com) {
            System.out.println("비겼습니다.");
        } else if ((user == 0 && com == 2) || (user == 1 && com == 0) || (user == 2 && com == 1)) {
            System.out.println("사용자 Win!!");
        } else {
            System.out.println("컴퓨터 Win!!");
        }

        System.out.println("============가위바위보 게임을 종료합니다==============");
    }
}