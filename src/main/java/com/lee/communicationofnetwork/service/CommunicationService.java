package com.lee.communicationofnetwork.service;

import com.lee.communicationofnetwork.entity.NetworkServerInfo;

public interface CommunicationService {
    void start(NetworkServerInfo networkServerInfo) throws Exception;
    void restart(NetworkServerInfo networkServerInfo) throws Exception;
    void close();
}
