package Main;
import java.util.Random;

public class room {
	private item loot;
	private mob enemy;
	private trap trap;
	private boolean isExit;
	
	public room(item l, mob e, trap t){
		loot = l;
		enemy = e;
		trap = t;
		isExit = false;
	}
	
	public void setExit(){
		isExit = true;
	}
	
	public mob getMob(){
		return enemy;
	}
	
	public trap getTrap(){
		return trap;
	}
	
	public item loot(){
		return loot;
	}
	
	public void setTrapDisabled(){
		trap = null;
	}
	
	public void setMobDead(){
		enemy = null;
	}
	
	public void setLootTaken(){
		loot = null;
	}
	
	public boolean isExit(){
		return isExit;
	}
	
	public String look(){
		if(loot != null){
			return "You see a chest in the room. Possibly filled with loot";
		}
		Random rand = new Random();
		int randInt = rand.nextInt(5);
		if(randInt == 0){
			return "You look at the dark walls carefully, they are completely uninteresting.";
		}else if(randInt == 1){
			return "You feel as if you could get lost down here, all the rooms look the same.";
		}else if(randInt == 2){
			return "A dark feeling creeps over you as you stand in the center of the room. Shadows move in the corridors.";
		}else if(randInt == 3){
			return "Nothing interests you.";
		}else if(randInt == 4){
			return "You notice a mold spreading in the corner, it notices you and you share a moment of mutual apathy";
		}else{
			return "There is nothing here.";
		}
	}
	
}
