package Main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MainLoop {
	
	//Random
	static Random rand = new Random();
	 //Input scanner
	static Scanner input = new Scanner(System.in);
	
	//Variables
	static String playerName = ""; //Player's Name 
	static int Maxhealth = 10; // Player health
	static int Maxmagic = 10; //Player Magic
	static int health = Maxhealth;
	static int magic = Maxmagic;
	//stats
	static int Basestr = 4;
	static int Basecon = 4;
	static int Basedex = 4;
	static int Baseintel = 4;
	static int Basespd = 4;
	static int Baselck = 4;
	static int str = 4;
	static int con = 4;
	static int dex = 4;
	static int intel = 4;
	static int spd = 4;
	static int lck = 4;
	
	//inventory
	static item rHand = null;
	static item lHand = null;
	static item hatSlot = null;
	static item neckSlot = null;
	static item Ring = null;
	static item footSlot = null;
	static item chestPlate = null;
	static item legSlot = null;
	static item backPack1 = null;
	static item backPack2 = null;
	static item backPack3 = null;
	static item backPack4 = null;
	
	//magic inventory
	static spell spell1 = null;
	static spell spell2 = null;
	static spell spell3 = null;
	static spell spell4 = null;
	
	static int currentLevel = 1;
	static int roundsThisLevel = 0;
	static int[][] playerPosition = {{2},{2}};
	//Level 1 Map
	static room[][] Lev1Rooms = new room[5][5];
	
	static boolean alive = true;

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
				
			if(skillPoints > 0){
				System.out.println("Your remaining " + skillPoints + " will be assigned in order.");
				while(skillPoints > 0){
					if(lck != 8){
						lck++;
						skillPoints--;
					}else if(spd != 8){
						spd++;
						skillPoints--;
					}else if(intel != 8){
						intel++;
						skillPoints--;
					}else if(dex != 8){
						dex++;
						skillPoints--;
					}else if(con != 8){
						con++;
						skillPoints--;
					}else if(str != 8){
						str++;
						skillPoints--;
					}
				}
			}
			System.out.println("Final skill points: ");
			System.out.println("STR: " + str);
			System.out.println("CON: " + con);
			System.out.println("DEX: " + dex);
			System.out.println("INT: " + intel);
			System.out.println("SPD: " + spd);
			System.out.println("LCK: " + lck);
			Basestr = str;
			Basecon = con;
			Basedex = dex;
			Baseintel = intel;
			Basespd = spd;
			Baselck = lck;
			Maxhealth += (con - 4);
			Maxmagic += (intel - 4);
			//Begin tutorial
			System.out.println("Welcome to the Maze.");
				spell1 = new spell("ENEMY", 1, "Energy Blast", 2);
				chestPlate = new item("Chestplate", "Old Robes", 1);
				rHand = new item("Melee", "Wooden Blade", 2);
				backPack1 = new item("Potion", "Potion of Health", 10);
				backPack2 = new item("Potion", "Potion of Magic", 10);
				if(rHand != null){
					increaseStats(rHand);
				}
				if(lHand != null){
					increaseStats(lHand);
				}
				if(hatSlot != null){
					increaseStats(hatSlot);
				}
				if(chestPlate != null){
					increaseStats(chestPlate);
				}
				if(legSlot != null){
					increaseStats(legSlot);
				}
				if(footSlot != null){
					increaseStats(footSlot);
				}
				if(neckSlot != null){
					increaseStats(neckSlot);
				}
				if(Ring != null){
					increaseStats(Ring);
				}
				System.out.println("To control your character use these commands:");
				System.out.println("Look: Look around the room for doors, items, or objects");
				System.out.println("Inventory: Select an item from your inventory to use or equip");
				System.out.println("Move: Go to a different room");
				System.out.println("Interact: Act on an object in a room");
				System.out.println("Use: Use Item in hand");
				System.out.println("Stats: See character stats");
				buildLevel(Lev1Rooms);
				beginLevelLoop(Lev1Rooms);
				
			
	}

	private static void beginLevelLoop(room[][] rooms) {
		System.out.println(rooms[playerPosition[0][0]][playerPosition[1][0]].look());
		boolean foundExit = false;
		while(alive && !foundExit){
			System.out.println("What do you do?");
			String command = input.nextLine();
			if(command.equalsIgnoreCase("Look")){
				System.out.println(rooms[playerPosition[0][0]][playerPosition[1][0]].look());
			}else if(command.equalsIgnoreCase("Inventory")){
				enterInventoryLoop();
			}else if(command.equalsIgnoreCase("Move")){
				System.out.println("Which Direction? (North, West, East, South)");
				String direction = input.nextLine();
				if(direction.equalsIgnoreCase("North")){
					if( playerPosition[1][0] != 4){
						playerPosition[1][0]++;
						roundsThisLevel++;
						triggerRoomEntry(rooms[playerPosition[0][0]][playerPosition[1][0]]);
					}else{
						System.out.println("Can't move that way.");
					}
				}else if(direction.equalsIgnoreCase("South")){
					if( playerPosition[1][0] != 0){
						playerPosition[1][0]--;
						roundsThisLevel++;
						triggerRoomEntry(rooms[playerPosition[0][0]][playerPosition[1][0]]);
					}else{
						System.out.println("Can't move that way.");
					}
				}else if(direction.equalsIgnoreCase("West")){
					if( playerPosition[0][0] != 0){
						playerPosition[0][0]--;
						roundsThisLevel++;
						triggerRoomEntry(rooms[playerPosition[0][0]][playerPosition[1][0]]);
					}else{
						System.out.println("Can't move that way.");
					}
				}else if(direction.equalsIgnoreCase("East")){
					if( playerPosition[0][0] != 4){
						playerPosition[0][0]++;
						roundsThisLevel++;
						triggerRoomEntry(rooms[playerPosition[0][0]][playerPosition[1][0]]);
					}else{
						System.out.println("Can't move that way.");
					}
				}else{
					System.out.println("Invaid Direction");
				}
			}
		}
	}

	private static void triggerRoomEntry(room room) {
		if(room.getMob() != null){
			fightLoop(room.getMob(), room);
		}
		if(room.getTrap() != null){
			
		}
		
	}

	private static void fightLoop(mob mob, room room) {
		boolean youDead = false;
		boolean monsterDead = false;
		if(spd/4 < mob.getlevel()){
			System.out.println("The monster is too fast!");
			String nextAction = mob.getAction();
			if(nextAction.equalsIgnoreCase("Heal")){
				System.out.println("The Monster heals Himself!");
				mob.hurt(mob.getlevel() * -2);
			}else if(nextAction.equalsIgnoreCase("Magic Attack")){
				preformNegativeMagic(mob.getlevel());
				System.out.println("The Monster uses dark magic!");
			}else{
				System.out.println("The Monster attacks");
				int temp = roll20Dice();
				if(temp + dex > mob.getlevel() + 15){
					
				}else if(temp + dex > mob.getlevel() + 10){
					health -= mob.getlevel();
				}else{
					health -= mob.getlevel()*2;
				}
			}
			System.out.println("Health: " + health + " Magic: " + magic);
		}
		boolean ran = false;
		while(!youDead && !monsterDead){
			boolean madeAction = false;
			
			System.out.println("Health: " + health + " Magic: " + magic);
			System.out.println("What do you do? (Cast, inventory, attack, run, SpellInfo, Use)");
			String action = input.nextLine();
			if(action.equalsIgnoreCase("attack")){
				System.out.println("You attack the mob!");
				mob.hurt(str/3);
				madeAction = true;
			}else if(action.equalsIgnoreCase("Cast")){
				System.out.println("Cast which Spell (Spell1, Spell2....through 4)");
				String spellnum = input.nextLine();
				if(spellnum.equals("Spell1")){
					if(spell1 != null){
						madeAction = true;
						if(spell1.cast(mob)){
						System.out.println("You cast " + spell1.getName());
						}else{
							System.out.println("The spell fizzles do to lack of magic");
						}
					}else{
						System.out.println("No Spell in slot 1");
					}
				}else if(spellnum.equalsIgnoreCase("spell2")){
					if(spell2 != null){
						madeAction = true;
						if(spell2.cast(mob)){
						System.out.println("You cast " + spell2.getName());
						}else{
							System.out.println("The spell fizzles do to lack of magic");
						}
					}else{
						System.out.println("No Spell in slot 2");
					}
				}else if(spellnum.equalsIgnoreCase("spell3")){
					if(spell3 != null){
						madeAction = true;
						if(spell3.cast(mob)){
						System.out.println("You cast " + spell3.getName());
						}else{
							System.out.println("The spell fizzles do to lack of magic");
						}
					}else{
						System.out.println("No Spell in slot 3");
					}
				}else if(spellnum.equalsIgnoreCase("spell4")){
					if(spell4 != null){
						madeAction = true;
						if(spell4.cast(mob)){
						System.out.println("You cast " + spell4.getName());
						}else{
							System.out.println("The spell fizzles do to lack of magic");
						}
					}else{
						System.out.println("No Spell in slot 4");
					}
				}
			}else if(action.equalsIgnoreCase("inventory")){
				enterInventoryLoop();
			}else if(action.equalsIgnoreCase("SpellInfo")){
				getSpellInfo();
			}else if(action.equalsIgnoreCase("Use")){
				System.out.println("Use which Item? (Right / Left)");
				String rlItem = input.nextLine();
				if(rlItem.equals("Right")){
					if(rHand != null){
						madeAction = true;
						rHand.use();
					}else{
						System.out.println("That Hand is Empty Fool");
					}
				}else if(rlItem.equalsIgnoreCase("Left")){
					if(lHand != null){
						madeAction = true;
						lHand.use();
					}else{
						System.out.println("That Hand is Empty Fool");
					}
				}else{
					System.out.println("You only have 2 hands, right and left");
				}
			}else if(action.equals("run")){
				madeAction = true;
				int randInt = roll20Dice();
				if(randInt + spd > 15 + mob.getlevel()){
					monsterDead = true;
					ran = true;
					System.out.println("You run away through the coridors in the room. You lose the monster but when you return the loot is gone");
					room.setLootTaken();
					room.setMobDead();
				}else{
					System.out.println("You try to run but you are overcome by the monster.");
				}
			}
			monsterDead = mob.isDead();
			if(!monsterDead && madeAction){
				String nextAction = mob.getAction();
				if(nextAction.equalsIgnoreCase("Heal")){
					System.out.println("The Monster heals Himself!");
					mob.hurt(mob.getlevel() * -2);
				}else if(nextAction.equalsIgnoreCase("Magic Attack")){
					preformNegativeMagic(mob.getlevel());
					System.out.println("The Monster uses dark magic!");
				}else{
					System.out.println("The Monster attacks");
					int temp = roll20Dice();
					if(temp + dex > mob.getlevel() + 15){
						
					}else if(temp + dex > mob.getlevel() + 10){
						health -= mob.getlevel();
					}else{
						health -= mob.getlevel()*2;
					}
				}
			}
			
		}
		if(youDead){
			alive = false;
			try {
				killPlayer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			if(monsterDead && !ran){
				levelUp();
			}
		}
	}

	private static void levelUp() {
		System.out.println("Choose a stat to level by 1 point! (str, con, dex, int, spd, lck)" );
		boolean hasChoosen = false;
		while(!hasChoosen){
			String choice = input.nextLine();
			if(choice.equalsIgnoreCase("str")){
				hasChoosen = true;
				str++;
				Basestr++;
			}else if(choice.equalsIgnoreCase("con")){
				hasChoosen = true;
				con++;
				Basecon++;
			}else if(choice.equalsIgnoreCase("dex")){
				hasChoosen = true;
				dex++;
				Basedex++;
			}else if(choice.equalsIgnoreCase("int")){
				hasChoosen = true;
				intel++;
				Baseintel++;
			}else if(choice.equalsIgnoreCase("spd")){
				hasChoosen = true;
				spd++;
				Basespd++;
			}else if(choice.equalsIgnoreCase("lck")){
				hasChoosen = true;
				lck++;
				Baselck++;
			}else{
				System.out.println("Invalid input try again");
			}
			System.out.println("Stat increased!");
		}
		
	}

	private static void killPlayer() throws InterruptedException {
		System.out.println("You lose! Game Over! Your final level: " + currentLevel );
		Thread.sleep(4000);
		System.exit(1);
	}

	private static void preformNegativeMagic(int level) {
		if(level == 1){
			int effectRand = roll20Dice();
			if(effectRand > 17){
				if(health > Maxhealth/2){
					health = Maxhealth/2;
					System.out.println("Monster used Level Dice. Your health is reduced to Half strength");
				}
			}else if(effectRand > 2){
				magic -= 3;
				System.out.println("Monster used Enervate. Magic drained by 3 points!");
			}else{
				Maxmagic--;
				Maxhealth--;
				System.out.println("Monster used Nullification Max Health and Max Magic reduced by 1 each!");
			}
		}else if(level < 3){
			int effectRand = roll20Dice();
			if(effectRand > 17){
				if(health > Maxhealth/3){
					health = Maxhealth/3;
					System.out.println("Monster used Level Dice. Your health is reduced to 1/3 strength");
				}
			}else if(effectRand > 2){
				magic -= 5;
				health--;
				System.out.println("Monster used Enervate. Magic drained by 5 points! Health by 1");
			}else{
				Baselck--;
				lck--;
				System.out.println("Monster used Curse. Luck Decreased by 1");
			}
		}else{
			int effectRand = roll20Dice();
			if(effectRand > 17){
				if(health > Maxhealth/4){
					health = Maxhealth/4;
					System.out.println("Monster used Level Dice Maxima. Your health is reduced to 1/4 strength");
				}
			}else if(effectRand > 2){
				magic -= 10;
				health -= 3;
				System.out.println("Monster used Enervate Maxima. Magic drained by 10 points! Health by 3");
			}else{
				Baselck--;
				lck--;
				Basestr--;
				str--;
				System.out.println("Monster used Curse Maxima. Luck Decreased by 1, Strength decreased by 1");
			}
		}
		
	}

	private static void enterInventoryLoop() {
		boolean exitInv = false;
		System.out.println("Entered Inventory Management Mode");
		while(!exitInv){
			System.out.println("Commands: View, Equip, Drop, exitInv");
			String command = input.nextLine();
			if(command.equalsIgnoreCase("Equip")){
				System.out.println("Which BackpackSlot do you want to equip from? (Backpack1, Backpack2,...");
				String slot = input.nextLine();
				if(slot.equalsIgnoreCase("Backpack1")){
					if(backPack1 != null){
						if(backPack1.getType().equals("Spellbook") || backPack1.getType().equals("Melee") || backPack1.getType().equals("Potion") || backPack1.getType().equals("Scroll")){
							System.out.println("Right or Left (hand), or Esc");
							String hand = input.nextLine();
							if(hand.equalsIgnoreCase("Right")){
								item temp1 = rHand;
								item temp2 = backPack1;
								rHand = temp2;
								backPack1 = temp1;
								System.out.println("Equiped " + rHand.getName());
							}else if(hand.equalsIgnoreCase("Left")){
								item temp1 = lHand;
								item temp2 = backPack1;
								lHand = temp2;
								backPack1 = temp1;
								System.out.println("Equiped " + lHand.getName());
							}
						}else if(backPack1.getType().equals("Hat")){
							item temp1 = hatSlot;
							item temp2 = backPack1;
							hatSlot = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + hatSlot.getName());
						}else if(backPack1.getType().equals("Necklace")){
							item temp1 = neckSlot;
							item temp2 = backPack1;
							neckSlot = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + neckSlot.getName());
						}else if(backPack1.getType().equals("Necklace")){
							item temp1 = neckSlot;
							item temp2 = backPack1;
							neckSlot = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + neckSlot.getName());
						}else if(backPack1.getType().equals("Ring")){
							item temp1 = Ring;
							item temp2 = backPack1;
							Ring = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + Ring.getName());
						}else if(backPack1.getType().equals("Boots")){
							item temp1 = footSlot;
							item temp2 = backPack1;
							footSlot = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + footSlot.getName());
						}else if(backPack1.getType().equals("Chestplate")){
							item temp1 = chestPlate;
							item temp2 = backPack1;
							chestPlate = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + chestPlate.getName());
						}else if(backPack1.getType().equals("Pants")){
							item temp1 = legSlot;
							item temp2 = backPack1;
							legSlot = temp2;
							backPack1 = temp1;
							System.out.println("Equiped " + legSlot.getName());
						}
					}else{
						System.out.println("No Item that slot!");
					}
				}else if(slot.equalsIgnoreCase("backpack2")){
					if(backPack2 != null){
						if(backPack2.getType().equals("Spellbook") || backPack2.getType().equals("Melee") || backPack2.getType().equals("Potion") || backPack2.getType().equals("Scroll")){
							System.out.println("Right or Left (hand), or Esc");
							String hand = input.nextLine();
							if(hand.equalsIgnoreCase("Right")){
								item temp1 = rHand;
								item temp2 = backPack2;
								rHand = temp2;
								backPack2 = temp1;
								System.out.println("Equiped " + rHand.getName());
							}else if(hand.equalsIgnoreCase("Left")){
								item temp1 = lHand;
								item temp2 = backPack2;
								lHand = temp2;
								backPack2 = temp1;
								System.out.println("Equiped " + lHand.getName());
							}
						}else if(backPack2.getType().equals("Hat")){
							item temp1 = hatSlot;
							item temp2 = backPack2;
							hatSlot = temp2;
							backPack2 = temp1;
							System.out.println("Equiped " + hatSlot.getName());
						}else if(backPack2.getType().equals("Necklace")){
							item temp1 = neckSlot;
							item temp2 = backPack2;
							neckSlot = temp2;
							backPack2 = temp1;
							System.out.println("Equiped " + neckSlot.getName());
						}else if(backPack2.getType().equals("Ring")){
							item temp1 = Ring;
							item temp2 = backPack2;
							Ring = temp2;
							backPack2 = temp1;
							System.out.println("Equiped " + Ring.getName());
						}else if(backPack2.getType().equals("Boots")){
							item temp1 = footSlot;
							item temp2 = backPack2;
							footSlot = temp2;
							backPack2= temp1;
							System.out.println("Equiped " + footSlot.getName());
						}else if(backPack2.getType().equals("Chestplate")){
							item temp1 = chestPlate;
							item temp2 = backPack2;
							chestPlate = temp2;
							backPack2 = temp1;
							System.out.println("Equiped " + chestPlate.getName());
						}else if(backPack2.getType().equals("Pants")){
							item temp1 = legSlot;
							item temp2 = backPack2;
							legSlot = temp2;
							backPack2 = temp1;
							System.out.println("Equiped " + legSlot.getName());
						}
					}else{
						System.out.println("No Item that slot!");
					}
				}else if(slot.equalsIgnoreCase("backpack3")){
					if(backPack3 != null){
						if(backPack3.getType().equals("Spellbook") || backPack3.getType().equals("Melee") || backPack3.getType().equals("Potion") || backPack3.getType().equals("Scroll")){
							System.out.println("Right or Left (hand), or Esc");
							String hand = input.nextLine();
							if(hand.equalsIgnoreCase("Right")){
								item temp1 = rHand;
								item temp2 = backPack3;
								rHand = temp2;
								backPack3 = temp1;
								System.out.println("Equiped " + rHand.getName());
							}else if(hand.equalsIgnoreCase("Left")){
								item temp1 = lHand;
								item temp2 = backPack3;
								lHand = temp2;
								backPack3 = temp1;
								System.out.println("Equiped " + lHand.getName());
							}
						}else if(backPack3.getType().equals("Hat")){
							item temp1 = hatSlot;
							item temp2 = backPack3;
							hatSlot = temp2;
							backPack3 = temp1;
							System.out.println("Equiped " + hatSlot.getName());
						}else if(backPack3.getType().equals("Necklace")){
							item temp1 = neckSlot;
							item temp2 = backPack3;
							neckSlot = temp2;
							backPack3 = temp1;
							System.out.println("Equiped " + neckSlot.getName());
						}else if(backPack3.getType().equals("Ring")){
							item temp1 = Ring;
							item temp2 = backPack3;
							Ring = temp2;
							backPack3 = temp1;
							System.out.println("Equiped " + Ring.getName());
						}else if(backPack3.getType().equals("Boots")){
							item temp1 = footSlot;
							item temp2 = backPack3;
							footSlot = temp2;
							backPack3 = temp1;
							System.out.println("Equiped " + footSlot.getName());
						}else if(backPack3.getType().equals("Chestplate")){
							item temp1 = chestPlate;
							item temp2 = backPack3;
							chestPlate = temp2;
							backPack3 = temp1;
							System.out.println("Equiped " + chestPlate.getName());
						}else if(backPack3.getType().equals("Pants")){
							item temp1 = legSlot;
							item temp2 = backPack3;
							legSlot = temp2;
							backPack3 = temp1;
							System.out.println("Equiped " + legSlot.getName());
						}
					}else{
						System.out.println("No Item that slot!");
					}
				}else if(slot.equalsIgnoreCase("backpack4")){
					if(backPack4 != null){
						if(backPack4.getType().equals("Spellbook") || backPack4.getType().equals("Melee") || backPack4.getType().equals("Potion") || backPack4.getType().equals("Scroll")){
							System.out.println("Right or Left (hand), or Esc");
							String hand = input.nextLine();
							if(hand.equalsIgnoreCase("Right")){
								item temp1 = rHand;
								item temp2 = backPack4;
								rHand = temp2;
								backPack4 = temp1;
								System.out.println("Equiped " + rHand.getName());
							}else if(hand.equalsIgnoreCase("Left")){
								item temp1 = lHand;
								item temp2 = backPack4;
								lHand = temp2;
								backPack4 = temp1;
								System.out.println("Equiped " + lHand.getName());
							}
						}else if(backPack4.getType().equals("Hat")){
							item temp1 = hatSlot;
							item temp2 = backPack4;
							hatSlot = temp2;
							backPack4 = temp1;
							System.out.println("Equiped " + hatSlot.getName());
						}else if(backPack4.getType().equals("Necklace")){
							item temp1 = neckSlot;
							item temp2 = backPack4;
							neckSlot = temp2;
							backPack4 = temp1;
							System.out.println("Equiped " + neckSlot.getName());
						}else if(backPack4.getType().equals("Ring")){
							item temp1 = Ring;
							item temp2 = backPack4;
							Ring = temp2;
							backPack4 = temp1;
							System.out.println("Equiped " + Ring.getName());
						}else if(backPack4.getType().equals("Boots")){
							item temp1 = footSlot;
							item temp2 = backPack4;
							footSlot = temp2;
							backPack4 = temp1;
							System.out.println("Equiped " + footSlot.getName());
						}else if(backPack4.getType().equals("Chestplate")){
							item temp1 = chestPlate;
							item temp2 = backPack4;
							chestPlate = temp2;
							backPack4 = temp1;
							System.out.println("Equiped " + chestPlate.getName());
						}else if(backPack4.getType().equals("Pants")){
							item temp1 = legSlot;
							item temp2 = backPack4;
							legSlot = temp2;
							backPack4 = temp1;
							System.out.println("Equiped " + legSlot.getName());
						}
					}else{
						System.out.println("No Item that slot!");
					}
				}else{
					System.out.println("Invalid slot");
				}
			}else if(command.equalsIgnoreCase("View")){
				if(rHand != null){
					System.out.println("Right Hand: " + rHand.getName());
				}
				if(lHand != null){
					System.out.println("Left Hand: " + lHand.getName());
				}
				if(hatSlot != null){
					System.out.println("Hat " + hatSlot.getName());
				}
				if(chestPlate != null){
					System.out.println("Chestplate " + chestPlate.getName());
				}
				if(legSlot != null){
					System.out.println("Pants " + legSlot.getName());
				}
				if(footSlot != null){
					System.out.println("Boots: " + footSlot.getName());
				}
				if(neckSlot != null){
					System.out.println("Necklace: " + neckSlot.getName());
				}
				if(Ring != null){
					System.out.println("Ring: " + Ring.getName());
				}
				if(backPack1 != null){
					System.out.println("BackPack1: " + backPack1.getName());
				}
				if(backPack2 != null){
					System.out.println("BackPack2: " + backPack2.getName());
				}
				if(backPack3 != null){
					System.out.println("BackPack3: " + backPack3.getName());
				}
				if(backPack4 != null){
					System.out.println("BackPack4: " + backPack4.getName());
				}
				
				
			}else if(command.equalsIgnoreCase("Drop")){
				System.out.println("WARNING: ITEM WILL BE DESTROYED!");
				System.out.println("Drop what? (Right Hand, Left Hand, Ring, Necklace, Hat, Chestplate, Pants, Boots,Backpack#, none) ");
				String slot = input.nextLine();
				if(slot.equalsIgnoreCase("Right Hand")){
					rHand = null;
					System.out.println("Right Hand Item Dropped");
				}else if(slot.equalsIgnoreCase("Left Hand")){
					lHand = null;
					System.out.println("Left Hand Item Dropped");
				}else if(slot.equalsIgnoreCase("Ring")){
					Ring = null;
					System.out.println("Ring Dropped");
				}else if(slot.equalsIgnoreCase("Necklace")){
					neckSlot = null;
					System.out.println("Necklace Dropped");
				}else if(slot.equalsIgnoreCase("Hat")){
					hatSlot = null;
					System.out.println("Hat Dropped");
				}else if(slot.equalsIgnoreCase("Chestplate")){
					chestPlate = null;
					System.out.println("Chestplate Dropped");
				}else if(slot.equalsIgnoreCase("Boots")){
					footSlot = null;
					System.out.println("Boots Dropped");
				}else if(slot.equalsIgnoreCase("Backpack1")){
					backPack1 = null;
					System.out.println("Slot 1 Item Dropped");
				}else if(slot.equalsIgnoreCase("Backpack2")){
					backPack2 = null;
					System.out.println("Slot 2 Item Dropped");
				}else if(slot.equalsIgnoreCase("Backpack3")){
					backPack3 = null;
					System.out.println("Slot 3 Item Dropped");
				}else if(slot.equalsIgnoreCase("Backpack4")){
					backPack4 = null;
					System.out.println("Slot 4 Item Dropped");
				}else{
					System.out.println("Operation Cancelled");
				}
			}else if(command.equalsIgnoreCase("exitInv")){
				exitInv = true;
			}else{
				System.out.println("Invalid Input");
			}
		}
		lck = Baselck;
		spd = Basespd;
		intel = Baseintel;
		dex = Basedex;
		con = Basecon;
		str = Basestr;
		if(rHand != null){
			increaseStats(rHand);
		}
		if(lHand != null){
			increaseStats(lHand);
		}
		if(hatSlot != null){
			increaseStats(hatSlot);
		}
		if(chestPlate != null){
			increaseStats(chestPlate);
		}
		if(legSlot != null){
			increaseStats(legSlot);
		}
		if(footSlot != null){
			increaseStats(footSlot);
		}
		if(neckSlot != null){
			increaseStats(neckSlot);
		}
		if(Ring != null){
			increaseStats(Ring);
		}
	}

	private static void buildLevel(room[][] rooms) {
		int lootChance = (roll20Dice() + lck/2 + currentLevel);
		int lootLevel = 0;
		if(lootChance > 10){
			lootLevel = 1;
		}else if(lootChance > 15){
			lootLevel = 2;
		}else if(lootChance > 20){
			lootLevel = 3;
		}else if(lootChance > 25){
			lootLevel = 4;
		}
		
		rooms[2][2] = new room(generateLoot(lootLevel), generatePossibleMob(currentLevel, roundsThisLevel), null);
		//generate rooms off of that
		for(int x = 0; x < 5; x++){
			for(int y = 0; y < 5; y++){
				if(x != 2 && y != 2){
					lootChance = (roll20Dice() + lck/2 + currentLevel);
					lootLevel = 0;
					if(lootChance > 10){
						lootLevel = 1;
					}else if(lootChance > 15){
						lootLevel = 2;
					}else if(lootChance > 20){
						lootLevel = 3;
					}else if(lootChance > 25){
						lootLevel = 4;
					}
					
					rooms[x][y] = new room(generateLoot(lootLevel), generatePossibleMob(currentLevel, roundsThisLevel), generatePossibleTrap());
				}
			}
		}
		
		boolean randBool = rand.nextBoolean();
		boolean randBool2 = rand.nextBoolean();
		if(randBool){
			if(randBool2){
				rooms[0][rand.nextInt(5)].setExit();
			}else{
				rooms[4][rand.nextInt(5)].setExit();
			}
		}else{
			if(randBool2){
				rooms[rand.nextInt(5)][0].setExit();
			}else{
				rooms[rand.nextInt(5)][4].setExit();
			}
		}
		
	}

	private static trap generatePossibleTrap() {
		if((roll20Dice() + currentLevel - lck/2) > 15){
			return new trap(currentLevel);
		}else{
			return null;
		}
	}

	private static mob generatePossibleMob(int lev,
			int rounds) {
		if(roll20Dice() > (15 - lev - (rounds/5) + lck/4)){
			return new mob(lev + (rounds/5));
		}else{
			return null;
		}
	}

	private static item generateLoot(int lootLevel) {
		if(lootLevel == 0){
			return null;
		}
		if(lootLevel != 0){
			String type = getRandomItemType();
			String name = getRandomItemName(type);
			
			return new item(getRandomItemType(), name, lootLevel + rand.nextInt(lck/2));
		}
		return null;
		
	}

	private static String getRandomItemName(String type) {
		String Adj1 = getAdjective();
		String Adj2 = getAdjective();
		String Noun = getNoun();
		String itemName;
		if(type.equals("Melee")){
			int randInt = roll20Dice();
			if(randInt > 15){
				itemName = "Sword";
			}else if(randInt > 10){
				itemName = "Axe";
			}else if(randInt > 5){
				itemName = "Hammer";
			}else if(randInt > 1){
				itemName = "Dagger";
			}else{
				itemName = "Slightly Pointy, oddly effective Stick";
			}
		}else{
			itemName = type;
		}
		return Adj1 + " " + itemName + " " + Adj2 + " " + Noun;
	}

	private static String getNoun() {
		int var = roll20Dice();
		String desc;
		switch(var){
		case 1: desc = "Justice";
		break;
		case 2: desc =  "Power";
		break;
		case 3: desc =  "Influence";
		break;
		case 4: desc =  "Fire";
		break;
		case 5: desc =  "Fame";
		break;
		case 6: desc =  "Pride";
		break;
		case 7: desc =  "Victory";
		break;
		case 8: desc =  "Slashing";
		break;
		case 9: desc =  "Defenistrating";
		break;
		case 10: desc =  "Pathfinding";
		break;
		case 11: desc = "Hacking";
		break;
		case 12: desc = "Injecting";
		break;
		case 13: desc = "Defiling";
		break;
		case 14: desc = "Knowing";
		break;
		case 15: desc = "Loyalty";
		break;
		case 16: desc = "Rage";
		break;
		case 17: desc = "Far-sight";
		break;
		case 18: desc = "Sharpening";
		break;
		case 19: desc = "Enervating";
		break;
		case 20: desc = "Infusion";
		break;
		default: desc = "Bugged";
		break;
		}
		return desc;
	}

	private static String getAdjective() {
		int var = roll20Dice();
		String desc;
		switch(var){
		case 1: desc = "Slimy";
		break;
		case 2: desc =  "Odd";
		break;
		case 3: desc =  "Green";
		break;
		case 4: desc =  "Pulsating";
		break;
		case 5: desc =  "Stiff";
		break;
		case 6: desc =  "Slippery";
		break;
		case 7: desc =  "Throbbing";
		break;
		case 8: desc =  "Hallowed";
		break;
		case 9: desc =  "Arcane";
		break;
		case 10: desc =  "Ancient";
		break;
		case 11: desc = "Second-Hand";
		break;
		case 12: desc = "New";
		break;
		case 13: desc = "Smelly";
		break;
		case 14: desc = "Unknowable";
		break;
		case 15: desc = "Sturdy";
		break;
		case 16: desc = "Open-Sourced";
		break;
		case 17: desc = "Jury-rigged";
		break;
		case 18: desc = "Dull";
		break;
		case 19: desc = "Sharp";
		break;
		case 20: desc = "Pretty darn cool";
		break;
		default: desc = "Bugged";
		break;
		}
		return desc;
	}

	private static String getRandomItemType() {
		int randomInt = roll20Dice();
		if(randomInt == 1){
			return "Ring";
		}else if(randomInt < 5){
			return "Necklace";
		}else if(randomInt < 7){
			return "Scroll";
		}else if(randomInt < 11){
			int minorRoll = roll20Dice();
			if(minorRoll > 15){
				return "Hat";
			}else if(minorRoll > 10){
				return "Chestplate";
			}else if(minorRoll > 5){
				return "Pants";
			}else{
				return "Boots";
			}
		}else if(randomInt < 16){
			return "Potion";
		}else{
			int minorRoll = roll20Dice();
			if(minorRoll > 10){
				return "Melee";
			}else{
				return "Spellbook";
			}
		}
	}

	private static int roll20Dice() {
		return rand.nextInt(20) + 1;
	}
	
	private static void increaseStats(item Item){
		if(Item.getBoost().equalsIgnoreCase("Strength")){
			str += Item.getPower();
		}else if(Item.getBoost().equalsIgnoreCase("Constitution")){
			con += Item.getPower();
		}else if(Item.getBoost().equalsIgnoreCase("Dexterity")){
			dex += Item.getPower();
		}else if(Item.getBoost().equalsIgnoreCase("Intelligence")){
			intel += Item.getPower();
		}else if(Item.getBoost().equalsIgnoreCase("Speed")){
			spd += Item.getPower();
		}else if(Item.getBoost().equalsIgnoreCase("Luck")){
			lck += Item.getPower();
		}
	}
	
	private static void getSpellInfo(){
		if(spell1 != null){
			System.out.println("Spell1: " + spell1.getName() + " Cost: " + spell1.getCost());
		}else{
			System.out.println("No spell in slot 1");
		}
		if(spell2 != null){
			System.out.println("Spell2: " + spell2.getName() + " Cost: " + spell2.getCost());
		}else{
			System.out.println("No spell in slot 2");
		}
		if(spell3 != null){
			System.out.println("Spell1: " + spell3.getName() + " Cost: " + spell3.getCost());
		}else{
			System.out.println("No spell in slot 3");
		}
		if(spell4 != null){
			System.out.println("Spell1: " + spell4.getName() + " Cost: " + spell4.getCost());
		}else{
			System.out.println("No spell in slot 4");
		}
		
	}

}
