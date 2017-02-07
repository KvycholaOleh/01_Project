package ua.controller.admin;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import ua.entity.TypeDisplay;
import ua.service.TypeDisplayService;
import ua.validator.TypeDisplayValidator;

@Controller
@RequestMapping("/admin/typedisplay")
@SessionAttributes(names="typeDisplay")
public class TypeDisplayController {
	
	@Autowired
	private TypeDisplayService typeDisplayService;
	
	@ModelAttribute("typeDisplay")
	public TypeDisplay getForm(){
		return new TypeDisplay();
	}
	
	@InitBinder("typeDisplay")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new TypeDisplayValidator(typeDisplayService));
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("typedisplays", typeDisplayService.findAll());
		return "admin-typedisplay";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		typeDisplayService.delete(id);
		return "redirect:/admin/typedisplay";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("typeDisplay", typeDisplayService.findOne(id));
		model.addAttribute("typedisplays", typeDisplayService.findAll());
		return "admin-typedisplay";
	}
	
	@PostMapping
	public String save(@ModelAttribute("typeDisplay") @Valid TypeDisplay typeDisplay,
			BindingResult br, SessionStatus status, Model model) {
		if (br.hasErrors()) {
			show(model);
			return "admin-typedisplay";
		}
		typeDisplayService.save(typeDisplay);
		status.setComplete();
		return "redirect:/admin/typedisplay";
	}
	
	
	
//	@PostMapping
//	public String save(@ModelAttribute("typeDisplay") TypeDisplay typeDisplay, SessionStatus status){
//		typeDisplayService.save(typeDisplay);
//		status.setComplete();
//		return "redirect:/admin/typedisplay";
//	}
	
//	@PostMapping
//	public String save(@RequestParam String name){
//		TypeDisplay typeDisplay = new TypeDisplay();
//		typeDisplay.setName(name);
//		typeDisplayService.save(typeDisplay);
//		return "redirect:/admin/typedisplay";
//	}

}
