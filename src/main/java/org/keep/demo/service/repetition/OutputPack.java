package org.keep.demo.service.repetition;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public class OutputPack {

    // Getters and Setters
    private String voiceId;
    private String command;
    private String cmdTurn;
    private String speaker;
    private List<Scene> scene;
    private Map<String, String> keyInfo;
    private List<Ner> ner;
    private List<String> token;
    private int wrongFlag;
    private String time;
    private String cmdTurnSpace;
    private String icaoCode;

    // Scene inner class
    @Setter
    @Getter
    public static class Scene {
        // Getters and Setters
        private int sceneId;
        private String sceneName;
        private String sceneCode;
    }


    // Ner inner class
    @Setter
    @Getter
    public static class Ner {
        // Getters and Setters
        private int strFrom;
        private int strTo;
        private String attr;
        private String entity;
        private String key;
        private List<Integer> sceneId;
        private String originalText;
        private String processingText;

    }
}