package liffft.com.stackrx.questions.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import liffft.com.stackrx.R;
import liffft.com.stackrx.main.application.AppConstants;
import liffft.com.stackrx.main.event.NavigationEvent;
import liffft.com.stackrx.services.questions.model.Item;
import roboguice.RoboGuice;

public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    //region INJECTED CLASSES ----------------------------------------------------------------------
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------
    //endregion

    //region LOCAL CONSTANTS -----------------------------------------------------------------------
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private List<Item> mItemList = new ArrayList<>();
    private Context mContext;
    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------

    public QuestionRecyclerViewAdapter(Context context) {
        RoboGuice.injectMembers(context, this);
        mContext = context;
    }
    //endregion

    //region LIFE CYCLE METHODS --------------------------------------------------------------------

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View v = inflater.inflate(R.layout.item_question, viewGroup, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ItemHolder itemHolder = (ItemHolder) viewHolder;
        itemHolder.mQuestionText.setText(mItemList.get(i).getTitle());
        itemHolder.mViewAnswersButton.setText(String.format(mContext.getString(R.string.item_question_view_answers), mItemList.get(i).getAnswerCount()));

        itemHolder.mViewAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavigationEvent navigationEvent = new NavigationEvent();
                navigationEvent.setDrawerItem(AppConstants.NAVIGATION.DRAWER_IDENTIFIER.QUESTION_DRAWER);
                navigationEvent.setFragmentName(AppConstants.NAVIGATION.NAVIGATION_ROUTES.ANSWER_FRAGMENT);
            }
        });

    }
    //endregion

    //region WIDGET --------------------------------------------------------------------------------

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region LOCAL METHODS -------------------------------------------------------------------------
    //endregion

    //region OBSERVERS -----------------------------------------------------------------------------
    //endregion

    //region ACCESSORS -----------------------------------------------------------------------------

    public void setItemList(List<Item> itemList) {
        if (mItemList.size() == 0)
            mItemList = itemList;
        else
            mItemList.addAll(itemList);
    }
    //endregion

    //region INNER CLASSES -------------------------------------------------------------------------

    private class ItemHolder extends RecyclerView.ViewHolder {

        public TextView mQuestionText;
        public Button mViewAnswersButton;

        private ItemHolder(View itemView) {
            super(itemView);
            mQuestionText = (TextView) itemView.findViewById(R.id.item_question_question_text_view);
            mViewAnswersButton = (Button) itemView.findViewById(R.id.item_question_view_answers_button);
        }
    }
    //endregion

    //region CLASS METHODS -------------------------------------------------------------------------
    //endregion



}
