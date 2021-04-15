package org.zerock.guestbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.zerock.guestbook.entity.Guestbook2;

public interface GuestbookRepository1 extends JpaRepository<Guestbook2, Long>
, QuerydslPredicateExecutor<Guestbook2>{

}
