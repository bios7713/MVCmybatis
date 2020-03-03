package Controller.Comment;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Service.Comment.InsertService;
import Service.Comment.ListService;
import Service.Comment.UserService;

@Controller
public class CommentController {
	@Autowired
	private InsertService  insertService;
	@Autowired
	private UserService userService;
	@Autowired
	 private ListService listService;
		@RequestMapping(value="/comment/comment_insert",method= RequestMethod.POST)
		public String commentInsert(@RequestParam("commentSubject") String commentSubject ,
												@RequestParam("commentContent") String commentContent
												 ,HttpSession session) {
			insertService.commentInsert(commentSubject,commentContent,session);
			
			
			
			return "redirect:/comment/comment_List";
		}
		
		@RequestMapping(value="/comment/comment_List", method = RequestMethod.GET)
		public String commentList(Model model) {
			listService.commentList(model);
			
			return "comment/commentList";
		}
		@RequestMapping(value="/comment/commentDetail" )
		public String detail(@RequestParam(value="num") Long commentNo ,Model model) {
			userService.user(commentNo,model);
				
			return "comment/commentCollection";		
		}
		
		@RequestMapping(value="/comment/replyInsert")
		public String replyInsert(@RequestParam(value="cuserId") String cuserId ,
											@RequestParam(value="commentNo") Long commentNo,
											@RequestParam(value="replyContent") String replyContent  ,HttpSession session ,Model model ) {
			
			insertService.replyInsert(cuserId,commentNo,replyContent ,session);
			
			
			
			return "redirect:/comment/commentDetail?num=" + commentNo ;
		}
		
}
