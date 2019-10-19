package com.qxf.service.impl;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qxf.mapper.MajorMapper;
import com.qxf.pojo.Major;
import com.qxf.service.MajorService;
import tk.mybatis.mapper.entity.Example;

@Service
public class MajorServiceImpl extends BaseService<Major> implements MajorService{
    @Autowired
	private MajorMapper majorMapper;

	@Override
	public PageInfo<Major> selectByPage(Major major, int start, int length) {
		int page = start/length+1;
		//分页查询
		PageHelper.startPage(page, length);
		List<Major> majorList = majorMapper.findAllMajor(major);
		return new PageInfo<>(majorList);
	}

	public List<Major> findAllMajor(Major major) {
		// TODO Auto-generated method stub
		return majorMapper.findAllMajor(major);
	}

	public Major findMajorById(String id) {
		// TODO Auto-generated method stub
		return majorMapper.findMajorById(id);
	}

	public Major findMajorByName(String name) {
		// TODO Auto-generated method stub
		return majorMapper.findMajorByName(name);
	}

	public Integer deleteMajorById(String id) {
		// TODO Auto-generated method stub
		return majorMapper.deleteMajorById(id);
	}

	public Integer updateMajor(Major major) {
		// TODO Auto-generated method stub
		return majorMapper.updateMajor(major);
	}

	public Integer addMajor(Major major) {
		// TODO Auto-generated method stub
		return majorMapper.addMajor(major);
	}

}
