package com.example.shopping.controller;

import com.example.shopping.dto.OrderDTO;
import com.example.shopping.dto.ResponseOrderDTO;
import com.example.shopping.model.Item;
import com.example.shopping.model.Order;
import com.example.shopping.service.ItemService;
import com.example.shopping.service.OrderService;
import com.example.shopping.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class Controller {

    private OrderService orderService;
    private ItemService itemService;

    public Controller(OrderService orderService, ItemService itemService) {
        this.itemService = itemService;
        this.orderService = orderService;
    }

    private Logger logger = LoggerFactory.getLogger(Controller.class);

    @GetMapping("/hi")
    public String sayHi() {
        return "Say hi to the world - just because you can :-) ";
    }

    @GetMapping("/getItems")
    public ResponseEntity<List<Item>> getAllItems() {
        List<Item> items = itemService.getAllItems();

        if(items.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/addItem")
    public ResponseEntity<Item> addItem(@RequestBody Item item) {
        try {
            Item newItem = itemService.saveItem(new Item(item.getName(), item.getPrice()));
            return new ResponseEntity<>(newItem, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // add Items - possible to add an array of items

    @PostMapping("/orderPlacement")
    public ResponseEntity<ResponseOrderDTO> orderPlacement(@RequestBody OrderDTO orderDTO){
        logger.info("Request Payload " + orderDTO.toString());
        ResponseOrderDTO responseOrderDTO = new ResponseOrderDTO();

        Order newOrder = new Order(orderDTO.getOrderNotes(), orderDTO.getCartItems());

        newOrder = orderService.saveOrder(newOrder);
        logger.info("Order processed successfully..");

        responseOrderDTO.setDate(DateUtil.getCurrentDateTime());
        responseOrderDTO.setOrderId(newOrder.getId());
        responseOrderDTO.setOrderNotes(orderDTO.getOrderNotes());

        logger.info("Wauw your order is created...");

    return null;
    }
}
