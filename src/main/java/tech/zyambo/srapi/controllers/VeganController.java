package tech.zyambo.srapi.controllers;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.zyambo.srapi.Vegan;
// import tech.zyambo.srapi.Recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping(path="/srapi/v1", produces="application/json")
public class VeganController {

    @GetMapping("/vegan")
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("breakfast", "/srapi/v1/vegan/breakfast");
        resUrls.put("lunch", "/srapi/v1/vegan/lunch");
        resUrls.put("dinner", "/srapi/v1/vegan/dinner");
        
        HashMap<String, HashMap<String, String>> res = new HashMap<>();
        
        res.put("result:", resUrls);
    
        return res;
    }
    
    @PostMapping("/vegan")
    public HashMap<String, Vegan> vegan(@RequestParam(value = "name", defaultValue = "none") String name){
        Vegan myRecipe = new Vegan(name);
        myRecipe.addData("Dinner", "Zyambo", "Zambia");

        ArrayList<String> ingr = new ArrayList<>();
        ingr.add("Potato");
        ingr.add("Mayonnaise");
        ingr.add("Onions");
        myRecipe.addIngredients(ingr);

        HashMap<String, Integer> prep = new HashMap<>();

        prep.put("prep", 3);
        prep.put("cook", 4);
        myRecipe.addPrepTime(prep);

        ArrayList<String> steps = new ArrayList<>();
        steps.add("peel potatoes");
        steps.add("slice potatos");
        steps.add("add mayonaise in bow and mix");
        myRecipe.addDescription(steps);

         ArrayList<String> nutrients = new ArrayList<>();
        nutrients.add("more energy");
        nutrients.add("vitamin C");
        nutrients.add("carbohydrates");
        myRecipe.addNutrition(nutrients);

        HashMap<String, Vegan> recipe = new HashMap<>();

        recipe.put(name, myRecipe);

        return recipe;

    }

}