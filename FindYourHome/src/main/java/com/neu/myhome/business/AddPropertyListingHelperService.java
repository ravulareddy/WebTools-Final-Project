package com.neu.myhome.business;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

import com.neu.myhome.dao.ProperListingDAO;
import com.neu.myhome.pojo.Agent;
import com.neu.myhome.pojo.HomeAddress;
import com.neu.myhome.pojo.Listing;
import com.neu.myhome.pojo.Person;
import com.neu.myhome.pojo.Property;
import com.neu.myhome.pojo.PropertyFeatures;

public class AddPropertyListingHelperService {

	public static Listing addPropList(HttpServletRequest request, Person person, ProperListingDAO properListingDAO) {
		try {

			Listing listing = new Listing();
			String homeType = request.getParameter("homeType");
			System.out.println("request parameter ?>>>>." + homeType);
			int noOfBaths = Integer.parseInt(request.getParameter("noOfBaths"));
			int noOfBedrooms = Integer.parseInt(request.getParameter("noOfBedrooms"));
			int yearBuilt = Integer.parseInt(request.getParameter("yearBuilt"));
			float price = Float.parseFloat(request.getParameter("price"));
			String imagePath = (String) request.getAttribute("imagePath");

			String addressLine1 = request.getParameter("addressLine1");
			String addressLine2 = request.getParameter("addressLine2");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			int zipcode = Integer.parseInt(request.getParameter("zipcode"));
			String title = request.getParameter("title");
			String category = request.getParameter("category");

			String features[] = request.getParameterValues("features");

			HomeAddress homeAddress = new HomeAddress();
			homeAddress.setAddressLine1(addressLine1);
			homeAddress.setAddressLine2(addressLine2);
			homeAddress.setCity(city);
			homeAddress.setState(state);
			homeAddress.setZipcode(zipcode);

			Property property = new Property();

			property.setHomeAddress(homeAddress);
			// property.setHomeType(homeType);
			property.setListedBy(person.getName());
			property.setNoOfBaths(noOfBaths);
			property.setNoOfBedrooms(noOfBedrooms);
			property.setPrice(price);
			property.setImagePath(imagePath);

			homeAddress.setHome(property);

			/*
			 * List<PropertyFeatures> featureList = new
			 * ArrayList<PropertyFeatures>(); PropertyFeatures propertyFeatures
			 * = new PropertyFeatures();
			 * 
			 * propertyFeatures.setFeature("test");
			 * propertyFeatures.setDescription("test");
			 * featureList.add(propertyFeatures);
			 */

			/*
			 * for(PropertyFeatures propertyFeatures: featureList) {
			 * if(propertyFeatures.getFeature().equals(propertyFeatures)) {
			 * featureList.add(propertyFeatures); } }
			 */

			long homeTypeId = properListingDAO.getPropertyId(homeType);

			System.out.println("homeTypeId in AddPropertyListingHelperService @@@@@@" + homeTypeId);
			property.setPropType(homeTypeId);

			Date listDate = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("MMDDYYYY");

			long categoryId = properListingDAO.getCategoryId(category);

			listing.setCategory(categoryId);
			listing.setCategory_name(category);

			listing.setStartDate(sdf.format(listDate));
			listing.setTitle(title);
			listing.setPostedBy(person.getFirstName() + " " + person.getLastName());
			listing.setMessage("First");
			listing.setProperty(property);
			Date endDate = addDaysToStartDate(new Date(), 30);
			listing.setEndDate(sdf.format(endDate));
			if (person instanceof Agent) {
				listing.setAgent((Agent) person);
			}

			property.setListing(listing);
			List<Property> properties = new ArrayList<Property>();
			properties.add(property);

			// propertyFeatures.setProperty(properties);

			List<PropertyFeatures> featureList = new ArrayList<PropertyFeatures>();
			for (int i = 0; i < features.length; i++) {
				System.out.println("features[]>>>>>>>>>" + features[i]);
				PropertyFeatures pf = (PropertyFeatures) properListingDAO.getPropertyFeatures(features[i]);
				featureList.add(pf);
				pf.setProperty(properties);
			}
			property.setPropertyFeatures(featureList);

			Listing proplisting = properListingDAO.savePropListing(listing);
			return proplisting;
		} catch (NullPointerException npe) {
	//		System.out.println("NullPointerException>>>>>>>>>" + npe.getMessage());
		} catch (Exception exception) {
	//		exception.printStackTrace();
	//		System.out.println(
	//				"Exception in PropertyListingHelperService >>>>>addPropList method >>>>>" + exception.getMessage());
		}
		return null;

	}

	public static String uploadImageAndGetFilePath(MultipartFile imagefile, String saveDirectory) throws IOException {

		Date todaysdate = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("HHmmss");
		String folderAppnd = sdf.format(todaysdate);
		String fileName = folderAppnd.concat(imagefile.getOriginalFilename());
		// String fileName = imagefile.getOriginalFilename();
		System.out.println("directory with file name: saveDirectory:::::: " + saveDirectory);
		File file = new File(saveDirectory + fileName);
		if (!file.exists()) {
			file.mkdirs();
		}
		imagefile.transferTo(file);
		String imagePath = fileName;

		System.out.println("imagePath&&&&&&&&&&&&&" + imagePath);

		return imagePath;
	}

	public static Date addDaysToStartDate(Date startdate, int days) {
		startdate.setTime(startdate.getTime() + days * 1000 * 60 * 60 * 24);
		return startdate;
	}

}
