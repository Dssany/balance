package com.care.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.care.dto.MoneyDTO;

public class MoneyDAO {
	private JdbcTemplate template;
	private TransactionTemplate transactionTemplate;
	
	
	public void setTransactionTemplate(TransactionTemplate t) {
		this.transactionTemplate = t;
	}
	
	
	public MoneyDAO(JdbcTemplate template) {
		this.template = template;
	}
	
	public int[] sendMoney(int money) {
		String sql_my = "update myaccount set money=? where num='" +1+"'" ;
	     String sql_sys = "update sysaccount set money=? where num='"+1+"'";
	     String sql_bal = "update balance set totmoney=? where num='"+1+"'";
	     String sql = "select * from sysaccount where num=" + 1;
	     MoneyDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<MoneyDTO>(MoneyDTO.class));
	     
		int arr[] = new int[3];
		try {
				transactionTemplate.execute(new TransactionCallbackWithoutResult() {
					@Override
					protected void doInTransactionWithoutResult(TransactionStatus status) {
			arr[0] = template.update(sql_my,ps->{
				ps.setInt(1, dto.getMoney()-money);
			});
			arr[1] = template.update(sql_sys,ps->{
				ps.setInt(1, dto.getMoney()-money);
			});
			arr[2] = template.update(sql_bal,ps->{
				ps.setInt(1, dto.getMoney()-money);
			});
	}
});
		}catch(Exception e) { e.printStackTrace();}
		return arr;
	}
	
	public int resultTicket(int money){
		
		String sql = "select * from sysaccount where num=" + 1;
		MoneyDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<MoneyDTO>(MoneyDTO.class));
		
		
	     String sql_my = "update myaccount set money=? where num='" +1+"'" ;
	     String sql_sys = "update sysaccount set money=? where num='"+1+"'";
	     String sql_bal = "update balance set totmoney=? where num='"+1+"'";
		
	     
		template.update(sql_my,ps-> {
				ps.setInt(1, dto.getMoney()+money);
			});
		template.update(sql_sys,ps-> {
				ps.setInt(1, dto.getMoney()+money);
			});
		template.update(sql_bal,ps-> {
				ps.setInt(1, dto.getMoney()+money);
			});
		
		
		return dto.getMoney()+money;
	   }
	
		public MoneyDTO balence() {
			String sql = "select * from sysaccount where num=" + 1;
			MoneyDTO dto = template.queryForObject(sql, new BeanPropertyRowMapper<MoneyDTO>(MoneyDTO.class));
		
		
			 return dto;
		}
	
	
	
	
}
