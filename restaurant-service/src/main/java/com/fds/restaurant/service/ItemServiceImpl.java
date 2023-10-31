package com.fds.restaurant.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fds.restaurant.exception.ItemException;
import com.fds.restaurant.exception.RestaurantNotFoundException;
import com.fds.restaurant.model.Item;
import com.fds.restaurant.model.Restaurant;
import com.fds.restaurant.repository.ItemRepository;
import com.fds.restaurant.repository.RestaurantRepo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;
	
	@Autowired
	RestaurantRepo restaurantRepo;

	@Override
	public Item addItem(Item item) {
		log.info("addItem method in item service");
		// TODO Auto-generated method stub
		boolean b=false;
		List<Restaurant> restList=restaurantRepo.findAll();
		for(Restaurant r:restList) {
			if(r.getRestaurantId().equals(item.getRestaurantId())) {
				b=true;
				break;
			}else {
				b=false;
			}
		}
		if(b) {
			Item i1= item;
			i1.setItemId(item.getRestaurantId()+item.getItemId());
			return itemRepository.save(item);
		}else {
			throw new ItemException("The restaurant with "+item.getRestaurantId()+" id is not there");
		}
	}

	@Override
	public List<Item> viewAllItems() {
		// TODO Auto-generated method stub
		log.info("viewAllItems method in item service");
		List<Item> findAll=itemRepository.findAll();
		if(!findAll.isEmpty()) {
			return findAll;
		}else {
			throw new ItemException("No Items found");
		}
	}

	@Override
	public List<Item> viewItemByName(String itemName) {
		// TODO Auto-generated method stub
		log.info("viewItemByName method in item service");
		List<Item> items=itemRepository.findByItemName(itemName);
		if(items.isEmpty()) {
			throw new ItemException("There are no items with that name");
		}else {
			return items;
		}
	}

	@Override
	public String deleteItemById(String id) {
		// TODO Auto-generated method stub
		log.info("deleteItemById method in item service");
		Optional<Item> item = itemRepository.findById(id);

		if (item.isPresent()) {
			itemRepository.deleteById(id);
			return "item is deleted Successfully";
		} else {
			throw new ItemException("The item with " + id + " is not exists");
		}
	}

	@Override
	public Item updateItem(String itemId, Item item) {
		// TODO Auto-generated method stub
		log.info("Updating the item");
		Optional<Item> i = itemRepository.findById(itemId);
		if(i.isPresent()) {
			Item i2=i.get();
			i2.setItemName(item.getItemName());
			i2.setCategory( item.getCategory());
			i2.setDescription(item.getDescription());
			i2.setPrice(item.getPrice());
			i2.setImage(item.getImage());
			
			Item updatedItem=itemRepository.save(i2);
			return updatedItem;
		}else {
			throw new ItemException("The item is not found");
		}
	}

	@Override
	public Item viewItemById(String itemId) {
		// TODO Auto-generated method stub
		log.info("Get item by id ");
		Optional<Item> item= itemRepository.findById(itemId);
		if(item.isPresent()) {
			return item.get();
		}else {
			throw new RestaurantNotFoundException("Restaurant with id "+itemId+" is not found");
		}
	}

	@Override
	public List<Item> viewByRestaurantName(String name) {
		// TODO Auto-generated method stub
		List<Restaurant> rest= restaurantRepo.findByRestaurantName(name);
		List<Item> itemList= new ArrayList<>();
		for(Restaurant r:rest) {
			itemList.addAll( itemRepository.findByRestaurantId(r.getRestaurantId()) );
		}
		
		
		return itemList;
	}

}
