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

import ua.editor.CountryEditor;
import ua.entity.Country;
import ua.entity.Producer;
import ua.service.CountryService;
import ua.service.ProducerService;
import ua.validator.ProducerValidator;

@Controller
@RequestMapping("/admin/producer")
@SessionAttributes(names="producer")
public class ProducerController {
	
	@Autowired
	private ProducerService producerService;
	
	@Autowired
	private CountryService countryService;
	

	@InitBinder("producer")
	protected void initBinder(WebDataBinder binder){
	   binder.registerCustomEditor(Country.class, new CountryEditor(countryService));
	   binder.setValidator(new ProducerValidator(producerService));
	}
	
	@ModelAttribute("producer")
	public Producer getForm(){
		return new Producer();
	}
	
	@RequestMapping
	public String show(Model model){
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id){
		producerService.delete(id);
		return "redirect:/admin/producer";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("producer", producerService.findOne(id));
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("countries", countryService.findAll());
		return "admin-producer";
	}
	
	@PostMapping
	public String save(@ModelAttribute("producer") @Valid Producer producer,
			BindingResult br, SessionStatus status, Model model) {
		if (br.hasErrors()) {
			show(model);
			return "admin-producer";
		}
		producerService.save(producer);
		status.setComplete();
		return "redirect:/admin/producer";
	}
	
	
//	@PostMapping
//	public String save(@ModelAttribute("producer") Producer producer, SessionStatus status){
//		producerService.save(producer);
//		status.setComplete();
//		return "redirect:/admin/producer";
//	}
	
//	@PostMapping
//	public String save(@RequestParam String name, @RequestParam int producerId){
//		Producer producer = new Producer();
//		producer.setName(name);
//		producer.setCountry(countryService.findOne(producerId));
//		producerService.save(producer);
//		return "redirect:/admin/producer";
//	}

}
