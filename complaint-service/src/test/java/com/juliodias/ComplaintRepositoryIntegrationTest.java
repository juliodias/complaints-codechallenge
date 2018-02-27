package com.juliodias;

import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.juliodias.domain.Address;
import com.juliodias.domain.Company;
import com.juliodias.domain.Complaint;
import com.juliodias.repository.ComplaintRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ComplaintRepositoryIntegrationTest {
	
	@Autowired private MockMvc mockMvc;
	@Autowired private ObjectMapper objectMapper;
	@Autowired private ComplaintRepository complaintRepository;
	
	private Complaint complaint;
	private PageRequest pageRequest = new PageRequest(0, 10);
	
	@Before
	public void setUpBefore() {
		complaint = createComplaint();
		complaintRepository.save(complaint);
	}
	
	@After
	public void setUpAfter() {
		complaintRepository.deleteAll();
	}
	
	@Test
	public void testSaveComplaints() throws Exception {
		mockMvc.perform(post("/complaints")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(complaint)))
				.andExpect(status().isCreated());
	}
	
	@Test
	public void testResourceNotFound() throws Exception {
		mockMvc.perform(get("/complaintz"))
				.andDo(print())
				.andExpect(status()
				.isNotFound());
	}
	
	@Test
	public void testFindComplaintsByTitle() {
		Page<Complaint> complaints = complaintRepository.findByTitle(complaint.getTitle(), pageRequest);
		
		assertThat(complaints.getContent(), hasItem(complaint));
	}
	
	@Test
	public void testFindComplaintsByCompanyName() {
		Company company = complaint.getCompany();

		Page<Complaint> complaints = complaintRepository.findByCompanyName(company.getName(), pageRequest);
		
		assertThat(complaints.getContent(), hasItem(complaint));
	}
	
	@Test
	public void testFindComplaintsByCity() {
		Address address = complaint.getAddress();

		Page<Complaint> complaints = complaintRepository.findByAddressCity(address.getCity(), pageRequest);
		
		assertThat(complaints.getContent(), hasItem(complaint));
	}
	
	@Test
	public void testFindComplaintsByState() {
		Address address = complaint.getAddress();

		Page<Complaint> complaints = complaintRepository.findByAddressState(address.getState(), pageRequest);
		
		assertThat(complaints.getContent(), hasItem(complaint));
	}
	
	@Test
	public void testNumbersOfComplaintsSaved() {
		List<Complaint> complaints = complaintRepository.findAll();
		
		assertEquals(complaints.size(), 1);
	}

	private Complaint createComplaint() {
		return new Complaint("I did not receive my product", "", new Company("Umbrella Corporation"), new Address("Raccon City", "UN"));
	}
	
}