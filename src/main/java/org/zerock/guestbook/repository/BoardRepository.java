package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Board2;


public interface BoardRepository extends JpaRepository<Board2, Long>
, QuerydslPredicateExecutor<Board2>{

}