package dev.juntralala.controller;

import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.springframework.http.MediaType.TEXT_PLAIN;

/**
 * beberapa nggak ku sebutin disini:
 * View, java.util.Map, Model, @ModelAttribute, ModelAndView => berhungan dengan view atau html template
 * FragmentRendering, Collection<ModelAndView> => buat HTMX dan Hotwire Turbo
 * ListenableFuture => seperti CompletableFuture tapi sudah deprecated
 * ResposneBodyEmitter, SseEmitter => stream object with HttpMessageConverter in async request: https://docs.spring.io/spring-framework/reference/web/webmvc/mvc-ann-async.html#mvc-ann-async-http-streaming
 * ReactiveAdapterRegistry
 */
@Controller
public class ReturnController {

    @ResponseBody
    @GetMapping("/response-body")
    public String responseBody() {
        // returnnya pakai HttpMessageConverter
        return "Hello from response Body";
    }

    @GetMapping("/http-entity")
    public HttpEntity<String> httpEntity() {
        // bagian body pakai HttpMessageConverter
        var res = new HttpEntity<String>("Hello http entity");
        res.getHeaders().setContentType(TEXT_PLAIN);
        return res;
    }

    @GetMapping("/response-entity")
    public ResponseEntity<String> responseEntity() {
        // body pakai HttpMessageConverter
        return ResponseEntity.ok("Hello response Entity");
    }

    @GetMapping("/error-response")
    public ErrorResponse errorResponse() {
        // response error ngikut RFC 9457
        return ErrorResponse.create(new Exception("Hello"), HttpStatus.BAD_REQUEST, "Nothing");
    }

    @GetMapping("/problem-detail")
    public ProblemDetail problemDetail() {
        // response error ngikut RFC 9457
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, "Nothing");
    }

    @GetMapping("/string")
    public String stringReturn() {
        // kalau string biasa dia return view template, tapi karna disin aku nggak nginstall jadi nggak bisa
        return "some-template.jsp";
    }

    // pakai @ResponseBody agar return string bukan malah nyari view/html template, dan harus juga kalau return object
    @GetMapping("/deferred-result")
    @ResponseBody
    public DeferredResult<String> deferredResult() {
        final var deferredResult = new DeferredResult<String>();
        Thread.ofPlatform().start(() -> {
            try {
                Thread.sleep(5_000);
                deferredResult.setResult("Helllo Deferred Result");
            } catch (InterruptedException e) {
                deferredResult.setResult("Error Accured");
                throw new RuntimeException(e);
            }
        });
        return deferredResult;
    }

    // pakai @ResponseBody agar return string bukan malah nyari view/html template
    @GetMapping("/callable")
    @ResponseBody
    public Callable<String> callable() {
        // callable yang direturn akan dijalankan di threadpool yang dimanage spring
        return () -> Thread.currentThread().getName() + ": Hello callable";
    }

    // pakai @ResponseBody agar return string bukan malah nyari view/html template, dan pakai juga kalau return object
    @GetMapping("/completable-future")
    @ResponseBody
    public CompletableFuture<String> completableFuture() {
        return CompletableFuture.supplyAsync(
                () -> Thread.currentThread().getName() + ": Hello callable"
        );
    }

    // pakai @ResponseBody agar return string bukan malah nyari view/html template, dan pakai juga kalau return object
    @GetMapping("/completion-stage")
    @ResponseBody
    public CompletionStage<String> completionStage() {
        return CompletableFuture.supplyAsync(
                () -> Thread.currentThread().getName() + ": Hello callable"
        );
    }

    @GetMapping("/streaming-response-body")
    @ResponseBody
    public StreamingResponseBody streamingResponseBody() {
        // StreamingResponseBody juga bisa pakai ResponseEntity => ResponseEntity<StreamingResponseBody>
        return outputStream -> {
            outputStream.write("Hello ".getBytes(UTF_8));
            outputStream.write("ujun".getBytes(UTF_8));
        };
    }


}
