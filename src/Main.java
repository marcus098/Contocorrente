import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tmp = 0;
        double value = 0;
        ContoCorrente conto1 = new ContoCorrente(10000);
        boolean flag = true;
        while (flag) {
            value = 0;
            tmp = 0;
            System.out.println();
            while (tmp <= 0 || tmp > 6) {
                System.out.println("Cosa vuoi fare?\n1. Prelievo\n2. Versamento\n3. Saldo\n4. Ultimi 5 Movimenti\n5. Movimenti anno\n6. Esci");
                tmp = sc.nextInt();
            }
            switch (tmp) {
                case 1:
                    while (value <= 0) {
                        System.out.println("Inserisci importo prelievo");
                        value = sc.nextDouble();
                    }
                    conto1.prelievo(value);
                    break;

                case 2:
                    while (value <= 0) {
                        System.out.println("Inserisci importo versamento");
                        value = sc.nextDouble();
                    }
                    conto1.versamento(value);
                    break;

                case 3:
                    System.out.println(conto1);
                    break;
                case 4:
                    conto1.lista();
                    break;
                case 5:
                    while (value < 1900 || value> LocalDateTime.now().getYear()) {
                        System.out.println("Inserisci anno controllo");
                        value = sc.nextInt();
                    }
                    conto1.listaAnno((int)(value));
                    break;
                case 6:
                    flag = false;
                    break;
            }
        }

    }

}
