package repository;

import dto.ProductDTO;
import exception.MyErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private List<ProductDTO> productList;
    @Autowired
    private ProductDTO product1;
    @Autowired
    private ProductDTO product2;
    @Autowired
    private ProductDTO product3;



    ////////////////////////////////////////////////////////////////
    public ProductDAOImpl() {
        System.out.println("ProductDAOImpl constructor invoked..");
    }


    /////////////////////////////public methods/////////////////////////
    @Override
    public List<ProductDTO> select() {
        return productList;
    }

    @Override
    public int insert(ProductDTO productDTO) throws MyErrorException {
        int result = 0;
        if(!isDuplicateCode(productDTO)) {
            productList.add(productDTO);
            result = 1;
        }

        return result;
    }

    @Override
    public int delete(String productCode) throws MyErrorException {
        int result = 0;

        ProductDTO productDTO = selectByCode(productCode);
        if(productDTO == null) {
            throw new MyErrorException("There is no product by the inserted productCode");
        }else {
            productList.remove(productDTO);
            result = 1;
        }


        return result;
    }

    @Override
    public ProductDTO selectByCode(String productCode) throws MyErrorException {
        ProductDTO result = null;
        for(ProductDTO p : productList) {
            if( p.getCode().equals(productCode) ) {
                result = p;
            }
        }

        return result;
    }


    /////////////////////////////private methods/////////////////////////
    private boolean isDuplicateCode(ProductDTO productDTO) {
        for(ProductDTO p : productList) {
            if( p.getCode().equals(productDTO.getCode()) ) {
                return true;
            }
        }
        return false;
    }

}
