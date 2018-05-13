
package com.kath.model;

public class Member {
	
	private int Id;
	private String name;
	private String lName;
	private String adress;
	private String city;
	private String userName;
	private String profession;
	
	public Member() {}
	
	public Member(int Id) {
		this.Id = Id;
	}
	
	public Member(int id, String name, String lName, String adress, String city, String username, String profession) {
		this.Id = id;
		this.name = name;
		this.lName = lName;
		this.adress = adress;
		this.city = city;
		this.userName = username;
		this.profession = profession;
	}
	
	public Member(String name, String lName, String adress, String city, String username, String profession) {
		this.name = name;
		this.lName = lName;
		this.adress = adress;
		this.city = city;
		this.userName = username;
		this.profession = profession;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	@Override
	public String toString() {
		return "Member [Id=" + Id + ", name=" + name + ", lName=" + lName + ", adress=" + adress + ", "
				+ "city=" + city + ", userName=" + userName + " profession=" + profession + "]";
	}

}

