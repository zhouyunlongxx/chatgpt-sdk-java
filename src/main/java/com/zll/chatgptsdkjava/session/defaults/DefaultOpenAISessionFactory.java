package com.zll.chatgptsdkjava.session.defaults;


import com.zll.chatgptsdkjava.IOpenAIApi;
import com.zll.chatgptsdkjava.inteceptor.OpenAIInterceptor;
import com.zll.chatgptsdkjava.session.Configuration;
import com.zll.chatgptsdkjava.session.OpenAISession;
import com.zll.chatgptsdkjava.session.OpenAISessionFactory;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

public class DefaultOpenAISessionFactory implements OpenAISessionFactory {

    private final Configuration configuration;

    public DefaultOpenAISessionFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    @Override
    public OpenAISession openSession() {
        // 1. 日志配置
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.HEADERS);

        // 2. 开启 Http 客户端
        OkHttpClient okHttpClient = new OkHttpClient
                .Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(new OpenAIInterceptor(configuration.getApiKey(), configuration.getAuthToken()))
                .connectTimeout(450, TimeUnit.SECONDS)
                .writeTimeout(450, TimeUnit.SECONDS)
                .readTimeout(450, TimeUnit.SECONDS)
                .build();

        // 3. 创建 API 服务
        IOpenAIApi openAiApi = new Retrofit.Builder()
                .baseUrl(configuration.getApiHost())
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(JacksonConverterFactory.create())
                .build().create(IOpenAIApi.class);

        return new DefaultOpenAISession(openAiApi);
    }

}