package com.kh.jdbc.homework.planet.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kh.jdbc.homework.planet.model.vo.Planet;

public class PlanetDAO {
	// SID
	// 집컴 : orcl
	// 학원컴 : xe

	private final String URL = "jdbc:oracle:thin:@localhost:1521:orcl";
	private final String USER = "KH";
	private final String PASSWORD = "KH";
	private final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";

	// 1. 전체조회
	public List<Planet> selectAll() {
		String sql = "SELECT NAME,NICKNAME,GRAVITY,TEMPERATURE,ATOMSPHERE,SURFACE FROM PLANET_TBL";
		Planet planet = null;
		List<Planet> pList = null;
		try {
			// 1. 드라이버 등록
			Class.forName(DRIVER_NAME);
			// 2. DB 연결 생성
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			// 3. 쿼리문 실행준비(statement)
			Statement stmt = conn.createStatement();
			// 4. 쿼리문 실행 및 결과 받기
			ResultSet rset = stmt.executeQuery(sql);
			pList = new ArrayList<Planet>();

			// rset을 바로 사용하지 못하기 때문에 후처리 해줘야함
			while (rset.next()) {
				planet = new Planet();
				planet.setName(rset.getString("NAME"));
				planet.setNickname(rset.getString("NICKNAME"));
				planet.setGravity(rset.getInt("GRAVITY"));
				planet.setTemp(rset.getInt("TEMPERATURE"));
				planet.setAtoms(rset.getString("ATOMSPHERE"));
				planet.setSurface(rset.getString("SURFACE"));
				pList.add(planet);
			}

			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	// 2. 이름으로 조회
	public List<Planet> selectAllbyName(String planetName) {
		List<Planet> pList = null;
		Planet planet = null;
		String sql = "SELECT * FROM PLANET_TBL WHERE NAME = '" + planetName + "'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			pList = new ArrayList<Planet>();
			while (rset.next()) {
				planet = new Planet();
				planet.setName(rset.getString("NAME"));
				planet.setNickname(rset.getString("NICKNAME"));
				planet.setGravity(rset.getInt("GRAVITY"));
				planet.setTemp(rset.getInt("TEMPERATURE"));
				planet.setAtoms(rset.getString("ATOMSPHERE"));
				planet.setSurface(rset.getString("SURFACE"));

				pList.add(planet);
			}
			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pList;
	}

	// 3. 행성설명듣기
	public Planet selectOnebyName(String planetName) {
		Planet planet = null;
		String sql = "SELECT EXPLAIN FROM PLANET_TBL WHERE NAME = '" + planetName + "'";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(sql);
			if (rset.next()) {
				planet = new Planet();
				planet.setExplain(rset.getString("EXPLAIN"));
			}

			rset.close();
			stmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return planet;
	}

	// 4. 행성추가
	public int insertPlanet(Planet planet) {
		int result = 0;
		String sql = "INSERT INTO PLANET_TBL VALUES(?,?,?,?,?,?,?)";
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, planet.getName());
			pstmt.setString(2, planet.getNickname());
			pstmt.setInt(3, planet.getGravity());
			pstmt.setInt(4, planet.getTemp());
			pstmt.setString(5, planet.getAtoms());
			pstmt.setString(6, planet.getSurface());
			pstmt.setString(7, planet.getExplain());
			result = pstmt.executeUpdate();

			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// 5. 행성 삭제
	public int deletePlanet(String planetName) {
		String sql = "DELETE FROM PLANET_TBL WHERE NAME = ?";
		int result = 0;
		try {
			Class.forName(DRIVER_NAME);
			Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, planetName);
			result = pstmt.executeUpdate();

			pstmt.close();
			conn.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
