package repository;

import entity.MenuItems;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface MenuItemsRepository extends CrudRepository<MenuItems, Integer> {

}
