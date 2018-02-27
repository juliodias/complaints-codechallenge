package com.juliodias.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.juliodias.domain.Complaint;

public interface ComplaintRepository extends MongoRepository<Complaint, String> {
	
	@RestResource(path = "titles", rel = "titles")
	Page<Complaint> findByTitle(@Param("title") String title, Pageable pageable);
	
	@RestResource(path = "cities", rel = "cities")
	Page<Complaint> findByAddressCity(@Param("city") String city, Pageable pageable);
	
	@RestResource(path = "states", rel = "states")
	Page<Complaint> findByAddressState(@Param("state") String state, Pageable pageable);
	
	@RestResource(path = "companies", rel = "companies")
	Page<Complaint> findByCompanyName(@Param("name") String name, Pageable pageable);
	
	@RestResource(path = "companiesByCity", rel = "companies-by-city")
	Page<Complaint> findByCompanyNameAndAddressCity(@Param("name") String name, @Param("city") String city, Pageable pageable);
}
