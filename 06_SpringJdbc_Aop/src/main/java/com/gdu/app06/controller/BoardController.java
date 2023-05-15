package com.gdu.app06.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gdu.app06.domain.BoardDTO;
import com.gdu.app06.service.BoardService;

@RequestMapping("/board")
@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	// ParameterCheckAOP에 의해서 파라미터 체크할 메소드의 이름은 모두 ParamCheck로 끝난다.
	
	@GetMapping("/list.do")
	public String list(Model model) {
		model.addAttribute("board", boardService.getBoardList());
		return "board/list";
	}
	
	@GetMapping("write.do")
	public String write() {
		return "board/write";
	}	
	
	@PostMapping("/add.do")
	public String addParamCheck(BoardDTO board) {
		boardService.add(board);
		System.out.println("작성완료");
		return "redirect:/board/list.do";
	}
	
	@GetMapping("/detail.do")
	public String detailParamCheck(@RequestParam("board_no") int board_no, Model model) {
		model.addAttribute("board", boardService.getBoardByNo(board_no));
		return "board/detail";
	}
	
	@GetMapping("/remove.do")
	public String removeParamCheck(@RequestParam("board_no") int board_no) {
		boardService.removeBoard(board_no);
		return "redirect:/board/list.do";
	}
	@PostMapping("/edit.do")
	public String edit(@ModelAttribute("board") BoardDTO boardDTO) {
		return "board/edit";
	}
	@GetMapping("/modify.do")
		public String modify(BoardDTO boardDTO) {
			boardService.modifyBoard(boardDTO);
			return "redirect:/board/detail.do?board_no=" + boardDTO.getBoard_no();
		}
	
	// 트랜잭션 처리 확인을 위한 testTx()메소드 호출하기
	@GetMapping("/tx.do") // http://localhost:9090/app06/board/tx.do
	public String tx() {
		boardService.testTx();
		return "redirect:/board/list.do";
	}
	
}
