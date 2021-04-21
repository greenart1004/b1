package org.zerock.guestbook.entity;

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
public class Board1 extends BaseEntity {
		

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long gno1;

	@Column(length = 100, nullable = false)
	private String title1;

	@Column(length = 1500, nullable = false)
	private String content1;

	@ManyToOne(fetch = FetchType.LAZY)
	private Member1 writer1;

	public void changeTitle(String title) {
		this.title1 = title;
	}

	public void changeContent(String content) {
		this.content1 = content;
	}
}   