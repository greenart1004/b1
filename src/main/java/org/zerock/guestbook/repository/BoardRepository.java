package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Board1;


public interface BoardRepository extends JpaRepository<Board1, Long>
, QuerydslPredicateExecutor<Board1>{

}