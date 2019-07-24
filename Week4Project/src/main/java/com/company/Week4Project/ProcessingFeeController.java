package com.company.Week4Project;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@RestController
public class ProcessingFeeController {
    @Autowired
    private Service service;

    @RequestMapping(value = "/processingFee", method = RequestMethod.GET)
    public List<ProcessingFee> getAllProcessingFees(){return service.getAllProcessingFees();}
}
