package Coding_Blox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class QuestionsRepository {
    private HashMap<Difficulty, ArrayList<Question>> questionsByDifficulty;
    private TreeMap<Integer, Question> questionsById;
    private static Integer questionCount = 0;

    public QuestionsRepository() {
        questionsByDifficulty = new HashMap<>();
        questionsByDifficulty.put(Difficulty.HIGH, new ArrayList<>());
        questionsByDifficulty.put(Difficulty.MEDIUM, new ArrayList<>());
        questionsByDifficulty.put(Difficulty.LOW, new ArrayList<>());
        questionsById = new TreeMap<>();
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
        if(difficulty != null) {
            for(Question q: questionsByDifficulty.get(difficulty)) {
                System.out.println("Id: "+q.getId()+"\tDifficulty: "+q.getDifficulty()+"\tScore: "+q.getScore());
            }
        } else {
            for(Map.Entry<Integer, Question> entry: questionsById.entrySet()) {
                Question q = entry.getValue();
                System.out.println("Id: "+q.getId()+"\tDifficulty: "+q.getDifficulty()+"\tScore: "+q.getScore());
            }
        }
    }
}
