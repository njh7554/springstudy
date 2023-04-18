package com.jdu.app04.controller; // 서비스를 가져다 쓰는건 controller

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jdu.app04.domain.BoardDTO;
import com.jdu.app04.service.BoardService;

@RequestMapping("/board") // /board/list.do앞에 중복되는 /board같은건 컨트롤러 위에 설정해주면 된다.(중간매핑)
@Controller				  // 모든 mapping에 /board가 prefix로 추가됩니다.(별도의 컨트롤러로 빼준거다.
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	@GetMapping("/list.do")
	public String list(Model model) {  // Model : jsp로 전달(forward)할 데이터(속성, attribute)를 저장한다.
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/list";
	}
	
	@GetMapping("/write.do")
	public String write() {
		return "board/write";
	}
	
	@PostMapping("/add.do")
	public String add(BoardDTO board) {
		boardService.addBoard(board);      // addBoard() 메소드의 호출 결과인 int 값(0 또는 1)은 사용하지 않았다.
		return "redirect:/board/list.do";  // 목록 보기로 redirect(redirect 경로는 항상 mapping으로 작성한다.)
	}
	
	@GetMapping("/detail.do")
	public String detail(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no
						, Model model) {
		model.addAttribute("b", boardService.getBoardByNo(board_no));
		return "board/detail";
	}
	
	@GetMapping("/remove.do")
	public String remove(@RequestParam(value="board_no", required=false, defaultValue="0") int board_no) {
		boardService.removeBoard(board_no);
		return "redirect:/board/list.do";
	}
	
	@PostMapping("/modify.do")
	public String modify(BoardDTO board) {
		boardService.modifyBoard(board);
		return "redirect:/board/detail.do?board_no=" + board.getBoard_no();
	}
	
	
}
