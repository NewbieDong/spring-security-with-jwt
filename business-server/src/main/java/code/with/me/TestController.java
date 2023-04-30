package code.with.me;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andong@xiaomalixing.com
 */
@RestController
public class TestController {

    @GetMapping("/test")
    public String test() {
        return "Test";
    }
}