package hu.zimikri.todoapp.models;

public class ApiStatusDto {
    private String status = "error";
    private String message;

    public ApiStatusDto(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ApiStatusDto ok(String message) {
        return new ApiStatusDto("ok", message);
    }

    public static ApiStatusDto error(String message) {
        return new ApiStatusDto("error", message);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
