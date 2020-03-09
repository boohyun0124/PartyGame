package vo;

public class MonsterVo {
	private String monster_name;
	private int ability_power;
	private int ability_Defense;
	private int ability_health;
	
	public MonsterVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MonsterVo(String monster_name, int ability_power, int ability_Defense, int ability_health) {
		super();
		this.monster_name = monster_name;
		this.ability_power = ability_power;
		this.ability_Defense = ability_Defense;
		this.ability_health = ability_health;
	}
	
	//╟ыем ╪бем
	public String getMonster_name() {
		return monster_name;
	}
	public void setMonster_name(String monster_name) {
		this.monster_name = monster_name;
	}
	public int getAbility_power() {
		return ability_power;
	}
	public void setAbility_power(int ability_power) {
		this.ability_power = ability_power;
	}
	public int getAbility_Defense() {
		return ability_Defense;
	}
	public void setAbility_Defense(int ability_Defense) {
		this.ability_Defense = ability_Defense;
	}
	public int getAbility_health() {
		return ability_health;
	}
	public void setAbility_health(int ability_health) {
		this.ability_health = ability_health;
	}
	
	//toString
	@Override
	public String toString() {
		return "MonsterVo [monster_name=" + monster_name + ", ability_power=" + ability_power + ", ability_Defense="
				+ ability_Defense + ", ability_health=" + ability_health + "]";
	}
	
	
}
