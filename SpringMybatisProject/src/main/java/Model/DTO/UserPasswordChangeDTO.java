package Model.DTO;

public class UserPasswordChangeDTO {
	
	String userId;
	String userPw;
	String newUserPw;	
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getOldPw() {
		return userPw;
	}
	public void setOldPw(String userPw) {
		this.userPw = userPw;
	}
	public String getNewPw() {
		return newUserPw;
	}
	public void setNewPw(String newUserPw) {
		this.newUserPw = newUserPw;
	}

	public UserPasswordChangeDTO(String userId, String userPw, String newUserPw) {
		this.userId = userId;
		this.userPw = userPw;
		this.newUserPw = newUserPw;
	}


}
