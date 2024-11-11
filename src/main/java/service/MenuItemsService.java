package service;

import entity.MenuItems;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.MenuItemsRepository;

import java.util.List;
import java.util.Map;

@Service
public class MenuItemsService {

    @Autowired
    private MenuItemsRepository MenuItemsRepository;

    public Map<String, List<MenuItems>> getMenuItemsByCategory() {
        List<MenuItems> allItems = menuItemsRepo
    }
}
