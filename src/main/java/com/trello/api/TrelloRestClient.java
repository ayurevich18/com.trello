package com.trello.api;

import com.trello.api.interceptors.TrelloAuthInterceptor;
import com.trello.api.models.Checklists;
import com.trello.api.models.Members;
import com.trello.api.services.*;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;

public class TrelloRestClient implements Serializable {
    public static final String HOME_IO_BASE_URL = "https://api.trello.com/1/";


    public BoardsService boardsService;
    public ListsService listsService;
    public CardsService cardsService;
    public MembersServise membersServise;
    public ChecklistsService checklistsService;


    public TrelloRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOME_IO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        boardsService = retrofit.create(BoardsService.class);
        listsService = retrofit.create(ListsService.class);
        cardsService = retrofit.create(CardsService.class);
        membersServise = retrofit.create(MembersServise.class);
        checklistsService = retrofit.create(ChecklistsService.class);
    }

}
