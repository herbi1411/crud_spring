package hello.post_crud.dto;
import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewPostRequest {
    @NotBlank(message = "제목은 50자 이하여야 합니다.")
    private String title;
    @NotBlank(message = "본문은 3000자 이하여야 합니다.")
    private String content;

//    public NewPostRequest() {
//    }
//
//    public NewPostRequest(String title, String content) {
//        this.title = title;
//        this.content = content;
//    }

    @Override
    public String toString() {
        return "NewPostRequest{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
