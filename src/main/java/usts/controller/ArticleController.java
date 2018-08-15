package usts.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @Value("${hostname}")
    String host;

    //@pathvariable从地址栏里面拿出这个id，给aid
    @RequestMapping("/details/{id}")
    public void showArticleById(@PathVariable("id") int aid){
        System.out.println(aid);
        System.out.println(host);
    }
}
