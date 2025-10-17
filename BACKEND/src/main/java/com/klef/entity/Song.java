package com.klef.entity;

	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.Id;
	import jakarta.persistence.Table;

	/*@Entity
	@Table(name = "Music_table")
	public class Song{
		@Id
		@Column(name = "id")
		private int id;
		@Column(name = "name", nullable = false, length = 50)
		private String name;
		@Column(name = "title", nullable = false, length = 10)
		private String gender; //FEMALE or MALE
		@Column(name = "artist", nullable = false, length = 20)
		private String department;
		@Column(name = "album", nullable = false, length = 10)
		private String program; //B.Tech or M.Tech or BCA or MCA
		@Column(name = "year", nullable = false)
		private String year; // 1 or 2 or 3
	@Entity
	@Table(name = "Music_table")
	public class Song {

	    @Id
	    @Column(name = "id")
	    private int id;

	    @Column(name = "title", nullable = false, length = 50)
	    private String title;

	    @Column(name = "artist", nullable = false, length = 50)
	    private String artist;

	    @Column(name = "gender", nullable = false, length = 10)
	    private String gender;

	    @Column(name = "album", nullable = false, length = 50)
	    private String album;

	    @Column(name = "year")
	    private String year;

	   
	
		
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return title;
		}
		public void setName(String name) {
			this.title = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAlbum() {
			return album;
		}
		public void setAlbum(String album) {
			this.album = album;
		}
		
		
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		
		
		@Override
		public String toString() {
			return "Song [id=" + id + ", name=" + title + ", gender=" + gender + ", album=" + album + ", year=" + year +"]";

		}
	}

*/
	@Entity
	@Table(name = "music_table")
	public class Song {

	    @Id
	    @Column(name = "id")
	    private int id;

	    @Column(name = "title", nullable = false, length = 50)
	    private String title;

	    @Column(name = "artist", nullable = false, length = 50)
	    private String artist;

	    @Column(name = "mood", nullable = false, length = 10)
	    private String mood;

	    @Column(name = "album", nullable = false, length = 50)
	    private String album;

	    @Column(name = "year")
	    private String year;

	    // --- Getters and Setters ---
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }

	    public String getTitle() {
	        return title;
	    }
	    public void setTitle(String title) {
	        this.title = title;
	    }

	    public String getArtist() {
	        return artist;
	    }
	    public void setArtist(String artist) {
	        this.artist = artist;
	    }

	    public String getMood() {
	        return mood;
	    }
	    public void setMood(String mood) {
	        this.mood = mood;
	    }

	    public String getAlbum() {
	        return album;
	    }
	    public void setAlbum(String album) {
	        this.album = album;
	    }

	    public String getYear() {
	        return year;
	    }
	    public void setYear(String year) {
	        this.year = year;
	    }

	    @Override
	    public String toString() {
	        return "Song [id=" + id + ", title=" + title + ", artist=" + artist +
	               ", mood=" + mood + ", album=" + album + ", year=" + year + "]";
	    }
	}

