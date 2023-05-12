package PokemonDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import PokemonController.ActCon;
import PokemonDTO.PokemonDTO;

public class PokemonDAO {
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	PokemonDTO pdto = new PokemonDTO(100, 0, 0, 0);
	
	static PokemonController.ActCon pcon = new PokemonController.ActCon();

	// 문열기
	public void getConn() {

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String db_id = "service";
			String db_pw = "12345";
			conn = DriverManager.getConnection(url, db_id, db_pw);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	// UPDATE 행동선택때마다 감소하거나 증가하는 능력치 수정해주는 메소드
	// 채찍질 hp - 30 / atk + 5 / exp +2
	
	// 놀아주기 hp - 30 / love +5 / exp +2
	
	// 잠자기 hp100 / exp +2
	
	
	
	// 로그인 정보 체크하는 메소드 (select)
	// 포켓몬 상태창에 불러올 수 있다면 메소드 중복해서 활용하자 
	int con = 0;
	public PokemonDTO login(String T_ID , int T_PW) {
		getConn();
		
		
		String sql = "SELECT T_ID , T_PW FROM 트레이너 WHERE T_ID = ? AND T_PW = ?";
		PokemonDTO t_pdto = null;
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, T_ID);
			psmt.setInt(2, T_PW);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String T_id = rs.getString(1);
				int T_pw = rs.getInt(2);
			
				t_pdto = new PokemonDTO(T_id,T_pw);
			}
			
			
			
		} catch (SQLException e) {
			
			pcon.main();
			e.printStackTrace();
		}finally {
			getClose();
		}
		return t_pdto;
		
		
		
	}

	
	
	
	
	
	// 회원가입 메소드

	public void insertTrainer(String T_ID , int T_PW , int PCODE) {
		getConn();
		
		String sql = "INSERT INTO 트레이너 (T_ID, T_PW, PCODE) VALUES (?, ?, ?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, T_ID);
			psmt.setInt(2, T_PW);
			psmt.setInt(3, PCODE);
			psmt.executeUpdate();

			String sql_P = "INSERT INTO 포켓몬 (T_ID ,PCODE, HP, ATK, LOVE, EXP, PNAME) VALUES ( ?, ?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql_P);
			psmt.setString(1, T_ID);
			psmt.setInt(2, PCODE);
			psmt.setInt(3, pdto.getHP()); // 초기값: 100
			psmt.setInt(4, pdto.getATK()); // 초기값: 0
			psmt.setInt(5, pdto.getLOVE()); // 초기값: 0
			psmt.setInt(6, pdto.getEXP()); // 초기값: 0
			if(PCODE == 1) {
				psmt.setString(7,"피카츄"); 
				
			}else if (PCODE == 2) {
				psmt.setString(7,"이브이"); 
				
			}else if (PCODE == 3) {
				psmt.setString(7,"치코리타"); 
				
			}
			
			
			psmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("중복된 이름입니다. 메인화면으로 이동합니다.");
			pcon.main();

			e.printStackTrace();
		} finally {
			getClose();

		}

	}

	// 문닫기
	public void getClose() {

		try {
			if (rs != null)
				rs.close();
			if (psmt != null)
				psmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}