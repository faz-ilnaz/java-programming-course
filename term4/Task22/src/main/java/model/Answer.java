package model;

public class Answer {
    private Long num;
    private String text;
    private boolean correct;


    public Answer(Long num, String text, boolean correct) {
        this.num = num;
        this.text = text;
        this.correct = correct;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "num=" + num +
                ", text='" + text + '\'' +
                ", correct=" + correct +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer answer = (Answer) o;

        if (correct != answer.correct) return false;
        if (!num.equals(answer.num)) return false;
        if (!text.equals(answer.text)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = num.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + (correct ? 1 : 0);
        return result;
    }

    public Answer() {
    }

    public Answer(Long num, String text) {
        this.num = num;
        this.text = text;
    }

    public Long getNum() {
        return num;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
