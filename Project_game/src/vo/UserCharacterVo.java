package vo;

public class UserCharacterVo {
	private String user_id;
	private String user_name;
	private String character_name;
	private int ability_power;
	private int ability_magic;
	private int ability_defense;
	private int ability_health;
	public UserCharacterVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserCharacterVo(String user_id, String user_name, String character_name, int ability_power,
			int ability_magic, int ability_defense, int ability_health) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.character_name = character_name;
		this.ability_power = ability_power;
		this.ability_magic = ability_magic;
		this.ability_defense = ability_defense;
		this.ability_health = ability_health;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getCharacter_name() {
		return character_name;
	}
	public void setCharacter_name(String character_name) {
		this.character_name = character_name;
	}
	public int getAbility_power() {
		return ability_power;
	}
	public void setAbility_power(int ability_power) {
		this.ability_power = ability_power;
	}
	public int getAbility_magic() {
		return ability_magic;
	}
	public void setAbility_magic(int ability_magic) {
		this.ability_magic = ability_magic;
	}
	public int getAbility_defense() {
		return ability_defense;
	}
	public void setAbility_defense(int ability_defense) {
		this.ability_defense = ability_defense;
	}
	public int getAbility_health() {
		return ability_health;
	}
	public void setAbility_health(int ability_health) {
		this.ability_health = ability_health;
	}
	@Override
	public String toString() {
		return "UserCharacterVo [user_id=" + user_id + ", user_name=" + user_name + ", character_name=" + character_name
				+ ", ability_power=" + ability_power + ", ability_magic=" + ability_magic + ", ability_defense="
				+ ability_defense + ", ability_health=" + ability_health + "]";
	}
	
}
