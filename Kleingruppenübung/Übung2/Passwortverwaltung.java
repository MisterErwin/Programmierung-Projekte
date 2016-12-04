import java.util.Scanner;

public class Passwortverwaltung
{
    // password cache - initialisation
    private static String password = null;
    
    // input buffer
    
    public static void main(String args[]){
        // scanner for analysing the input
        Scanner scanner = new Scanner(System.in);
        String input; // input buffer
        
        System.out.println("Guten Tag!");
        welcome(); // print command reference
        // Loop that keeps running until the user input "V" to quit the application
        while(!(input = scanner.next()).equals("V")){
            
            // cases for input seperation
            if("A".equals(input)){
                System.out.println("\n");
                // if password isn't set, there's nothing to display. Otherwise print the password
                if(password == null){
                    System.out.println("Das Passwort wurde noch nicht gesetzt! Bitte setzen Sie das Passwort erst!");
                } else {
                    System.out.println(password);
                }
            } else if(input.equals("S")){
                 String confirm; // Buffer for confirmation of the entered password
                 System.out.println("Bitte geben Sie das neue Passwort ein:");
                 password = scanner.next(); // receive the first password
                 System.out.println("Bitte geben Sie das Passwort erneut ein:");
                 confirm = scanner.next(); // receive the confirmation
                 if(password.equals(confirm)){ // Compare both strings to be equals
                     System.out.println("Das Passwort wurde gesetzt.");
                 } else { // otherwise let the user know he has to try again
                     System.out.println("Die Passwörter stimmen nicht überein. Bitte versuchen Sie es erneut");
                     password = "";
                 }
            } else { // catching all invalid inputs
                System.out.println("Diese Eingabe wurde nicht erkannt. Bitte versuchen Sie es erneut");
            }
            welcome(); // print command reference after every loop run
        }    
        System.out.println("Vielen Dank für Ihren Besuch!");
        System.exit(0);
    }
    /**
     * welcome service - prints the possible operations for the user to choose 
     */
    private static void welcome(){
        System.out.println("\n");
        System.out.println("Bitte wählen Sie eine der folgenden Möglichkeiten:");
        System.out.println("A: Anzeigen des Passworts");
        System.out.println("S: Setzen des Passworts");
        System.out.println("V: Verlassen des Programms");
    }
}
