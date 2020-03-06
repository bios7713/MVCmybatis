package Service.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.AuthInfo;
import Model.DTO.CartDTO;
import Model.DTO.CartRemove;
import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsCartService {
	@Autowired
	private GoodsRepository goodsRepository;
	public void cartAdd(Long goodsSeq, Model model,HttpSession session) {
		GoodsDTO GDTO = goodsRepository.detail(goodsSeq);
		CartDTO CDTO =  new CartDTO();
		CDTO.setGoodsImage(GDTO.getGoodsImage());
		CDTO.setGoodsName(GDTO.getGoodsName());
		CDTO.setGoodsPrice(GDTO.getGoodsPrice());
		CDTO.setGoodsSeq(goodsSeq);
		CDTO.setQty(1L);
		CDTO.setUserId(((AuthInfo)session.getAttribute("authInfo")).getId());
	    
		Integer i =goodsRepository.cartAdd(CDTO);
		
		model.addAttribute("num",i);
		
	}
	
	public void GcartList(Model model,HttpSession session) {
		
			String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		List<CartDTO> list =  goodsRepository.cartList(userId);
	
		model.addAttribute("cartList" , list);
		
	}
	public void cartDown(Long goodsSeq,Model model,HttpSession session) {
		CartDTO  CDTO = new CartDTO();
		
		
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		CDTO.setGoodsSeq(goodsSeq);
		CDTO.setUserId(userId);
		
		goodsRepository.qtyDown(CDTO);
		
		
	}
	
	public void cartRemove(Long [] goodsSeqs ) {
		List<Long> cs = new ArrayList<Long>();
		
		for(Long goodsSeq : goodsSeqs) {
			cs.add(goodsSeq);
			
		}
		Map<String, Object> condition = new HashMap<String, Object>();
		
		condition.put("seqs", cs);
		goodsRepository.cartRemove(condition);
		
		
	}
	
}
