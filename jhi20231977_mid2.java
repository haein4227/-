import java.util.Scanner;
import java.util.Random;

public class jhi20231977_mid2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        String[] choices = {"가위", "바위", "보"};
        
        System.out.println("묵찌바 게임 시작!");
        
        boolean isAttackerUser = false; // 사용자가 공격자인지 여부
        boolean isFirstRound = true; // 첫 라운드인지 여부
        
        while (true) {
            if (isFirstRound) {
                System.out.println("첫 번째 라운드입니다. 가위, 바위, 보 중 하나를 선택하세요:");
            } else {
                System.out.println(isAttackerUser ? "당신의 공격 차례입니다. 가위, 바위, 보 중 하나를 선택하세요:" : "컴퓨터의 공격 차례입니다.");
            }
            
            String userChoice = scanner.nextLine();
            int computerChoiceIndex = random.nextInt(3);
            String computerChoice = choices[computerChoiceIndex];
            
            System.out.println("컴퓨터의 선택: " + computerChoice);
            
            if (userChoice.equals(computerChoice)) {
                if (!isFirstRound) {
                    if (isAttackerUser) {
                        System.out.println("축하합니다! 당신이 이겼습니다!");
                        break;
                    } else {
                        System.out.println("아쉽게도 컴퓨터가 이겼습니다.");
                        break;
                    }
                }
            } else {
                // 가위바위보 로직으로 공격자 결정
                if (isFirstRound || (!isFirstRound && !isAttackerUser)) {
                    int result = determineWinner(userChoice, computerChoice);
                    if (result == 1) {
                        isAttackerUser = true;
                        System.out.println("당신이 공격자가 되었습니다.");
                    } else if (result == -1) {
                        isAttackerUser = false;
                        System.out.println("컴퓨터가 공격자가 되었습니다.");
                    }
                    isFirstRound = false;
                }
            }
        }
        
        scanner.close();
    }
    
    private static int determineWinner(String userChoice, String computerChoice) {
        if ((userChoice.equals("가위") && computerChoice.equals("보")) ||
            (userChoice.equals("바위") && computerChoice.equals("가위")) ||
            (userChoice.equals("보") && computerChoice.equals("바위"))) {
            return 1; // 사용자 승
        } else {
            return -1; // 컴퓨터 승
        }
    }
}
