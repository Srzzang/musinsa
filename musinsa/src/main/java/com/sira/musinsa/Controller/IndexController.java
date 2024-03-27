package com.sira.musinsa.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sira.musinsa.Service.UserPointService;

import java.awt.Dialog.ModalExclusionType;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



@Controller
public class IndexController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private UserPointService userPointService;

 
    
    @RequestMapping(value= "/user/point", method = RequestMethod.GET)
    public ModelAndView pointList(){
    	ModelAndView mv  = new ModelAndView("index");
    	
    	//회원별 포인트 합계 리스트 
    	List<Map<String,String>> list =  userPointService.selectListSearch();
    	System.err.println(list);
    	mv.addObject("list", list);
    	return mv;
    }
   
}

