package Coding_Blox.CommandUtil;

import Coding_Blox.Difficulty.Difficulty;
import Coding_Blox.Questions.QuestionsRepository;
import Coding_Blox.Users.UserRepository;
import Coding_Blox.Contests.ContestRepository;

public class CommandUtil {

    public void parseCommand(String command) {
        String[] commands = command.split(" ");
        if (commands.length == 0) {
            System.out.println("Command not recognised!");
            return;
        }
        switch (commands[0]) {
            case "CreateUser":
                handleCreateUser(commands);
                break;
            case "CreateQuestion":
                handleCreateQuestion(commands);
                break;
            case "ListQuestion":
                handleListQuestion(commands);
                break;
            default:
                return;
        }
    }

    private void handleCreateUser(String[] commands) {
        if (commands.length != 2) {
            Print.print("Use command template CreateUser <user_name> to create new user.");
        } else {
            UserRepository.users.createUser(commands[1]);
        }
    }

    private void handleCreateQuestion(String[] commands) {
        if (commands.length != 3) {
            Print.print("Use command template CreateQuestion <difficulty_level> <score> to create new question.");
        } else {
            Difficulty difficulty = parseDifficulty(commands[1]);
            if (difficulty != null) {
                Integer score = validatedScore(commands[2]);
                if (score != null) {
                    QuestionsRepository.questions.createQuestion(difficulty, score);
                }
            }
        }
    }

    private void handleListQuestion(String[] commands) {
        if (commands.length != 2) {
            Print.print("Use command template ListQuestion <difficulty_level> to list questions.");
        } else {
            Difficulty difficulty = parseDifficulty(commands[1]);
            if (difficulty != null) {
                QuestionsRepository.questions.listQuestions(difficulty);
            }
        }
    }

    

    //Common functions

    private Difficulty parseDifficulty(String term) {
        switch (term) {
            case "HIGH":
                return Difficulty.HIGH;
            case "LOW":
                return Difficulty.LOW;
            case "MEDIUM":
                return Difficulty.MEDIUM;
            default:
                Print.print("Invalid difficulty");
                return null;
        }
    }

    private Integer validatedScore(String score) {
        try {
            return Integer.parseInt(score);
        } catch (NumberFormatException e) {
            Print.print("Score must be numeric.");
            return null;
        }
    }
}
