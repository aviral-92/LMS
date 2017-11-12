package com.lms.repository;

import org.springframework.data.repository.CrudRepository;

import com.lms.entity.Inventory;

public interface InventoryRepository extends CrudRepository<Inventory, Integer> {

	public Inventory findByInventoryId(Integer inventoryId);

	public Inventory findByBk_Id(Integer bookId);

	public java.util.List<Inventory> findByBookName(String bookName);
}
