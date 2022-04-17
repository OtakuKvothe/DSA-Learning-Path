package Coding_Blox.Users;

import java.util.HashMap;
import java.util.TreeSet;

public class UserRepository {
    private TreeSet<User> usersByScore;
    private HashMap<Integer, User> usersById;
    private HashMap<String, User> usersByName;
    private static Integer userCount = 0;

    public static UserRepository users = new UserRepository();

    private UserRepository() {
        usersByScore = new TreeSet<>((a, b) -> {
            return -Integer.compare(a.getScore(), b.getScore());
        });
        usersById = new HashMap<>();
        usersByName = new HashMap<>();
    }

    private Integer getNewUserId() {
        return ++UserRepository.userCount;
    }

    public Integer getUserCount() {
        return UserRepository.userCount;
    }

    public void createUser(String userName) {
        Integer newUserId = getNewUserId();
        User user = new User(userName, newUserId);
        usersByScore.add(user);
        usersById.put(newUserId, user);
        usersByName.put(userName, user);
    }

    public User getUser(String userName) {
        if (usersByName.containsKey(userName)) {
            return usersByName.get(userName);
        } else {
            return null;
        }
    }

    public User getUser(Integer userId) {
        if (usersById.containsKey(userId)) {
            return usersById.get(userId);
        } else {
            return null;
        }
    }

    public void updateUserScore(Integer userId, Integer score) {
        User user = getUser(userId);
        usersByScore.remove(user);
        user.updateScore(score);
        usersByScore.add(user);
    }
}
