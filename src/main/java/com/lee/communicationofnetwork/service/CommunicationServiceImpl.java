package com.lee.communicationofnetwork.service;

import com.lee.communicationofnetwork.entity.NetworkServerInfo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class CommunicationServiceImpl extends NetworkServer implements CommunicationService {

    @Override
    public void start(NetworkServerInfo networkServerInfo) throws Exception {
        run(networkServerInfo.getPort());
    }

    @Override
    public void restart(NetworkServerInfo networkServerInfo) throws Exception {
        close();
        run(networkServerInfo.getPort());
    }

    @Override
    public void close() {
        System.out.println("close");
        super.close();
        System.out.println("close 2");
    }
}
