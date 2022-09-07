package tech.zyambo.srapi.controllers;

import java.util.HashMap;
import com.google.gson.Gson;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

import tech.zyambo.srapi.FileStorage;
import tech.zyambo.srapi.Recipe;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@RestController
@RequestMapping(path="/srapi/v1/recipes", produces="application/json")
public class VeganController {

    @GetMapping("/vegan")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public HashMap<String, HashMap<String, String>> resources(){

        HashMap<String, String> resUrls = new HashMap<>();
        // add key value pair (dishGroup, URL)
        resUrls.put("breakfast", "/srapi/v1/vegan/breakfast");
        resUrls.put("lunch", "/srapi/v1/vegan/lunch");
        resUrls.put("dinner", "/srapi/v1/vegan/dinner");
        
        HashMap<String, HashMap<String, String>> res = new HashMap<>();

        FileStorage myObj = new FileStorage();
        myObj.readFile();
        
        res.put("result:", resUrls);
    
        return res;
    }
    
    @PostMapping("/vegan")
    @ResponseStatus(HttpStatus.CREATED)
    public String createVgnRecipe(
        @RequestBody Recipe data,
        @RequestParam String name){
        RecipeController myObj = new RecipeController();
        myObj.createRecipe(data, name, "vegan");

        // Status message
        String Jmsg;
        HashMap<String, String> msg = new HashMap<>();
        msg.put("message", "ok");
        Gson gson = new Gson();
        Jmsg = gson.toJson(msg);

        return Jmsg;
    }
}