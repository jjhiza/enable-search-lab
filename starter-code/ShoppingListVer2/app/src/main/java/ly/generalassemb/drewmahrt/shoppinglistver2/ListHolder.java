package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by jay on 10/25/16.
 */

public class ListHolder extends RecyclerView.ViewHolder {

    public TextView mItemName, mDescription, mPrice, mType;



    public ListHolder(View itemView) {
        super(itemView);

        mItemName = (TextView)itemView.findViewById(R.id.itemName);

        mDescription = (TextView)itemView.findViewById(R.id.itemDescription);

        mPrice = (TextView)itemView.findViewById(R.id.itemPrice);

        mType = (TextView)itemView.findViewById(R.id.itemType);

    }
}
