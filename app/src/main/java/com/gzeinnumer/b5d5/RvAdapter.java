package com.gzeinnumer.b5d5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.gzeinnumer.b5d5.databinding.ItemRvDataBinding;

import java.util.ArrayList;
import java.util.List;

//todo 1
public class RvAdapter extends RecyclerView.Adapter<RvAdapter.MyHolder> implements Filterable {

    //todo 3
    private ArrayList<MyModel> list;
    private ArrayList<MyModel> listFilter;

    public RvAdapter(){

    }

    //todo 2
    public void setList(ArrayList<MyModel> list) {
        this.list = list;
        this.listFilter = new ArrayList<>(list);
    }

    //todo 5
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(ItemRvDataBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    //todo 7
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        MyModel d = list.get(position);
        holder.bind(d);
    }

    //todo 4
    @Override
    public int getItemCount() {
        return list.size();
    }

    //todo 6
    public static class MyHolder extends RecyclerView.ViewHolder {

        public ItemRvDataBinding binding;

        public MyHolder(@NonNull ItemRvDataBinding itemView) {
            super(itemView.getRoot());
            binding = itemView;
        }

        //todo 8
        public void bind(MyModel d) {
            binding.tv.setText(d.getNama() + " - " +d.getNo());
        }
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private final Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<MyModel> fildteredList = new ArrayList<>();
            if (constraint == null || constraint.length() == 0) {
                fildteredList.addAll(listFilter);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (MyModel item : listFilter) {
                    if (item.getNama().toLowerCase().contains(filterPattern)) {
                        fildteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = fildteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            list.clear();
            list.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };
}
