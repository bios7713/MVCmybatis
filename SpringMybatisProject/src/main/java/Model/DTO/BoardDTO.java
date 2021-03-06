package Model.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

@SuppressWarnings("serial")
public class BoardDTO implements Serializable
{
   
   Integer boardNum;
   String userId;
   String boardName;
   String boardPass;
   String boardSubject;
   String boardContent;
   Timestamp boardDate;
   String boardAddr;
   Integer readCount;
   
   public Integer getBoardNum()
   {
      return boardNum;
   }
   public void setBoardNum(Integer boardNum)
   {
      this.boardNum = boardNum;
   }
   public String getUserId()
   {
      return userId;
   }
   public void setUserId(String userId)
   {
      this.userId = userId;
   }
   public String getBoardName()
   {
      return boardName;
   }
   public void setBoardName(String boardName)
   {
      this.boardName = boardName;
   }
   public void setBoardNum(String userId)
   {
      this.userId = userId;
   }
   public String getBoardPass()
   {
      return boardPass;
   }
   public void setBoardPass(String boardPass)
   {
      this.boardPass = boardPass;
   }
   public String getBoardSubject()
   {
      return boardSubject;
   }
   public void setBoardSubject(String boardSubject)
   {
      this.boardSubject = boardSubject;
   }
   public String getBoardContent()
   {
      return boardContent;
   }
   public void setBoardContent(String boardContent)
   {
      this.boardContent = boardContent;
   }
   public Timestamp getBoardDate()
   {
      return boardDate;
   }
   public void setBoardDate(Timestamp boardDate)
   {
      this.boardDate = boardDate;
   }
   public String getBoardAddr() 
   {
         return boardAddr;
   }
   public void setBoardAddr(String boardAddr)
   {
      this.boardAddr = boardAddr;
   }
      
   public Integer getReadCount()
   {
         return readCount;
   }
   public void setReadCount(Integer readCount)
   {
         this.readCount = readCount;
   }
}