package co.gov.heqc.healthcite.controllers;

import co.gov.heqc.healthcite.dto.request.EpsRequestDto;
import co.gov.heqc.healthcite.dto.response.EpsResponseDto;
import co.gov.heqc.healthcite.services.EpsService;
import co.gov.heqc.healthcite.utils.constants.EpsConstants;
import co.gov.heqc.healthcite.utils.constants.GlobalConstants;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/eps")
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequiredArgsConstructor
public class EpsController {

    private final EpsService epsService;

    @Secured({"ADMIN"})
    @PostMapping("/")
    public ResponseEntity<Map<String, String>> createEps(@Valid @RequestBody
                                                                 EpsRequestDto epsRequest) {
        epsService.createEps(epsRequest);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Collections.singletonMap(
                        GlobalConstants.RESPONSE_MESSAGE_KEY,
                        EpsConstants.EPS_CREATED_MESSAGE
                ));
    }

    @Secured({"ADMIN", "DOCTOR"})
    @GetMapping("/{id}")
    public ResponseEntity<EpsResponseDto> getEpsById(@PathVariable Long id) {
        return ResponseEntity.ok(epsService.getEpsById(id));
    }

    @Secured({"ADMIN", "DOCTOR"})
    @GetMapping("/nit/")
    public ResponseEntity<EpsResponseDto> getEpsByNit(@RequestParam String nit) {
        return ResponseEntity.ok(epsService.getEpsByNit(nit));
    }

    @Secured({"ADMIN", "DOCTOR"})
    @GetMapping("/")
    public ResponseEntity<List<EpsResponseDto>> getAllEps() {
        return ResponseEntity.ok(epsService.getAllEps());
    }


}
