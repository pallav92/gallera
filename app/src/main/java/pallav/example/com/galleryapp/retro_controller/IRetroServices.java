package pallav.example.com.galleryapp.retro_controller;


import pallav.example.com.galleryapp.MovieResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRetroServices {


    /*@FormUrlEncoded
    @POST("user/api/v1/login")
    Call<BaseResponse<LoginResponse>> loginApi(@Field("email") String email, @Field("pwd") String pwd);*/

    @GET("")
    Call<MovieResponse> getMovieData(@Query("t")String Title , @Query("y")String year , @Query("plot")String Plot , @Query("r")String Response);

    /*@GET("user/api/v1/dids")
    Call<BaseResponse<DeviceListApiResponse>> getDeviceList();

    @FormUrlEncoded
    @POST("user/api/v1/forgotPass")
    Call<BaseResponse<MessageResponse>> forgotPasswordApi(@Field("email") String email);

    @FormUrlEncoded
    @POST("user/api/v1/changepass")
    Call<BaseResponse<MessageResponse>> changePasswordApi(@Field("oldPass") String oldPass, @Field("newPass") String newPass);

    @FormUrlEncoded
    @POST("user/api/v1/piechart")
    Call<BaseResponse<PieChartApiResponse>> getPieChartDataApi(@Field("filterType") String filterType);

    @FormUrlEncoded
    @POST ("user/api/v1/linechartdata")
    Call<BaseResponse<LineChartApiResponse>> getLineChartDataApi(@Field("startTime") String startTime, @Field("endTime") String endTime, @Field("difference") String difference);

    @FormUrlEncoded
    @POST ("user/api/v1/barchartdata")
    Call<BaseResponse<BarChartApiResponse>> getBarChartDataApi(@Field("filterType") String filterType, @Field("dayDataFilter") String dayDataFilter, @Field("isCompared") Boolean isCompared);

    @FormUrlEncoded
    @POST ("user/api/v1/messages")
    Call<BaseResponse<MessageApiResponse>> getMessagesOnHomeScreen(@Field("startTime") String startTime);

    @GET ("user/api/v1/settings")
    Call<BaseResponse<SettingApiResponse>> getSettingUrls();

    @FormUrlEncoded
    @POST ("user/api/v1/setlimit")
    Call<BaseResponse<MessageResponse>> setWaterUsedLimit(@Field("lim") String lim);


    @DELETE("user/api/v1/logout")
    Call<BaseResponse<MessageResponse>> logoutUser();*/


}
