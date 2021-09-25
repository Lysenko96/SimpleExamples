package net.boot.beater.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.boot.beater.entity.Message;
import net.boot.beater.repo.MessageRepo;

@Controller
public class PageController {

	private MessageRepo messageRepo;

	public PageController(MessageRepo messageRepo) {
		this.messageRepo = messageRepo;
	}

	@GetMapping("/list")
	public String list() {
		return "list";
	}

	@PostMapping("/list")
	public String save(@RequestParam String tag, @RequestParam String text, Map<String, Object> model) {
		Message message = new Message(tag, text);
		messageRepo.save(message);
		model.put("messages", messageRepo.findAll());
		return "list";
	}

	@PostMapping("/search")
	public String search(@RequestParam String tag, Map<String, Object> model) {
		if (tag != null && !tag.isEmpty()) {
			model.put("messages", messageRepo.findByTag(tag));
		} else {
			model.put("messages", messageRepo.findAll());
		}
		return "list";
	}

}