public class card {
    private String term;
    private String definition;
    private String answer;
    public card(String name, String definition) {
        this.term = name;
        this.definition = definition;
    }
    public String getTerm() {
        return term;
    }
    public String getDefinition() {
        return definition;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    public String getAnswer() {
        return answer;
    }
}
