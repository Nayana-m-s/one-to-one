package one_to_one_uni.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdharCard {
	@Id
	private int  adharid;
	private String name;
	private String address;
	public int getAdharid() {
		return adharid;
	}
	public void setAdharid(int adharid) {
		this.adharid = adharid;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "AdharCard [adharid=" + adharid + ", name=" + name + ", address=" + address + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
