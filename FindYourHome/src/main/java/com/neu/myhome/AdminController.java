package com.neu.myhome;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neu.myhome.pojo.UserTypes;

@Controller
@RequestMapping(name = "adduserType.htm")
public class AdminController {

	public AdminController() {

	}

	public String addUserTypes(@ModelAttribute("userTypes") UserTypes userTypes) {
		return "addUserType";

	}

}
