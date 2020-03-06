package Service.Goods;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import Command.Goods.GoodsCommand;
import Model.DTO.AuthInfo;
import Model.DTO.GoodsDTO;
import Repository.Goods.GoodsRepository;


@Service
public class GoodsWriteService {
	
	@Autowired
	GoodsRepository goodsRepository;
	
	public void goodsWritePro(GoodsCommand goodsCommand , HttpSession session 
			                                 ,HttpServletRequest request) {
		GoodsDTO DTO = new GoodsDTO();
		
		System.out.println("ServiceCommand: " + goodsCommand.getGoodsContent());
		DTO.setGoodsContent(goodsCommand.getGoodsContent());
		DTO.setGoodsName(goodsCommand.getGoodsName());
		DTO.setGoodsNum(goodsCommand.getGoodsNum());
		DTO.setGoodsPrice(goodsCommand.getGoodsPrice());
		DTO.setGoodsQty(goodsCommand.getGoodsQty());
	    DTO.setUserId(((AuthInfo)session.getAttribute("authInfo")).getId());
	
		String storeTotal = "";

		
	//	String realPath = request.getServletContext().getRealPath(path);
		for(MultipartFile mf :  goodsCommand.getGoodsImage()) {
		    String original = mf.getOriginalFilename();
		    //확장자  										    마지막 .부터	
		    String originalFileExtension =    
					original.substring(original.lastIndexOf("."));
		    //저장하기 위한 이름                               문자로 가져오기  바꾸기  -를 지우기  
		    String store = UUID.randomUUID().toString().replace("-","")
		    															+ originalFileExtension;

			//originalTotal에  -를 붙여서 추가한다.
	       
	         //storeTotal에 구분자(-)를 붙임
			 storeTotal += store + "-";	 
			 String path = request.getServletContext().getRealPath("/");
			  path += "WEB-INF\\view\\goodsView\\update\\";
			 
		
			 File file = new File(path + store);  //파일 객체 생성!
			 
			 try {
				 mf.transferTo(file);
			 }catch(Exception e) {
				 e.printStackTrace();				 
			 }		 		
		}
		
		DTO.setGoodsImage(storeTotal);
		goodsRepository.goodsInsert(DTO);
	}
}
