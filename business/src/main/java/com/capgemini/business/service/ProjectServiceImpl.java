package com.capgemini.business.service;

import com.capgemini.business.mapper.dataobject.projects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectService projectService;

    @Autowired
    public ProjectServiceImpl(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public List<projects> selectProjectList(int project_id) {
        List<projects> list = projectService.selectProjectList(project_id);
        System.out.println("--------------" + list);
        return list;
    }

    @Override
    public int insertIntoProject(projects pro) {
        return projectService.insertIntoProject(pro);

    }
}
