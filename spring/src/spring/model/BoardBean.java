package spring.model;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import spring.model.service.BoardDaoService;
import spring.model.service.BoardDataBean;

@Controller
@RequestMapping("/board/")
public class BoardBean {

	@Autowired
	private BoardDaoService boardDAO = null;

	@RequestMapping("list.do")
	public String list(@RequestParam(defaultValue = "1", required = true) int pageNum, Model model) throws Exception {

		/*
		 * if (pageNum == 0) { pageNum = 1; }
		 */
		int pageSize = 10;// 한 페이지의 글의 개수
		int currentPage = pageNum;
		int startRow = (currentPage - 1) * pageSize + 1;// 한 페이지의 시작글 번호
		int endRow = currentPage * pageSize;// 한 페이지의 마지막 글번호
		int count = 0;
		int number = 0;

		List articleList = null;
		count = boardDAO.getArticleCount();// 전체 글의 수

		if (count > 0) {
			articleList = boardDAO.getArticles(startRow, endRow);// 현재 페이지에 해당하는 글 목록
		} else {
			articleList = Collections.EMPTY_LIST;
		}

		number = count - (currentPage - 1) * pageSize;// 글목록에 표시할 글번호
		// 해당 뷰에서 사용할 속성
		model.addAttribute("currentPage", new Integer(currentPage));
		model.addAttribute("startRow", new Integer(startRow));
		model.addAttribute("endRow", new Integer(endRow));
		model.addAttribute("count", new Integer(count));
		model.addAttribute("pageSize", new Integer(pageSize));
		model.addAttribute("number", new Integer(number));
		model.addAttribute("articleList", articleList);
		return "board/list";
	}

	@RequestMapping("writeForm.do")
	public String writeForm(BoardDataBean dto, Model model) throws Exception {

		model.addAttribute("dto", dto);
		return "board/writeForm";
	}

	@RequestMapping("writePro.do")
	public String writePro(BoardDataBean dto, HttpServletRequest request) throws Exception {
		dto.setIp(request.getLocalAddr());
		boardDAO.insertArticle(dto);
		return "board/writePro";
	}


	@RequestMapping("content.do") 
	public String content(int num, int pageNum,Model model) throws Exception { 
	
		BoardDataBean article = boardDAO.getArticle(num);// 해당 글번호에 대한 해당 레코드
	 
	 // 해당 뷰에서 사용할 속성 
	model.addAttribute("num", new Integer(num));
	model.addAttribute("pageNum", new Integer(pageNum));
	model.addAttribute("article", article); return "board/content"; 
	

	}

}
