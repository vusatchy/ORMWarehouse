package com.lnu.bd.rest;

import com.lnu.bd.dao.PurchaseRepository;
import com.lnu.bd.model.Product;
import com.lnu.bd.model.Purchase;
import com.lnu.bd.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PurchaseController {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @GetMapping(value = "/purchase")
    public String purchase(Model model){
        return "purchase";
    }

}

