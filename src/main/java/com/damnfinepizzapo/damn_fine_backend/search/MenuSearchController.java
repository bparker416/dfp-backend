package com.damnfinepizzapo.damn_fine_backend.search;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public/menu-search")
@CrossOrigin(origins = "http://localhost:4200")
public class MenuSearchController {
    private final MenuSearchService menuSearchService;

    public MenuSearchController(MenuSearchService menuSearchService) {
        this.menuSearchService = menuSearchService;
    }


}
