package Service.Goods;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.AuthInfo;
import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsWishService {
	@Autowired
	GoodsRepository goodsRepository;
	
	public void wishAdd(Long goodsSeq, Model model ,HttpSession session) {
		
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		Integer i = goodsRepository.wishAdd(goodsSeq,userId);
		
		model.addAttribute("num", i);				
	}
	
	public void wishList(Model model,HttpSession session) {
		
		String userId = ((AuthInfo)session.getAttribute("authInfo")).getId();
		
		List<GoodsDTO> list = goodsRepository.wishList(userId);
		
	    model.addAttribute("wishList",list);
	}

}
