package com.lnu.bd.rest;


import com.lnu.bd.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    @RequestMapping(value = "/products", method = RequestMethod.GET)
    public String products(Model model) {
        model.addAttribute("productList", productRepository.findAll());
        return "products";
    }

    /*@RequestMapping(value = "/product", method = RequestMethod.GET)
    public Product byId(@RequestParam(name = "id") int id) {
        return productRepositiry.getById(id);
    }

    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public void save(@RequestParam(name = "name") String name,
                     @RequestParam(name = "price") float price,
                     @RequestParam(name = "avaliable") boolean avaliable,
                     @RequestParam(name = "category_id") int cat) {
        Product product = new Product();
        product.setCategory(new Category());
        product.setName(name);
        product.setPrice(price);
        product.setAvaliable(avaliable);
        product.getCategory().setId(cat);
        productRepositiry.save(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public void update(@RequestParam(name = "name") String name,
                       @RequestParam(name = "price") float price,
                       @RequestParam(name = "id") int id,
                       @RequestParam(name = "avaliable") boolean avaliable,
                       @RequestParam(name = "category_id") int cat) {
        Product product = new Product();
        product.setId(id);
        product.setCategory(new Category());
        product.setName(name);
        product.setPrice(price);
        product.setAvaliable(avaliable);
        product.getCategory().setId(cat);
        productRepositiry.update(product);
    }

    @RequestMapping(value = "/product", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id") int id) {
        Product product = new Product();
        product.setId(id);
        productRepositiry.delete(product);
    }*/
}
