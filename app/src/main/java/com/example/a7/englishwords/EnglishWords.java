package com.example.a7.englishwords;

public class EnglishWords {

    private String infinitive;
    private String pastSimple;
    private String pastParticular;

    public EnglishWords(String infinitive, String pastSimple, String pastParticular) {
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticular = pastParticular;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public String getPastParticular() {
        return pastParticular;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public void setPastParticular(String pastParticular) {
        this.pastParticular = pastParticular;
    }
}
