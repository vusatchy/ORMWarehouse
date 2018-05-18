package com.lnu.bd.rest;

import com.lnu.bd.dao.GenericCrudDao;
import com.lnu.bd.model.Feedback;
import com.lnu.bd.model.Product;
import com.lnu.bd.model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@RestController
public class FeedbackController {

    private GenericCrudDao<Feedback> feedbackRepository;

    @RequestMapping(value = "/feedbacks", method = RequestMethod.GET)
    public List<Feedback> all() {
        return feedbackRepository.getAll();
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.GET)
    public Feedback feedback(@RequestParam(name = "id") int id) {
        return feedbackRepository.getById(id);
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.POST)
    public void save(@RequestParam(name = "user.id") int userId,
                     @RequestParam(name = "product.id") int productId,
                     @RequestParam(name = "comment") String comment) {
        Feedback feedback = new Feedback();
        feedback.setProduct(new Product());
        feedback.setUser(new User());
        feedback.getProduct().setId(productId);
        feedback.getUser().setId(userId);
        feedback.setComment(comment);
        feedback.setDate(Date.valueOf(LocalDate.now()));
        feedbackRepository.save(feedback);
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.PUT)
    public void update(@RequestParam(name = "id") int id,
                       @RequestParam(name = "comment") String comment) {
        Feedback feedback = new Feedback();
        feedback.setId(id);
        feedback.setComment(comment);
        feedback.setDate(Date.valueOf(LocalDate.now()));
        feedbackRepository.update(feedback);
    }

    @RequestMapping(value = "/feedback", method = RequestMethod.DELETE)
    public void delete(@RequestParam(name = "id") int id) {
        Feedback feedback = new Feedback();
        feedback.setId(id);
        feedbackRepository.delete(feedback);
    }

}
