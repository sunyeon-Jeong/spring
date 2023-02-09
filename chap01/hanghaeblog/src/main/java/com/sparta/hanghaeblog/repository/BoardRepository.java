package com.sparta.hanghaeblog.repository;

import com.sparta.hanghaeblog.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board,Long> {
    /**
     * 게시글 등록일 내림차순 정렬
     * @return
     */
    List<Board> findAllByOrderByCreatedAtDesc();
}