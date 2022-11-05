package hello.post_crud.domain;

import hello.post_crud.exception.InvalidTitleException;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Title {

    private static final int MAX_TITLE_LENGTH = 50;

    @Column(name = "title", nullable = false)
    private String value;

    protected Title () {
        // 기본 Constructor를 선언하지 않으면 에러 발생
    }

    public Title(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidTitleException();
        }
        if (value.length() > MAX_TITLE_LENGTH) {
            throw new InvalidTitleException();
        }
    }

    @Override
    public String toString() {
        return "Title{" +
                "value='" + value + '\'' +
                '}';
    }
}
