package com.neu.myhome;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.dao.AgentDAO;
import com.neu.myhome.dao.homeDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Agent;

@Controller
public class FindAgentController {

	AgentDAO agentDAO;

	public FindAgentController() {

	}

	@RequestMapping(value = "/sell_FindAgent.htm", method = RequestMethod.GET)
	public String findAgent(@ModelAttribute(value = "agent") Agent agent) {

		return "findAgent";

	}

	@RequestMapping(value = "/sell_FindAgent.htm", method = RequestMethod.POST)
	public ModelAndView searchAgentByName(HttpServletResponse response, @RequestParam("agentName") String agentName)
			throws AdException {
		ModelAndView mav = new ModelAndView();
		try {

			System.out.println("Ajax Call made >>>>>>");

			// System.out.println("Ajax Call made >>agentName>>>>"+agentName);
			// agentDAO = new AgentDAO();
			homeDAO agentDAO = new homeDAO();
			Agent agent = agentDAO.findAgentByName(agentName);
			if (agent != null) {
				// System.out.println("person
				// &&&&&&&&&&&&"+agent.getFirstName());
				mav.addObject("agent", agent);
				mav.setViewName("displayAjaxAgent");
			} else {
				String errMsg = "Please enter valid agent name, Agent does not exist with name " + agentName;
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");
			}
			return mav;
		} catch (AdException e) {
			String errMsg = "Please enter valid agent name, Agent does not exist with name " + agentName;
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

	@RequestMapping(value = "/sell_FindAllAgents.htm", method = RequestMethod.GET)
	public ModelAndView findAllAgents(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		try {
			agentDAO = new AgentDAO();
			List<Agent> agentslist = agentDAO.findAllAgents();
			if (agentslist != null && agentslist.size() > 0) {
				mav.addObject("agentslist", agentslist);
				mav.addObject("listTitle", "Agents and Details");
				mav.setViewName("displayAllAgents");
			} else {
				String errMsg = "Agents Not Available as of now, Please visit later";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");

			}
			return mav;
		} catch (AdException e) {
			String errMsg = "Unable to fetch agents, Please visit later";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");
			return mav;
		}
	}

}
