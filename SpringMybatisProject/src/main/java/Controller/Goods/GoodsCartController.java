package Controller.Goods;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Goods.GoodsCartService;

@Controller
public class GoodsCartController {
	@Autowired
	private GoodsCartService goodsCartService;
	@RequestMapping(value="/goods/goodsCartAdd")
	public String cart(@RequestParam(value="num") Long goodsSeq, Model model,HttpSession session) {
		goodsCartService.cartAdd(goodsSeq,model,session);
		return "goodsView/success";
	}
	@RequestMapping(value="/goods/goodsCartList")
	public String cartList(Model model , HttpSession session ) {
		
		goodsCartService.GcartList(model,session);
		return "goodsView/goodsCartList";
	}
	@RequestMapping(value="/goods/goodsQtyUp")
	public String qtyUp( @RequestParam(value="goodsNum") 
										Long goodsSeq,Model model , HttpSession session) {
		goodsCartService.cartAdd(goodsSeq, model, session);
		return "redirect:/goods/goodsCartList";
	}
	@RequestMapping(value="/goods/goodsQtyDown")
	public String qtyDown(@RequestParam(value="goodsNum") Long goodsSeq ,
							Model model , HttpSession session) {
		goodsCartService.cartDown(goodsSeq, model, session);
		
		return "redirect:/goods/goodsCartList";	
	}
	@RequestMapping(value="/goods/goodsCartRemove")
	public String cartRemove(@RequestParam(value="delete" ) Long [] goodsSeqs ) {
		
		goodsCartService.cartRemove(goodsSeqs);
		
		
		return "redirect:/goods/goodsCartList";
	}
	
}
