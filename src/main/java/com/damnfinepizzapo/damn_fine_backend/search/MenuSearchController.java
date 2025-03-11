package com.damnfinepizzapo.damn_fine_backend.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/public/search")
@CrossOrigin(origins = "https://dfp-website-brandons-projects-bc9e4d60.vercel.app/")
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