package ua.service.implementation;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.entity.Item;
import ua.repository.ItemRepository;
import ua.service.ItemService;
import dto.form.ItemForm;

@Service
public class ItemServiceImpl implements ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	@Override
	@Transactional(readOnly = true)
	public Item findOne(int id) {
		return itemRepository.findOne(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Item> findAll() {
		return itemRepository.findAll();
	}

	@Override
	@Transactional
	public void save(ItemForm itemForm) {
		Item item = new Item();
		item.setId(itemForm.getId());
		item.setProducer(itemForm.getProducer());
		item.setModel(itemForm.getModel());
		item.setOs(itemForm.getOs());
		item.setColor(itemForm.getColor());
		item.setTypeDisplay(itemForm.getTypeDisplay());
		item.setDisplaySize(new BigDecimal(itemForm.getDisplaySize().replace(',', '.')));
		item.setCamera(new BigDecimal(itemForm.getCamera().replace(',', '.')));
		item.setBatteryCapacity(Integer.valueOf(itemForm.getBatteryCapacity()));
		item.setPrice(new BigDecimal(itemForm.getPrice().replace(',', '.')));
		itemRepository.save(item);
	}

	@Override
	public void delete(int id) {
		itemRepository.delete(id);
	}

	@Override
	public ItemForm findForm(int id) {
		Item item = itemRepository.findOne(id);
		ItemForm itemForm = new ItemForm();
		itemForm.setBatteryCapacity(String.valueOf(item.getBatteryCapacity()));
		itemForm.setCamera(String.valueOf(item.getCamera()));
		itemForm.setColor(item.getColor());
		itemForm.setDisplaySize(String.valueOf(item.getDisplaySize()));
		itemForm.setId(item.getId());
		itemForm.setModel(item.getModel());
		itemForm.setOs(item.getOs());
		itemForm.setPrice(String.valueOf(item.getPrice()));
		itemForm.setProducer(item.getProducer());
		itemForm.setTypeDisplay(item.getTypeDisplay());
		return itemForm;
	}

	

}
