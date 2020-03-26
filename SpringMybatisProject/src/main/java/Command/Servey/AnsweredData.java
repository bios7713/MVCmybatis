package Command.Servey;

import java.util.List;

public class AnsweredData {
	public List<String> getResponse() {
		return response;
	}
	public void setResponse(List<String> response) {
		this.response = response;
	}
	public Respondent getRes() {
		return res;
	}
	public void setRes(Respondent res) {
		this.res = res;
	}
	private List<String> response;
	private Respondent res;
	
	
	
}
