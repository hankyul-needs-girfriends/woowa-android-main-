package com.woowahan.woowahanfoods.httpConnection;

import com.google.gson.JsonObject;
import com.woowahan.woowahanfoods.Dataframe.FeedResult;
import com.woowahan.woowahanfoods.Dataframe.RestaurantSearchResult;
import com.woowahan.woowahanfoods.Dataframe.SearchResultJson;
import com.woowahan.woowahanfoods.Dataframe.SearchResultJson2;
import com.woowahan.woowahanfoods.httpConnection.Response.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/auth/login")
    Call<LoginResponse> kakaoLogin(@Query("id") long id, @Query("token") String token);

    @GET("/addrlink/addrLinkApi.do")
    Call<SearchResultJson> searchAddress(@Query("confmKey") String confmKey, @Query("currentPage") int currentPage, @Query("countPerPage") int countPerPage, @Query("keyword") String keyword, @Query("resultType") String resultType);

    @GET("/addrlink/addrCoordApi.do")
    Call<SearchResultJson> convertor(@Query("confmKey") String confmKey, @Query("admCd") String admCd, @Query("rnMgtSn") String rnMgtSn, @Query("udrtYn") String udrtYn, @Query("buldMnnm") int buldMnnm, @Query("buldSlno") int buldSlno, @Query("resultType") String resultType);

    @GET("/search/restaurantList")
    Call<RestaurantSearchResult> searchRestaurant(@Query("name") String name, @Query("region") String region);

    @GET("/search/schoolList")
    Call<RestaurantSearchResult> searchSchoolList(@Query("schoolName") String schoolName);

    @GET("/17841442985795349/media")
    Call<FeedResult> getFeeds(@Query("fields") String fields, @Query("access_token") String access_token);

    @GET("/{id}/children")
    Call<FeedResult> getFeedDetails(@Path("id") String id, @Query("fields") String fields, @Query("access_token") String access_token);
}
