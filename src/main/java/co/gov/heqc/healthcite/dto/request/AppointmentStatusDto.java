package co.gov.heqc.healthcite.dto.request;

public class AppointmentStatusDto {

    private String status;

    public AppointmentStatusDto() {}

    public AppointmentStatusDto(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
