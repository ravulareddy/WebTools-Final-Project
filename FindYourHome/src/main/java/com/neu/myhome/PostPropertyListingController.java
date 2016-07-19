package com.neu.myhome;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.neu.myhome.business.AddPropertyListingHelperService;
import com.neu.myhome.dao.ProperListingDAO;
import com.neu.myhome.exception.AdException;
import com.neu.myhome.pojo.Listing;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.pojo.PropertyFeatures;
import com.neu.myhome.pojo.PropertyListingCategory;
import com.neu.myhome.pojo.PropertyType;
import com.neu.myhome.validation.PropertyListingValidator;

@Controller
@RequestMapping(value = "/sell_postListing.htm")
public class PostPropertyListingController {

	@Autowired
	@Qualifier("propListingValidator")
	PropertyListingValidator propListingValidator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.setValidator(propListingValidator);
	}

	ProperListingDAO properListingDAO;
	HttpSession session;

	public PostPropertyListingController() {

	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView propertyListing(HttpServletRequest request) throws NumberFormatException, AdException {
		ModelAndView mav = new ModelAndView();

		session = request.getSession();
		if (session.getAttribute("user") != null) {
			Person agent = (Person) session.getAttribute("user");

			if (agent == null || agent.getName().isEmpty() || agent.getRole().equals("BUYER")) {
				String errMsg = "Please Login as an Agent to post a Listing";
				mav.addObject("errorMsg", errMsg);
				mav.setViewName("displayerror");
			}

			else {
				properListingDAO = new ProperListingDAO();
				// System.out.println("properListingDAO>>>>>>"+properListingDAO.toString());
				List<PropertyListingCategory> categories = properListingDAO.getListingCategories();
				List categoriesList = new ArrayList<String>();
				Iterator catIter = categories.iterator();
				while (catIter.hasNext()) {
					PropertyListingCategory propertyListingCategory = (PropertyListingCategory) catIter.next();
					categoriesList.add(propertyListingCategory.getTitle());
				}

				// System.out.println("properListingDAO>>>>>>"+properListingDAO.toString());
				List<PropertyFeatures> features = properListingDAO.getPropertyFeatures();
				List featuresList = new ArrayList<String>();
				Iterator featureIter = features.iterator();
				while (featureIter.hasNext()) {
					PropertyFeatures propertyFeatures = (PropertyFeatures) featureIter.next();
					featuresList.add(propertyFeatures.getFeature());
				}

				List<PropertyType> propertyTypes = properListingDAO.getPropertyTypeList();
				// System.out.println("propertyTypes$$$$$$$$$$"+propertyTypes);
				List propertyTypeList = new ArrayList<String>();
				Iterator propTypeIter = propertyTypes.iterator();
				while (propTypeIter.hasNext()) {
					PropertyType propertyType = (PropertyType) propTypeIter.next();
					propertyTypeList.add(propertyType.getHomeTypeName());
					// System.out.println("propertyTypeList>>>>>>>>"+propertyTypeList.size());
				}

				mav.addObject("featuresList", featuresList);
				mav.addObject("categoriesList", categoriesList);
				mav.addObject("propertyTypeList", propertyTypeList);
				// mav.addObject("userName", userName);
				mav.setViewName("property_List");
			}
		} else {
			String errMsg = "Please Login to post a Listing";
			mav.addObject("errorMsg", errMsg);
			mav.setViewName("displayerror");

		}
		return mav;

	}

	@RequestMapping(method = RequestMethod.POST)
	protected ModelAndView addPropertyListing(@RequestParam("action") String action,
			@RequestParam("imagefile") MultipartFile imagefile, HttpServletRequest request)
			throws NumberFormatException, AdException {
		ModelAndView mav = new ModelAndView();
		session = request.getSession();
		// System.out.println("Adding Property details
		// >>>>>>>>>"+session.getAttribute("user"));
		// Map reqMap = request.getParameterMap();
		Person person = (Person) session.getAttribute("user");

		// System.out.println("Adding Property details
		// >>>>>>>>>"+person.getName());
		Date todaysdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String folderAppnd = sdf.format(todaysdate);
		todaysdate.getTime();

		String folderName = "resources/images".concat(File.separator);
		// System.out.println("folderName>>>>>>>>>"+folderName);

		// String
		// saveDirectory=request.getSession().getServletContext().getRealPath("/")+folderName;
		String saveDirectory = "/Users/tejageetla/Documents/workspace-sts-3.7.3.RELEASE/FindYourHome/src/main/webapp/"
				.concat(folderName);
		// System.out.println("saveDirectory**********"+saveDirectory);
		String imagePath = null;
		if (imagefile != null && !imagefile.isEmpty() && !saveDirectory.isEmpty()) {
			try {
				// System.out.println("imagefile**********"+imagefile.getOriginalFilename());
				imagePath = AddPropertyListingHelperService.uploadImageAndGetFilePath(imagefile, saveDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		request.setAttribute("imagePath", imagePath);
		Listing propList = AddPropertyListingHelperService.addPropList(request, person, properListingDAO);

		mav.addObject("propList", propList);
		mav.setViewName("addPropertyList_success");
		return mav;
	}

}
