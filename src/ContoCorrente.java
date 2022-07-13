import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class ContoCorrente {
    /*
    Crea un programma per la gestione di un contocorrente gestito dalla classe ContoCorrente.
    Il programma deve essere in grado di effettuare versamenti, prelievi, di restituire il saldo e
    di effettuare la lista degli ultimi 5 movimenti.
     */
    private double saldo;
    private int count;
    private boolean check;
    private double[] movimenti;
    private String[] date;

    public ContoCorrente() {
        saldo = 0;
        count = -1;
        date = new String[1];
        movimenti = new double[1];
    }

    public ContoCorrente(double saldo) {
        this.saldo = saldo;
        count = 0;
        date = new String[1];
        movimenti = new double[1];
        //movimenti = new double[5];
    }

    public void versamento(double value) {
        saldo += value;
        System.out.println("Versamento effettuato con successo!");
        count++;
        if (count != 1) {
            setMovimenti(value);
        }
        else {
            movimenti[movimenti.length - 1] = value;
            date[date.length - 1] = getCurrentDate();
        }
        System.out.println(Arrays.toString(movimenti));
    }
private String getCurrentDate(){
    // Get current date time
    LocalDateTime currentDateTime = LocalDateTime.now();
    // Custom format if needed
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    // Format LocalDateTime
    String formattedDateTime = currentDateTime.format(formatter);
    return formattedDateTime;
}
    private void setMovimenti(double value) {
        double[] tmpMov = movimenti.clone();
        String[] tmpStr = date.clone();
        movimenti = new double[count];
        date = new String[count];
        System.out.println(count + " - " + date.length + " - " + tmpStr.length);
        if(count==3)
        System.out.println(date[2]);
        for (int i = 0; i < tmpMov.length; i++) {
            movimenti[i] = tmpMov[i];
            date[i] = tmpStr[i];
        }
        date[date.length - 1] = getCurrentDate();
        movimenti[movimenti.length - 1] = value;
    }

    public void prelievo(double value) {
        if (value > saldo) {
            System.out.println("valore prelievo maggiore del saldo presente!");
        } else {
            saldo -= value;
            System.out.println("Prelievo effettuato con successo!");
            count++;
            if (count != 1) {
                setMovimenti((0 - value));
            } else {
                movimenti[movimenti.length - 1] = value;
                date[date.length - 1] = getCurrentDate();
            }
        }
        System.out.println(Arrays.toString(movimenti));
    }

    public double getSaldo() {
        return saldo;
    }

    public void lista() {
        if (count <= 5) {
            for (int i = movimenti.length - 1; i >= 0; i--)
                System.out.println(movimenti[i] + "Data: " + date[i]);
        } else {
            for (int i = movimenti.length - 1; i >= movimenti.length - 5; i--)
                System.out.println(movimenti[i] + "Data: " + date[i]);
        }
    }

    public void listaAnno(int anno){
        if(anno>1900 && anno <= LocalDateTime.now().getYear()){
            for (int i = date.length - 1; i >= 0; i--)
                if(date[i].startsWith(""+anno))
                    System.out.println(movimenti[i] + "Data: " + date[i]);
        }
    }
    public String toString() {
        System.out.println(Arrays.toString(date));
        return "il saldo presente nel conto e': " + saldo;

    }
}
