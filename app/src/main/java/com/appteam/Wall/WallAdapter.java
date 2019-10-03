package com.appteam.Wall;


import android.app.Activity;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieProperty;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.SimpleLottieValueCallback;
import com.androidnetworking.AndroidNetworking;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class WallAdapter extends RecyclerView.Adapter<WallAdapter.MyViewHolder> {

    String roll;
    List<wall> wallList;
    Activity activity;
    wall wall;
    boolean isliked;
    int likes;
    String image_id, user_id;
    private boolean check = true;

    public WallAdapter(List<wall> wallList, Activity activity) {
        this.activity = activity;
        this.wallList = wallList;
    }

    @androidx.annotation.NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@androidx.annotation.NonNull ViewGroup parent, int viewType) {
        AndroidNetworking.initialize(parent.getContext());
        View view = View.inflate(parent.getContext(), com.appteam.hillfair2k19.R.layout.adapter_wall, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        wall = wallList.get(position);

        holder.like.addValueCallback(
                new KeyPath("**"),
                LottieProperty.COLOR_FILTER,
                new SimpleLottieValueCallback<ColorFilter>() {
                    @Override
                    public ColorFilter getValue(LottieFrameInfo<ColorFilter> frameInfo) {
                        return new PorterDuffColorFilter(Color.WHITE, PorterDuff.Mode.SRC_ATOP);
                    }
                }
        );

        // todo heart ka color abhi white hai tap hone par orange karo, white karne ka code upar hai usme orange color use karo jo har jagah used hai


//        SharedPreferences prefs = activity.getSharedPreferences("number", Context.MODE_PRIVATE);
//        roll = prefs.getString("roll number", "gsb");

        if (wallList.get(position).getImage_url() != null)
            Picasso.with(activity).load(wallList.get(position).getImage_url()).into(holder.image);

//        holder.like_count.setText(likesArray.get(position) + " Likes");
//        getlike2(holder);

//        if (likedArray.get(position)) {
//            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//            valueAnimator.setDuration(1000);
//            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    holder.like.setProgress(animation.getAnimatedFraction());
//                }
//            });
//            valueAnimator.start();
//        }

//        holder.like.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (!likedArray.get(position)) {
//                    post(holder, position);
//                    likedArray.set(position, true);
//                    holder.like.setEnabled(false);
//                } else {
//                    likedArray.set(position, false);
//                    remove(holder, position);
//                    holder.like.setEnabled(false);
//                }
//            }
//
//        });
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return wallList.size();
    }

//    public void post(final MyViewHolder holder, final int position) {
//        AndroidNetworking.get(activity.getString(com.appteam.hillfair2k19.R.string.baseUrl) + "postlike/" + imageArray.get(position) + "/" + roll + "/1")
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        getlike(holder);
//
//                        System.out.println("liked");
//                        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//                        valueAnimator.setDuration(1000);
//                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                            @Override
//                            public void onAnimationUpdate(ValueAnimator animation) {
//                                holder.like.setProgress(animation.getAnimatedFraction());
//                            }
//                        });
//                        valueAnimator.start();
//                        likesArray.set(position, String.valueOf(Integer.parseInt(likesArray.get(position)) + 1));
//                        holder.like_count.setText(likesArray.get(position) + " Likes");
//                        holder.like.setEnabled(true);
//                    }
//
//                    @Override
//                    public void onError(ANError error) {
//                    }
//                });
//    }

//    public void getlike(final MyViewHolder holder) {
//        AndroidNetworking.get(activity.getString(com.appteam.hillfair2k19.R.string.baseUrl) + "getlike/" + image_id)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            likes = Integer.parseInt(response.getString("likes")) > 0 ? Integer.parseInt(response.getString("likes")) : 0;
//                            System.out.println("likesssssss" + likes);
//                            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//                            valueAnimator.setDuration(1000);
//                            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                                @Override
//                                public void onAnimationUpdate(ValueAnimator animation) {
//                                    holder.like.setProgress(animation.getAnimatedFraction());
//                                }
//                            });
//                            valueAnimator.start();
//                            holder.like_count.setText(String.valueOf(likes) + " Likes");
//                            holder.like.setEnabled(true);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                    }
//                });
//    }

//    public void getlike1(final MyViewHolder holder) {
//        AndroidNetworking.get(activity.getString(com.appteam.hillfair2k19.R.string.baseUrl) + "getlike/" + image_id)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            likes = Integer.parseInt(response.getString("likes")) > 0 ? Integer.parseInt(response.getString("likes")) : 0;
//                            System.out.println("likesssssss  " + likes);
//                            ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//                            valueAnimator.setDuration(100);
//                            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                                @Override
//                                public void onAnimationUpdate(ValueAnimator animation) {
//                                    holder.like.setProgress(1 - animation.getAnimatedFraction());
//                                }
//                            });
//                            valueAnimator.start();
//                            holder.like_count.setText(String.valueOf(likes) + " Likes");
//                            holder.like.setEnabled(true);
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                    }
//                });
//    }

//    public void getlike2(final MyViewHolder holder) {
//        AndroidNetworking.get(activity.getString(com.appteam.hillfair2k19.R.string.baseUrl) + "getlike/" + image_id)
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        try {
//                            likes = Integer.parseInt(response.getString("likes"));
//                            holder.like_count.setText(String.valueOf(likes) + " Likes");
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//                    }
//
//                    @Override
//                    public void onError(ANError error) {
//                        // handle error
//                    }
//                });
//    }

//    public void remove(final MyViewHolder holder, final int position) {
//        AndroidNetworking.get(activity.getString(com.appteam.hillfair2k19.R.string.baseUrl) + "postlike/" + imageArray.get(position) + "/" + roll + "/0")
//                .build()
//                .getAsJSONObject(new JSONObjectRequestListener() {
//                    @Override
//                    public void onResponse(JSONObject response) {
////                        getlike1(holder);
//                        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0f, 1f);
//                        valueAnimator.setDuration(100);
//                        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                            @Override
//                            public void onAnimationUpdate(ValueAnimator animation) {
//                                holder.like.setProgress(1 - animation.getAnimatedFraction());
//                            }
//                        });
//                        valueAnimator.start();
//
//                        likesArray.set(position, String.valueOf(Integer.parseInt(likesArray.get(position)) - 1));
//                        holder.like_count.setText(likesArray.get(position) + " Likes");
//                        holder.like.setEnabled(true);
//                        System.out.println("disliked");
//                    }
//
//                    @Override
//                    public void onError(ANError error) {
//                    }
//                });
//    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView profile;
        TextView title, desc, like_count;
        ImageView image, share;
        LottieAnimationView like;


        public MyViewHolder(View itemView) {
            super(itemView);
            like = itemView.findViewById(com.appteam.hillfair2k19.R.id.like);
//            share = itemView.findViewById(R.id.share);
            image = itemView.findViewById(com.appteam.hillfair2k19.R.id.upload);
            like_count = itemView.findViewById(com.appteam.hillfair2k19.R.id.like_count);
            desc = itemView.findViewById(com.appteam.hillfair2k19.R.id.desc);
            title = itemView.findViewById(com.appteam.hillfair2k19.R.id.title);
            profile = itemView.findViewById(com.appteam.hillfair2k19.R.id.image);
        }
    }
}