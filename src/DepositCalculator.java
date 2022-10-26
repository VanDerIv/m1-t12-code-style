import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double amount, double yearRate, int depositPeriod ) {
        double pay = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return round(pay, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        return round(amount + amount * yearRate * depositPeriod, 2);
    }
    
    /* Мне кажется, что лучше дать функции какое-то другое имя,
    например, roundAmount, так как существует Math.round() и можно запутаться при их
    одновременном использовании*/
    double round(double amount , int places) {
        double scale = Math.pow(10, places);
        return Math.round(amount * scale) / scale;
    }

    void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        int depositAmount = scanner.nextInt();

        System.out.println("Введите срок вклада в годах:");
        int depositPeriod = scanner.nextInt();

        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        int action = scanner.nextInt();
        
        /* Я бы вынес значение 0.06 в переменную yearRate, так как оно используется в нескольких
        местах и, при необходимости, в дальнейшем его можно будет более гибко менять*/
        double out = 0;
        if (action == 1) {
            out = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (action == 2) {
            out = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }

        System.out.println("Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + out);
    }

    public static void main(String[] args) {
        new DepositCalculator().run();
    }
}
