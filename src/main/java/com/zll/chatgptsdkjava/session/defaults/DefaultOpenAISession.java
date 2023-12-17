package com.zll.chatgptsdkjava.session.defaults;

import com.zll.chatgptsdkjava.IOpenAIApi;
import com.zll.chatgptsdkjava.domain.chat.ChatCompletionRequest;
import com.zll.chatgptsdkjava.domain.chat.ChatCompletionResponse;
import com.zll.chatgptsdkjava.domain.qa.QACompletionRequest;
import com.zll.chatgptsdkjava.domain.qa.QACompletionResponse;
import com.zll.chatgptsdkjava.session.OpenAISession;
import io.reactivex.Single;

public class DefaultOpenAISession implements OpenAISession {

    private IOpenAIApi OpenAIApi;

    public DefaultOpenAISession(IOpenAIApi OpenAIApi) {
        this.OpenAIApi = OpenAIApi;
    }

    @Override
    public QACompletionResponse completions(QACompletionRequest qaCompletionRequest) {
        return this.OpenAIApi.completions(qaCompletionRequest).blockingGet();
    }

    @Override
    public QACompletionResponse completions(String question) {
        QACompletionRequest request = QACompletionRequest
                .builder()
                .prompt(question)
                .build();
        Single<QACompletionResponse> completions = this.OpenAIApi.completions(request);
        return completions.blockingGet();
    }

    @Override
    public ChatCompletionResponse completions(ChatCompletionRequest chatCompletionRequest) {
        return this.OpenAIApi.completions(chatCompletionRequest).blockingGet();
    }

}
