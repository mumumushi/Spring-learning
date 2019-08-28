package com.testcloud.calculate.controller;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;



@Slf4j
@RestController
@RequestMapping(value="calc")
public class CalculateController {
	
	@GetMapping("/")
	public String index() {
		return "welcome. This is Calculate server!";
	}
	
	@GetMapping("/add")
	public String add(@RequestParam Integer a, @RequestParam Integer b){
		Integer result = a + b;
		log.info(a + " + " + b + " = " + result);
		return a + " + " + b + " = " + result;
	}
	
	@GetMapping("/sub")
	public String sub(@RequestParam Integer a, @RequestParam Integer b){
		Integer result = a - b;
		log.info(a + " - " + b + " = " + result);
		return a + " - " + b + " = " + result;
	}
	
/*	private void readData(String name) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("没有找到类！");
			//hehe上面那个类名有个D是大写。。
			return;
		}
		String url = "jdbc:mysql://localhost:3306/contact?serverTimezone=UTC&useSSL=false";
		//添加一个useSSL=false参数关闭验证
		String username = "root";
		String password = "123456";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM student WHERE name='" + name + "'";
		try {
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				System.out.println("name: " + rs.getObject("name"));
				System.out.println("score:" + rs.getObject("score"));
			}

		} catch (SQLException e) {
			System.out.println("读取数据库失败");
			e.printStackTrace();
			return;
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (st != null) {
				try {
					st.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return;
	}*/

}
