package com.example.crms1;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

class MyAdapter2 extends RecyclerView.Adapter<MyViewHolder2> {

    private Context context;
    private List<HelperClass2> dataList;

    public MyAdapter2(Context context, List<HelperClass2> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public MyViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new MyViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder2 holder, int position) {
        // Use Glide to load image into ImageView
        // Assuming HelperClass2 has appropriate getters for company name, description, and language
        // Adjust the code accordingly if the getters have different names
        // Example: holder.recTitle.setText(dataList.get(position).getCompanyName());
        holder.recTitle.setText(dataList.get(position).getCompany_name());
        holder.recDesc.setText(dataList.get(position).getDescription());
        holder.recLang.setText(dataList.get(position).getLanguage());

        holder.recTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Handle click event, e.g., navigate to detail activity
                // Example: Intent intent = new Intent(context, DetailActivity.class);
                // Adjust the code according to your requirements
                // Example: intent.putExtra("CompanyName", dataList.get(position).getCompanyName());
                // Adjust the code accordingly if needed
                // context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void searchDataList(ArrayList<HelperClass2> searchList) {
        dataList = searchList;
        notifyDataSetChanged();
    }
}

class MyViewHolder2 extends RecyclerView.ViewHolder {

  //  ImageView recImage;
    TextView recTitle, recDesc, recLang;
    CardView recCard;

    public MyViewHolder2(@NonNull View itemView) {
        super(itemView);

        // Initialize views
       // recImage = itemView.findViewById(R.id.recImage);
        recLang = itemView.findViewById(R.id.recPriority);
        recDesc = itemView.findViewById(R.id.recDesc);
        recTitle = itemView.findViewById(R.id.recTitle);
    }
}
