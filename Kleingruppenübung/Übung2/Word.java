import java.util.Scanner;

public class Word
{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int number = 0;
        // wait for the user to enter a positive whole number
        while(number < 1){
            System.out.println("Bitte pos. Ganzzahl eingeben!");
            number = scanner.nextInt();
        }
        
        // read a word
        System.out.println("Bitte ein Wort eingeben!");
        String word = scanner.next();
        
        // output the word as many times as specified by the entered positive number
        for(int i = 0; i < number; i++){
            System.out.println(word);
        }
    }
}
