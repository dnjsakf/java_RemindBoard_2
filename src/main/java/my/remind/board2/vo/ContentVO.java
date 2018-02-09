package my.remind.board2.vo;

public class ContentVO {

	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardDate;
	private String boardContent;
	private int boardAvailable;
	
	public ContentVO() {
		
	}
	public ContentVO(int boardNo, String boardTitle, String boardWriter, String boardDate, String boardContent, int boardAvailable ) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardDate = boardDate;
		this.boardContent = boardContent;
		this.boardAvailable = boardAvailable;
	}
	
	public int getBoardNo() {
		return boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public String getBoardDate() {
		return boardDate;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public int getBoardAvailable() {
		return boardAvailable;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public void setBoardDate(String boardDate) {
		this.boardDate = boardDate;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public void setBoardAvailable(int boardAvailable) {
		this.boardAvailable = boardAvailable;
	}
	
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nNO: " + this.boardNo);
		sb.append("\nTitle: " + this.boardTitle);
		sb.append("\nDate: " + this.boardDate);
		sb.append("\nWriter: " + this.boardWriter);
		sb.append("\nContent: " + this.boardContent);
		sb.append("\nAvailable: " + this.boardAvailable);
		return sb.toString();
	}
	
}
