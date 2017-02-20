package dog.human.years;

import java.util.Scanner;

/**
  For testing purposes:
  Dog age of 1 = Human age 13
  Dog age of 2 = Human age 18
  Dog age of 5 = Human age 34
  Dog age of 8 = Human age 50
  Dog age of 12 = Human age 72
 */




public class DogYears {

    public int convertToHumanYears(int dog) {
    	int human = 13 + (int)(16.0 / 3.0 * (dog - 1) + 0.5);
    	return human;
    }

	
    public int convertToDogYears(int human) {
    	// Work on this once you have finished convertToHumanYears()!
    	int dog = (int) ((6.0*(human-13.0)+29.0)/(32.0));
    	return dog+1;
    }
    

	public static void main (String[] args) {
		// TAKE IN USER INPUT
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("1 - Dog age to equivalent human years conversion");
		System.out.println("2 - Human years to equivalent Dog age conversion");
		System.out.print("Enter the number of the option you would like to select:");
		int mode = keyboard.nextInt();
		
		
		if (mode == 1) {
			
		System.out.print("Enter the dog's age:");
		int dog = keyboard.nextInt();
		keyboard.close();

		DogYears converter = new DogYears();
		int human = converter.convertToHumanYears(dog);

		System.out.println(human);
		
		} else if (mode == 2){
			System.out.print("Enter the number of human years:");
			int human = keyboard.nextInt();
			keyboard.close();

			DogYears converter = new DogYears();
			int dog = converter.convertToDogYears(human);

			System.out.println(dog);
			
		} else {
			System.out.println("ERROR: You did not enter a valid mode number!");
			main(args);
		}
	}

}