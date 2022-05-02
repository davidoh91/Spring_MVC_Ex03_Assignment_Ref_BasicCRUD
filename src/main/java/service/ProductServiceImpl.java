package service;

import dto.ProductDTO;
import exception.MyErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ProductDAO;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    //Singleton : ProductDAOImpl instance
    @Autowired
    private ProductDAO productDAOImpl;
    private final int MIN_PRICE = 1000;
    private final int MAX_PRICE = 10000;


    ////////////////////////////////////////////////////////////////
    //check if productDAOImpl is injected
    public ProductServiceImpl() {
        System.out.println("ProductServiceImpl constructor invoked..");
    }


    /////////////////////////////public methods/////////////////////////
    //test method
    public void test() {
        System.out.println("productServiceImpl.test() invoked..");
    }

    @Override
    public List<ProductDTO> select() {
        List<ProductDTO> productList = productDAOImpl.select();

        return productList;
    }

    @Override
    public int insert(ProductDTO productDTO) throws MyErrorException {
        int result = 0;

        //first, check price range of 1000-10000
        if(isPriceInRange(productDTO)) {
            result = productDAOImpl.insert(productDTO);
        }else {
            throw new MyErrorException("Price is not in range");
        }

        return result;
    }

    @Override
    public int delete(String productCode) throws MyErrorException {
        int result = productDAOImpl.delete(productCode);

        return result;
    }

    @Override
    public ProductDTO selectByCode(String productCode) throws MyErrorException {
        ProductDTO productDTO = productDAOImpl.selectByCode(productCode);

        return productDTO;
    }


    /////////////////////////////private methods/////////////////////////
    private boolean isPriceInRange(ProductDTO productDTO) {
        boolean result = false;
        int price = productDTO.getPrice();
        if(price >= MIN_PRICE && price <= MAX_PRICE) {
            result = true;
        }

        return result;
    }


}
