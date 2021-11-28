package com.example.designtask

import android.content.Context
import com.example.designtask.Product
import androidx.recyclerview.widget.RecyclerView
import com.example.designtask.ProductAdapter.ProductViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import com.example.designtask.R
import android.widget.TextView

class ProductAdapter     //getting the context and product list with constructor
    (//this context we will use to inflate the layout
    private val mCtx: Context, //we are storing all the products in a list
    private val productList: ArrayList<Product>
) : RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        //inflating and returning our view holder
        val inflater = LayoutInflater.from(mCtx)
        val view = inflater.inflate(R.layout.row_data, null)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        //getting the product of the specified position
        val product = productList[position]

        //binding the data with the viewholder views
        holder.textViewTitle.text = product.title
        holder.textViewShortDesc.text = product.date
        holder.textViewRating.text = product.amount
        holder.textViewPrice.text = product.amountValue
        holder.imageView.setImageDrawable(mCtx.resources.getDrawable(product.image))
        holder.statusTextView.text=product.status
       // holder.textViewAccountInfo.text=product.accountInfo
        holder.textViewAccounterName.text=product.accounterName
        holder.textViewDeductions.text=product.deductions
        holder.textViewService.text=product.service
        holder.serviceValue.text=product.serviceValue
        holder.tds.text=product.tds
        holder.tdsValue.text=product.tdsValue
        holder.imps.text=product.imps
        holder.impsValue.text=product.impsValue
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    inner class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textViewTitle: TextView
        var textViewShortDesc: TextView
        var textViewRating: TextView
        var textViewPrice: TextView
        var imageView: ImageView
         var statusTextView: TextView
      //  var textViewAccountInfo: TextView
        var textViewAccounterName: TextView
        var textViewDeductions:TextView
        var textViewService:TextView
        var serviceValue:TextView
        var tds:TextView
        var tdsValue:TextView
        var imps:TextView
        var impsValue:TextView

        init {
            textViewTitle = itemView.findViewById(R.id.textViewTitle)
            textViewShortDesc = itemView.findViewById(R.id.textViewDate)
            textViewRating = itemView.findViewById(R.id.textViewAmount)
            textViewPrice = itemView.findViewById(R.id.textViewAmountValue)
            imageView = itemView.findViewById(R.id.imageView)
            statusTextView=itemView.findViewById(R.id.textViewStatus)
          //  textViewAccountInfo=itemView.findViewById(R.id.textViewAccountInfo)
            textViewAccounterName=itemView.findViewById(R.id.textViewAccounterName)
            textViewDeductions=itemView.findViewById(R.id.textViewDeductions)
            textViewService=itemView.findViewById(R.id.serviceText)
            serviceValue=itemView.findViewById(R.id.serviceValue)
            tds=itemView.findViewById(R.id.tdsText);
            tdsValue=itemView.findViewById(R.id.tdsValue);
            imps=itemView.findViewById(R.id.impsFee);
            impsValue=itemView.findViewById(R.id.impsValue)

        }
    }
}