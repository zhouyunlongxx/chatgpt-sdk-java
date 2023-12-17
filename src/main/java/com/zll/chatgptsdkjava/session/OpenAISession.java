package com.zll.chatgptsdkjava.session;


import com.zll.chatgptsdkjava.domain.chat.ChatCompletionRequest;
import com.zll.chatgptsdkjava.domain.chat.ChatCompletionResponse;
import com.zll.chatgptsdkjava.domain.qa.QACompletionRequest;
import com.zll.chatgptsdkjava.domain.qa.QACompletionResponse;

public interface OpenAISession {

    /**
     * 文本问答
     * @param qaCompletionRequest 请求信息
     * @return                    返回结果
     * @author zhouyunlongxx
     * @date 2023/12/17 20:16
     */
    QACompletionResponse completions(QACompletionRequest qaCompletionRequest);

    /**
     * 文本问答；简单请求
     * @param question 请求信息
     * @return         返回结果
     * @author zhouyunlongxx
     * @date 2023/12/17 20:16
     */
    QACompletionResponse completions(String question);

    /**
     * 默认 GPT-3.5 问答模型
     * @param chatCompletionRequest 请求信息
     * @return                      返回结果
     * @author zhouyunlongxx
     * @date 2023/12/17 20:16
     */
    ChatCompletionResponse completions(ChatCompletionRequest chatCompletionRequest);

}
