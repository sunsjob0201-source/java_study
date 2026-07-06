package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MutterDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetMutterListService {

    private final MutterDAO mutterDAO;

    public List<Mutter> execute() {
        return mutterDAO.findAll();
    }
}