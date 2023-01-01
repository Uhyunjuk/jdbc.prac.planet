package com.kh.jdbc.homework.planet.run;

import java.util.List;

import com.kh.jdbc.homework.planet.controller.PlanetController;
import com.kh.jdbc.homework.planet.model.vo.Planet;
import com.kh.jdbc.homework.planet.view.PlanetView;

public class PlanetRun {
	public static void main(String[] args) {
		PlanetView pView = new PlanetView();
		PlanetController pCon = new PlanetController();
		Planet planet = null;
		List<Planet> pList = null;
		String planetName = "";
		String planetExplain = "";
		int result = 0;
		
		bye: while (true) {
			int choice = pView.mainMenu();
			switch (choice) {
			case 1:
				// 전체조회
				pList = pCon.printAll();
				if(!pList.isEmpty()) {
					pView.showAll(pList);
				} else {
					pView.displayError("데이터가 존재하지 않습니다.");
				}
					break;
			case 2:
				// 이름으로 조회
				planetName = pView.inputPlanetName("검색 ");
				pList = pCon.printAllbyName(planetName);
				if(!pList.isEmpty()) {
					pView.showAll2(pList);
				} else {
					pView.displayError("일치하는 행성이 없습니다.");
				}
				break;
			case 3:
				// 행성 설명 출력하기
				planetName = pView.inputPlanetName2("설명을 듣고 싶은 ");
				planet = pCon.printOnebyName(planetName);
				if(planet != null) {
					pView.showOne(planet);
				} else {
					pView.displayError("일치하는 데이터가 없습니다.");
				}
				break;
			case 4:
				// 행성 추가하기
				planet = pView.inputPlanet();
				result = pCon.registerPlanet(planet);
				if(result > 0) {
					pView.displaySuccess("행성 추가 완료 !");
				}else {
					pView.displaySuccess("행성 추가 실패");
				}
				break;
			case 5:
				// 행성 삭제하기
				planetName = pView.inputPlanetName("삭제");
				result = pCon.removePlanet(planetName);
				if(result > 0) {
					pView.displaySuccess("행성 삭제 완료");
				}else {
					pView.displayError("행성 삭제 실패 !!!");
				}
				break ;
			case 6:
				// 종료
				break bye;
			}

		}

	}

}
