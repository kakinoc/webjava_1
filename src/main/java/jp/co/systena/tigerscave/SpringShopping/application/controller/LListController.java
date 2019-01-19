package jp.co.systena.tigerscave.SpringShopping.application.controller;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class LListController {

  @RequestMapping("/ListView") // URLとのマッピング
  public String index(HttpSession session, Model model,
                            @RequestParam(name = "name", required = false)String name,
                            @RequestParam(name = "num", required = false)int num) {

    model.addAttribute("name", name);
    model.addAttribute("num", num);

    return "listview";
  }
}
