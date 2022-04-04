package Coding_Blox;

public class Question {
    private Difficulty difficulty;
    private Integer id;
    private Integer score;

    public Question(Difficulty difficulty, Integer score, Integer id) {
        this.difficulty = difficulty;
        this.score = score;
        this.id = id;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public Integer getId() {
        return id;
    }

    public Integer getScore() {
        return score;
    }
}
