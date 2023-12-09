package ahlam.java.server.authentication;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/")
public class MainController {
	@RequestMapping("/")
	public @ResponseBody GreetingJson greeting() {
		 return new GreetingJson("Student Course Management System");
	}
	
	public static class GreetingJson {
        private final String message;

        public GreetingJson(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}