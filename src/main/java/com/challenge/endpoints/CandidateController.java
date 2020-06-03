package com.challenge.endpoints;


import com.challenge.dto.CandidateDTO;
import com.challenge.entity.Candidate;
import com.challenge.mappers.CandidateMapper;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{companyId}/{accelerationId}")
    public ResponseEntity<CandidateDTO> findById(@PathVariable Long userId,
                                                 @PathVariable Long companyId,
                                                 @PathVariable Long accelerationId){

        return ResponseEntity.ok(candidateService.findById(userId, companyId, accelerationId)
                .map(candidateMapper::map)
                .orElseGet(CandidateDTO::new));
    }

    @GetMapping(params = "companyId")
    public ResponseEntity<List<CandidateDTO>> findByCompanyId(@RequestParam(required = false) Long companyId){
        if (companyId != null){
            return ResponseEntity.ok(candidateMapper.map(candidateService.findByCompanyId(companyId)));
        }

        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }

    @GetMapping(params = "accelerationId")
    public ResponseEntity<List<CandidateDTO>> findByAccelerationId(
            @RequestParam(required = false) Long accelerationId){

        if (accelerationId != null){
            return ResponseEntity.ok(candidateMapper.map(candidateService.findByAccelerationId(accelerationId)));
        }

        return new ResponseEntity<>(Collections.emptyList(), HttpStatus.NOT_FOUND);
    }


}
