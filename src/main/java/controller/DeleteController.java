package controller;

import exception.MyErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

@Controller
public class DeleteController {
    //Singleton : ProductServiceImpl instance
    @Autowired
    private ProductService productServiceImpl;

    /*  make sure to ..
        (1) use flexible url path
        (2) receive it via path variable
     */
    @RequestMapping("/{code}") // you can omit "/del" because web.xml already covers that
    public String handleDeleteProduct(@PathVariable String code) throws MyErrorException {

        int result = productServiceImpl.delete(code);
        if(result == 0) throw new MyErrorException("Product Deletion Failure");

        return "redirect:/index.kosta";
    }

    //add ExceptionHandler for all exceptions
    @ExceptionHandler(value = {Exception.class})
    public ModelAndView error(Exception e) {
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errMessage", e.getMessage());

        return mv;
    }

}
