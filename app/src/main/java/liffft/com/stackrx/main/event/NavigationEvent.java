package liffft.com.stackrx.main.event;

public class NavigationEvent {
    private int mDrawerItem;

    private String mFragmentName;

    public int getDrawerItem() {
        return mDrawerItem;
    }

    public void setDrawerItem(int drawerItem) {
        mDrawerItem = drawerItem;
    }

    public String getFragmentName() {
        return mFragmentName;
    }

    public void setFragmentName(String fragmentName) {
        mFragmentName = fragmentName;
    }
}
