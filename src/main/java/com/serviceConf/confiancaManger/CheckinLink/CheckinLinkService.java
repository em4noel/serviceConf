package com.serviceConf.confiancaManger.CheckinLink;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckinLinkService {
    @Autowired
    private CheckinLinkRepository checkinLinkRepository;

    public List<CheckinLink> findAll(CheckinLink filter) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<CheckinLink> example = Example.of(filter, matcher);
        return checkinLinkRepository.findAll(example);
    }
}
