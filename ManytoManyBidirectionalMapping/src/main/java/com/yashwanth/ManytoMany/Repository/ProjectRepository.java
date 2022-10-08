package com.yashwanth.ManytoMany.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.yashwanth.ManytoMany.Entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

		
}
