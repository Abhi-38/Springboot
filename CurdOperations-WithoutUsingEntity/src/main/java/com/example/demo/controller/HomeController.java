package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.DataRepository;

@RestController
@RequestMapping("/api")
public class HomeController {
	private final DataRepository dataRepository;
	
	@Autowired
	public HomeController(DataRepository dataRepository) {
		this.dataRepository = dataRepository;
	}
	
	@GetMapping("/getTableData")
	public List<Object[]> getData(){
		return dataRepository.getAllData();
	}//getData
	
	@PostMapping("/filterTableData/{data}")
	public List<Object[]> filterData(@PathVariable String data){
		return dataRepository.getAllFilterData(data);
	}
	
	@PutMapping("/insertData")
	public String insertData(@RequestBody Map<String,Object> insert) {
		return dataRepository.addData(insert);
	}//insertData
	
	@PutMapping("/updateData/{uname}")
	public String updateData(@PathVariable String uname, @RequestBody Map<String,Object> update) {
		return dataRepository.updateData(uname, update);
	}//updateData
	
	@PutMapping("/updatePwd/{uname}")
	public String updatePwd(@PathVariable String uname,@RequestBody Map<String,Object> password) {
		return dataRepository.updatePwd(uname, password);
	}//updatePwd
	
	@DeleteMapping("/deleteData/{uname}")
	public String deleteData(@PathVariable String uname) {
		return dataRepository.deleteData(uname);
	}//deleteData
	
}//HomeController
