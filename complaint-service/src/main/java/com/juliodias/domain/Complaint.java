package com.juliodias.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "complaints")
public class Complaint {

	@Id
	private String id;
	private String title, description;
	private Company company;
	private Address address;
	
	public Complaint() {
	}
	
	public Complaint(String title, String description, Company company, Address address) {
		this.title = title;
		this.company = company;
		this.address = address;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public Company getCompany() {
		return company;
	}
	
	public Address getAddress() {
		return address;
	}
	
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Complaint)) {
            return false;
        }
        Complaint complaint = (Complaint) o;
        return complaint.title.equals(title) &&
               complaint.description.equals(description) &&
               complaint.address.equals(address) &&
               complaint.company.equals(company);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + title.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + company.hashCode();
        return result;
    }
}
