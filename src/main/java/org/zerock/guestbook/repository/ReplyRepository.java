package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Reply1;

public interface ReplyRepository extends JpaRepository<Reply1, Long>
, QuerydslPredicateExecutor<Reply1>{

}