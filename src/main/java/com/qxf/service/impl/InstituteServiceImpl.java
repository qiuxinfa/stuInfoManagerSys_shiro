package com.qxf.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxf.mapper.InstituteMapper;
import com.qxf.pojo.Institute;
import com.qxf.service.InstituteService;
import tk.mybatis.mapper.entity.Example;

@Service
public class InstituteServiceImpl extends BaseService<Institute> implements InstituteService{
    @Autowired
	private InstituteMapper instituteMapper;

	@Override
	public PageInfo<Institute> selectByPage(Institute institute, int start, int length) {
		int page = start/length+1;
		//分页查询
		PageHelper.startPage(page, length);
		List<Institute> instituteList = findAllInstitute(institute);
		return new PageInfo<>(instituteList);
	}

	public List<Institute> findAllInstitute(Institute institute) {
		// TODO Auto-generated method stub
		return instituteMapper.findAllInstitute(institute);
	}

	public Institute findInstituteById(String id) {
		// TODO Auto-generated method stub
		return instituteMapper.findInstituteById(id);
	}

	public Institute findInstituteByName(String name) {
		// TODO Auto-generated method stub
		return instituteMapper.findInstituteByName(name);
	}

	public Integer deleteInstituteById(String id) {
		// TODO Auto-generated method stub
		return instituteMapper.deleteInstituteById(id);
	}

	public Integer updateInstitute(Institute institute) {
		// TODO Auto-generated method stub
		return instituteMapper.updateInstitute(institute);
	}

	public Integer addInstitute(Institute institute) {
		// TODO Auto-generated method stub
		return instituteMapper.addInstitute(institute);
	}

}
