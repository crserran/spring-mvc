package sogeti.spring.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionTwo")
	public String toUpperCase(HttpServletRequest request, Model model) {
		
		// read the request parameter from HTML form
		String theName = request.getParameter("studentName");
		
		// convert the data to all caps
		String result = theName.toUpperCase();
		
		// add message to the model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName, 
			Model model) {
		
		// convert the data to all caps
		String result = "Version 3: " + theName.toUpperCase();
		
		// add message to the model
		model.addAttribute("message", result);
		
		
		return "helloworld";
	}
	
}
