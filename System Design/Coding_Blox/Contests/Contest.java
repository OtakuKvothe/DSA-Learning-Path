package Coding_Blox.Contests;

import Coding_Blox.Difficulty.Difficulty;

public class Contest {
    private Integer id;
    private String contestName;
    private String creatorUsername;
    private Difficulty difficulty;

    public Contest(Integer id, String contestName, Difficulty difficulty, String creatorUserName) {
        this.id = id;
        this.contestName = contestName;
        this.difficulty = difficulty;
        this.creatorUsername = creatorUserName;
    }

    public Integer getId() {
        return id;
    }
    
    public String getContestName() {
        return contestName;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getCreatorUsername() {
        return creatorUsername;
    }
}
