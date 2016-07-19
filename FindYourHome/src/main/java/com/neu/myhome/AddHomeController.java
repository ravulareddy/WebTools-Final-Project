package com.neu.myhome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.myhome.pojo.Property;

@Controller
@RequestMapping("/addHome.htm")
public class AddHomeController {

	public String addHomeListing(@ModelAttribute("home") Property home) {

		return "addHomeResult";
	}
}
