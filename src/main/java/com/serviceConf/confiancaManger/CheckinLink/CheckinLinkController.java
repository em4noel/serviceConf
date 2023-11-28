package com.serviceConf.confiancaManger.CheckinLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/checkinLink")
public class CheckinLinkController {
    @Autowired
    private CheckinLinkService checkinLinkService;
    @GetMapping
    public List<CheckinLink> findAll(CheckinLink checkinLink){
        return checkinLinkService.findAll(checkinLink);
    }
}
