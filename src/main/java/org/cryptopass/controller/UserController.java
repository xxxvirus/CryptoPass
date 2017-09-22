package org.cryptopass.controller;

import org.cryptopass.crypto.AES;
import org.cryptopass.crypto.RSA;
import org.cryptopass.entity.SIte;
import org.cryptopass.entity.User;
import org.cryptopass.service.KeyAESService;
import org.cryptopass.service.SiteService;
import org.cryptopass.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/{id}")
public class UserController {

	@Autowired
	private UserService userService;
	@Autowired
	private SiteService siteService;
	@Autowired
	private KeyAESService keyAESService;
	private AES aes = new AES();
	
	@ModelAttribute("site")
	public SIte getSIte(){
		return new SIte();
	}
	
	@GetMapping
	public String user(Model model, @PathVariable int id, String decText, @PageableDefault Pageable pageable) {
		model.addAttribute("users", userService.findOne(id));
		model.addAttribute("page", siteService.findByUserId(id, pageable));
		model.addAttribute("decText", decText);
		return "admin-user";
	}
	
	@RequestMapping("/createSite")
	public String creteTask(Model model, @PathVariable int id){
		model.addAttribute("site", new SIte());
		model.addAttribute("user", userService.findOne(id));
		return "admin-createSite";
	}
	
	@PostMapping("/createSite")
	public String saveSite(@ModelAttribute("site") SIte site, @PathVariable int id){
	    siteService.createSite(site);
		return "redirect:/user/{id}";
	}
	
	@GetMapping("/deleteSite/{idd}")
	public String deleteSite(Model model, @PathVariable int idd) {
		int aesId = siteService.findOne(idd).getKeyAES().getId();
		siteService.delete(idd);
		keyAESService.delete(aesId);
		return "redirect:/user/{id}";
	}
	
	@GetMapping("/editSite/{idd}")
	public String editSite(Model model, @PathVariable int id, @PathVariable int idd) {
		model.addAttribute("user", userService.findOne(id));
		model.addAttribute("site", siteService.findOne(idd));
		return "admin-editSite";
	}

	@PostMapping("/editSite/{idd}")
	public String saveTaskEdit(SIte site, @PathVariable int idd) {
		siteService.editSite(site, idd);
		return "redirect:/user/{id}";
	}
	
	@GetMapping("/dec/{idd}")
	public String decrypt(Model model, @PathVariable int id,
			@PathVariable int idd, Pageable pageable) {
		User user = userService.findOne(id);
		SIte site = siteService.findOne(idd);
		String keyEnc = site.getKeyAES().getGenKey();
		String keyAES = RSA.decrypt(keyEnc, user.getKeys().getPrivateKey());
		String decText = aes.decrypt(keyAES, site.getPass());
		return user(model, id, decText, pageable);
	}
}
