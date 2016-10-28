package ly.generalassemb.drewmahrt.shoppinglistver2;

/**
 * Created by jay on 10/27/16.
 */

public class Groceries {
    private String mName;
    private float mPrice;

    public Groceries(String name, float price) {

        mName = name;
        mPrice = price;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String name) {
        mName = name;
    }

    public float getPrice() {
        return mPrice;
    }

    public void setPrice(float price) {
        mPrice = price;
    }
}
