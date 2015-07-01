package liffft.com.stackrx.main.widget;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import liffft.com.stackrx.R;

/**
 * Created by graemeharnish on 6/30/15.
 */
public class LoadingIndicatorDialog extends Dialog {

    //region INJECTED CLASSES ----------------------------------------------------------------------
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------
    //endregion

    //region STATIC LOCAL CONSTANTS ----------------------------------------------------------------
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private static final int ANIMATION_DURATION = 250;
    private View mFadeView = null;
    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------

    public LoadingIndicatorDialog(Context context, String message, boolean makeTransparent) {
        super(context);

        // We set canceled on outside so that the user cannot spam the UI
        // this seems to make the dialog not respond to any touches on the page
        // while still responding to the back button.
        // we should as a future enhancement cancel pending actions on back button
        setCanceledOnTouchOutside(false);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);

        View v = getLayoutInflater().inflate(R.layout.loading_indicator_dialog_layout, null);
        TextView messageTv = (TextView) v.findViewById(R.id.loading_indicator_dialog_message_text_view);
        if (message != null) {
            messageTv.setText(message);
        } else {
            messageTv.setVisibility(View.GONE);
        }
        setContentView(v);
        if (makeTransparent) {
            getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        }
        show();

    }
    //endregion

    //region LIFECYCLE METHODS ---------------------------------------------------------------------
    //endregion

    //region WIDGET --------------------------------------------------------------------------------

    @Override
    public void dismiss() {
        if (mFadeView != null) {
            mFadeView.animate()
                    .setDuration(ANIMATION_DURATION)
                    .alpha(1)
                    .start();
        }
        super.dismiss();
    }
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region ACCESSORS -----------------------------------------------------------------------------
    //endregion

    //region PUBLIC CLASS METHODS ------------------------------------------------------------------
    //endregion

    //region PRIVATE METHODS -----------------------------------------------------------------------
    //endregion

    //region OBSERVERS -----------------------------------------------------------------------------
    //endregion

    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion
}
