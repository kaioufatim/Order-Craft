package com.joseph.service.Impl;

import com.joseph.entity.Command;
import com.joseph.repository.CommandRepository;
import com.joseph.service.CommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommandServiceImpl implements CommandService {

    @Autowired
    private CommandRepository commandRepository;

    @Override
    public List<Command> getAllCommands() {

        // return commandRepository.findAllWithCustomerAndCommandArticles();
        return commandRepository.findAll();
    }
}
