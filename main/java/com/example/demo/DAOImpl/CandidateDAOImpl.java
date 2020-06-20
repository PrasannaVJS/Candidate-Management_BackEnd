package com.example.demo.DAOImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.demo.DAO.CandidateDAOCustom;

import com.example.demo.models.Candidate3;

public class CandidateDAOImpl implements CandidateDAOCustom {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	public List<Candidate3> getAllCandidates(){
		try {
		return jdbcTemplate.query(
				"select * from candidate3",
				(rs,rowNum) ->
					new Candidate3(
							rs.getInt("id"),
							rs.getString("firstname"),
							rs.getString("lastname"),
							rs.getString("emailID"),
							rs.getString("institution"),
							rs.getString("joindate"),
							rs.getString("location"),
							rs.getString("feedback"),
							rs.getString("jobdescrip"),
							rs.getLong("contactno"),
							rs.getBoolean("cpp"),
							rs.getBoolean("java"),
							rs.getBoolean("python"),
							rs.getBoolean("angular"),
							rs.getBoolean("spring")
						)
				);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Candidate3> getCandidateByLocation(String location_choice)
	{
		StringBuilder sb=new StringBuilder();
		for (char c:location_choice.toCharArray()) {
			sb.append(c).append("%");
		}
		try {
		 return jdbcTemplate.query(
	                "select * from candidate3 where location like '%"+sb+"'",
	                (rs, rowNum) ->
	                        new Candidate3(
	                        		rs.getInt("id"),
	    							rs.getString("firstname"),
	    							rs.getString("lastname"),
	    							rs.getString("emailID"),
	    							rs.getString("institution"),
	    							rs.getString("joindate"),
	    							rs.getString("location"),
	    							rs.getString("feedback"),
	    							rs.getString("jobdescrip"),
	    							rs.getLong("contactno"),
	    							rs.getBoolean("cpp"),
	    							rs.getBoolean("java"),
	    							rs.getBoolean("python"),
	    							rs.getBoolean("angular"),
	    							rs.getBoolean("spring")                   
	                        )
	        );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Candidate3> getCandidateByJob(String jobdescrip){
		try {
		return jdbcTemplate.query(
                "select * from candidate3 where jobdescrip like '%"+jobdescrip+"%'",
                (rs, rowNum) ->
                        new Candidate3(
                        		rs.getInt("id"),
    							rs.getString("firstname"),
    							rs.getString("lastname"),
    							rs.getString("emailID"),
    							rs.getString("institution"),
    							rs.getString("joindate"),
    							rs.getString("location"),
    							rs.getString("feedback"),
    							rs.getString("jobdescrip"),
    							rs.getLong("contactno"),
    							rs.getBoolean("cpp"),
    							rs.getBoolean("java"),
    							rs.getBoolean("python"),
    							rs.getBoolean("angular"),
    							rs.getBoolean("spring")                   
                        )
        );
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Candidate3> getCandidateBySkill(String sname){
		try {
		return jdbcTemplate.query(
                "select * from candidate3 where "+sname+ "=?",new Object[]{true},
                (rs, rowNum) ->
                        new Candidate3(
                        		rs.getInt("id"),
    							rs.getString("firstname"),
    							rs.getString("lastname"),
    							rs.getString("emailID"),
    							rs.getString("institution"),
    							rs.getString("joindate"),
    							rs.getString("location"),
    							rs.getString("feedback"),
    							rs.getString("jobdescrip"),
    							rs.getLong("contactno"),
    							rs.getBoolean("cpp"),
    							rs.getBoolean("java"),
    							rs.getBoolean("python"),
    							rs.getBoolean("angular"),
    							rs.getBoolean("spring")                   
                        )
        );
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	
	public List<Candidate3> getCandidateByID(int Id) throws DataAccessException {
		
		try {
			return jdbcTemplate.query(
					"select * from candidate3 where id =?",new Object[]{Id},
					(rs,rowNum) ->
						new Candidate3(
								rs.getInt("id"),
								rs.getString("firstname"),
								rs.getString("lastname"),
								rs.getString("emailID"),
								rs.getString("institution"),
								rs.getString("joindate"),
								rs.getString("location"),
								rs.getString("feedback"),
								rs.getString("jobdescrip"),
								rs.getLong("contactno"),
								rs.getBoolean("cpp"),
								rs.getBoolean("java"),
								rs.getBoolean("python"),
								rs.getBoolean("angular"),
								rs.getBoolean("spring")
							)
					);
			}
			catch(Exception e){
				e.printStackTrace();
			}
			return null;
	}
}
