package application.dtos.response;

import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;

@NoArgsConstructor
public class DetailedResponse {
    public long time;
    public int code;
    public Object response;

    public DetailedResponse(ResponseEntity res, long start) {
        this.response = res.getBody();
        this.time = System.currentTimeMillis() - start;
        this.code = res.getStatusCodeValue();
    }
}
