package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.UserCharacterVo;
import vo.UserVo;

public class LoginDao {
	//싱글톤
	private static LoginDao instance;
	private LoginDao() {
		
	}
	public static LoginDao getInstance() {
		if (instance == null) {
			instance = new LoginDao();
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
	//유저 정보 입력
	public boolean joinUserInfo(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into user_table(user_id, user_pw, user_name)"
					+ " values(?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_pw());
			pstmt.setString(3, vo.getUser_name());
			pstmt.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	
	//캐릭터 정보입력
	public boolean joinCharacterInfo(UserCharacterVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			String sql = "insert into user_character_table(user_id, user_name, character_name, ability_power, ability_magic, ability_defense, ability_health)"
					+ " values(?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getUser_id());
			pstmt.setString(2, vo.getUser_name());
			pstmt.setString(3, vo.getCharacter_name());
			pstmt.setInt(4, vo.getAbility_power());
			pstmt.setInt(5, vo.getAbility_magic());
			pstmt.setInt(6, vo.getAbility_defense());
			pstmt.setInt(7, vo.getAbility_health());
			pstmt.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			closeAll(conn, pstmt, null);
		}
		return false;
	}
	//로그인 하기
	public UserVo login(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			String sql = "select * from user_table"
					+ "   where user_id = ?"
					+ "   and user_pw = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userVo.getUser_id());
			pstmt.setString(2, userVo.getUser_pw());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String user_id = rs.getString("user_id");
				String user_pw = rs.getString("user_pw");
				String user_name = rs.getString("user_name");
				
				UserVo loginVo = new UserVo(user_id, user_pw, user_name);
				return loginVo;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}
		return null;
	} // login()
		
}
