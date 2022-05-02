package controller;

import dto.ProductDTO;
import exception.MyErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
public class InsertController {
    //Singleton : ProductServiceImpl instance
    @Autowired
    private ProductService productServiceImpl;

    public InsertController() {
        System.out.println("InsertController constructor invoked..");
    }

    //handle request for insertForm view page
    //${pageContext.request.contextPath}
    @RequestMapping("insertForm.kosta")
    public String handleInsertFormView() {
        return "insertForm";
    }

    //handle request for inserting a new product
    @RequestMapping("insert.kosta")
    public String handleInsertProduct(String code, String name, Integer price, String detail) throws MyErrorException {
        System.out.println("testing... :" + code + name + price + detail);

        //if insert is successful (int result == 1), redirect to index.kosta
        int result = productServiceImpl.insert(new ProductDTO(code, name, price, detail));
        if(result == 0) throw new MyErrorException("Product Insertion Failure");

        return "redirect:/index.kosta";
    }

    //handle request to read a product detail info
    @RequestMapping("read.kosta")
    public ModelAndView handleReadInfo(String code) throws MyErrorException {
        ProductDTO productDTO = productServiceImpl.selectByCode(code);

        ModelAndView mv = new ModelAndView("read", "productDTO", productDTO);

        return mv;
    }


}
