package org.zerock.guestbook.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Board2;
import org.zerock.guestbook.entity.Reply1;


public interface ReplyRepository extends JpaRepository<Reply1, Long>
, QuerydslPredicateExecutor<Reply1>{

	
//	@Modifying                                              // delete/update에 @Modifying 사용한다       
//	@Query("delete from Reply1 r where r.Reply1.rno1 =:rno1")   // 한번에 댓글 다 삭제???
//	void deleteByRno1(Long Rno1);
//	
//    List<Reply1> getRepliesByBoardOrderByRno(Board2 board);
}