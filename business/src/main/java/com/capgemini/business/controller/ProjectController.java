package com.capgemini.business.controller;

import com.capgemini.business.mapper.dataobject.projects;
import com.capgemini.business.service.ProjectService;
import com.capgemini.commons.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/get_projects")
    @ResponseBody
    public Response<List<projects>> getProjects(Model model) {
        List<projects> projects = projectService.selectProjectList(1);
        return Response.success(projects);

    }

    @PostMapping("/update_projects")
    public String createProject(@RequestBody projects project) {
        int rowsAffected = projectService.insertIntoProject(project);
        if (rowsAffected > 0) {
            return "Project created successfully";
        } else {
            return "Failed to create project";
        }
    }
}
