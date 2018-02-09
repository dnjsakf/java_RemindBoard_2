package my.remind.board2.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import my.remind.board2.dao.comment.CommentDAO;
import my.remind.board2.dao.content.ContentDAO;
import my.remind.board2.vo.CommentVO;
import my.remind.board2.vo.ContentVO;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Inject
	private ContentDAO dao;
	
	@Inject
	private CommentDAO cmt;
	
	private int prevPage = 1;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String boardList(Model model, HttpServletRequest request ) {
		if( request.getParameter("page") != null ) { 
			this.prevPage = Integer.valueOf(request.getParameter("page"));
		}
		
		ArrayList<ContentVO> contents = dao.getContents(this.prevPage);
		int firstId = contents.get(0).getBoardNo();
		int lastId = contents.get( contents.size()-1 ).getBoardNo();

		int existNextPage = dao.existNextPage(lastId);	// 몫만 가져오기
		int existPrevPage = dao.existPrevPage(firstId);	// 몫만 가져오기
		
		int nextPages = Integer.valueOf(existNextPage / 10);
		int prevPages = Integer.valueOf(existPrevPage / 10);
		
		if( existNextPage % 10 != 0 ) { nextPages += 1; }
		if( existPrevPage % 10 != 0 ) { prevPages += 1; }
		
		model.addAttribute("contents" , contents);
		model.addAttribute("nextPages", nextPages);
		model.addAttribute("prevPages", prevPages);
		model.addAttribute("mode", "list");
		
		return "/board/BoardApp";
	}
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String viewContent(Model model, HttpServletRequest request) {
		String failureView = "redirect:/board/list?page="+this.prevPage;
		String successView = "board/BoardApp";
		int contentId = -1;
		
		if( request.getParameter("id") == null ) { return failureView; }

		contentId = Integer.valueOf( request.getParameter("id") );
		model.addAttribute("content", dao.getContent(contentId));
		model.addAttribute("mode", "view");
		return successView;	
	}
	
	@RequestMapping(value="/ajax/comments", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> ajaxTest(HttpServletRequest request) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		if( request.getParameter("id") == null ) {
			map.put("error", "not found id var");
			return map;
		}
		int contentId = Integer.valueOf( request.getParameter("id"));
		ArrayList<CommentVO> comments = cmt.getComments(contentId, 1);
		if( comments.size() == 0 ) {
			map.put("comments", null);
			return map;
		}

		if( comments.size() == 0) { return null; }

		int viewCount = 3;
		
		int firstId = comments.get(0).getNo();
		int lastId = comments.get( comments.size()-1 ).getNo();
		
		int existNextComment = cmt.existNextComment(contentId, lastId);
		int existPrevComment = cmt.existPrevComment(contentId, firstId);
		
		int nextComments = Integer.valueOf( existNextComment / viewCount );
		int prevComments = Integer.valueOf( existPrevComment / viewCount );
		
		if( existNextComment % viewCount != 0 ) { nextComments += 1; }
		if( existPrevComment % viewCount != 0 ) { prevComments += 1; }

		map.put( "comments", comments );
		
		map.put( "nextComments", nextComments );
		map.put( "prevComments", prevComments );
		
		return map;
	}
	
	/**
	 * POST 타입으로 보낸 데이터를 받을 때는 @RequestBody Map<String, Object>가 필요함
	 * 데이터는 주로 JSON 타입으로 보내지고, 보내기 전에 JSON.stringify( data )로 문자열 형식으로 변환시켜서 보내야됨
	 * GET으로 받을 경우에는
	 */
	@RequestMapping(value="/ajax/comment/insert", method = RequestMethod.POST)
	@ResponseBody
	public String insertComment(@RequestBody Map<String, Object> params){
		if( params.get("writer") == null ||
			params.get("password") == null ||
			params.get("date") == null ||
			params.get("comment") == null ||
			params.get("boardNo") == null) {
			return "failure";
		}
		CommentVO comment = new CommentVO(
			(String) params.get("writer"),
			(String) params.get("date"),
			(String) params.get("password"),
			(String) params.get("comment"),
			Integer.parseInt( (String) params.get("boardNo"))
		);
		cmt.insertComment(comment);
		return "success";
	}
	
	
	/**
	 * CURD
	 */
	// 1-1. Write: write-from
	@RequestMapping(value="/write")
	public String viewWritePage(Model model, HttpServletRequest request) {
		String failureView = "";
		String successView = "/board/ContentWrite";
		
		return successView;
	}
	// 1-2. Write: insert
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String doInsertContent(@RequestAttribute ContentVO content) {
		String failureView = "";
		String successView = "";
		
		return successView;
	}
}
