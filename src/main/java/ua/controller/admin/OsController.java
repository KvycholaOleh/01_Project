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

import ua.entity.Os;
import ua.service.OsService;
import ua.validator.OsValidator;

@Controller
@RequestMapping("/admin/os")
@SessionAttributes(names="os")
public class OsController {
	
	@Autowired
	private OsService osService;
	
	@ModelAttribute("os")
	public Os getForm(){
		return new Os();
	}
	
	@InitBinder("os")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new OsValidator(osService));
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("oss", osService.findAll());
		return "admin-os";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		osService.delete(id);
		return "redirect:/admin/os";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("os", osService.findOne(id));
		model.addAttribute("oss", osService.findAll());
		return "admin-os";
	}
	
	@PostMapping
	public String save(@ModelAttribute("os") @Valid Os os,
			BindingResult br, SessionStatus status, Model model) {
		if (br.hasErrors()) {
			show(model);
			return "admin-os";
		}
		osService.save(os);
		status.setComplete();
		return "redirect:/admin/os";
	}
	
	
	
//	@PostMapping
//	public String save(@ModelAttribute("os") Os os, SessionStatus status){
//		osService.save(os);
//		status.setComplete();
//		return "redirect:/admin/os";
//	}
	
//	@PostMapping
//	public String save(@RequestParam String name){
//		Os os = new Os();
//		os.setName(name);
//		osService.save(os);
//		return "redirect:/admin/os";
//	}

}
