package repository;

import java.util.List;

import dto.ProductDTO;
import exception.MyErrorException;

public interface ProductDAO {
   /**
    * 검색
    * */
	List<ProductDTO> select();
	
	/**
	 * 등록
	 * */
	int insert(ProductDTO productDTO)throws MyErrorException;
	
	/**
	 * 삭제
	 * */
	 int delete(String code)throws MyErrorException;

	/**
	 * 상세보기
	 */

	ProductDTO selectByCode(String code)throws MyErrorException;
}










