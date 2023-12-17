package com.zll.chatgptsdkjava;


import com.zll.chatgptsdkjava.domain.chat.ChatCompletionRequest;
import com.zll.chatgptsdkjava.domain.chat.ChatCompletionResponse;
import com.zll.chatgptsdkjava.domain.qa.QACompletionRequest;
import com.zll.chatgptsdkjava.domain.qa.QACompletionResponse;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface IOpenAIApi {

    /**
     * 文本问答
     * @param qaCompletionRequest           请求信息
     * @return Single<QACompletionResponse> 返回结果
     * @author zhouyunlongxx
     * @date 2023/12/17 20:12
     */
    @POST("v1/completions")
    Single<QACompletionResponse> completions(@Body QACompletionRequest qaCompletionRequest);

    /**
     * GPT3.5 问答
     * @param chatCompletionRequest           请求信息
     * @return Single<ChatCompletionResponse> 返回结果
     * @author zhouyunlongxx
     * @date 2023/12/17 20:13
     */
    @POST("v1/chat/completions")
    Single<ChatCompletionResponse> completions(@Body ChatCompletionRequest chatCompletionRequest);

}
