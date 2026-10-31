package inheritance_and_polymorphism.class_problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExaminationQuestionGrader {

    abstract static class Question {
        protected final String type;
        protected final String questionText;
        protected final String correctAnswer;
        protected final String studentAnswer;
        protected final double points;

        public Question(String type, String questionText, String correctAnswer, String studentAnswer, double points) {
            this.type = type;
            this.questionText = questionText;
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        public String getType() {
            return type;
        }

        public abstract double evaluate();
    }

    static class McqQuestion extends Question {
        public McqQuestion(String q, String c, String s, double p) {
            super("MCQ", q, c, s, p);
        }

        @Override
        public double evaluate() {
            return studentAnswer.equals(correctAnswer) ? points : 0.0;
        }
    }

    static class TrueFalseQuestion extends Question {
        public TrueFalseQuestion(String q, String c, String s, double p) {
            super("TF", q, c, s, p);
        }

        @Override
        public double evaluate() {
            return studentAnswer.equals(correctAnswer) ? points : 0.0;
        }
    }

    static class EssayQuestion extends Question {
        public EssayQuestion(String q, String c, String s, double p) {
            super("ESSAY", q, c, s, p);
        }

        @Override
        public double evaluate() {
            String[] keywords = correctAnswer.split(",");
            String lowerStudent = studentAnswer.toLowerCase();
            int matchedCount = 0;
            for (String kw : keywords) {
                String cleanKw = kw.trim().toLowerCase();
                if (!cleanKw.isEmpty() && lowerStudent.contains(cleanKw)) {
                    matchedCount++;
                }
            }
            if (matchedCount >= 2) {
                return points * 0.75;
            } else if (matchedCount == 1) {
                return points * 0.50;
            }
            return 0.0;
        }
    }

    private static Question parseLine(String line) {
        int firstSpace = line.indexOf(' ');
        String type = line.substring(0, firstSpace).trim();
        Pattern quotedPattern = Pattern.compile("\"([^\"]*)\"");
        Matcher matcher = quotedPattern.matcher(line);
        List<String> quoted = new ArrayList<>();
        int lastEnd = 0;
        while (matcher.find()) {
            quoted.add(matcher.group(1));
            lastEnd = matcher.end();
        }
        double points = Double.parseDouble(line.substring(lastEnd).trim());
        switch (type) {
            case "MCQ":
                return new McqQuestion(quoted.get(0), quoted.get(1), quoted.get(2), points);
            case "TF":
                return new TrueFalseQuestion(quoted.get(0), quoted.get(1), quoted.get(2), points);
            default:
                return new EssayQuestion(quoted.get(0), quoted.get(1), quoted.get(2), points);
        }
    }

    public static void main(String[] args) {
        String sampleInput = "4\n"
                + "MCQ \"What is the capital of France?\" \"Paris\" \"Paris\" 10\n"
                + "TF \"The Earth is flat?\" \"False\" \"True\" 5\n"
                + "ESSAY \"Name two primary OOP principles.\" \"Inheritance, Polymorphism, Encapsulation\" \"Polymorphism is one.\" 20\n"
                + "ESSAY \"Describe abstraction and composition.\" \"Abstraction, Composition\" \"I talked about abstraction.\" 15\n";
        Scanner sc = (args.length > 0 && "--stdin".equals(args[0]))
                ? new Scanner(System.in)
                : new Scanner(sampleInput);

        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            questions.add(parseLine(sc.nextLine().trim()));
        }

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluate();
            totalScore += score;
            System.out.printf("%s: %.2f%n", q.getType(), score);
        }
        System.out.printf("Total Score: %.2f%n", totalScore);
    }
}
