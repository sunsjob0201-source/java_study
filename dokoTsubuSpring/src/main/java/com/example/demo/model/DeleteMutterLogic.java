package com.example.demo.model;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MutterDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeleteMutterLogic {

    private final MutterDAO mutterDAO;

    public boolean execute(int id, int userID) {
        return mutterDAO.delete(id, userID);
    }
}