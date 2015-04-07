package liffft.com.stackrx.questions.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.inject.Inject;

import java.util.List;

import liffft.com.stackrx.R;
import liffft.com.stackrx.main.user.UserSession;
import liffft.com.stackrx.services.questions.model.Item;
import roboguice.RoboGuice;

/**
 * Created by pair on 4/6/15.
 */
public class QuestionRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Inject
    UserSession mUserSession;

    private List<Item> mItemList;

    public QuestionRecyclerViewAdapter(Context context) {
        RoboGuice.injectMembers(context, this);
        mItemList = mUserSession.getQuestions().getItems();
    }

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
        itemHolder.mViewAnswersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mUserSession.setSelectedQuestion(mItemList.get(i));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public TextView mQuestionText;
        public Button mViewAnswersButton;

        private ItemHolder(View itemView) {
            super(itemView);
            mQuestionText = (TextView) itemView.findViewById(R.id.item_question_question_text_view);
            mViewAnswersButton = (Button) itemView.findViewById(R.id.item_question_view_answers_button);
        }
    }

}
