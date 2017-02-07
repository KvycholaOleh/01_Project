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

import dto.form.ItemForm;
import ua.editor.ColorEditor;
import ua.editor.ModelEditor;
import ua.editor.OsEditor;
import ua.editor.ProducerEditor;
import ua.editor.TypeDisplayEditor;
import ua.entity.Color;
import ua.entity.Os;
import ua.entity.Producer;
import ua.entity.TypeDisplay;
import ua.service.ColorService;
import ua.service.ItemService;
import ua.service.ModelService;
import ua.service.OsService;
import ua.service.ProducerService;
import ua.service.TypeDisplayService;
import ua.validator.ItemValidator;

@Controller
@RequestMapping("/admin/item")
@SessionAttributes(names="item")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private ProducerService producerService;

	@Autowired
	private ModelService modelService;

	@Autowired
	private OsService osService;

	@Autowired
	private TypeDisplayService typeDisplayService;

	@Autowired
	private ColorService colorService;
	
	@InitBinder("item")
	protected void initBinder(WebDataBinder binder){
		   binder.registerCustomEditor(Producer.class, new ProducerEditor(producerService));
		   binder.registerCustomEditor(ua.entity.Model.class, new ModelEditor(modelService));
		   binder.registerCustomEditor(Os.class, new OsEditor(osService));
		   binder.registerCustomEditor(TypeDisplay.class, new TypeDisplayEditor(typeDisplayService));
		   binder.registerCustomEditor(Color.class, new ColorEditor(colorService));
		   binder.setValidator(new ItemValidator());
		}
	
	@ModelAttribute("item")
	public ItemForm getForm(){
		return new ItemForm();
	}

	@RequestMapping
	public String show(Model model) {
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("producers", producerService.findAll());
		model.addAttribute("models", modelService.findAll());
		model.addAttribute("oss", osService.findAll());
		model.addAttribute("typeDisplays", typeDisplayService.findAll());
		model.addAttribute("colors", colorService.findAll());
		return "admin-item";
	}

	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		itemService.delete(id);
		return "redirect:/admin/item";
	}
	
	@RequestMapping("/update/{id}")
	public String update(@PathVariable int id, Model model){
		model.addAttribute("item", itemService.findForm(id));
		show(model);
		return "admin-item";
	}
	
	@PostMapping
	public String save(@ModelAttribute("item") @Valid ItemForm item, BindingResult br, Model model, SessionStatus sessionStatus){
		if(br.hasErrors()){
			model.addAttribute("items", itemService.findAll());
			model.addAttribute("producers", producerService.findAll());
			model.addAttribute("models", modelService.findAll());
			model.addAttribute("oss", osService.findAll());
			model.addAttribute("typeDisplays", typeDisplayService.findAll());
			model.addAttribute("colors", colorService.findAll());
			return "admin-item";
		}
		itemService.save(item);
		sessionStatus.setComplete();
		return "redirect:/admin/item";
	}
	
//	@PostMapping
//	public String save(@ModelAttribute("item") Item item, SessionStatus status){
//		itemService.save(item);
//		status.setComplete();
//		return "redirect:/admin/item";
//	}

//	@PostMapping
//	public String save(@RequestParam int producerId, @RequestParam int modelId, @RequestParam int osId, @RequestParam int typedisplayId, @RequestParam int colorId, @RequestParam int batteryCapacity, @RequestParam BigDecimal displaySize, @RequestParam BigDecimal camera, @RequestParam BigDecimal price){
//		Item item = new Item();
//		item.setProducer(producerService.findOne(producerId));
//		item.setModel(modelService.findOne(modelId));
//		item.setOs(osService.findOne(osId));
//		item.setTypeDisplay(typeDisplayService.findOne(typedisplayId));
//		item.setColor(colorService.findOne(colorId));
//		item.setBatteryCapacity(batteryCapacity);
//		item.setDisplaySize(displaySize);
//		item.setCamera(camera);
//		item.setPrice(price);
//		itemService.save(item);
//		return "redirect:/admin/item";
//	}
}
