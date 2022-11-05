package hello.post_crud.exception;

public class InvalidContentException extends RuntimeException {
    // 원래 상속 순서: BadRequestException -> BusinessException -> RuntimeException
    private static final String MESSAGE = "본문은 3000자 이하여야 합니다.";

    public InvalidContentException() {
        super(MESSAGE);
    }
}
