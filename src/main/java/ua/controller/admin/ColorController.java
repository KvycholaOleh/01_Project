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

import ua.entity.Color;
import ua.service.ColorService;
import ua.validator.ColorValidator;

@Controller
@RequestMapping("/admin/color")
@SessionAttributes(names="color")
public class ColorController {
	
	@Autowired
	private ColorService colorService;
	
	@ModelAttribute("color")
	public Color getForm(){
		return new Color();
	}
	
	@InitBinder("color")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ColorValidator(colorService));
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("colors", colorService.findAll());
		return "admin-color";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		colorService.delete(id);
		return "redirect:/admin/color";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("color", colorService.findOne(id));
		model.addAttribute("colors", colorService.findAll());
		return "admin-color";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("color") @Valid Color color,
			BindingResult br, SessionStatus status, Model model) {
		if (br.hasErrors()) {
			show(model);
			return "admin-color";
		}
		colorService.save(color);
		status.setComplete();
		return "redirect:/admin/color";
	}
	
	
//	@PostMapping
//	public String save(@ModelAttribute("color") Color color, SessionStatus status){
//		colorService.save(color);
//		status.setComplete();
//		return "redirect:/admin/color";
//	}
	
//	@PostMapping
//	public String save(@RequestParam String name){
//		Color color = new Color();
//		color.setName(name);
//		colorService.save(color);
//		return "redirect:/admin/color";
//	}

}
