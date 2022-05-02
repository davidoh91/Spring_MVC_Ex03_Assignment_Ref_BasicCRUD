package dto;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Scope("prototype") // prototype scope will allow DTO1 and DTO2 to be created separately (different instances instead of one shared instance)
public class ProductDTO {

//   @Value("product-code") // use springframework @Value() annotation
   private String code;

//   @Value("product-name")
   private String name;

//   @Value("4000")
   private int price;

//   @Value("product-detail product-detail product-detail product-detail product-detail")
   private String detail;

}
