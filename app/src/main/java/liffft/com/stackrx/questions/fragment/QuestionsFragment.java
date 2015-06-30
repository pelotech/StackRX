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
import liffft.com.stackrx.main.widget.LoadingIndicator;
import liffft.com.stackrx.questions.adapter.QuestionRecyclerViewAdapter;
import liffft.com.stackrx.services.questions.dao.QuestionsDAO;
import liffft.com.stackrx.services.questions.model.Questions;
import roboguice.inject.InjectView;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;

public class QuestionsFragment extends StackRXBaseFragmemt {
    //region INJECTED CLASSES ----------------------------------------------------------------------

    @Inject
    private QuestionsDAO mQuestionsDAO;

    @Inject
    private UserSession mUserSession;

    @Inject
    private LoadingIndicator mLoadingIndicator;
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------

    @InjectView (R.id.question_fragment_question_recycler_view)
    RecyclerView mRecyclerView;

    //endregion

    //region LOCAL CONSTANTS -----------------------------------------------------------------------

    private Activity mActivity;
    private LinearLayoutManager mQuestionLinearLayoutManager;
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private QuestionRecyclerViewAdapter mQuestionRecyclerViewAdapter;

    private GetQuestionObserver mGetQuestionObserver;

    private int mCurrentPage = 1;
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

        //  Start the loading indicator
        mLoadingIndicator.showLoadingIndicatorTransparent();

        // Setup recycler view
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mQuestionLinearLayoutManager = layoutManager;

        // Subscribe and call the observable
        mGetQuestionObserver = new GetQuestionObserver();
        mCompositeSubscription.add(mQuestionsDAO.getQuestions(mCurrentPage).observeOn(AndroidSchedulers.mainThread()).subscribe(mGetQuestionObserver));

        mQuestionRecyclerViewAdapter = new QuestionRecyclerViewAdapter(getActivity());
        mRecyclerView.setAdapter(mQuestionRecyclerViewAdapter);
        mRecyclerView.setOnScrollListener(new QuestionRecyclerViewScrollListener());
        mActivity = getActivity();
    }

    //endregion

    //region WIDGET --------------------------------------------------------------------------------
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------

    private class QuestionRecyclerViewScrollListener extends RecyclerView.OnScrollListener {

        private boolean mLoading = true;
        private int mPastVisiblesItems, mVisibleItemCount, mTotalItemCount;

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

            mVisibleItemCount = mQuestionLinearLayoutManager.getChildCount();
            mTotalItemCount = mQuestionLinearLayoutManager.getItemCount();
            mPastVisiblesItems = mQuestionLinearLayoutManager.findFirstVisibleItemPosition();

            if (mLoading) {
                if ((mVisibleItemCount + mPastVisiblesItems) >= mTotalItemCount) {
                    mCurrentPage = mCurrentPage + 1;
                    mLoading = false;
                    mCompositeSubscription.add(mQuestionsDAO.getQuestions(mCurrentPage).observeOn(AndroidSchedulers.mainThread()).subscribe(mGetQuestionObserver));

                }
            }
        }
    }
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region LOCAL METHODS -------------------------------------------------------------------------
    //endregion

    //region OBSERVERS -----------------------------------------------------------------------------
    private class GetQuestionObserver implements Observer<Questions> {

        @Override
        public void onCompleted() {
            mLoadingIndicator.hideLoadingIndicator();
        }

        @Override
        public void onError(Throwable e) {
            mLoadingIndicator.hideLoadingIndicator();
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
