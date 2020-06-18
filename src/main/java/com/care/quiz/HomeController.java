package com.care.quiz;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.care.service.MoneySendServiceImpl;
import com.care.service.MoneyService;
import com.care.service.MoneyServiceImpl;
import com.care.service.MoneybalenceImpl;



@Controller
public class HomeController {
	private MoneyService ms;
	
	
	@RequestMapping("main")
	public String main() {
		return "main";
	}
	
	
	
	@RequestMapping("deposit")
	public String deposit() {
		
		return "deposit";
	}
	
	@RequestMapping("depositchk")
	public String depositchk(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		ms = new MoneyServiceImpl();
		ms.execute(model);
		return "depositresult";
		
		
	}
	
	
	@RequestMapping("sendMoney")
	public String sendMoney(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		ms = new MoneySendServiceImpl();
		ms.execute(model);
		return "sendmoneyresult";
	}
	
	@RequestMapping("sendpage")
	public String sendpage() {
		return "sendMoney";
	}
	
	@RequestMapping("balance")
	public String balence(Model model) {
		ms = new MoneybalenceImpl();
		ms.execute(model);
		return "balence";
	}
	
}
