package Service.Goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;

@Service
public class GoodsDetailService {
	@Autowired
	private GoodsRepository goodsRepository;
	public void detail(Long goodsSeq, Model model) {
		GoodsDTO DTO = goodsRepository.detail(goodsSeq);
		
		model.addAttribute("goods",DTO);
		
		
	}
	
}
