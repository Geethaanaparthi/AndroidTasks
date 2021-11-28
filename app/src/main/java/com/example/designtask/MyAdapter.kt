package com.example.designtask

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.designtask.model.ProductInfo
import com.example.designtask.task.ImageLoadTask

class MyAdapter internal constructor(
    private val mContext: Context,
    mFlowerList: List<ProductInfo>
) : RecyclerView.Adapter<ProductViewHolder?>() {
    private val mFlowerList: List<ProductInfo>
    override  fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val mView: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.recyclerview_row_item, parent, false)
        return ProductViewHolder(mView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
//          ImageLoadTask(mFlowerList.get(position).image, holder.mImage).execute();
        Glide.with(mContext).load(mFlowerList.get(position).image).into(holder.mImage)

        holder.mTitle.setText(getEllipseTxt(mFlowerList[position].title!!,30))
       // holder.mTitle.setText(mFlowerList[position].title!!)
        holder.mDescription.setText(getEllipseTxt(mFlowerList[position].description!!,50))
       // holder.mDescription.setText(mFlowerList[position].description!!)
         holder.mPrice.setText("₹".plus(mFlowerList.get(position).price.toString()));
    }
    fun getEllipseTxt(text:String, size:Int):String{
       val length =text!!.length;
        if(length>size){
            return text.substring(0,size)+"...";
        }
        return text
    }



    override fun getItemCount(): Int {
        return mFlowerList.size
    }

    init {
        this.mFlowerList = mFlowerList
    }
}

class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var mImage: ImageView
    var mTitle: TextView
    var mDescription: TextView
    var mPrice: TextView
    var mCardView: CardView

    init {
        mImage = itemView.findViewById(R.id.ivItemImage)
        mTitle = itemView.findViewById<TextView>(R.id.tvItemTitle)
        mDescription = itemView.findViewById<TextView>(R.id.tvItemDescription)
        mPrice = itemView.findViewById<TextView>(R.id.tvItemPrice)
        mCardView = itemView.findViewById(R.id.cardview)
    }
}