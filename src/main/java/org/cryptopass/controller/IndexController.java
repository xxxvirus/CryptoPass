package org.cryptopass.controller;

import java.security.KeyPair;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.validation.Valid;

import org.cryptopass.crypto.RSA;
import org.cryptopass.entity.RSAKeysUser;
import org.cryptopass.entity.User;
import org.cryptopass.service.RSAKeysUserService;
import org.cryptopass.service.UserService;
import org.cryptopass.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private UserService userService;
	@Autowired
	private RSAKeysUserService keyService;
	
	@GetMapping
	public String index(Principal principal, Model model) {
		if (principal != null) {
			System.out.println(principal.getName());
			SecurityContextHolder.getContext().getAuthentication()
					.getPrincipal();
		}
		return "user-index";
	}

	@InitBinder("user")
	protected void bind(WebDataBinder binder) {
		binder.setValidator(new UserValidator(userService));
	}

	@GetMapping("/registration")
	public String registration(Model model) {
		model.addAttribute("user", new User());
		return "user-registration";
	}

	@PostMapping("/registration")
	public String save(@ModelAttribute("user") @Valid User user,
			BindingResult br, Model model) {
		if (br.hasErrors())
			return "user-registration";
		userService.save(user);
		RSAKeysUser rsa = new RSAKeysUser();
		KeyPair pair = RSA.generateKeyPair();
	    PublicKey pubKey = pair.getPublic();
	    PrivateKey privKey = pair.getPrivate();
	    rsa.setPublickKey(pubKey);
	    rsa.setPrivateKey(privKey);
	    rsa.setUser(user);
	    keyService.save(rsa);
		return "redirect:/login";
	}
	
	@GetMapping("/login")
	public String login() {
		return "user-login";
	}
}
