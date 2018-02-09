package my.remind.board2.vo;

public class CommentVO {
	private int no;
	private String writer;
	private String date;
	private String password;
	private String comment;
	private int boardNo;

	public CommentVO() {
		
	}
	public CommentVO(String writer, String date, String password, String comment, int boardNo) {
		this.writer = writer;
		this.date = date;
		this.password = password;;
		this.comment = comment;
		this.boardNo = boardNo;
	}
	
	public int getNo() {
		return no;
	}
	public String getWriter() {
		return writer;
	}
	public String getPassword() {
		return password;
	}
	public String getDate() {
		return date;
	}
	public String getComment() {
		return comment;
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("\nNO: " + this.no);
		sb.append("\nWriter: " + this.writer);
		sb.append("\nDate: " + this.date);
		sb.append("\nPassword: " + this.password);
		sb.append("\nComment: " + this.comment);
		sb.append("\nBoardNo: " + this.boardNo);
		return sb.toString();
	}
}
