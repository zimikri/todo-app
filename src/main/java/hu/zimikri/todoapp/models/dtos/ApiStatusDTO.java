package hu.zimikri.todoapp.models.dtos;

public class ApiStatusDTO {
    private String status = "error";
    private String message;

    public ApiStatusDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    public static ApiStatusDTO ok(String message) {
        return new ApiStatusDTO("ok", message);
    }

    public static ApiStatusDTO error(String message) {
        return new ApiStatusDTO("error", message);
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
