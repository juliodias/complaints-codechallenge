package com.juliodias.domain;

public class Company {

	private String name;
	
	public Company() {
	}
	
	public Company(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Company)) {
            return false;
        }
        Company company = (Company) obj;
        return company.name.equals(name);
    }
	
	@Override
	public int hashCode() {
        int result = 17;
        result = 31 * result + name.hashCode();
        return result;
	}
}
