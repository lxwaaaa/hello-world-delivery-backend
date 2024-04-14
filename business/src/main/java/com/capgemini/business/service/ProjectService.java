package com.capgemini.business.service;

import com.capgemini.business.mapper.dataobject.projects;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ProjectService {
    @Select("select * from projects where project_id=#{project_id}")
    public List<projects> selectProjectList(int project_id);

    @Insert("insert into projects (project_id, project_name, description, start_date, end_date, budget, project_manager, team_members) values (#{pro.projectId}, #{pro.projectName}, #{pro.description}, #{pro.startDate}, #{pro.endDate}, #{pro.budget}, #{pro.projectManager}, #{pro.teamMembers})")
    public int insertIntoProject(@Param("pro") projects pro);

//    @Update("update from projects")

}
