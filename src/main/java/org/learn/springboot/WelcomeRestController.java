/**
 * 
 */
package org.learn.springboot;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Vishesh
 *
 */
@RestController
@RequestMapping("/api")
public class WelcomeRestController {
	
	@GetMapping(value="/welcome", produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<String> welcome() {
		String welcome = "Hola Mundo!";
		return new ResponseEntity<String>(welcome, HttpStatus.OK);
	}
}
