import java.util.Random;
import java.util.Scanner;

/**
 * @author Annika Tuulivuori
 * @version 5.1.2023
 * 
 * Käyttäjä voi kokeilla arvata kolmella (3) yrityksellä
 * satunnaisesti arvottu luku väliltä 1-100 
 *
 */
public class ArvaaNumero {

    /**
     * @param args tyhjä
     */
    public static void main(String[] args) {
        ArvaaNumeroPeli();

    }
    
    /**
     * Numeroarvauspelin metodi
     */
    public static void ArvaaNumeroPeli() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        
        System.out.println("==== Arvaa Numero -peli! ====");
        System.out.println("Saat 3 yritystä arvata numeron");
        
        
        int arvottu = RandomNumero();
        
        int i, arvaus;
        
        int kierroksia = 3;
        
        for (i = 0; i < kierroksia; i++) {
            System.out.print("Anna numero väliltä 1-100 ja paina enter >");
            
            arvaus = input.nextInt();
            
            if (arvaus < 1 || arvaus > 100) {
                System.out.println("Et noudattanut sääntöjä joten peli loppui :(");
                break;
            } else if (arvaus == arvottu) {
                System.out.println("Onneksi olkoon! Arvasit numeron :)");
                break;
            } else if (arvaus > arvottu && i != kierroksia - 1) {
                System.out.println("Arvaa pienempi numero!");
            } else if (arvaus < arvottu && i != kierroksia - 1){
                System.out.println("Arvaa suurempi numero");
            }
        }
        
        input.close();
        
        if (i == kierroksia) {
            System.out.println("Ei enää arvauskertoja jäljellä :(");
            System.out.println("Numero oli " + arvottu);
        }
    }
    
    /**
     * Arpoo satunnaisen (arvattavan) luvun
     * @return random arvattava numero
     */
    public static int RandomNumero() {
        Random rand = new Random();
        
         return rand.nextInt(100 - 1) + 1;
    }

}
