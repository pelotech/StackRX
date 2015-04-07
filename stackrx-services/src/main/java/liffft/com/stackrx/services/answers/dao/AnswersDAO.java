package liffft.com.stackrx.services.answers.dao;

import com.google.inject.Inject;

import liffft.com.stackrx.services.answers.model.Answers;
import liffft.com.stackrx.services.answers.service.AnswerService;
import liffft.com.stackrx.services.base.BaseService;
import liffft.com.stackrx.services.base.ServiceEnvironment;
import rx.Observable;

public class AnswersDAO extends BaseService<AnswerService>{

    /**
     * Setup retrofit with the correct parameters from the environment.
     *
     * @param serviceEnvironment     environment parameters
     */
    @Inject
    public AnswersDAO(ServiceEnvironment serviceEnvironment) {
        super(AnswerService.class, serviceEnvironment.getSecureParameters());
    }

    /**
     * GET list of questions
     * @return List of questions
     */
    public Observable<Answers> getAnswersBasedOnQuestionId(String questionId) {
        return API().getAnswers(questionId);
    }


}
