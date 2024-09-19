package com.bit.boardappbackend.service.impl;

import com.bit.boardappbackend.common.FileUtils;
import com.bit.boardappbackend.dto.BoardDto;
import com.bit.boardappbackend.dto.BoardFileDto;
import com.bit.boardappbackend.entity.Board;
import com.bit.boardappbackend.entity.Member;
import com.bit.boardappbackend.repository.BoardFileRepository;
import com.bit.boardappbackend.repository.BoardRepository;
import com.bit.boardappbackend.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardRepository boardRepository;
    private final BoardFileRepository boardFileRepository;
    private final FileUtils fileUtils;

    @Override
    public List<BoardDto> post(BoardDto boardDto, MultipartFile[] uploadFiles, Member member) {
        boardDto.setRegdate(LocalDateTime.now());
        boardDto.setModdate(LocalDateTime.now());

        Board board = boardDto.toEntity(member);

        if (uploadFiles != null) {
            Arrays.stream(uploadFiles).forEach(multipartFile -> {
                if(multipartFile.getOriginalFilename() != null &&
                    !multipartFile.getOriginalFilename().equalsIgnoreCase("")) {

                    BoardFileDto boardFileDto = fileUtils.parserFileInfo(multipartFile, "board/");

                    board.getBoardFileList().add(boardFileDto.toEntity(board));
                }
            });
        }

        boardRepository.save(board);

        return boardRepository.findAll().stream().map(Board::toDto).toList();
    }

    @Override
    public Page<BoardDto> findAll(String searchCondition, String searchKeyword, Pageable pageable) {
        return boardRepository
                .searchAll(searchCondition, searchKeyword, pageable)
                .map(Board::toDto);
    }
}
