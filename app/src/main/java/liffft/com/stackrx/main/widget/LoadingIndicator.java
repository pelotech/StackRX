package liffft.com.stackrx.main.widget;

import android.app.Activity;
import android.view.View;

import com.google.inject.Inject;

import roboguice.RoboGuice;

/**
 * Created by graemeharnish on 6/30/15.
 */
public class LoadingIndicator {

    //region INJECTED CLASSES ----------------------------------------------------------------------
    //endregion

    //region INJECTED VIEWS ------------------------------------------------------------------------
    //endregion

    //region STATIC LOCAL CONSTANTS ----------------------------------------------------------------
    //endregion

    //region CLASS VARIABLES -----------------------------------------------------------------------

    private LoadingIndicatorDialog mLoadingIndicator;
    private Activity mActivity;
    //endregion

    //region CONSTRUCTOR ---------------------------------------------------------------------------

    @Inject
    public LoadingIndicator(Activity activity) {
        mActivity = activity;
        RoboGuice.injectMembers(activity, this);
    }

    //endregion

    //region LIFECYCLE METHODS ---------------------------------------------------------------------
    //endregion

    //region WIDGET --------------------------------------------------------------------------------
    //endregion

    //region LISTENERS -----------------------------------------------------------------------------
    //endregion

    //region EVENTS --------------------------------------------------------------------------------
    //endregion

    //region LOCAL METHODS -------------------------------------------------------------------------
    /**
     * shows a loading indicator progress dialog containing a message with id
     * if indicator is already shown, the indicators show count is incremented
     *
     * @param messageResId the message id
     */
    public void showLoadingIndicatorOpaque(int messageResId) {
        showLoadingIndicator(null, mActivity.getString(messageResId), false);
    }

    /**
     * shows a loading indicator progress dialog
     * if indicator is already shown, the indicators show count is incremented
     */
    public void showLoadingIndicatorTransparent() {
        showLoadingIndicator(null, null, true);
    }

    /**
     * shows a loading indicator progress dialog
     * if indicator is already shown, the indicators show count is incremented
     *
     * @param fadeView view to fade out and back in when {@link #hideLoadingIndicator()}
     *                 or {@link #hideLoadingIndicatorIgnoreCount()} is called
     */
    public void showLoadingIndicatorTransparent(View fadeView) {
        showLoadingIndicator(fadeView, null, true);
    }

    private void showLoadingIndicator(View fadeView, final String message, final boolean makeTransparent) {
        if (mLoadingIndicator == null) {
            mLoadingIndicator = new LoadingIndicatorDialog(mActivity, message, makeTransparent);
        }
    }

    /**
     * hides loading indicator
     * or decrements its count if the show count is greater than 1
     */
    public void hideLoadingIndicator() {
        if (mLoadingIndicator != null) {
            mLoadingIndicator = null;
        }
    }

    /**
     * hides loading indicator no matter what its show count is
     */
    public void hideLoadingIndicatorIgnoreCount() {
        if (mLoadingIndicator != null) {
            mLoadingIndicator.dismiss();
            mLoadingIndicator = null;
        }
    }
    //endregion

    //region ACCESSORS -----------------------------------------------------------------------------
    //endregion

    //region OBSERVERS -----------------------------------------------------------------------------
    //endregion

    //region INNER CLASSES -------------------------------------------------------------------------
    //endregion
}
