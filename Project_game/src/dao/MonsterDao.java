package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.MonsterVo;

public class MonsterDao {
	private static MonsterDao instance;
	private MonsterDao() {
		
	}
	public static MonsterDao getInstance() {
		if (instance == null) {
			instance = new MonsterDao();
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
	
	//피카츄 정보 주기
	public MonsterVo PikachuInfo(MonsterVo monsterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select*"
					+ " from MONSTER_TABLE"
					+ " where MONSTER_NAME = 'pikachu'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String MONSTER_NAME = rs.getString("MONSTER_NAME");
				int ABILITY_POWER = rs.getInt("ABILITY_POWER");
				int ABILITY_DEFENSE = rs.getInt("ABILITY_DEFENSE");
				int ABILITY_HEALTH = rs.getInt("ABILITY_HEALTH");
				
				MonsterVo pikachu = new MonsterVo(MONSTER_NAME, ABILITY_POWER, ABILITY_DEFENSE, ABILITY_HEALTH);
				return pikachu;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
	//스폰지밥과 뚱이
	public MonsterVo SpongebobAndPatrickFat_Info(MonsterVo monsterVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select*"
					+ " from MONSTER_TABLE"
					+ " where MONSTER_NAME = 'song'";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				String MONSTER_NAME = rs.getString("MONSTER_NAME");
				int ABILITY_POWER = rs.getInt("ABILITY_POWER");
				int ABILITY_DEFENSE = rs.getInt("ABILITY_DEFENSE");
				int ABILITY_HEALTH = rs.getInt("ABILITY_HEALTH");
				
				MonsterVo song = new MonsterVo(MONSTER_NAME, ABILITY_POWER, ABILITY_DEFENSE, ABILITY_HEALTH);
				return song;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	}
}
