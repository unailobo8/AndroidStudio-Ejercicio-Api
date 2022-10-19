package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WebViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WebViewFragment extends android.app.Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "pWeb";

    // TODO: Rename and change types of parameters
    private String pWeb;

    public WebViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param pWeb Parameter 1.
     * @return A new instance of fragment WebView.
     */
    // TODO: Rename and change types and number of parameters
    public WebViewFragment newInstance(String pWeb) {
        WebViewFragment fragment = new WebViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, pWeb);
        fragment.setArguments(args);
        this.pWeb = pWeb;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            pWeb = getArguments().getString(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        WebView webView = (WebView) container.findViewById(R.id.vWeb);
        pWeb = "https://" + pWeb.substring(11, pWeb.length() -4);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(pWeb);
        return inflater.inflate(R.layout.fragment_web_view, container, false);
    }
}