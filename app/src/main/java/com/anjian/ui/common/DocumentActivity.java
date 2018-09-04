package com.anjian.ui.common;

import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.anjian.R;
import com.anjian.base.BaseActivity;
import com.anjian.base.BasePresenter;
import com.anjian.databinding.ActivityDocumentBinding;

public class DocumentActivity extends BaseActivity<BasePresenter,ActivityDocumentBinding> {


    @Override
    public int getLayoutId() {
        return R.layout.activity_document;
    }

    @Override
    protected boolean isTitleBar() {
        return true;
    }

    @Override
    protected void initTitleBar() {
        super.initTitleBar();
        mTitleBarLayout.setTitle("查看文档");
    }

    @Override
    protected boolean isPrestener() {
        return false;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initData() {
        super.initData();
       /* mBinding.wvBody.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });*/
        mBinding.wvBody.getSettings().setJavaScriptEnabled(true);
       // mBinding.wvBody.loadUrl("https://view.officeapps.live.com/op/view.aspx?src=https://github.com/ax3726/Anjian/raw/master/app/doc/%E9%BB%8E%E6%98%8E.doc");
        mBinding.wvBody.loadUrl("https://github.com/ax3726/Anjian/raw/master/app/doc/%E9%BB%8E%E6%98%8E.doc");
    }
}
