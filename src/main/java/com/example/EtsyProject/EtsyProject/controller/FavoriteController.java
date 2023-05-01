package com.example.EtsyProject.EtsyProject.controller;

import com.example.EtsyProject.EtsyProject.entity.Favorite;
import com.example.EtsyProject.EtsyProject.entity.FavoriteId;
import com.example.EtsyProject.EtsyProject.entity.Products;
import com.example.EtsyProject.EtsyProject.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class FavoriteController {

    private FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService){
        this.favoriteService = favoriteService;
    }
    @PostMapping("/favorite")
    public Favorite addFavorite(@RequestBody Favorite favorite){
        return favoriteService.addFavorite(favorite);
    }

    @PostMapping("/deletefavorite")
    public String deleteFavorite(@RequestBody FavoriteId favorite){
        return favoriteService.deleteFavorite(favorite);
    }

    @GetMapping("/getfavorite")
    public List<Products> getFavorite(@RequestParam Map<String ,String > favData) throws Exception{
        return favoriteService.getFavoriteProducts(favData);
    }
}
