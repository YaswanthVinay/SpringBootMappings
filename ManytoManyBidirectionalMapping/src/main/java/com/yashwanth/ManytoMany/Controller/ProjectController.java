package com.yashwanth.ManytoMany.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yashwanth.ManytoMany.Entity.Project;
import com.yashwanth.ManytoMany.Service.ProjectService;

@RestController
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping("/SaveProject")
	public List<Project> Saveproject(@RequestBody List<Project> proj) {
		return projectService.SaveProject(proj);

	}
	@GetMapping("/GetProjectDetails")
	public List<Project> GetProjectDetails(){
		return projectService.GetDetailsOfProject();
	}
	
	@GetMapping("/GetProjectDetails/{proid}")
	public ResponseEntity<Project> GetProjectById(@PathVariable int proid){
		return projectService.GetProjectInfoById(proid);
	}
}
