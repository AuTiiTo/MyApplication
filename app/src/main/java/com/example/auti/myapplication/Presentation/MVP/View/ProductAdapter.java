package com.example.auti.myapplication.Presentation.MVP.View;

import android.net.sip.SipAudioCall;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.auti.myapplication.Domain.Pojos.Product;
import com.example.auti.myapplication.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by auti_ on 11/4/2017.
 */

public class ProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Product> mProducts;
    private ProductClickListener mListener;

    public ProductAdapter(List<Product> products, ProductClickListener listener) {
        this.mProducts = products;
        mListener = listener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHoder(view, mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ProductViewHoder) {
            Product product = getItem(position);
            ProductViewHoder viewHolder = (ProductViewHoder) holder;
            viewHolder.productName.setText(product.getName());
            viewHolder.productPrice.setText(product.getFormatedPrice());
            viewHolder.productsInStock.setText(product.getFormattedUnitsInStock());
            Picasso.with(viewHolder.itemView.getContext())
                    .load(product.getImageUrl())
                    .into(viewHolder.productImage);
        }
    }

    @Override
    public int getItemCount() {
        return mProducts.size();
    }

    private Product getItem(int position) {
        return mProducts.get(position);
    }

    public class ProductViewHoder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView productName;
        private TextView productPrice;
        private ImageView productImage;
        private TextView productsInStock;

        private ProductClickListener productClickListener;

        public ProductViewHoder(View itemView, ProductClickListener clickListener) {
            super(itemView);
            productClickListener = clickListener;
            productName = (TextView) itemView.findViewById(R.id.name_product);
            productPrice = (TextView) itemView.findViewById(R.id.price_product);
            productImage = (ImageView) itemView.findViewById(R.id.image_product);
            productsInStock = (TextView) itemView.findViewById(R.id.stock_product);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Product product = getItem(position);
            mListener.onProductClickListener(product);
        }
    }

    public interface ProductClickListener {
        void onProductClickListener(Product clickedProduct);
    }
}
