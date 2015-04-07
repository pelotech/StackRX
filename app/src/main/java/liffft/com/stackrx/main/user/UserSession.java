package liffft.com.stackrx.main.user;

import com.google.inject.Singleton;

import liffft.com.stackrx.services.questions.model.Item;
import liffft.com.stackrx.services.questions.model.Questions;

/**
 * Created by graemeharnish on 4/7/15.
 */
@Singleton
public class UserSession {
    private Questions mQuestions;
    private Item mSelectedQuestion;

    public Questions getQuestions() {
        return mQuestions;
    }

    public void setQuestions(Questions questions) {
        mQuestions = questions;
    }

    public Item getSelectedQuestion() {
        return mSelectedQuestion;
    }

    public void setSelectedQuestion(Item selectedQuestion) {
        mSelectedQuestion = selectedQuestion;
    }
}
