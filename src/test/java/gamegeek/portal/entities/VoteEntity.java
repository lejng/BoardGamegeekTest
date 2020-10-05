package gamegeek.portal.entities;

import base.BaseEntity;

public class VoteEntity extends BaseEntity {
    public String question;
    public int voteCount;

    public VoteEntity(String question, int voteCount) {
        this.question = question;
        this.voteCount = voteCount;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
