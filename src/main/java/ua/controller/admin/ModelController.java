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

import ua.service.ModelService;
import ua.validator.ModelValidator;

@Controller
@RequestMapping("/admin/model")
@SessionAttributes(names="model")
public class ModelController {
	
	@Autowired
	private ModelService modelService;
	
	@ModelAttribute("model")
	public ua.entity.Model getForm(){
		return new ua.entity.Model();
	}
	
	@InitBinder("model")
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(new ModelValidator(modelService));
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("models", modelService.findAll());
		return "admin-model";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		modelService.delete(id);
		return "redirect:/admin/model";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("model", modelService.findOne(id));
		model.addAttribute("models", modelService.findAll());
		return "admin-model";
	}
	
	
	@PostMapping
	public String save(@ModelAttribute("model") @Valid ua.entity.Model myModel,
			BindingResult br, SessionStatus status, Model model) {
		if (br.hasErrors()) {
			show(model);
			return "admin-model";
		}
		modelService.save(myModel);
		status.setComplete();
		return "redirect:/admin/model";
	}
	
	
//	@PostMapping
//	public String save(@ModelAttribute("model") ua.entity.Model model, SessionStatus status){
//		modelService.save(model);
//		status.setComplete();
//		return "redirect:/admin/model";
//	}
	
//	@PostMapping
//	public String save(@RequestParam String name){
//		ua.entity.Model model = new ua.entity.Model();
//		model.setName(name);
//		modelService.save(model);
//		return "redirect:/admin/model";
//	}

}
