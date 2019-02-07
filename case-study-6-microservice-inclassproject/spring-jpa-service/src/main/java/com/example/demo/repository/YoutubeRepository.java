package com.example.demo.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Youtube;

@Repository
public interface YoutubeRepository extends PagingAndSortingRepository<Youtube, Long>{

	
	@Query(value="select channel_name from youtube limit 1", nativeQuery=true)
	public List<Youtube> getChannelsName();
	
	@Query(value="SELECT * FROM youtube where channel_name=?1", nativeQuery=true)
	public Youtube findChannelByName(String channelName);
	
	public List<Youtube> findByRankOrderByRankAsc(String rank);
	
	public List<Youtube> findByRankOrderByChannelNameAsc(String rank);
	
	public List<Youtube> findByOrderByChannelNameAsc();
	
	public List<Youtube> findAll(Pageable pageable);
}
