package com.lnu.bd.rest;

import com.lnu.bd.dao.GenericCrudDao;
import com.lnu.bd.model.Product;
import com.lnu.bd.model.Purchase;
import com.lnu.bd.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class PurchaseController {


    private GenericCrudDao<Purchase> purchaseRepository;

    @RequestMapping(value = "/purchases", method = RequestMethod.GET)
    public List<Purchase> getAll() {
        return purchaseRepository.getAll();
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.GET)
    public Purchase getByID(
            @RequestParam(name = "id") int id) {
        return purchaseRepository.getById(id);
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public void save(
            @RequestParam(name = "user_id") int userId,
            @RequestParam(name = "product_id") int productId) {
        Purchase purchase = new Purchase();
        purchase.setProduct(new Product());
        purchase.setUser(new User());
        purchase.getUser().setId(userId);
        purchase.getProduct().setId(productId);
        purchase.setTime(Date.valueOf(LocalDate.now()));
        purchaseRepository.save(purchase);
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.PUT)
    public void upadte(
            @RequestParam(name = "user_id") int userId,
            @RequestParam(name = "product_id") int productId,
            @RequestParam(name = "id") int id) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchase.setProduct(new Product());
        purchase.setUser(new User());
        purchase.getUser().setId(userId);
        purchase.getProduct().setId(productId);
        purchase.setTime(Date.valueOf(LocalDate.now()));
        purchaseRepository.update(purchase);
    }

    @RequestMapping(value = "/purchase", method = RequestMethod.DELETE)
    public void delete(
            @RequestParam(name = "id") int id) {
        Purchase purchase = new Purchase();
        purchase.setId(id);
        purchaseRepository.delete(purchase);
    }
}
