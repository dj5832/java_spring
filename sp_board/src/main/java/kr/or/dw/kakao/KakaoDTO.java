package kr.or.dw.kakao;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class KakaoDTO {

    private long id;
    private String email;
    private String nickname;
    
}