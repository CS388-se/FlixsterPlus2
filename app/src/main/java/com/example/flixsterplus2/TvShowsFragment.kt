package com.example.flixsterplus2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.ContentLoadingProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.codepath.asynchttpclient.AsyncHttpClient
import com.codepath.asynchttpclient.RequestParams
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Headers

private const val API_KEY = BuildConfig.API_KEY
const val TV_SHOW_EXTRA = "TV_SHOW_EXTRA"

class TvShowsFragment : Fragment(), OnListFragmentInteractionListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_tv_shows_list, container, false)
        val progressBar = view.findViewById<View>(R.id.showProgress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.showList) as RecyclerView
        val context = view.context
        recyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        updateAdapter(progressBar, recyclerView)
        return view
    }

    private fun updateAdapter(progressBar: ContentLoadingProgressBar, recyclerView: RecyclerView) {
        progressBar.show()

        // Create and set up an AsyncHTTPClient() here
        val client = AsyncHttpClient()
        val params = RequestParams()
        params["api_key"] = API_KEY

        // Using the client, perform the HTTP request
        client[
            "https://api.themoviedb.org/3/tv/popular",
            params,
            object : JsonHttpResponseHandler() { // connect these callbacks to your API call
                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JSON
                ) {
                    // The wait for a response is over
                    progressBar.hide()

                    // TODO - Parse JSON into Models
                    val tvShowsJSON = json.jsonObject.get("results").toString()
                    val gson = Gson()
                    val arrayBookType = object : TypeToken<List<TvShow>>() {}.type
                    val models: List<TvShow> =
                        gson.fromJson(tvShowsJSON, arrayBookType)

                    recyclerView.adapter =
                        TvShowsRecyclerViewAdapter(models, this@TvShowsFragment)

                    // Look for this in Logcat:
                    Log.d("TvShowFragment", "response successful")
                }

                    /*
                     * The onFailure function gets called when
                     * HTTP response status is "4XX" (eg. 401, 403, 404)
                     */
                override fun onFailure(
                    statusCode: Int,
                    headers: Headers?,
                    errorResponse: String,
                    t: Throwable?
                ) {
                    // The wait for a response is over
                    progressBar.hide()

                    // If the error is not null, log it!
                    t?.message?.let {
                        Log.e("TvShowFragment", errorResponse)
                    }
                }
            }
        ]
    }

    override fun onItemClick(movie: Movie) {
        TODO("Not yet implemented")
    }

    override fun onItemClick(tvShow: TvShow) {
        val intent = Intent(context, TvShowDetailActivity::class.java)
        intent.putExtra(TV_SHOW_EXTRA, tvShow)
        context?.startActivity(intent)
    }
}
