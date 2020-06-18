package com.care.service;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.ui.Model;

import com.care.dao.MoneyDAO;

public class MoneyServiceImpl implements MoneyService{
	private MoneyDAO dao;
	
	public MoneyServiceImpl() {
		String config = "classpath:applicationJDBC.xml";
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext(config);
		dao = ctx.getBean("dao",MoneyDAO.class);
	}
	
	
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest re = (HttpServletRequest)map.get("request");
		int money = Integer.parseInt(re.getParameter("money"));
		model.addAttribute("money",dao.resultTicket(money));
		
		
		
		
	}
	

}
