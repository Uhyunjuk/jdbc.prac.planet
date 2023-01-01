package com.kh.jdbc.homework.planet.controller;

import java.util.List;

import com.kh.jdbc.homework.planet.model.dao.PlanetDAO;
import com.kh.jdbc.homework.planet.model.vo.Planet;

public class PlanetController {
	
	/**
	 * 행성 목록 전체조회
	 * @return List<Planet>
	 */
	public List<Planet> printAll() {
		PlanetDAO pDao = new PlanetDAO();
		List<Planet> pList = pDao.selectAll();
		return pList;
	}
	
	/**
	 * 행성 이름으로 조회
	 * @param planetName
	 * @return
	 */
	public List<Planet> printAllbyName(String planetName) {
		PlanetDAO pDao = new PlanetDAO();
		List<Planet> pList = pDao.selectAllbyName(planetName);
		return pList;
	}
	
	/**
	 * 설명 듣고 싶은 행성 이름 조회
	 * @param planetName
	 * @return
	 */
	public Planet printOnebyName(String planetName) {
		PlanetDAO pDao = new PlanetDAO();
		Planet planet = pDao.selectOnebyName(planetName);
		return planet;
	}
	
	/**
	 * 행성 추가하기
	 * @param planet
	 * @return int
	 */
	public int registerPlanet(Planet planet) {
		PlanetDAO pDao = new PlanetDAO();
		int result = pDao.insertPlanet(planet);
		return result;
	}
	

	/**
	 * 행성 삭제하기
	 * @param planetName
	 * @return int
	 */
	public int removePlanet(String planetName) {
		PlanetDAO pDao = new PlanetDAO();
		int result = pDao.deletePlanet(planetName);
		return result;
	}
	
}
