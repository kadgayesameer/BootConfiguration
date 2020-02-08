/**
 * 
 */
package com.iceico.BootConfiguration.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.util.Locale;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.iceico.BootConfiguration.exceptions.ResourceNotFoundException;

/**
 * @author Rajat
 *
 */

@Controller
public class CompilerController {
	/**
	 * 
	 */
	public CompilerController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("/admin/compiler")
	public String compilerDashboard(ModelMap modelMap, Locale locale) throws ResourceNotFoundException, ParseException {

		modelMap.addAttribute("user", this.getPrincipal());
		return "editor";
	}

	@PostMapping("/admin/compiler/run")
	public String runCode(ModelMap modelMap, Locale locale, 
			@RequestParam("code") String code, @RequestParam("language") String languageIn) throws ResourceNotFoundException, ParseException {		
		
		String clientId = "be9a209b50977cbd22c436977ab648d0"; //Replace with your client ID
        String clientSecret = "55794f230a6a52e27542d1f034747eb869b7ceef03b5c8f9cb0ae726c4ee14cc"; //Replace with your client Secret
        String script = code;
        String language = languageIn;
        String versionIndex = "2";
        
        try {
            URL url = new URL("https://api.jdoodle.com/execute");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + script +
            "\",\"language\":\"" + language + "\",\"versionIndex\":\"" + versionIndex + "\"} ";

            System.out.println("input ===> "+input);
            
            OutputStream outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

//            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
//                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
//            }

            BufferedReader bufferedReader;
            bufferedReader = new BufferedReader(new InputStreamReader((connection.getInputStream())));

            String output;
            System.out.println("Output from JDoodle .... \n");
            while ((output = bufferedReader.readLine()) != null) {
                System.out.println("Output ====> "+output);
            }

            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
		

		modelMap.addAttribute("user", this.getPrincipal());
		return "editor";
	}
	
	private String getPrincipal() {
		String userName = null;
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			userName = ((UserDetails) principal).getUsername();
		} else {
			userName = principal.toString();
		}
		return userName;
	}
}
