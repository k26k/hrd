package net.cloud.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;
import net.cloud.domain.SampleVO;

@Log4j
@RequestMapping("/sample/*")
@Controller
public class SampleController {

	@RequestMapping(value = "/basic", method = RequestMethod.GET)	
	public void basic() {
		log.info("basic get...");
	}
	
	@GetMapping("/basicGet")
	public void basicGet() {
		log.info("basic get only get...");
	}
	
	@GetMapping("/ex01")
	public String ex01(@ModelAttribute("vo") SampleVO vo, Model model) {
		log.info(vo);
		model.addAttribute(vo);
		return "ex01";
	}
	
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam("ids") ArrayList<String> vo, Model model) {
		log.info(vo);
		model.addAttribute(vo);
		return "ex02";
	}

	@GetMapping("/ex03")
	public String ex03(SampleVO vo, int page, Model model) {
		log.info(vo);
		log.info(page);
		model.addAttribute("page",page);
		return "ex03";
	}
	
	
}
