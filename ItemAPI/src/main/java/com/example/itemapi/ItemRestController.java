package com.example.itemapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/item")
public class ItemRestController {
    @Autowired
    private ItemRepository itemRepo;

    @PostMapping(path = "")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createItem(@RequestBody Item item) {
        Item newitem = new Item(item.getName(), item.getDescription(), item.getUnitPrice());
        itemRepo.save(newitem);
    }

    @PostMapping(path = "/addItems")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createItems(@RequestBody List<Item> items) {
        for (Item item : items) {
            createItem(item);
        }
    }

    @GetMapping(path = "/{itemID}")
    @ResponseStatus(code = HttpStatus.OK)
    public Optional<Item> getItemById(@PathVariable UUID itemID) {
        return itemRepo.findById(itemID);
    }

    @GetMapping(path = "/search/{searchText}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Item> searchItems(@PathVariable(required = true) String searchText) {
        return itemRepo.findByNameContainingOrDescriptionContaining(searchText, searchText);
    }

    @GetMapping(path = "")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Item> getAllItems() {
        return itemRepo.findAll();
    }

    @DeleteMapping(path = "/{itemID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void deleteItem(@PathVariable UUID itemID) {
        itemRepo.deleteById(itemID);
    }

    @PutMapping(path = "/{itemID}")
    @ResponseStatus(code = HttpStatus.OK)
    public void updateItem(@RequestBody Item item, @PathVariable UUID itemID) {
        if (item.getId() == itemID) {
            itemRepo.save(item);
        } else System.out.println("The items id's do not match");
    }
}
