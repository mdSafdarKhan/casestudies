package com.example.demo.controller;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Youtube;
import com.example.demo.repository.YoutubeRepository;

@RestController
@RequestMapping("/api/youtube")
public class YoutubeController {

	@Autowired
	YoutubeRepository youtubeRepository;
	
	@GetMapping
	public Long getChannelsCount() {
		return youtubeRepository.count();
	}
	
	@GetMapping("/all")
	public Iterable<Youtube> all(){
		return youtubeRepository.findAll();
	}
	
	@GetMapping("/channelName")
	public List<Youtube> getChannelsName(){
		return youtubeRepository.getChannelsName();
	}
	
	@GetMapping("/{channelName}")
	public Youtube getChannelsName(@PathVariable String channelName){
		return youtubeRepository.findChannelByName(channelName);
	}
	
	@GetMapping("/findByRankOrderByRank/{rank}")
	public List<Youtube> findByRankOrderByRank(@PathVariable String rank){
		return youtubeRepository.findByRankOrderByRankAsc(rank);
	}
	
	@GetMapping("/findByRankOrderByChannelName/{channelName}")
	public List<Youtube> findByRankOrderByChannelName(@PathVariable String channelName){
		return youtubeRepository.findByRankOrderByChannelNameAsc(channelName);
	}
	
	@GetMapping("/findByOrderByChannelNameAsc")
	public List<Youtube> findByOrderByChannelNameAsc(){
		return youtubeRepository.findByOrderByChannelNameAsc();
	}
	
	@GetMapping("/getChannelsWithPagination")
	public List<Youtube> getChannels(Pageable pageable) {
		return youtubeRepository.getChannelsWithPagination(pageable);
	}
}
