/*
 *
 *  * Copyright (C) 2014 Antonio Leiva Gordillo.
 *  *
 *  * Licensed under the Apache License, Version 2.0 (the "License");
 *  * you may not use this file except in compliance with the License.
 *  * You may obtain a copy of the License at
 *  *
 *  *      http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  * Unless required by applicable law or agreed to in writing, software
 *  * distributed under the License is distributed on an "AS IS" BASIS,
 *  * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  * See the License for the specific language governing permissions and
 *  * limitations under the License.
 *
 */

package com.wahyuadityanugraha.mvpexample.app.finditems;

import com.wahyuadityanugraha.mvpexample.app.entities.Feed;

import java.util.List;

public class FeedPresenterImpl implements FeedPresenter, OnFinishedListener {

    private FeedFunction mainView;
    private FeedInteractor feedInteractor;

    public FeedPresenterImpl(FeedFunction mainView) {
        this.mainView = mainView;
        feedInteractor = new FeedInteractorImpl();
    }

    @Override public void onResume() {
        mainView.showProgress();
        feedInteractor.findItems(this);
    }

    @Override public void onItemClicked(int position) {
        mainView.showMessage(String.format("Position %d clicked", position + 1));
    }

    @Override public void onFinished(List<Feed> items) {
        mainView.setItems(items);
        mainView.hideProgress();
    }
}
