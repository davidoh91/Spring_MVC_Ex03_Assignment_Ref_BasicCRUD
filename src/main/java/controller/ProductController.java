package controller;

import dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.util.List;

@Controller
public class ProductController {
    //Singleton : ProductServiceImpl instance
    @Autowired
    private ProductService productServiceImpl;

    //check if ProductServiceImpl is injected
    public ProductController() {
        System.out.println("ProductController constructor invoked..");
    }


    //handle request index.kosta
    @RequestMapping("index.kosta")
    public ModelAndView handleIndex() {
        List<ProductDTO> productDTOList = productServiceImpl.select();
        System.out.println(productDTOList);

        ModelAndView mv = new ModelAndView("productList", "productDTOList", productDTOList);

        return mv;
    }



}
