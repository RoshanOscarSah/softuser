package com.assignment.esoftwarica.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import com.assignment.esoftwarica.R

class AboutFragment : Fragment() {

    private lateinit var webView: WebView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_about, container, false);
        webView = view.findViewById(R.id.webView);
        webView.settings.javaScriptEnabled = true;

        webView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                view?.loadUrl(url!!);
                return true;
            }
        }
        webView.loadUrl("https://softwarica.edu.np/about-softwarica/");
        return view;
    }

}