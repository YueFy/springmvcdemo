package usts.controller;

import com.sun.jmx.snmp.SnmpInt;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import usts.pojoj.Country;
import usts.pojoj.Person;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/country")
public class CountryController {
    //springMVC是基于方法
    @RequestMapping(value = "/showCountry.do")
    public ModelAndView showCountries() {
        List<String> ccc = new ArrayList<>();
        ccc.add("China NO.1");
        ccc.add("Japan is small");
        ccc.add("America will be hitten");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("countries", ccc);
        modelAndView.setViewName("country");
        return modelAndView;
    }

    @RequestMapping("/addCountry.do")
    public void addCountry(String location,String population){
        System.out.println(location+"\t"+population);
    }

    @RequestMapping("/addCountryEntity")
    public void addCountryEntity(Country country){
        System.out.println(country);
    }

    //正常使用ajax
    @RequestMapping( "/json")
    public void add(String name,int age){
        System.out.println(name+"\t"+age);
    }

    //这里是使用了@RequestBody的方法，将ajax发出的请求(json格式)写入到对象
    // 添加了注解之后可以在ajax里面添加上contentType: "application/json",以及使用JSON.stringify()
    //@ResponseBody是将结果直接返回一个json格式
    @ResponseBody
    @RequestMapping("/jsonObject")
    public void testjsonObject(@RequestBody String person) throws Exception{
        person= URLDecoder.decode(person, "utf-8");
        System.out.println(person);
    }

    //这里是一个json的数组，用Person对象数组接收
    @RequestMapping("/jsonBody")
    public void testjsonBody(@RequestBody Person[] personList) throws Exception{
        for (Person person:personList){
            System.out.println(person);
        }
    }

    @RequestMapping(value = "/file", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadFile(@RequestParam("fileupload") MultipartFile multipartFile) throws IOException {
            multipartFile.transferTo(new File("F://"+multipartFile.getOriginalFilename()));
    }

    @RequestMapping("/testPage.do")
    public ModelAndView page(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("a","aa");
        modelAndView.setViewName("index");
        return modelAndView;
    }

    //转发的return里面使用了forward的时候，InternalResourceViewResolver就不起作用了，必须使用全路径
    @RequestMapping("/testPage2.do")
    public String page2(Model model){
        model.addAttribute("age",20);
        model.addAttribute("name","杨超越");
        return "forward:/home/index.jsp";
    }

    @RequestMapping("/testPage3.do")
    public String page3(ModelMap modelMap){
        modelMap.addAttribute("age",20);
        modelMap.addAttribute("name","杨超越");
        return "redirect:/home/index.jsp";
    }

    @ResponseBody
    @RequestMapping("/returnjson")
    public List<Country> testjson(){
        List<Country> countries = new ArrayList<>();

        Country country1=new Country();
        country1.setLocation("亚洲");
        country1.setPopulation("100");

        Country country2=new Country();
        country2.setLocation("非洲");
        country2.setPopulation("10000");

        countries.add(country1);
        countries.add(country2);

        return countries;
    }
}
