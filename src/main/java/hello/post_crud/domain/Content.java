package hello.post_crud.domain;

import hello.post_crud.exception.InvalidContentException;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;

@Embeddable
@Getter
public class Content {

    private static final int MAX_CONTENT_LENGTH = 3000;

    @Column(name = "content", nullable = false)
    @Lob
    private String value;

    protected Content() {

    }

    public Content(String value) {
        validate(value);
        this.value = value;
    }

    private void validate(String value) {
        if (value == null || value.isBlank()) {
            throw new InvalidContentException();
        }
        if (value.length() > MAX_CONTENT_LENGTH) {
            throw new InvalidContentException();
        }
    }

    @Override
    public String toString() {
        return "Content{" +
                "value='" + value + '\'' +
                '}';
    }
}
