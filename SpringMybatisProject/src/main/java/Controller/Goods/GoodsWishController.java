package Controller.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsWishService;

@Controller

public class GoodsWishController {
	@Autowired
	private GoodsWishService goodsWishService;
		@RequestMapping(value="/goods/goodsWishAdd")
	public String wish(@RequestParam(value="num") Long goodsSeq,Model model,
																				HttpSession session) {
	          goodsWishService.wishAdd(goodsSeq,model,session);
		
		
		
		return "goodsView/success";
	}
		
	@RequestMapping(value="goods/wishList")
	public String wishList(Model model , HttpSession session) {
		
		goodsWishService.wishList(model, session);
			
		return "/goodsView/wishList";
	}
	
}
