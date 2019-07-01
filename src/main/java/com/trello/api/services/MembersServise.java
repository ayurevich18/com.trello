package com.trello.api.services;

import com.trello.api.models.Members;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MembersServise {

    @GET("members/{id}")
    Call<Members> getMembers(@Path("id") String id);
}
