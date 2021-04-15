package org.zerock.guestbook.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class GuestbookDTO {     // DTO를 Entity로 변환을 위한 그릇

    private Long gno;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime regDate, modDate;
}
