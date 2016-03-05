package Main;

import java.util.Random;

public class item {
	private final String Name;
	private final String type;
	private final int Power;
	private String skillBoost = "";
	
	
	public item(String Ltype, String name, int power){
		type = Ltype;
		Name = name;
		Power = power;
		if(type.equals("Melee")){
			skillBoost = "Strength";
		}else if(type.equalsIgnoreCase("potion") || type.equalsIgnoreCase("Scroll") || type.equalsIgnoreCase("SpellBook")){
			skillBoost = "None";
		}else if(type.equalsIgnoreCase("Hat") || type.equalsIgnoreCase("Boots")){
			skillBoost = "Consitution";
		}else if(type.equalsIgnoreCase("Chestplate") || type.equalsIgnoreCase("Pants")){
			skillBoost = "Dexterity";
		}else{
			Random rand = new Random();
			switch(rand.nextInt(6)){
			case 0: skillBoost = "Strength";
			break;
			case 1: skillBoost = "Constitution";
			break;
			case 2: skillBoost = "Dexterity";
			break;
			case 3: skillBoost = "Intelligence";
			break;
			case 4: skillBoost = "Speed";
			break;
			case 5: skillBoost = "Luck";
			}
		}
	}
	
	
	public String getType(){
		return type;
	}
	
	public String getName(){
		return Name;
	}
	
	public int getPower(){
		return Power;
	}
	
	public String getBoost(){
		return skillBoost;
	}


	public void use() {
		// TODO Auto-generated method stub
		
	}
	
}
