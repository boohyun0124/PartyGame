package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.UserCharacterVo;

public class CharacterDao {
	
	private static CharacterDao instance;
	private CharacterDao() {
		
	}
	public static CharacterDao getInstance() {
		if (instance == null) {
			instance = new CharacterDao();
		}
		return instance;
	}
	private final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private final String ID = "test02";
	private final String PW = "1234";
	
	//커넥션 얻기
	private Connection getConnection() {
		try {
			Class.forName(DRIVER);
			Connection conn = DriverManager.getConnection(URL, ID, PW);
			return conn;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//클로우즈 올
	private void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		if (rs != null) try {rs.close();} catch (Exception e) { }
		if (pstmt != null) try {rs.close();} catch (Exception e) { }
		if (conn != null) try {rs.close();} catch (Exception e) { }
	}
	
	//탱커 정보 주기
	public UserCharacterVo TankerInfo(UserCharacterVo characterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select*from user_character_table" + 
					" where character_name = 'tanker'" + 
					" and user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, characterVo.getUser_id());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String user_id = rs.getString("user_id");
				String user_name = rs.getString("user_name");
				String character_name = rs.getString("character_name");
				int ability_power = rs.getInt("ability_power");
				int ability_Magic = rs.getInt("ability_Magic");
				int ability_Defense = rs.getInt("ability_Defense");
				int ability_health = rs.getInt("ability_health");
				
				UserCharacterVo tanker = new UserCharacterVo(user_id, user_name, character_name, ability_power, ability_Magic, ability_Defense, ability_health);
				return tanker;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	//딜러 정보 주기
	public UserCharacterVo DealerInfo(UserCharacterVo characterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select*"
					+ " from user_character_table"
					+ " where character_name = 'dealer'"
					+ " and user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, characterVo.getUser_id());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String user_id = rs.getString("user_id");
				String user_name = rs.getString("user_name");
				String character_name = rs.getString("character_name");
				int ability_power = rs.getInt("ability_power");
				int ability_Magic = rs.getInt("ability_Magic");
				int ability_Defense = rs.getInt("ability_Defense");
				int ability_health = rs.getInt("ability_health");
				
				UserCharacterVo dealer = new UserCharacterVo(user_id, user_name, character_name, ability_power, ability_Magic, ability_Defense, ability_health);
				return dealer;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	//마법사 정보 주기
	public UserCharacterVo WizardInfo(UserCharacterVo characterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select*"
					+ " from user_character_table"
					+ " where character_name = 'wizard'"
					+ " and user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, characterVo.getUser_id());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String user_id = rs.getString("user_id");
				String user_name = rs.getString("user_name");
				String character_name = rs.getString("character_name");
				int ability_power = rs.getInt("ability_power");
				int ability_Magic = rs.getInt("ability_Magic");
				int ability_Defense = rs.getInt("ability_Defense");
				int ability_health = rs.getInt("ability_health");
				
				UserCharacterVo wizard = new UserCharacterVo(user_id, user_name, character_name, ability_power, ability_Magic, ability_Defense, ability_health);
				return wizard;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	
	//힐러 정보 주기
	public UserCharacterVo HealerInfo(UserCharacterVo characterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select*"
					+ " from user_character_table"
					+ " where character_name = 'healer'"
					+ " and user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, characterVo.getUser_id());
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String user_id = rs.getString("user_id");
				String user_name = rs.getString("user_name");
				String character_name = rs.getString("character_name");
				int ability_power = rs.getInt("ability_power");
				int ability_Magic = rs.getInt("ability_Magic");
				int ability_Defense = rs.getInt("ability_Defense");
				int ability_health = rs.getInt("ability_health");
				
				UserCharacterVo healer = new UserCharacterVo(user_id, user_name, character_name, ability_power, ability_Magic, ability_Defense, ability_health);
				return healer;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//캐릭터 정보 수정
	public void updateCharacterInfo(UserCharacterVo usercharacterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "update user_character_table set"
					+ " ABILITY_POWER = ?,"
					+ " ABILITY_MAGIC = ?,"
					+ " ABILITY_DEFENSE = ?,"
					+ " ABILITY_HEALTH = ?"
					+ " where CHARACTER_NAME = ?"
					+ " and user_id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, usercharacterVo.getAbility_power());
			pstmt.setInt(2, usercharacterVo.getAbility_magic());
			pstmt.setInt(3, usercharacterVo.getAbility_defense());
			pstmt.setInt(4, usercharacterVo.getAbility_health());
			pstmt.setString(5, usercharacterVo.getCharacter_name());
			pstmt.setString(6, usercharacterVo.getUser_id());
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
	}
}
