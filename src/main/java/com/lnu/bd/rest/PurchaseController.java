package com.lnu.bd.rest;

import com.lnu.bd.dao.PurchaseRepository;
import com.lnu.bd.dao.UserRepository;
import com.lnu.bd.model.Product;
import com.lnu.bd.model.Purchase;
import com.lnu.bd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/purchase")
    public String purchase(HttpServletRequest request, Model model) {
        Object obId = request.getSession().getAttribute("id");
        if (obId != null) {
            Integer id = Integer.parseInt((String) request.getSession().getAttribute("id"));
            Iterable<Purchase> purchases = purchaseRepository.findAllByUserId(id);
            model.addAttribute("purchases", purchases);
            model.addAttribute("sum", (new BigDecimal(userRepository.sumFunction(id)).setScale(3, RoundingMode.UP).doubleValue()));
        } else {
            model.addAttribute("sum", 0.00);
        }
        return "purchase";
    }


    @PostMapping(value = "/purchase")
    public String purchaseBuy(@RequestParam(value = "id") int prodId, HttpServletRequest request, Model model) {
        Object obId = request.getSession().getAttribute("id");
        Purchase purchase = new Purchase();
        purchase.setUser(new User());
        purchase.setProduct(new Product());
        purchase.getProduct().setId(prodId);
        if (obId != null) {
            Integer id = Integer.parseInt((String) request.getSession().getAttribute("id"));
            purchase.getUser().setId(id);
            purchase.setTime(Date.valueOf(LocalDate.now()));
            purchaseRepository.save(purchase);
        }
        return "purchase_red";
    }

}

