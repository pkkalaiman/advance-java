package com.xworkz.food.component;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xworkz.food.InterviewDTO.InterviewDTO;

@Component
@RequestMapping("/interview")
public class InterviewComponent {
	
	public InterviewComponent() {
		System.out.println("Created :" + this.getClass().getSimpleName());
	}
	
	@PostMapping
	public String onInterview(InterviewDTO dto) {
		System.out.println("Running in OnInterview......");
		System.out.println(dto);
		return "Interview.jsp";
	}

}
