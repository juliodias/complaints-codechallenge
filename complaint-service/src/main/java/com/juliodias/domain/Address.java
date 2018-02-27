package com.juliodias.domain;

public class Address {

	private String city, state;
	
	public Address() {
	}
	
	public Address(String city, String state) {
		this.city = city;
		this.state = state;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}

	@Override
	public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        return address.city.equals(city) &&
               address.state.equals(state);
	}
	
	@Override
	public int hashCode() {
        int result = 17;
        result = 31 * result + city.hashCode();
        result = 31 * result + state.hashCode();
        return result;
	}
	
}
