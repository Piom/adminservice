package ru.piom.spring.admin.client;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.piom.spring.admin.client.domain.Greeting;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Alex on 31.10.2016.
 */
@RestController
public class IndexController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }
}
