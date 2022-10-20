package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello")    //웹 어플리케이션에서 /hello가 작성되면 이 메소드를 호출한다.
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");  //hello!!를 다른것으로 변경 시 내용이 바뀜
        return "hello";
    }
}
