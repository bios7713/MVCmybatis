package Service.Servey;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import Model.DTO.Question;
import Model.DTO.QuestionOption;
import Repository.Servey.ServeyRepository;

public class ServeyService {
	@Autowired
	private ServeyRepository serveyRepository;

	public void execute(Model model) {
		List<Question> questions =new ArrayList<Question>();
		List<QuestionOption> lists = serveyRepository.selectAll();
		String question = "";
		List<String> list = null;
		for(int i = 0; i<= lists.size(); i++) {
			QuestionOption q = new QuestionOption();
			if(i<lists.size()) q = lists.get(i);
			if(!question.equals("") && !question.equals(q.getQuestion()) ) {
				if(lists.size() != 0) {
					Question q1 = new Question(question ,list);
					questions.add(q1); 
				}else {						  
					Question q1 = new Question(question);
					questions.add(q1); }
			}
			if(!question.equals(q.getQuestion())) {
				question = q.getQuestion(); 
				list =  new ArrayList<String>();
			}
			if(q.getOption() != null) {			
				list.add(q.getOption());
			}
		}		
		model.addAttribute("questions" ,questions);
	}
}
