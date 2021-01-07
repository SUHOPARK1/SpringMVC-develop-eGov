package com.example.demo.uss.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.cmm.enm.Sql;
import com.example.demo.cmm.utl.DummyGenerator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService{
	@Autowired DummyGenerator dummy;
    @Autowired
    StudentMapper studentMapper;

    @Transactional
    public int insertMany(int count) {
    	for(int i=0; i < count; i++) {
    		studentMapper.insert(dummy.makeStudent());
    	}
    	int a = count;
    	return count();
    }
    @Transactional
    public int truncate() {
    	var map = new HashMap<String,String>();
    	map.put("TRUNCATE_STUDENTS", Sql.TRUNCATE_STUDENTS.toString());
    	studentMapper.truncate(map);
    	return count() != 0 ? 0 : 1;
    }
    
    public int count() {
    	var map = new HashMap<String,String>();
    	map.put("COUNT_STUDENTS", Sql.COUNT_STUDENTS.toString());
    	return studentMapper.count(map);
    }
    
}