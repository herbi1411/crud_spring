package hello.post_crud.exception;

public class InvalidTitleException extends RuntimeException {
    // 원래 상속 순서: BadRequestException -> BusinessException -> RuntimeException
    private static final String MESSAGE = "제목은 50자 이하여야 합니다.";

    public InvalidTitleException() {
        super(MESSAGE);
    }
}
