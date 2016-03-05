package Main;

import java.util.Scanner;

public class MainLoop {
	
	 //Input scanner
	static Scanner input = new Scanner(System.in);
	
	//Variables
	static String playerName = ""; //Player's Name 
	static int str = 4;
	static int con = 4;
	static int dex = 4;
	static int intel = 4;
	static int spd = 4;
	static int lck = 4;

	public static void main(String[] args) {
		//Start game build
		System.out.println("Welcome to the Maze!");
		System.out.println("This game is controlled through a text based interface!");
		//Get player name
		System.out.print("Let's try it out! Enter your name: ");
		playerName = input.nextLine();
		System.out.println("Hello " + playerName + ", what a cool name.");
		System.out.println("Ok, to start lets tell you a littl bit about how to play this game.");
		System.out.println("First you need to pick your stats.");
		//Explain Stats
		System.out.println("The stats you need to balance are Strength, Constitution, Dexterity, Intelligence, Speed, and Luck.");
		System.out.println("Strength determines how much damage you do and whether you can break certain objects with shear strength.");
		System.out.println("Constitution determines how much health you have and how resistant you are to poison and fatigue.");
		System.out.println("Dexterity determines how likely it is you can dodge attacks and disarm traps.");
		System.out.println("Intelligence determines if you can read a scroll or cast a spell, it also plays into disarming traps.");
		System.out.println("Speed determines how fast you can move throughout the dungeon, if it is low you take more time and things get harder the longer you spend in a level.");
		System.out.println("Luck is how likely you are to come out on the good end of a random event. It is a flat bonus to any dice roll.");
		System.out.println("An average skill level is 4, you have 8 points to spend. You can not improve a single skill beyond 8 at the beginning of the game.");
		System.out.println("Current Skill levels: STR: " + str);
		System.out.println("CON: " + con);
		System.out.println("DEX: " + dex);
		System.out.println("INT: " + intel);
		System.out.println("SPD: " + spd);
		System.out.println("LCK: " + lck);
		int skillPoints = 8;
		//Increase Strength
		System.out.println("Current Skill Points remaining: " + skillPoints);
		boolean flag = true;
		boolean firstLoop = true;
		while(!flag || firstLoop){
			if(firstLoop){
				firstLoop = !firstLoop;
			}
			System.out.println("How many points do you want to spend on strength? Remember the maximum is 4, minimum is 0.");
			int strengthAdd = input.nextInt();
			if(strengthAdd >= 0){
				if(strengthAdd <= 4){
					if(strengthAdd <= skillPoints){
						str += strengthAdd;
						skillPoints -= strengthAdd;
						flag = true;
						System.out.println("Strength increased to: " + str);
					}else{
						flag = false;
						System.out.println("Sorry you only have " + skillPoints + " remaining, try again!");
					}
				}else{
					System.out.println("Sorry, You cant add that many skill points to one skill. Try a number lower than 4.");
					flag = false;
				}
			}else{
				System.out.println("Sorry, you can't reduce a skill!");
				flag = false;
			}
		}
		//Increase Constitution
		System.out.println("Current Skill Points remaining: " + skillPoints);
		flag = true;
		firstLoop = true;
		while(!flag || firstLoop){
			if(firstLoop){
				firstLoop = !firstLoop;
			}
			System.out.println("How many points do you want to spend on constitution? Remember the maximum is 4, minimum is 0.");
			int constitutionAdd = input.nextInt();
			if(constitutionAdd >= 0){
				if(constitutionAdd <= 4){
					if(constitutionAdd <= skillPoints){
						con += constitutionAdd;
						skillPoints -= constitutionAdd;
						flag = true;
						System.out.println("Constitution increased to: " + con);
					}else{
						System.out.println("Sorry you only have " + skillPoints + " remaining, try again!");
						flag = false;
					}
				}else{
					System.out.println("Sorry, You cant add that many skill points to one skill. Try a number lower than 4.");
					flag = false;
				}
			}else{
				System.out.println("Sorry, you can't reduce a skill!");
				flag = false;
			}
		}
		//Increase Dexterity
		System.out.println("Current Skill Points remaining: " + skillPoints);
		flag = true;
		firstLoop = true;
		while(!flag || firstLoop){
		if(firstLoop){
				firstLoop = !firstLoop;
		}
		System.out.println("How many points do you want to spend on dexterity? Remember the maximum is 4, minimum is 0.");
		int dexterityAdd = input.nextInt();
		if(dexterityAdd >= 0){
			if(dexterityAdd <= 4){
				if(dexterityAdd <= skillPoints){
					dex += dexterityAdd;
					skillPoints -= dexterityAdd;
					flag = true;
					System.out.println("Dexterity increased to: " + dex);
				}else{
					System.out.println("Sorry you only have " + skillPoints + " remaining, try again!");
					flag = false;
				}
			}else{
				System.out.println("Sorry, You cant add that many skill points to one skill. Try a number lower than 4.");
				flag = false;
			}
		}else{
			System.out.println("Sorry, you can't reduce a skill!");
			flag = false;
		}
	}
		//Increase Intelligence
				System.out.println("Current Skill Points remaining: " + skillPoints);
				flag = true;
				firstLoop = true;
				while(!flag || firstLoop){
				if(firstLoop){
						firstLoop = !firstLoop;
				}
				System.out.println("How many points do you want to spend on Intelligence? Remember the maximum is 4, minimum is 0.");
				int intelAdd = input.nextInt();
				if(intelAdd >= 0){
					if(intelAdd <= 4){
						if(intelAdd <= skillPoints){
							intel += intelAdd;
							skillPoints -= intelAdd;
							flag = true;
							System.out.println("Intelligence increased to: " + intel);
						}else{
							System.out.println("Sorry you only have " + skillPoints + " remaining, try again!");
							flag = false;
						}
					}else{
						System.out.println("Sorry, You cant add that many skill points to one skill. Try a number lower than 4.");
						flag = false;
					}
				}else{
					System.out.println("Sorry, you can't reduce a skill!");
					flag = false;
				}
			}
				//Increase Speed
				System.out.println("Current Skill Points remaining: " + skillPoints);
				flag = true;
				firstLoop = true;
				while(!flag || firstLoop){
				if(firstLoop){
						firstLoop = !firstLoop;
				}
				System.out.println("How many points do you want to spend on speed? Remember the maximum is 4, minimum is 0.");
				int speedAdd = input.nextInt();
				if(speedAdd >= 0){
					if(speedAdd <= 4){
						if(speedAdd <= skillPoints){
							spd += speedAdd;
							skillPoints -= speedAdd;
							flag = true;
							System.out.println("Speed increased to: " + spd);
						}else{
							System.out.println("Sorry you only have " + skillPoints + " remaining, try again!");
							flag = false;
						}
					}else{
						System.out.println("Sorry, You cant add that many skill points to one skill. Try a number lower than 4.");
						flag = false;
					}
				}else{
					System.out.println("Sorry, you can't reduce a skill!");
					flag = false;
				}
			}
				//Increase Luck
				System.out.println("Current Skill Points remaining: " + skillPoints);
				flag = true;
				firstLoop = true;
				while(!flag || firstLoop){
				if(firstLoop){
						firstLoop = !firstLoop;
				}
				System.out.println("How many points do you want to spend on luck? Remember the maximum is 4, minimum is 0.");
				int luckAdd = input.nextInt();
				if(luckAdd >= 0){
					if(luckAdd <= 4){
						if(luckAdd <= skillPoints){
							lck += luckAdd;
							skillPoints -= luckAdd;
							flag = true;
							System.out.println("Speed increased to: " + lck);
						}else{
							System.out.println("Sorry you only have " + skillPoints + " remaining, try again!");
							flag = false;
						}
					}else{
						System.out.println("Sorry, You cant add that many skill points to one skill. Try a number lower than 4.");
						flag = false;
					}
				}else{
					System.out.println("Sorry, you can't reduce a skill!");
					flag = false;
				}
			}
	}
	
	

}
