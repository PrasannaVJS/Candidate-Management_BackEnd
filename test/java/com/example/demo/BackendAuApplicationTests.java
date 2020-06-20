package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Role;

import com.example.demo.DAO.CandidateDAO;
import com.example.demo.Service.CandidateService;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Candidate3;
import com.example.demo.models.DesignationChart;
import com.example.demo.models.SkillChart;


@SpringBootTest
class BackendAuApplicationTests {

	/*
	 * @Test void contextLoads() { }
	 */
	@Autowired
	private CandidateService candidateservice;
	@MockBean
	private CandidateDAO candidatedao;
	
		
	@Test
	public void addCandidateTest() {
		Candidate3 c=new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false);
		candidateservice.addCandidate(c);
		verify(candidatedao,times(1)).save(c);
	}
	
	
	@Test
	public void getChartDataPositionTest() {
		when(candidateservice.getChartDataPosition()).thenReturn((List<DesignationChart>) Stream.of(
				new DesignationChart("Intern",5),
				new DesignationChart("Employee",10),
				new DesignationChart("Manager",4),
				new DesignationChart("HR",2))
				.collect(Collectors.toList()));
		assertEquals(4,candidateservice.getChartDataPosition().size());
	}
	
	@Test
	public void getCandidateBySkillTest() {
		when(candidateservice.getCandidateBySkill("Java")).thenReturn((List<Candidate3>) Stream.of(
				new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,false,false,false,false),
				new Candidate3(2,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false))
				.collect(Collectors.toList()));
		assertEquals(2,candidateservice.getCandidateBySkill("Java").size());
		
	}
	
	@Test
	public void getCandidateByIDTest() {
		Candidate3 c=new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false);
		//List<Candidate3> list=new ArrayList<>();
		//list.add(c);
		//candidateservice.addCandidate(c);
		when(candidatedao.getCandidateByID(1)).thenReturn(Stream.of(
				new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false))
				.collect(Collectors.toList()));
		assertEquals(1,candidateservice.getCandidateById(1).size());
		
	}
	
	
	
	
	@Test
	public void getCandidatesTest1() {
		when(candidatedao.getAllCandidates()).thenReturn(Stream.of(
				new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,true,false,false,false),
				new Candidate3(2,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false))
				.collect(Collectors.toList()));
		assertEquals(2,candidateservice.getAllCandidates().size());
	}
	
	@Test
	public void getUserByLocationTest() {
		when(candidatedao.getCandidateByLocation("Chennai")).thenReturn(Stream.of(
				new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false),
				new Candidate3(2,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false))
				.collect(Collectors.toList()));
		assertEquals(2,candidateservice.getCandidateByLocation("Chennai").size());
	}
	
	
	  @Test public void getUserByRoleTest() {
	  when(candidatedao.getCandidateByJob("Employee")).thenReturn(Stream.of( new
			  Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false))
			  .collect(Collectors.toList()));
	  assertEquals(1,candidateservice.getCandidateByJob("Employee").size()); 
	  }
	  
	 
	  
	  @Test
	  public void getUserCountBySkill() {
		  when(candidatedao.getCandidateBySkill("angular")).thenReturn(Stream.of(
				  new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false))
				  .collect(Collectors.toList()));
		  assertEquals(1,candidateservice.getChartDataSkill().get(3).getGradcount());
	  }
	  
	 
	  
	  @Test
	  public void getUserCountByLocation() {
		  when(candidatedao.getCandidateByLocation("Bangalore")).thenReturn(Stream.of(
				  new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false))
				  .collect(Collectors.toList()));
		  assertEquals(1,candidateservice.getChartDataLocation().get(0).getCount());
	  }
	  
	  @Test
	  public void updateUserTest() {
		  Candidate3 c1=new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false);
		  candidateservice.updateCandidate(c1, 1);
		  verify(candidatedao,times(1)).save(c1);
	  }
	  
	  /*@Test
	  public void getCandidateByIDTest() {
		  Candidate3 c1=new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false);
		  candidateservice.addCandidate(c1);
		  candidateservice.getCandidateById(c1.getId());
		  verify(candidatedao,times(1)).findById(c1.getId());
	  }*/
	  
	  @Test
	  public void deleteUserTest() {
		  Candidate3 c1=new Candidate3(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","anylocation","good","Intern",2056401287,true,true,false,false,false);
		  candidateservice.deleteCandidate(c1.getId());
		  verify(candidatedao,times(1)).deleteById(c1.getId());
	  }
	  
	 @Test public void addUserTest() { 
		  Candidate3 c1=new Candidate3("Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,true,false,false,false);
	  when(candidatedao.save(c1)).thenReturn(c1);
	  assertEquals(c1,candidatedao.save(c1)); 
	  }
	  
	 @Test
	 public void daoGetAllCandidatesTest() {
		 List<Candidate3> candidate=new ArrayList<>();
			candidate.add(new Candidate3(1,"Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Mumbai","Super","HR",1056401287,true,true,false,false,false));
			candidate.add(new Candidate3(2,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","College Of Engineering, Guindy","2020-05-11","Bangalore","good","Intern",2056401287,true,false,false,false,false));
			when(candidatedao.getAllCandidates()).thenReturn(candidate);
			assertEquals(2,candidatedao.getAllCandidates().size());
	 }
	 
	/*
	 * @Test public void getUserByIdTest() { Candidate2 c1=new
	 * Candidate2(1,"Vj Prasanna","Shivajee","svprasanna04@gmail.com","anylocation",
	 * "good","Intern",2056401287,true,true,false,false,false); int id=1;
	 * candidateservice.getCandidateById(id);
	 * verify(candidatedao,times(1)).findById(id); }
	 */
}
