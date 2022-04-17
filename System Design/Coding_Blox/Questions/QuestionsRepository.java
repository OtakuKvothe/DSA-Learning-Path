package Coding_Blox.Questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Coding_Blox.Difficulty.Difficulty;

public class QuestionsRepository {
    private HashMap<Difficulty, ArrayList<Question>> questionsByDifficulty;
    private HashMap<Integer, Question> questionsById;
    private static Integer questionCount = 0;

    public static QuestionsRepository questions = new QuestionsRepository();

    private QuestionsRepository() {
        questionsByDifficulty = new HashMap<>();
        questionsByDifficulty.put(Difficulty.HIGH, new ArrayList<>());
        questionsByDifficulty.put(Difficulty.MEDIUM, new ArrayList<>());
        questionsByDifficulty.put(Difficulty.LOW, new ArrayList<>());
        questionsById = new HashMap<>();
    }

    public Integer getQuestionCount() {
        return QuestionsRepository.questionCount;
    }

    private Integer getNewQuestionId() {
        return ++QuestionsRepository.questionCount;
    }

    public void createQuestion(Difficulty difficulty, Integer score) {
        Integer newQuestionId = getNewQuestionId();
        Question question = new Question(difficulty, score, newQuestionId);
        questionsByDifficulty.get(difficulty).add(question);
        questionsById.put(newQuestionId, question);
    }

    public void listQuestions(Difficulty difficulty) {
        if (difficulty != null) {
            for (Question q : questionsByDifficulty.get(difficulty)) {
                System.out.println(
                        "Id: " + q.getId() + "\tDifficulty: " + q.getDifficulty() + "\tScore: " + q.getScore());
            }
        } else {
            for (Map.Entry<Integer, Question> entry : questionsById.entrySet()) {
                Question q = entry.getValue();
                System.out.println(
                        "Id: " + q.getId() + "\tDifficulty: " + q.getDifficulty() + "\tScore: " + q.getScore());
            }
        }
    }

    public ArrayList<Question> getQuestions(Difficulty difficulty) {
        return questionsByDifficulty.get(difficulty);
    }
}
