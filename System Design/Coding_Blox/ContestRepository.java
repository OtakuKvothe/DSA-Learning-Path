package Coding_Blox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ContestRepository {
    private HashMap<Difficulty, ArrayList<Contest>> contestsByDifficulty;
    private TreeMap<Integer, Contest> contestsById;
    private static Integer contestCount = 0;

    public ContestRepository() {
        contestsByDifficulty = new HashMap<>();
        contestsByDifficulty.put(Difficulty.HIGH, new ArrayList<>());
        contestsByDifficulty.put(Difficulty.MEDIUM, new ArrayList<>());
        contestsByDifficulty.put(Difficulty.LOW, new ArrayList<>());
        contestsById = new TreeMap<>();
    }

    private Integer getNewContestId() {
        return ++ContestRepository.contestCount;
    }

    public Integer getContestCount() {
        return ContestRepository.contestCount;
    }

    public void createContest(String contestName, Difficulty difficulty, String creatorUserName) {
        Integer newContestId = getNewContestId();
        Contest contest = new Contest(contestName, difficulty, creatorUserName);
    }
}
