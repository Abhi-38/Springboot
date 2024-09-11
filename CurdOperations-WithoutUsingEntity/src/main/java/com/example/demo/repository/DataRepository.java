package com.example.demo.repository;

import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class DataRepository {
	private final JdbcTemplate jdTemp;
	
	public DataRepository(JdbcTemplate jdTemp) {
		this.jdTemp = jdTemp;
	}//DataRepository
	
	//this is to get the data from member table
	public List<Object[]> getAllData(){
		String sqlQuery = "SELECT UNAME,PASSWORD,EMAIL,PHONE FROM MEMBER WHERE UNAME=?";
		return jdTemp.query(sqlQuery,(resultSet, rowNum)-> 
			new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)});
	}//getAllData()
	
	//this is to insert the data in table 
	public String addData(Map<String,Object> theData) {
		String sqlQuery = "INSERT INTO MEMBER VALUES(?,?,?,?)";
		jdTemp.update(sqlQuery, theData.get("uname"),theData.get("password"),theData.get("email"),theData.get("phone"));
		return "Member data insertion sucessful ! ! !";
	}//addData
	
	//this is to update existing record in table
	public String updateData(String uname, Map<String,Object> updateData) 
	{
		String sqlQuery = "UPDATE MEMBER SET EMAIL = ?, PHONE = ? WHERE UNAME = ?";
		jdTemp.update(sqlQuery, updateData.get("email"),updateData.get("phone"),uname);
		return "Updation Sucessful";
	}//updateData
	
	//this is to update the password of the member
	public String updatePwd(String uname, Map<String,Object> updatePassword) {
		String sqlQuery = "UPDATE MEMBER SET PASSWORD=? WHERE UNAME=?";
		jdTemp.update(sqlQuery,updatePassword.get("password"),uname);
		return "Password has been Updated";
	}//updatePwd
	
	//this is to delete the data from the table
	public String deleteData(String uname) {
		String sqlQuery = "DELETE FROM MEMBER WHERE UNAME = ?";
		jdTemp.update(sqlQuery,uname);
		return "Member Deletion Sucessful ! ! !";
	}//deleteData

	public List<Object[]> getAllFilterData(String condition) {
		String sqlQuery = "SELECT UNAME,PASSWORD,EMAIL,PHONE FROM MEMBER WHERE "+condition;
		return jdTemp.query(sqlQuery,(resultSet, rowNum)-> 
			new Object[]{resultSet.getString(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4)});
	}
}//class
