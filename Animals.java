import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Animals {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayCollection<String> animalCollection = new ArrayCollection<String>();
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", 
                            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", 
                            "Y", "Z"};
        File file = new File("Animals.txt");
        Scanner scanner = new Scanner(file);
        
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            animalCollection.add(line);
        }
        
        scanner.close();
        System.out.println("Ready to Play!");
        int score = 0;
        boolean stillPlaying = true; 
        while(stillPlaying)
        {
            if(score==0){
            int randomLetterNum = (int) (Math.random() * letters.length);
            String randomLetter = letters[randomLetterNum];
            System.out.println("Your letter is: " + randomLetter);
            System.out.println("Enter an animal that starts with this letter and Capitalize the first letter: ");
            }
            Scanner inputScanner = new Scanner(System.in);
            String userInput = inputScanner.nextLine();
            if(animalCollection.contains(userInput))
            {
                System.out.println("Correct! Keep going!");
                score++;
                animalCollection.remove(userInput);
            }
            else
            {
                System.out.println("Incorrect! Game Over!");
                System.out.println("Your score is: " + score+"\nPlay Again? (Y/N)");
                if(inputScanner.nextLine().equals("Y"))
                {
                    stillPlaying = true;
                    score = 0;
                    animalCollection = new ArrayCollection<String>();
                    Scanner scanner2 = new Scanner(file);
                    while (scanner2.hasNextLine()) {
                        String line = scanner2.nextLine();
                        animalCollection.add(line);
                    }
                    scanner2.close();
                }
                else
                {
                    stillPlaying = false;
                }
            }
        }
    }
}