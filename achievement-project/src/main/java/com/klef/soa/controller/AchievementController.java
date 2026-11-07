package com.klef.soa.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.klef.soa.entity.Achievement;
import com.klef.soa.service.AchievementService;




@RestController
@RequestMapping("achievement")
public class AchievementController {
	@Autowired
	private AchievementService service;
	@GetMapping("/")
	public String view() {
		return "Achievement";
	}
	@PostMapping("add")
	public ResponseEntity<Achievement> add(@RequestBody Achievement a) {
		Achievement b=service.addachievement(a);
		return ResponseEntity.status(200).body(b);
	}
	@PutMapping("update")
	public ResponseEntity<?> updateachivement(@RequestBody Achievement a) {
		Achievement b=service.updateachievement(a);
		if(b!=null) {
			return ResponseEntity.ok(b);
		}else {
			return ResponseEntity.ok("Not Found");
		}
    		
	}
	@GetMapping("displaybyId/{id}")
	public ResponseEntity<String> displaybyId(@PathVariable Long id) {
		Achievement b=service.viewachievementbyid(id);
		if(b!=null) {
			return ResponseEntity.ok(b.toString());
		}else {
			return ResponseEntity.ok("Not Found");
		}
	}
	@GetMapping("displayall")
	public ResponseEntity<List<Achievement>> displayall() {
		List<Achievement> al=service.viewacheivements();
		return ResponseEntity.status(200).body(al);
	}
	@GetMapping("byname")
	public ResponseEntity<List<Achievement>> displaybyname(@RequestParam String name) {
	  List<Achievement> al=service.viewachievementbyname(name);
	  return ResponseEntity.ok(al);
	}
	@GetMapping("bytype")
	public ResponseEntity<List<Achievement>> displaybytype(@RequestParam String type) {
		List<Achievement> al=service.viewachievementbytype(type);
		return ResponseEntity.ok(al);
	}
	@DeleteMapping("delete/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id ) {
		String msg=service.deleteachievement(id);
		return ResponseEntity.ok(msg);
		
	}
	@GetMapping("count")
	public ResponseEntity<String> count() {
		Long c=service.viewcount();
		return ResponseEntity.ok("total achievements="+c);
	}
	

}