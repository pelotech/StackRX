package liffft.com.stackrx.questions.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.inject.Inject;

import liffft.com.stackrx.R;
import liffft.com.stackrx.main.fragment.StackRXBaseFragmemt;
import liffft.com.stackrx.main.user.UserSession;
import liffft.com.stackrx.questions.adapter.QuestionRecyclerViewAdapter;
import liffft.com.stackrx.services.questions.dao.QuestionsDAO;
import liffft.com.stackrx.services.questions.model.Questions;
import roboguice.inject.InjectView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class QuestionsFragment extends StackRXBaseFragmemt {
    //region INJECTED CLASSES ----------------------------------------------------------------------

    @Inject
    QuestionsDAO mQuestionsDAO;

    @Inject
    UserSession mUserSession;
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------

    @InjectView (R.id.question_fragment_question_recycler_view)
    RecyclerView mRecyclerView;

    //endregion

    //region LOCAL CONSTANTS -----------------------------------------------------------------------

    private Activity mActivity;
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private QuestionRecyclerViewAdapter mQuestionRecyclerViewAdapter;

    private GetQuestionObserver mGetQuestionObserver;
    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------

    public QuestionsFragment() {
    }

    //endregion

    //region LIFE CYCLE METHODS --------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.questions_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup recycler view
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);

        // Subscribe and call the observable
        mGetQuestionObserver = new GetQuestionObserver();
        mCompositeSubscription.add(mQuestionsDAO.getQuestions().observeOn(AndroidSchedulers.mainThread()).subscribe(mGetQuestionObserver));

        mQuestionRecyclerViewAdapter = new QuestionRecyclerViewAdapter(getActivity());
        mRecyclerView.setAdapter(mQuestionRecyclerViewAdapter);

        mActivity = getActivity();
    }

    //endregion

    //region WIDGET --------------------------------------------------------------------------------
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region LOCAL METHODS -------------------------------------------------------------------------
    //endregion

    //region OBSERVERS -----------------------------------------------------------------------------

    private class GetQuestionObserver implements Observer<Questions> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(mActivity, mActivity.getString(R.string.service_error), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(Questions questions) {
            mUserSession.setQuestions(questions);
            mQuestionRecyclerViewAdapter.setItemList(questions.getItems());
            mQuestionRecyclerViewAdapter.notifyDataSetChanged();
        }
    }
    //endregion

    //region ACCESSORS -----------------------------------------------------------------------------
    //endregion

    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion

    //region CLASS METHODS -------------------------------------------------------------------------
    //endregion

}
