package com.lms.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lms.entity.Inventory;
import com.lms.entity.Issue;
import com.lms.enums.InventoryTypeEnum;
import com.lms.enums.LoginTypeEnum;
import com.lms.repository.InventoryRepository;

@Service
public class InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;

	public Inventory addBookInventory(Inventory inv, String addedBy) {

		Inventory inventory = null;
		if (!StringUtils.isEmpty(inv) && !StringUtils.isEmpty(addedBy)) {
			if (addedBy.equals(LoginTypeEnum.ADMIN) || addedBy.equals(LoginTypeEnum.LIBRARIAN)) {
				Inventory inventorys = inventoryRepository.findByBkId(inv.getBkId());
				if (!StringUtils.isEmpty(inventorys)) {
					inventory = new Inventory(inventorys.getInventoryId(), inventorys.getBkId(),
							inventorys.getBookCount(), addedBy, new Date(), InventoryTypeEnum.AVAILABLE.name());
					return inventoryRepository.save(inventory);
				} else {
					return inventoryRepository.save(inv);
				}
			}
		}
		return inventory;
	}

	public Inventory bookCountOperation(Issue issue, boolean issued) {

		Inventory tempInventory = null, inv = null;
		if (!StringUtils.isEmpty(issue) && !StringUtils.isEmpty(issue.getBookId())) {
			Inventory inventory = inventoryRepository.findByBkId(issue.getBookId());
			tempInventory = new Inventory();
			// If book got issued...
			if (issued) {
				if (inventory.getBookCount() == 1) {
					tempInventory.setBookCount(0);
				} else {
					tempInventory.setBookCount(inventory.getBookCount() - 1);
				}
				// if book got returned...
			} else {
				if (inventory.getBookCount() == 0) {
					tempInventory.setBookCount(1);
				} else {
					tempInventory.setBookCount(inventory.getBookCount() + 1);
				}
			}
			try {
				inv = inventoryRepository.save(tempInventory);
			} catch (Exception e) {
				inv = new Inventory();
			}
		} else {
			inv = new Inventory();
		}
		return inv;
	}

	public boolean isBookAvalableInInventory(Issue issue) {

		boolean isExist = false;
		if (!StringUtils.isEmpty(issue) && !StringUtils.isEmpty(issue.getBookId())) {
			Inventory inventory = inventoryRepository.findByBkId(issue.getBookId());
			if (!StringUtils.isEmpty(inventory) && inventory.getBookCount() > 0) {
				isExist = true;
			}
		}
		return isExist;
	}
}
