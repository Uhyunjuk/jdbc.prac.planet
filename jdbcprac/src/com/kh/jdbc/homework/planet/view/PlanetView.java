package com.kh.jdbc.homework.planet.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.homework.planet.model.vo.Planet;

public class PlanetView {

	// 기본메뉴 출력
	public int mainMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("✦ ✧ ✩ ✰ ✭ ✦  태양계 행성을 구경해보자 ✦ ✧ ✩ ✰ ✭ ✦ ");
		System.out.println("① 행성 목록 전체 조회하기");
		System.out.println("② 행성 이름으로 조회해보기");
		System.out.println("③ 행성에 대한 설명 듣기");
		System.out.println("④ 나만의 행성 추가하기");
		System.out.println("⑤ 행성 삭제하기");
		System.out.println("⑥ 프로그램 종료");
		System.out.print("메뉴 선택 : ");
		int choice = sc.nextInt();
		return choice;
	}
	

	// 1. 전체목록조회
	public void showAll(List<Planet> pList) {
		System.out.println("✦ ✧ ✩ ✰ ✭ ✦ ✧ ✩ ✰ ✭ ✦ ✧ ✩ ✰ 행성 전체 목록 조회 ✦ ✧ ✩ ✰ ✦ ✧ ✩ ✰ ✭ ✦ ✧ ✩ ✰ ✭");
		for (Planet pOne : pList) {
			System.out.print("행성 이름 : " + pOne.getName());
			System.out.print(", 행성 별명 : " + pOne.getNickname());
			System.out.print(", 중 력 : " + pOne.getGravity());
			System.out.print(", 온 도 : " + pOne.getTemp());
			System.out.print(", 대 기 : " + pOne.getAtoms());
			System.out.println(", 표 면 : " + pOne.getSurface());
		}
	}
	// 2. 이름으로 조회
	public void showAll2(List<Planet> pList) {
		System.out.println("✦ ✧ ✩ ✰ ✭ ✦ ✧ ✩ ✰ ✭ ✦ ✧ ✩ ✰ 선택한 행성의 목록을 전체조회합니다 ✦ ✧ ✩ ✰ ✦ ✧ ✩ ✰ ✭ ✦ ✧ ✩ ✰ ✭");
		for (Planet pOne : pList) {
			System.out.print("행성 이름 : " + pOne.getName());
			System.out.print(", 행성 별명 : " + pOne.getNickname());
			System.out.print(", 중 력 : " + pOne.getGravity());
			System.out.print(", 온 도 : " + pOne.getTemp());
			System.out.print(", 대 기 : " + pOne.getAtoms());
			System.out.println(", 표 면 : " + pOne.getSurface());
		}
	}

	// 2. 이름으로 조회
	public String inputPlanetName(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + "할 행성 이름 입력 : ");
		String planetName = sc.next();
		return planetName;
	}

	// 3. 행성 이름으로 조회해서 설명띄우기
	public String inputPlanetName2(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + "행성의 이름을 입력하세요 : ");
		String planetName = sc.next();
		return planetName;
	}

	public void showOne(Planet planet) {
		System.out.println(planet.getExplain());
	}

	// 4. 행성추가
	public Planet inputPlanet() {
		Scanner sc = new Scanner(System.in);
		System.out.println("=== === 나만의 행성 추가 하기 === === ");
		System.out.print("행성 이름 : ");
		String planetName = sc.next();
		System.out.print("행성 별명 : ");
		String planetNickname = sc.next();
		System.out.print("중 력 : ");
		int gravity = sc.nextInt();
		System.out.print("온 도 : ");
		int temp = sc.nextInt();
		System.out.print("대 기 : ");
		String atoms = sc.next();
		System.out.print("표 면(,로 구분) : ");
		String surface = sc.next();
		System.out.print("설명 : ");
		String explain = sc.next();

		Planet planet = new Planet(planetName, planetNickname, gravity, temp, atoms, surface, explain);
		return planet;
	}

	// 5. 행성삭제

	public void printMessage(String msg) {
		System.out.println(msg);
	}

	public void displaySuccess(String msg) {
		System.out.println("[서비스 성공] : " + msg);
	}

	public void displayError(String msg) {
		System.out.println("[서비스 실패] : " + msg);
	}

}
