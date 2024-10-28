
public class Pokemon extends Card{

	// Pokemon have hp, 
	private int hp;
	private Type type;
	private int damage;
	private String name;
	
	// holds true if the Pokemon has an energy card.
	private boolean energized;
	

	public Pokemon(String word, int health, int strength, Type t) {
		
		name = word;
		health = hp;
		strength = damage;
		type = t;
		
		
	}
	
	public void setEnergized(boolean b) {
		
		energized = b;
		
	}
	
	
	public int getHp() {
		
		return hp;
		
	}
	
	public int getDamage() {
		
		return damage;
		
	}
	
	public void setDamage(int strength) {
		
		damage = strength;
		
		
	}
	
	public void decreaseHp(int health) {
		
		hp -= health;
		
	}
	
	public void setType(Type t) {
		
		type = t;
		
	}
	
	public Type getType() {
		
		return type;
		
		
	}
	
}
