package com.gdu.app00.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.gdu.app00.domain.BoardDTO;

@Service
public class BoardServiceImpl implements BoardService {

	@Override
	public List<BoardDTO> getBoardList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BoardDTO getBoardByNo(int board_no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int modifiedBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int removeBoard(BoardDTO board) {
		// TODO Auto-generated method stub
		return 0;
	}

}
