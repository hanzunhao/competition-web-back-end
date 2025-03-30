package cn.edu.usst.competitionweb.service;

import java.io.IOException;

public interface WsService {
    void send(String sessionType, String text) throws IOException;

    void broadcast(String text) throws IOException;
}
