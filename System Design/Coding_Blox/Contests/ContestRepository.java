package Coding_Blox.Contests;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Coding_Blox.Difficulty.Difficulty;
import Coding_Blox.Users.User;
import Coding_Blox.Users.UserRepository;

public class ContestRepository {
    private HashMap<Difficulty, ArrayList<Contest>> contestsByDifficulty;
    private HashMap<Integer, Contest> contestsById;
    private HashMap<Integer, ArrayList<User>> contestAttendants;
    private static Integer contestCount = 0;

    public static ContestRepository contests = new ContestRepository();

    private ContestRepository() {
        contestsByDifficulty = new HashMap<>();
        contestsByDifficulty.put(Difficulty.HIGH, new ArrayList<>());
        contestsByDifficulty.put(Difficulty.MEDIUM, new ArrayList<>());
        contestsByDifficulty.put(Difficulty.LOW, new ArrayList<>());
        contestsById = new HashMap<>();;
    }

    private Integer getNewContestId() {
        return ++ContestRepository.contestCount;
    }

    public Integer getContestCount() {
        return ContestRepository.contestCount;
    }

    public void createContest(String contestName, Difficulty difficulty, String creatorUserName) {
        Integer newContestId = getNewContestId();
        Contest contest = new Contest(newContestId , contestName, difficulty, creatorUserName);
        contestAttendants.put(newContestId, new ArrayList<>());
        contestsByDifficulty.get(difficulty).add(contest);
        contestsById.put(newContestId, contest);
    }

    public void listContest(Difficulty difficulty) {
        if(difficulty != null) {
            for(Contest q: contestsByDifficulty.get(difficulty)) {
                System.out.println("Id: "+q.getId()+"\tDifficulty: "+q.getDifficulty()+"\tName: "+q.getContestName()+"\tCreator Name: "+q.getCreatorUsername());
            }
        } else {
            for(Map.Entry<Integer, Contest> entry: contestsById.entrySet()) {
                Contest q = entry.getValue();
                System.out.println("Id: "+q.getId()+"\tDifficulty: "+q.getDifficulty()+"\tName: "+q.getContestName()+"\tCreator Name: "+q.getCreatorUsername());
            }
        }
    }

    public void attendContest(Integer contestId, String userName) {
        User user = UserRepository.users.getUser(userName);
        if(user != null) {
            contestAttendants.get(contestId).add(user);
        } else {
            System.out.println("User does not exist.");
        }
    }

    public Boolean validateContest(Integer contestId) {
        return contestsById.containsKey(contestId);
    }

    public ArrayList<User> getContestAttendees(Integer contestId) {
        return contestAttendants.get(contestId);
    }
}
