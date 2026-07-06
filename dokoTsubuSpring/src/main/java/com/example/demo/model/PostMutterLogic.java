package com.example.demo.model;

import org.springframework.stereotype.Service;

import com.example.demo.dao.MutterDAO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostMutterLogic {
	private final MutterDAO mutterDAO;

    public boolean execute(Mutter mutter) {

        return mutterDAO.create(mutter);
    }
}