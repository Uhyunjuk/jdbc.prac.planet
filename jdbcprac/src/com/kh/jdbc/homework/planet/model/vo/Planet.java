package com.kh.jdbc.homework.planet.model.vo;

public class Planet {
	private String name;
	private String nickname;
	private int gravity;
	private int temp;
	private String atoms;
	private String surface;
	private String explain;
	
	public Planet() {
		
	}
	
	public Planet(String name, String nickname, int gravity, int temp, String atoms, String surface, String explain) {
		super();
		this.name = name;
		this.nickname = nickname;
		this.gravity = gravity;
		this.temp = temp;
		this.atoms = atoms;
		this.surface = surface;
		this.explain = explain;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getGravity() {
		return gravity;
	}

	public void setGravity(int gravity) {
		this.gravity = gravity;
	}

	public int getTemp() {
		return temp;
	}

	public void setTemp(int temp) {
		this.temp = temp;
	}

	public String getAtoms() {
		return atoms;
	}

	public void setAtoms(String atoms) {
		this.atoms = atoms;
	}

	public String getSurface() {
		return surface;
	}

	public void setSurface(String surface) {
		this.surface = surface;
	}
	
	public String getExplain() {
		return explain;
	}
	
	public void setExplain(String explain) {
		this.explain = explain;
	}

	@Override
	public String toString() {
		return "Planet [name=" + name + ", nickname=" + nickname + ", gravity=" + gravity + ", temp=" + temp
				+ ", atoms=" + atoms + ", surface=" + surface + ", explain=" + explain + "]";
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
