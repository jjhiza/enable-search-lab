package ly.generalassemb.drewmahrt.shoppinglistver2;

/**
 * Created by jay on 10/25/16. */

public class ItemsObject {
    String mItemName, mDescription, mType;
    String mPrice;

    public ItemsObject(String mItemName, String mDescription, String mType, String mPrice) {

        this.mItemName = mItemName;
        this.mDescription = mDescription;
        this.mType = mType;
        this.mPrice = mPrice;
    }

    public String getmItemName() {
        return mItemName;
    }

    public void setmItemName(String mItemName) {
        this.mItemName = mItemName;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public String getmPrice() {
        return mPrice;
    }

    public void setmPrice(String mPrice) {
        this.mPrice = mPrice;
    }
}
