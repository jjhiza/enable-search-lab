package ly.generalassemb.drewmahrt.shoppinglistver2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jay on 10/25/16.
 */

public class ListAdapter extends RecyclerView.Adapter<ListHolder> {

    List<ItemsObject> mItemsList;

    public ListAdapter(List<ItemsObject> list){
        mItemsList = list;
    }

    @Override
    public ListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_layout,parent, false);
        return new ListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListHolder holder, int position) {
        holder.mItemName.setText(mItemsList.get(position).getmItemName());
        holder.mDescription.setText(mItemsList.get(position).getmDescription());
        holder.mPrice.setText(mItemsList.get(position).getmPrice().toString());
        holder.mType.setText(mItemsList.get(position).getmType());

    }

    @Override
    public int getItemCount() {
        return mItemsList.size();
    }
}