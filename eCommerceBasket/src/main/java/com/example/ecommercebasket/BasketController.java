package com.example.ecommercebasket;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.DataInput;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping("/basket")
public class BasketController {
    @Autowired
    private RedisTemplate<String,Basket> redisTemplate;

    @GetMapping(path = "/{basketId}")
    @ResponseStatus(code = HttpStatus.OK)
    public Basket getBasket(@PathVariable String basketId){
        Basket basket = redisTemplate.opsForValue().get(basketId);
        return basket;
    }
    @PostMapping(path = "/{basketId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Basket addSingleItemToBasket(@PathVariable String basketId, @RequestBody Item item){
        //Item item = getItemFromAPI(itemId);

        Basket basket = null;
        if("new".equals(basketId)){
            basket = new Basket(UUID.randomUUID().toString());
        }else{
            basket = redisTemplate.opsForValue().get(basketId);
        }

        basket.getItems().add(item);

        redisTemplate.opsForValue().set(basket.getBasketGuid(), basket);

        return basket;
    }

    @PostMapping(path = "/addItems/{basketId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Basket addBooksToBasket(@PathVariable String basketId, @RequestBody List<Item> items){
        Basket basket = null;
        if("new".equals(basketId)){
            basket = new Basket(UUID.randomUUID().toString());
        }else{
            basket = redisTemplate.opsForValue().get(basketId);
        }

 /*       List<Item> items = new ArrayList<>();
        for (UUID id: ids) {
            items.add(getItemFromAPI(id));
        }*/
        basket.getItems().addAll(items);

        redisTemplate.opsForValue().set(basket.getBasketGuid(), basket);

        return basket;
    }

    @DeleteMapping(path = "/{basketId}/{ItemUUID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteBookFromBasket(@PathVariable String basketId, @PathVariable UUID ItemUUID){
        Basket basket = redisTemplate.opsForValue().get(basketId);
        basket.setItems(basket.getItems().stream().filter(b -> !b.getId().equals(ItemUUID)).collect(Collectors.toList()));
        redisTemplate.opsForValue().set(basketId, basket);
    }

    @DeleteMapping(path = "/{basketId}")
    @ResponseStatus(code=HttpStatus.OK)
    public void deleteBasket(@PathVariable String basketId){
        redisTemplate.delete(basketId);
    }

 /*   private Item getItemFromAPI(UUID id){
        try {
            URL url = new URL("http://localhost:8090/Item/" + id);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept", "application/json");
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (con.getInputStream())));
            String output;
            String info="";
            while ((output = br.readLine()) != null) {
                info+=output;
            }
            ObjectMapper mapper = new ObjectMapper();
            JsonNode json = mapper.readTree(info);
            Item item = mapper.readValue((DataInput) json, Item.class);
            return item;
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }*/
}
