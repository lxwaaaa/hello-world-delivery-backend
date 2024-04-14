package com.capgemini.business.mapper.dataobject;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class projects {
    private int projectId;
    private String projectName;
    private String description;
    private String startDate;
    private String endDate;
    private BigDecimal budget;
    private String projectManager;
    private List<String> teamMembers;

    // 构造函数
    public void Project(int projectId, String projectName, String description, Date startDate, Date endDate, BigDecimal budget, String projectManager, List<String> teamMembers) {
        this.projectId = projectId;
        this.projectName = projectName;
        this.description = description;
        this.startDate = String.valueOf(startDate);
        this.endDate = String.valueOf(endDate);
        this.budget = budget;
        this.projectManager = projectManager;
        this.teamMembers = teamMembers;
    }

    // Getter 和 Setter 方法
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public List<String> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<String> teamMembers) {
        this.teamMembers = teamMembers;
    }

    // toString 方法
    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", projectName='" + projectName + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", budget=" + budget +
                ", projectManager='" + projectManager + '\'' +
                ", teamMembers=" + teamMembers +
                '}';
    }
}
