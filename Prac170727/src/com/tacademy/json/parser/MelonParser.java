package com.tacademy.json.parser;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.tacademy.json.vo.Artist;
import com.tacademy.json.vo.Melon;
import com.tacademy.json.vo.Song;

public class MelonParser {
	public Melon doMelonParser(String jsonStr){
		Melon melon = new Melon();
		ArrayList<Song> songsArr = null;
		ArrayList<Artist> artistsArr = null;
//		Song song = null;
//		Artist artists = null;
		JSONObject obj = null;
		JSONObject jobj = null;
		JSONObject songs = null;
		JSONArray arr = null;
		
		
		try{
			obj = new JSONObject(jsonStr);
			jobj = obj.getJSONObject("melon");
			melon.setMenuId(jobj.getInt("menuId"));
			melon.setCount(jobj.getInt("count"));
			melon.setPage(jobj.getInt("page"));
			melon.setTotalPages(jobj.getInt("totalPages"));
			melon.setRankDay(jobj.getString("rankDay"));
			melon.setRankHour(jobj.getString("rankHour"));
			
			
			songs = jobj.getJSONObject("songs"); 
			arr = songs.getJSONArray("song");	//songs안에있짢어
			
			Song song = null;
			JSONObject tempSong = null;
			songsArr = new ArrayList<Song>();
			
			
			for(int i = 0; i < arr.length(); i++){
				//artist를 어디서 얻어오지??
				tempSong = arr.getJSONObject(i);
				song = new Song();
				song.setSongId(tempSong.getInt("songId"));
				song.setSongName(tempSong.getString("songName"));
				
				artistsArr = new ArrayList<Artist>(); 
				JSONObject art = null;
				JSONArray brr = null;
				Artist artist = null;
				JSONObject tempObj = null;
				
				//아티스츠를 얻어와야하고(얜 배열이 아니자너)
				art = tempSong.getJSONObject("artists");
				//아티스트 역시 가져와야한다(array)
				brr = art.getJSONArray("artist");
				
				
				for(int j = 0; j < brr.length(); j++){
					tempObj = brr.getJSONObject(j);
					artist = new Artist();
					artist.setArtistId(tempObj.getInt("artistId"));
					artist.setArtistName(tempObj.getString("artistName"));
					
					artistsArr.add(artist);	//하나씩 넣어주고
				}
				
				song.setArtists(artistsArr);	//다 넣은걸 여기에 넣는다
				
				song.setAlbumId(tempSong.getInt("albumId"));
				song.setAlbumName(tempSong.getString("albumName"));
				song.setCurrentRank(tempSong.getInt("currentRank"));
				song.setPastRank(tempSong.getInt("pastRank"));
				song.setPlayTime(tempSong.getInt("playTime"));
				song.setIssueDate(tempSong.getString("issueDate"));
				song.setTitleSong(tempSong.getBoolean("isTitleSong"));
				song.setHitSong(tempSong.getBoolean("isHitSong"));
				song.setAdult(tempSong.getBoolean("isAdult"));
				song.setFree(tempSong.getBoolean("isFree"));
//				song.getArtists().add(artist);
				songsArr.add(song);
			}
			
			melon.setSongs(songsArr);
			
		}catch(JSONException e){
			System.out.println("json 파싱 에러di!!: " + e);
		}
		
		
		return melon;
	}
}
