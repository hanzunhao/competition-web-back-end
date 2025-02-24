package cn.edu.usst.competitionweb.service;


import cn.edu.usst.competitionweb.pojo.DeepSeekAnswer;

public interface DeepSeekService {
    DeepSeekAnswer chat(String question);
}
