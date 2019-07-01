package com.trello.api.services;

import com.trello.api.models.Checklists;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ChecklistsService {

    @GET("checklists/{id}")
    Call<Checklists> getChecklist(@Path("id") String id);
}
