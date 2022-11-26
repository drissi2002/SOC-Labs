package eni.app.ms_gateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
class CircuitBreakerRestController {
    @GetMapping("/defaultMuslim")
    public Map<String, String> salat() {
        Map<String, String> data = new HashMap<>();
        data.put("message", "Horraire Salat");
        data.put("Fadjer","05:30 AM");
        data.put("Dhor","12:30 AM");
        data.put("Asr","03:30 AM");
        data.put("Maghreb","06:15 PM");
        data.put("isha","08:00 PM");
        return data;
    }
}
