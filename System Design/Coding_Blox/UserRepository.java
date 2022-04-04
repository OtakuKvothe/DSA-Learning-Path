package Coding_Blox;

import java.util.HashMap;
import java.util.TreeSet;

public class UserRepository {
    private TreeSet<User> usersByScore;
    private HashMap<Integer, User> usersById;
    private static Integer userCount = 0;

    public UserRepository() {
        usersByScore = new TreeSet<>((a, b) -> {
            return -Integer.compare(a.getScore(), b.getScore());
        });
        usersById = new HashMap<>();
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
    }
}
