package org.zerock.guestbook.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString(exclude = "writer1")
public class Board2 extends BaseEntity {
		

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno1;

	
	private String title1;


	private String content1;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Member1 writer1;

	public void changeTitle(String title1) {
		this.title1 = title1;
	}

	public void changeContent(String content1) {
		this.content1 = content1;
	}
}   