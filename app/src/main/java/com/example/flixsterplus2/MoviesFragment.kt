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
const val MOVIE_EXTRA = "MOVIE_EXTRA"

class MoviesFragment : Fragment(), OnListFragmentInteractionListener {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_movies_list, container, false)
        val progressBar = view.findViewById<View>(R.id.progress) as ContentLoadingProgressBar
        val recyclerView = view.findViewById<View>(R.id.list) as RecyclerView
        val context = view.context
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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
            "https://api.themoviedb.org/3/movie/popular",
            params,
            object : JsonHttpResponseHandler() { // connect these callbacks to your API call
                override fun onSuccess(
                    statusCode: Int,
                    headers: Headers,
                    json: JsonHttpResponseHandler.JSON
                ) {
                    // The wait for a response is over
                    progressBar.hide()

                    // TODO - Parse JSON into Models
                    val moviesJSON = json.jsonObject.get("results").toString()
                    val gson = Gson()
                    val arrayBookType = object : TypeToken<List<Movie>>() {}.type
                    val models: List<Movie> =
                        gson.fromJson(moviesJSON, arrayBookType)

                    recyclerView.adapter =
                        MoviesRecyclerViewAdapter(models, this@MoviesFragment)

                    // Look for this in Logcat:
                    Log.d("MoviesFragment", "response successful")
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
                        Log.e("MoviesFragment", errorResponse)
                    }
                }
            }
        ]
    }

    override fun onItemClick(movie: Movie) {
        val intent = Intent(context, MovieDetailActivity::class.java)
        intent.putExtra(MOVIE_EXTRA, movie)
        context?.startActivity(intent)
    }

    override fun onItemClick(tvShow: TvShow) {
        TODO("Not yet implemented")
    }
}
