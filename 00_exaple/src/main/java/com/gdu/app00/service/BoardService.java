package com.gdu.app00.service;

import java.util.List;

import com.gdu.app00.domain.BoardDTO;

public interface BoardService {

	public List<BoardDTO> getBoardList();
	public BoardDTO getBoardByNo (int board_no);
	public int addBoard(BoardDTO board);
	public int modifiedBoard(BoardDTO board);
	public int removeBoard(BoardDTO board);
	
	
}
