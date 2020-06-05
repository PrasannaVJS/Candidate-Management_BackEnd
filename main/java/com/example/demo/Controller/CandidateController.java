package com.example.demo.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.CandidateService;
import com.example.demo.models.Candidate;
import com.example.demo.models.Candidate2;
import com.example.demo.models.Chart;
import com.example.demo.models.SkillChart;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CandidateController {
	@Autowired
	private CandidateService candidateService;
	
	Logger logger=LoggerFactory.getLogger(CandidateController.class);
	@RequestMapping(value="/addcandidate",method=RequestMethod.POST)
	public String addCandidate(@RequestBody Candidate2 candidate) {
		//candidateService.addCandidate(new Candidate("Vijaya Prasanna","Shivajee","svprasanna04@gmail.com","bangalore","good","intern",805640128,true,true,false,true,false));
		System.out.println(candidate.toString());
		candidateService.addCandidate(candidate);
		//System.out.println("Candidate Successfully Added");
		logger.info("Candidate Successfully Added");
		return "Candidate Successfully Added";
	}
	
	@DeleteMapping("/deletecandidate/{id}")
	public List<Candidate2> deleteCandidate(@PathVariable Integer id){
		candidateService.deleteCandidate(id);
		//System.out.println("Grad with ID: "+id +" deleted");
		logger.info("Grad with ID: \"+id +\" deleted");
		return candidateService.getAllCandidates();
		
	}
	
	
	@GetMapping("/getcandidatebyid/{Id}")
	public Candidate2 getCandidateById(@PathVariable Integer Id) {
		return candidateService.getCandidateById(Id);
	}
	
	@GetMapping("/getallcandidates")
	public List<Candidate2> getAllCandidates(){
		return candidateService.getAllCandidates();
	}
	
	
	@GetMapping("/getcandidatebylocation/{location}")
	public List<Candidate2> getCandidateById(@PathVariable String location)
	{
		return candidateService.getCandidateByLocation(location);
	}
	
	
	@GetMapping("/getcandidatebyjob/{jobdescrip}")
	public List<Candidate2> getCandidateByJob(@PathVariable String jobdescrip)
	{
		return candidateService.getCandidateByJob(jobdescrip);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/updatecandidate/{Id}")
	public List<Candidate2> updateCandidate(@RequestBody Candidate2 candidate,@PathVariable Integer Id)
	{
		candidateService.updateCandidate(candidate,Id);
		logger.info("Candidate with ID: "+Id+ " got updated");
		return candidateService.getAllCandidates();
	}
	
	
	@GetMapping("/chartlocation")
	public List<Chart> getChartDataLocation(){
		return candidateService.getChartDataLocation();
	}
	

	@GetMapping("/chartskill")
	public List<SkillChart> getChartDataSkill(){
		return candidateService.getChartDataSkill();
	}
	
}
