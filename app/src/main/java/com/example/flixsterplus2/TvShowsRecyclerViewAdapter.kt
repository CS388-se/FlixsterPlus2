package com.example.flixsterplus2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.example.flixsterplus2.R.id

class TvShowsRecyclerViewAdapter(
    private val tvShows: List<TvShow>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<TvShowsRecyclerViewAdapter.TvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_tv_show, parent, false)
        return TvShowViewHolder(view)
    }

    inner class TvShowViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        var mItem: TvShow? = null
        val mTvShowTitle: TextView = mView.findViewById<View>(id.tvShow_title) as TextView

        //        val mMovieDescription: TextView = mView.findViewById<View>(id.movie_description) as TextView
        val mTvShowPoster: ImageView = mView.findViewById<View>(id.tvShow_poster) as ImageView
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = tvShows[position]

        holder.mItem = tvShow
        holder.mTvShowTitle.text = tvShow.title
//        holder.mMovieDescription.text = movie.description

        Glide.with(holder.mView)
            .load("https://image.tmdb.org/t/p/w500" + tvShow.imagePosterPath)
            .placeholder(R.drawable.ic_launcher_foreground)
            .centerCrop()
            .transform(RoundedCorners(30))
            .into(holder.mTvShowPoster)

        holder.mView.setOnClickListener {
            holder.mItem?.let { book ->
                mListener?.onItemClick(book)
            }
        }
    }

    override fun getItemCount(): Int {
        return tvShows.size
    }
}
