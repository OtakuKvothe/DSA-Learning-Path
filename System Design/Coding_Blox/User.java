package Coding_Blox;

public class User {    
    private String userName;
    private Integer userId;
    private Integer score;

    public User(String userName, Integer userId) {
        this.userName = userName;
        this.userId = userId;
        this.score = 1500;
    }

    public String getUserName() {
        return userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
