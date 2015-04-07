package liffft.com.stackrx.services.answers.service;

import liffft.com.stackrx.services.answers.model.Answers;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface AnswerService {
    @GET("/2.2/questions/{questionId}/answers?order=desc&sort=activity")
    Observable<Answers> getAnswers(@Path("questionId") String questionId);

}
