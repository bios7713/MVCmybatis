package Repository.Goods;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Model.DTO.CartDTO;
import Model.DTO.CartRemove;
import Model.DTO.GoodsDTO;
import Model.DTO.WishDTO;

@Repository
public class GoodsRepository {
 @Autowired
  private SqlSession sqlSession;
  private final String namespace = "goodsMapper";
  public void goodsInsert(GoodsDTO DTO) {
	  String statement = namespace + ".goodsInsert";
	  sqlSession.insert(statement,DTO);
  }
  
  public List<GoodsDTO> listSelect(){
	  String statement = namespace + ".goodsList";
	  
	  return sqlSession.selectList(statement);
  }
  
  public GoodsDTO detail(Long goodsSeq) {
	  String statement = namespace + ".goodsList";
	  
	  return sqlSession.selectOne(statement,goodsSeq);
  }
  
  public Integer wishAdd(Long goodsSeq,String userId) {
		      WishDTO dto = new WishDTO();
		      dto.setGoodsSeq(goodsSeq);
		      dto.setUserId(userId);
		      String statement = namespace + ".goodsList";
		      statement = namespace + ".goodsWishCount";
		      Integer i =  sqlSession.selectOne(statement,goodsSeq);
		      if(i == 0) {
		         statement = namespace + ".wishInsert";
		         sqlSession.insert(statement,dto);
		         i= 1;
		      }else {
		         statement = namespace + ".wishDel";
		         sqlSession.delete(statement,dto);
		      }
		      return i;
		   }
  
  public List<GoodsDTO> wishList(String userId) {
      String statement = namespace + ".wishList";
      return sqlSession.selectList(statement,userId);
  }
  
  public Integer cartAdd(CartDTO DTO) {
	  
	  String statement = namespace + ".cartInsert";
	  Integer i = sqlSession.insert(statement,DTO);
	  
	  
	  return i;
  }
  
  public List<CartDTO> cartList(String userId){
	  
	  String statement = namespace + ".cartList";
	  
	  return sqlSession.selectList(statement,userId);
  }
  
  public void qtyDown(CartDTO DTO) {
	  String statement = namespace + ".qtyDown";
	  
	  sqlSession.update(statement,DTO);  
  }
  
  public void cartRemove(Map<String, Object> condition) {
	  	
	  String statement = namespace + ".cartRemove";
	  	 
	  sqlSession.delete(statement,condition);
  }
  
  
}
