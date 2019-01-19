package jp.co.systena.tigerscave.SpringShopping.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import jp.co.systena.tigerscave.SpringShopping.application.model.ListForm;
import jp.co.systena.tigerscave.SpringShopping.application.model.Order;

@Controller
public class ListController {

  @Autowired
  HttpSession session;

  @RequestMapping(value = "/list", method = RequestMethod.GET)
  public ModelAndView show(ModelAndView mav) {

    ListForm listForm = (ListForm) session.getAttribute("form");
    session.removeAttribute("form");
    if (listForm != null) {
      mav.addObject("name", listForm.getItem());
      mav.addObject("num", listForm.getNum());
    }
    mav.addObject("listForm", new ListForm());

    List<Order> orders = (List<Order>) session.getAttribute("orderList");
    if (orders == null) {
      orders = new ArrayList<Order>();
      session.setAttribute("orderList", orders);
    }
    mav.addObject("orders", orders);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }

    mav.setViewName("listview");
    return mav;
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST)
  private ModelAndView order(ModelAndView mav, @Valid ListForm listForm,
      BindingResult bindingResult, HttpRequest request) {

    List<Order> orders = (List<Order>)session.getAttribute("orderList");
    //Cart orders = (Cart) session.getAttribute("orderList");
    if (orders == null) {
      orders = new ArrayList<Order>();
      //orders = new Cart();
      session.setAttribute("orderList", orders);
    }

    if (bindingResult.getAllErrors().size() > 0) {
      mav.addObject("listForm", orders);

      mav.addObject("orders", orders);

      mav.setViewName("listview");
      return mav;
    }

    Order order = new Order();
    order.setItem(listForm.getItem());
    order.setNum(listForm.getNum());
    orders.add(order);

    session.setAttribute("form", listForm);
    return new ModelAndView("redirect:/orderlist");
  }
}