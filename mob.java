package Main;

import java.util.Random;

public class mob {
	private final int level;
	private final double maxHealth;
	private double currentHealth;
	private double armor;
	private int healthPowerUses;
	private int magicAttackUses;
	private Random rand = new Random();
	
	public mob(int lvl){
		level = lvl;
		maxHealth = (Math.pow(level, 2) + 10);
		currentHealth = maxHealth;
		armor = (1/level) + 1;
		healthPowerUses = level + rand.nextInt(1);
	}
	
	public boolean hurt(int amt){
		if(amt > 0){
			currentHealth -= amt/armor;
		}else{
			currentHealth -= amt;
		}
		
		if(currentHealth <= 0){
			return true;
		}else{
			return false;
		}
	}
	
	public String getAction(){
		if(currentHealth < maxHealth/3 && healthPowerUses > 0){
			healthPowerUses--;
			return "Heal";
			
		}else{
			if(rand.nextBoolean() && magicAttackUses > 0){
				return "Magic Attack";
			}else{
				return "Normal Attack";
			}
		}
		
	}
	public int getlevel(){
		return level;
	}
	
	public boolean isDead(){
		if(currentHealth <= 0){
			return true;
		}else{
			return false;
		}
	}
}
