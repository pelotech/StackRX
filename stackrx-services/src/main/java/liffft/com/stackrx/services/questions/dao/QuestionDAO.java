package liffft.com.stackrx.services.questions.dao;

import liffft.com.stackrx.services.base.BaseService;
import liffft.com.stackrx.services.base.ServiceParameters;
import liffft.com.stackrx.services.questions.service.QuestionsService;

/**
 * Created by pair on 4/6/15.
 */
public class QuestionDAO extends BaseService<QuestionsService> {
    /**
     * Setup retrofit with the correct parameters from the environment.
     *
     * @param interfaceClass retrofit interface to different REST endpoints
     * @param parameters     environment parameters
     */
    public QuestionDAO(Class<QuestionsService> interfaceClass, ServiceParameters parameters) {
        super(interfaceClass, parameters);
    }


}
