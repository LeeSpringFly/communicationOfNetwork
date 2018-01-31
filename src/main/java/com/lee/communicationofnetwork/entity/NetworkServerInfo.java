package com.lee.communicationofnetwork.entity;

public class NetworkServerInfo {
    private Long id;
    private Integer port;

    public NetworkServerInfo() {
        this(1L, 8888);
    }

    public NetworkServerInfo(long id, int port) {
        this.id = id;
        this.port = port;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
