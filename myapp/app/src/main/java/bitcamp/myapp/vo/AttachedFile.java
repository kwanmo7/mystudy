package bitcamp.myapp.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // Mybatis 에서 사용할 기본 생성자를 만들어야 함
@AllArgsConstructor // 모든 field 값을 담을 생성자를 생성해 줌 , Builder를 사용할때 같이 사용해 줘야함
@Builder
@Data
public class AttachedFile {

  private int no;
  private String filePath;
  private int boardNo;

}
