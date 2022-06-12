package com.example.ninjagoldgame.Controller;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.time.*;
import java.time.format.DateTimeFormatter;

@Controller
public class GameController {
	@RequestMapping("")
	public String main() {
		return "redirect:/Gold";
	}
	
	@RequestMapping("/submitGold")
	public String submit(HttpSession session, Model model, @RequestParam("place") String place) {
		Random rand = new Random();
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dateFormate = DateTimeFormatter.ofPattern("MMMM dd yyyy h:mm a");
	
		int golds = (int) session.getAttribute("golds");
		int addedGold = 0;
		String output = (String) session.getAttribute("output");
		if(place.equals("farm") || place.equals("cave") || place.equals("house")) {
			addedGold = rand.nextInt(11) + 10;
			golds += addedGold;
			output += "<p class=\"green\">You entered a "+place+" and earned "+addedGold+" gold. ("+date.format(dateFormate)+")</p>";
		} else {
			addedGold = rand.nextInt(51);
			if(rand.nextBoolean()) {
				golds += addedGold;
				output += "<p class=\"green\">You completed a "+place+" and earned "+addedGold+" gold. ("+date.format(dateFormate)+")</p>";
			} else {
				golds -= addedGold;
				output += "<p class=\"red\">You failed a "+place+" and lost "+addedGold+" gold. Ouch. ("+date.format(dateFormate)+")</p>";
			}
		}
		session.setAttribute("output", output);
		session.setAttribute("addedGold", golds);
		return "redirect:/Gold";
	}
	
	@RequestMapping("/Gold")
	public String index(HttpSession session, Model model) {
		if(session.getAttribute("golds") == null) {
			session.setAttribute("golds", 0);
			session.setAttribute("output", "");
		} else {
			int addedGold = 0;
			if(session.getAttribute("addedGold") != null) {
				addedGold =  (int) session.getAttribute("addedGold");
			}
			session.setAttribute("golds", addedGold);
			session.setAttribute("addedGold", 0);
		}
		int golds = (int) session.getAttribute("golds");
		model.addAttribute("golds", golds);
		
		return "index.jsp";
	}
}
