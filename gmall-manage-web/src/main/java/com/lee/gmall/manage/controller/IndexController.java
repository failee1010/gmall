package com.lee.gmall.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("attrListPage")
    public String attrListPage() {
        return "attrListPage";
    }

    @RequestMapping("spuListPage")
    public String spuListPage() {
        return "spuListPage";
    }
}
