package Main;

public class spell {
	private final String target;
	private final int cost;
	private final String name;
	private final int effectLevel;

	public spell(String targ, int cst, String Nm, int eftlvl){
		target = targ;
		cost = cst;
		name = Nm;
		effectLevel = eftlvl;
	}

	public boolean cast(mob mob) {
		if(name.equalsIgnoreCase("Energy Blast")){
			if(MainLoop.magic < cost){
				mob.hurt(effectLevel + MainLoop.intel/4);
				return true;
			}else{
				return false;
			}
			
			
			
		}
		
		
		return false;
	}

	public String getName() {
		return name;
	}

	public int getCost() {
		return cost;
	}
}
