package com.damnfinepizzapo.damn_fine_backend.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/search")
@CrossOrigin(origins = "https://vercel.com/brandons-projects-bc9e4d60/dfp-website/GHHE4jeXhzmJkBkGmcd6kx7AzvMz")
public class MenuSearchController {
    private final MenuSearchService menuSearchService;

    @Autowired
    public MenuSearchController(MenuSearchService menuSearchService) {
        this.menuSearchService = menuSearchService;
    }

    @GetMapping("/search")
    public List<String> searchMenu(@RequestParam String name) {
        return menuSearchService.searchMenu(name);
    }

}
