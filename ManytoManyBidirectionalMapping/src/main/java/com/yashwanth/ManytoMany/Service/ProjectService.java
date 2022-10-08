package com.yashwanth.ManytoMany.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.yashwanth.ManytoMany.Entity.Project;
import com.yashwanth.ManytoMany.Repository.ProjectRepository;

@Service
@SuppressWarnings({ "rawtypes", "unchecked" })
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	
	
	public List<Project> SaveProject(List<Project> proj) {
		return projectRepository.saveAll(proj);
	}

	public List<Project> GetDetailsOfProject() {
		return projectRepository.findAll();
	}

	public ResponseEntity<Project> GetProjectInfoById(int proid) {
		Optional<Project> Projectoptional=projectRepository.findById(proid);
		if (Projectoptional.isPresent()) {
			return new ResponseEntity(proid,HttpStatus.OK);
			
		}else
		{
			return new ResponseEntity("Name Does not Exist",HttpStatus.NOT_FOUND);
		}
		
	}

}

