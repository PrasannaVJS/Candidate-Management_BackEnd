package com.example.demo;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.example.demo.Controller.CandidateController;
import com.example.demo.Service.CandidateService;
import com.example.demo.models.Candidate3;
import com.example.demo.models.Chart;
import com.example.demo.models.DesignationChart;
import com.example.demo.models.SkillChart;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers= {CandidateController.class})

public class ControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	CandidateService candidateservice;
	
	@Autowired
	private WebApplicationContext context;

	@Before
	void setUp() {
		mvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void getAllCandidatesTest() throws Exception {
		List<Candidate3> candidate=new ArrayList<>();
		candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,false,false,false,false));
		when(candidateservice.getAllCandidates()).thenReturn(candidate);
		mvc.perform(get("/getallcandidates")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void createCandidateTest() throws Exception {
		ObjectMapper om=new ObjectMapper();
		String jsonRequest=om.writeValueAsString(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		MvcResult result=mvc.perform(post("/addcandidate").content(jsonRequest)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();
	}
	
	@Test
	public void deleteCandidateTest() throws Exception {
		//List<Candidate3> candidate=new ArrayList<>();
		//candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		//candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,false,false,false,false));
		when(candidateservice.deleteCandidate(1)).thenReturn(true);
		mvc.perform(delete("/deletecandidate/{id}",1))
		.andExpect(status().isOk());
	}
	
	@Test
	public void updateCandidateTest() throws Exception {
		//List<Candidate3> candidate=new ArrayList<>();
		//candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		//candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,false,false,false,false));
		Candidate3 cand=new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false);
		candidateservice.addCandidate(cand);
		cand=new Candidate3(1,"Vijaya Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false);
		
		when(candidateservice.updateCandidate(cand,1)).thenReturn(true);
		mvc.perform(put("/updatecandidate/{Id}",1)).andExpect(status().isBadRequest());
	}

	
	@Test
	public void getCandidateByLocationTest() throws Exception {
		List<Candidate3> candidate=new ArrayList<>();
		candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,false,false,false,false));
		when(candidateservice.getCandidateByLocation("Mumbai")).thenReturn(candidate);
		mvc.perform(get("/getcandidatebylocation/{location}","Mumbai")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getCandidateByJobTest() throws Exception {
		List<Candidate3> candidate=new ArrayList<>();
		candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Manager",2056401287,true,false,false,false,false));
		when(candidateservice.getCandidateByJob("Manager")).thenReturn(candidate);
		mvc.perform(get("/getcandidatebyjob/{jobdescrip}","Manager")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getCandidateBySkillTest() throws Exception {
		List<Candidate3> candidate=new ArrayList<>();
		candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
		candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Manager",2056401287,true,false,false,false,false));
		when(candidateservice.getCandidateBySkill("java")).thenReturn(candidate);
		mvc.perform(get("/getcandidatebyskill/{skill}","java")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getCandidateByIdTest() throws Exception {
		Candidate3 candidate=new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false);
		List<Candidate3> list=new ArrayList<>();
		list.add(candidate);
		when(candidateservice.getCandidateById(1)).thenReturn(list);
		mvc.perform(get("/getcandidatebyid/{Id}","1")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void getChartDataLocationTest() throws Exception {
		Chart c1=new Chart("Bangalore",5);
		Chart c2=new Chart("Mumbai",10);
		List<Chart> list=new ArrayList<>();
		list.add(c1);
		list.add(c2);
		when(candidateservice.getChartDataLocation()).thenReturn(list);
		mvc.perform(get("/chartlocation")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
	
	@Test
	public void getChartDataSkillTest() throws Exception {
		SkillChart s1=new SkillChart("cpp",4);
		SkillChart s2=new SkillChart("java",2);
		List<SkillChart> list=new ArrayList<>();
		list.add(s1);
		list.add(s2);
		when(candidateservice.getChartDataSkill()).thenReturn(list);
		mvc.perform(get("/chartskill")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
	
	@Test
	public void getChartDataPositionTest() throws Exception {
		DesignationChart d1=new DesignationChart("Intern",10);
		DesignationChart d2=new DesignationChart("Employee",10);
		List<DesignationChart> list=new ArrayList<>();
		list.add(d1);
		list.add(d2);
		when(candidateservice.getChartDataPosition()).thenReturn(list);
		mvc.perform(get("/chartdesignation")).andExpect(status().isOk())
		.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		}
	
	

}
