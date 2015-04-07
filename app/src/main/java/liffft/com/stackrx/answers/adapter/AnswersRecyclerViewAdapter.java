package liffft.com.stackrx.answers.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.inject.Inject;

import java.util.List;

import liffft.com.stackrx.R;
import liffft.com.stackrx.main.user.UserSession;
import liffft.com.stackrx.services.answers.model.Item;
import roboguice.RoboGuice;

public class AnswersRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    @Inject
    UserSession mUserSession;

    private List<Item> mItemList;
    private Context mContext;

    public AnswersRecyclerViewAdapter(Context context) {
        RoboGuice.injectMembers(context, this);
        mItemList = mUserSession.getAnswers().getItems();
        mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        View v = inflater.inflate(R.layout.item_answers, viewGroup, false);
        return new ItemHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        ItemHolder itemHolder = (ItemHolder) viewHolder;
        itemHolder.mAnswerText.setText(mItemList.get(i).getBody());
//        itemHolder.mViewAnswersButton.setText(String.format(mContext.getString(R.string.item_question_view_answers), mItemList.get(i).getAnswerCount()));
//
//        itemHolder.mViewAnswersButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mUserSession.setSelectedQuestion(mItemList.get(i));
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    private class ItemHolder extends RecyclerView.ViewHolder {

        public TextView mAnswerText;
//        public Button mViewAnswersButton;

        private ItemHolder(View itemView) {
            super(itemView);
            mAnswerText = (TextView) itemView.findViewById(R.id.item_answer_answer_text_view);
//            mViewAnswersButton = (Button) itemView.findViewById(R.id.item_question_view_answers_button);
        }
    }

}
