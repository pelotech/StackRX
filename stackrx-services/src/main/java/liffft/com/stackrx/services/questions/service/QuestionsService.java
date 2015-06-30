package liffft.com.stackrx.services.questions.service;

import liffft.com.stackrx.services.questions.model.Questions;
import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by pair on 4/6/15.
 */
public interface QuestionsService {
    @GET("/2.2/questions?order=desc&sort=activity&site=stackoverflow")
    Observable<Questions> getQuestionsByPageNumber(@Query("page") String pageNumber);

}
