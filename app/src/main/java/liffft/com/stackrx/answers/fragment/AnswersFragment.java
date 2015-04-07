package liffft.com.stackrx.answers.fragment;

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
import liffft.com.stackrx.answers.adapter.AnswersRecyclerViewAdapter;
import liffft.com.stackrx.main.application.AppConstants;
import liffft.com.stackrx.main.event.NavigationEvent;
import liffft.com.stackrx.main.user.UserSession;
import liffft.com.stackrx.main.util.BusProvider;
import liffft.com.stackrx.services.answers.dao.AnswersDAO;
import liffft.com.stackrx.services.answers.model.Answers;
import roboguice.fragment.RoboFragment;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by graemeharnish on 4/7/15.
 */
@ContentView(R.layout.answers_fragment)
public class AnswersFragment extends RoboFragment {
    //region INJECTED CLASSES ----------------------------------------------------------------------

    @Inject
    AnswersDAO mAnswersDAO;

    @Inject
    UserSession mUserSession;
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------

    @InjectView(R.id.answer_fragment_answer_recycler_view)
    RecyclerView mRecyclerView;

    //endregion

    //region LOCAL CONSTANTS -----------------------------------------------------------------------

    private Activity mActivity;
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private AnswersRecyclerViewAdapter mAnswersRecyclerViewAdapter;

    private GetAnswersSubscriber mGetAnswersSubscriber;
    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------

    public AnswersFragment() {
    }

    //endregion

    //region LIFE CYCLE METHODS --------------------------------------------------------------------

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.answers_fragment, container, false);
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
        mGetAnswersSubscriber = new GetAnswersSubscriber();
        mAnswersDAO.getAnswersBasedOnQuestionId(String.valueOf(mUserSession.getSelectedQuestion().getQuestionId())).observeOn(AndroidSchedulers.mainThread()).subscribe(mGetAnswersSubscriber);

        mActivity = getActivity();
        NavigationEvent navigationEvent = new NavigationEvent();
        navigationEvent.setDrawerItem(AppConstants.NAVIGATION.DRAWER_IDENTIFIER.QUESTION_DRAWER);
        navigationEvent.setFragmentName(AppConstants.NAVIGATION.NAVIGATION_ROUTES.ANSWER_FRAGMENT);
        BusProvider.getInstance().post(navigationEvent);

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

    //region SUBSCRIBERS ---------------------------------------------------------------------------

    private class GetAnswersSubscriber extends Subscriber<Answers> {

        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Toast.makeText(mActivity, mActivity.getString(R.string.service_error), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onNext(Answers answers) {
            mUserSession.setAnswers(answers);
            mAnswersRecyclerViewAdapter = new AnswersRecyclerViewAdapter(getActivity());
            mRecyclerView.setAdapter(mAnswersRecyclerViewAdapter);
            mAnswersRecyclerViewAdapter.notifyDataSetChanged();
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
